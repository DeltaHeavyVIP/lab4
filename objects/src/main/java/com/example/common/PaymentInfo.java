package com.example.common;

import com.example.enums.PaymentStatus;

import java.util.UUID;

public class PaymentInfo {

    private UUID paymentUid;

    private PaymentStatus status;

    private Integer price;

    /*      CONSTRUCTORS     */
    public PaymentInfo() {

    }

    /*      GETTERS     */
    public UUID getPaymentUid() {
        return paymentUid;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Integer getPrice() {
        return price;
    }

    /*      SETTERS     */
    public void setPaymentUid(UUID paymentUid) {
        this.paymentUid = paymentUid;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
