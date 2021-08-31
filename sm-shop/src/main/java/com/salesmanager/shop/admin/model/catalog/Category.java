package com.salesmanager.shop.admin.model.catalog;

import com.salesmanager.core.model.catalog.category.CategoryDescription;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper to ease admin jstl
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private com.salesmanager.core.model.catalog.category.Category category;

    @Valid
    private List<CategoryDescription> descriptions = new ArrayList<CategoryDescription>();

    public com.salesmanager.core.model.catalog.category.Category getCategory() {
        return category;
    }

    public void setCategory(com.salesmanager.core.model.catalog.category.Category category) {
        this.category = category;
    }

    public List<CategoryDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<CategoryDescription> descriptions) {
        this.descriptions = descriptions;
    }
}
