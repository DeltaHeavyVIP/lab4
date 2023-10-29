package com.example.response;

import com.example.common.CarInfo;
import com.example.common.PaymentInfo;
import com.example.enums.RentalStatus;

import java.util.UUID;

public class RentalResponseDto {

    private UUID rentalUid;

    private RentalStatus status;

    private String dateFrom;

    private String dateTo;

    private CarInfo car;

    private PaymentInfo payment;

    /*      CONSTRUCTORS     */
    public RentalResponseDto() {

    }

    /*      GETTERS     */
    public UUID getRentalUid() {
        return rentalUid;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public CarInfo getCar() {
        return car;
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

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setCar(CarInfo car) {
        this.car = car;
    }

    public void setPayment(PaymentInfo payment) {
        this.payment = payment;
    }

}
