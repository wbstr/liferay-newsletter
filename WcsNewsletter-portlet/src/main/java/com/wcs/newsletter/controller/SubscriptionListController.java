package com.wcs.newsletter.controller;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 Webstar Csoport Kft.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.wcs.newsletter.dto.SubscriptionListElem;
import com.wcs.newsletter.dto.SubscriptionListElemDataModel;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;
import com.wcs.newsletter.service.persistence.SubscriptionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SubscriptionListController extends AbstractListController<SubscriptionListElem, SubscriptionListElemDataModel> {

    @Override
    protected void init() {
        initModel();
    }

    public void resetController() {
        model = null;
    }

    public void initModel() {
        if (model == null) {
            List<SubscriptionListElem> elems = new ArrayList<SubscriptionListElem>();
            try {
                elems = getSubscriptionListElems();
            } catch (SystemException ex) {
                logger.error(ex);
                addErrorMessage(ex);
            }

            model = new SubscriptionListElemDataModel(elems);
        }
    }

    private List<SubscriptionListElem> getSubscriptionListElems() throws SystemException {
        List<SubscriptionListElem> subscriptionListElems = new ArrayList<SubscriptionListElem>();
        List<Subscription> subscriptions = SubscriptionLocalServiceUtil.getSubscriptions();

        for (Subscription subscription : subscriptions) {
            long id = subscription.getSubscriptionId();

            List<SubscriptionCategory> subscribedList = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(id);
            long categoryCount = subscribedList != null ? subscribedList.size() : 0;

            SubscriptionListElem elem = new SubscriptionListElem(subscription, categoryCount);
            subscriptionListElems.add(elem);
        }

        return subscriptionListElems;
    }

    public void syncronizeSubscriptions() {
        try {
            List<User> allUsers = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
//            System.out.println("allUsers"+ allUsers);
            for (User subscriptionUser : allUsers) {
//                System.out.println("subscriptionUser"+subscriptionUser.getEmailAddress());
                List<Subscription> subs = SubscriptionLocalServiceUtil.findByEmail(subscriptionUser.getEmailAddress());
//                List<Subscription>  subs = SubscriptionLocalServiceUtil.findByUserId(subscriptionUser.getUserId());
//                System.out.println("subs"+subs);
                if (subs.size() > 0) {
                    for (Subscription sub : subs) {
                        System.out.println("bejön");
                        sub.setEmail("");
                        sub.setUserId(subscriptionUser.getUserId());
                        SubscriptionLocalServiceUtil.updateSubscription(sub);
                    }
                }
            }
        } catch (SystemException ex) {
            Logger.getLogger(SubscriptionListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String edit(SubscriptionListElem elem) {
        logger.info("edit {0}", new Object[]{elem});
        return getNavigationController().navigateToSubscriptionEdit(elem.getId());
    }

    @Override
    public String create() {
        return null;
    }

    @Override
    public void delete(SubscriptionListElem elem) throws Exception {
    }
}
