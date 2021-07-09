package com.salesmanager.core.model.payments;

import com.salesmanager.core.model.reference.currency.Currency;

import java.math.BigDecimal;
import java.util.Map;

public class Payment {

	private PaymentType paymentType;
	private TransactionType transactionType = TransactionType.AUTHORIZECAPTURE;
	private String moduleName;
	private Currency currency;
	private BigDecimal amount;
	private Map<String, String> paymentMetaData = null;

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Map<String, String> getPaymentMetaData() {
		return paymentMetaData;
	}

	public void setPaymentMetaData(Map<String, String> paymentMetaData) {
		this.paymentMetaData = paymentMetaData;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
