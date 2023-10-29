package com.example.response;

import com.example.common.PaymentInfo;
import com.example.enums.RentalStatus;

import java.util.UUID;

public class CreateRentalResponseDto {

    private UUID rentalUid;

    private RentalStatus status;

    private UUID carUid;

    private String dateFrom;

    private String dateTo;

    private PaymentInfo payment;

    /*      CONSTRUCTORS     */
    public CreateRentalResponseDto() {

    }

    /*      GETTERS     */
    public UUID getRentalUid() {
        return rentalUid;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public UUID getCarUid() {
        return carUid;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public PaymentInfo getPayment() {
        return payment;
    }

    /*      SETTERS     */
    public void setRentalUid(UUID rentalUid) {
        this.rentalUid = rentalUid;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public void setCarUid(UUID carUid) {
        this.carUid = carUid;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setPayment(PaymentInfo payment) {
        this.payment = payment;
    }

}
