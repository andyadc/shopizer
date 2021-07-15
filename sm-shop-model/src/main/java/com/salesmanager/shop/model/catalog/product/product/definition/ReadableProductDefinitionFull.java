package com.salesmanager.shop.model.catalog.product.product.definition;

import com.salesmanager.shop.model.catalog.product.ProductDescription;

import java.util.ArrayList;
import java.util.List;

public class ReadableProductDefinitionFull extends ReadableProductDefinition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductDescription> descriptions = new ArrayList<ProductDescription>();
	public List<ProductDescription> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<ProductDescription> descriptions) {
		this.descriptions = descriptions;
	}

}
