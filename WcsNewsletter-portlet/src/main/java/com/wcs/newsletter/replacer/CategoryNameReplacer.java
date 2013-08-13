package com.wcs.newsletter.replacer;

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

import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.util.EmailConst;
import com.wcs.tool.ListUtil;
import com.wcs.tool.StringUtil;
import java.util.ArrayList;
import java.util.List;


public class CategoryNameReplacer extends AbstractEmailReplacer {

    private String categoryName;
    private List<String> categoryIds;

    public CategoryNameReplacer(String categoryName) {
        this.categoryName = StringUtil.toString(categoryName);
    }    
    
    public CategoryNameReplacer(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }            
            
    @Override
    public String getVariableName() {
        return EmailConst.Variable.CATEGORY_NAME;
    }

    @Override
    public String getValue() throws Exception {
        if (StringUtil.isNotEmpty(categoryName)) {
            return categoryName;
        }
        
        return getCategoryNamesByCategoryIds();
    }

    private String getCategoryNamesByCategoryIds() throws Exception {
        List<String> categoryNames = new ArrayList<String>();
        
        if (ListUtil.isNotEmpty(categoryIds)) {
            for (String categoryId : categoryIds) {
                Category category = CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryId));

                String categoryName = category != null ? category.getName() : null;

                if (StringUtil.isNotEmpty(categoryName)) {
                    categoryNames.add(categoryName);
                }
            }
        }
        
        return StringUtil.toCSV(categoryNames);
    }    
    
}
