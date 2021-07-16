package com.salesmanager.shop.admin.model.catalog;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Post keyword from the admin
 * @author Carl Samson
 *
 */
public class Keyword implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long productId;
	private String languageCode;
	@NotEmpty
	private String keyword;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
