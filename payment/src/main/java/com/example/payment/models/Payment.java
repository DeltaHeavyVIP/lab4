package com.example.payment.models;

import com.example.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "payment_uid", nullable = false)
    private UUID paymentUid;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "price", nullable = false)
    private Integer price;

    /*      CONSTRUCTORS     */
    public Payment() {
    }

    public Payment(UUID paymentUid, PaymentStatus paymentStatus, Integer price) {
        this.paymentUid = paymentUid;
        this.paymentStatus = paymentStatus;
        this.price = price;
    }

    /*      GETTERS     */
    public Integer getId() {
        return id;
    }

    public UUID getPaymentUid() {
        return paymentUid;
    }

    public PaymentStatus getStatus() {
        return paymentStatus;
    }

    public Integer getPrice() {
        return price;
    }

    /*      SETTERS     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPaymentUid(UUID paymentUid) {
        this.paymentUid = paymentUid;
    }

    public void setStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
