package com.salesmanager.shop.model.order.v1;

import com.salesmanager.shop.model.entity.ReadableList;

import java.io.Serializable;
import java.util.List;


public class ReadableOrderList extends ReadableList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ReadableOrder> orders;
	
	
	
	public List<ReadableOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ReadableOrder> orders) {
		this.orders = orders;
	}

}
