package com.salesmanager.shop.model.content.box;

import com.salesmanager.shop.model.content.common.ContentDescription;

import java.util.List;

public class ReadableContentBoxFull extends ReadableContentBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ContentDescription> descriptions;

	public List<ContentDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<ContentDescription> descriptions) {
		this.descriptions = descriptions;
	}

}
