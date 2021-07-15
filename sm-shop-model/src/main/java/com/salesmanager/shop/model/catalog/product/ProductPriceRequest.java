package com.salesmanager.shop.model.catalog.product;

import com.salesmanager.shop.model.catalog.product.attribute.ProductAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductPriceRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductAttribute> options = new ArrayList<ProductAttribute>();

	public List<ProductAttribute> getOptions() {
		return options;
	}

	public void setOptions(List<ProductAttribute> options) {
		this.options = options;
	}

}
