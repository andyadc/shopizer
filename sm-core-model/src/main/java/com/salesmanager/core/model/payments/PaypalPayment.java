package com.salesmanager.core.model.payments;

/**
 * When the user performs a payment using paypal
 *
 * @author Carl Samson
 */
public class PaypalPayment extends Payment {

    //express checkout
    private String payerId;
    private String paymentToken;

    public PaypalPayment() {
        super.setPaymentType(PaymentType.PAYPAL);
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

}
