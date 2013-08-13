package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class SubscriptionCategoryPK implements Comparable<SubscriptionCategoryPK>,
    Serializable {
    public long subscriptionId;
    public long categoryId;

    public SubscriptionCategoryPK() {
    }

    public SubscriptionCategoryPK(long subscriptionId, long categoryId) {
        this.subscriptionId = subscriptionId;
        this.categoryId = categoryId;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int compareTo(SubscriptionCategoryPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (subscriptionId < pk.subscriptionId) {
            value = -1;
        } else if (subscriptionId > pk.subscriptionId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (categoryId < pk.categoryId) {
            value = -1;
        } else if (categoryId > pk.categoryId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SubscriptionCategoryPK pk = null;

        try {
            pk = (SubscriptionCategoryPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((subscriptionId == pk.subscriptionId) &&
                (categoryId == pk.categoryId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(subscriptionId) + String.valueOf(categoryId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("subscriptionId");
        sb.append(StringPool.EQUAL);
        sb.append(subscriptionId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("categoryId");
        sb.append(StringPool.EQUAL);
        sb.append(categoryId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
