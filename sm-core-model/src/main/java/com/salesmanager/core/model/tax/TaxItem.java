package com.salesmanager.core.model.tax;

import com.salesmanager.core.model.order.OrderTotalItem;
import com.salesmanager.core.model.tax.taxrate.TaxRate;

public class TaxItem extends OrderTotalItem {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private TaxRate taxRate = null;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}


}
