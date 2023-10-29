package com.example.request;

import java.util.Date;
import java.util.UUID;

public class CreateRentalRequestDto {

    private UUID carUid;

    private Date dateFrom;

    private Date dateTo;

    /*      CONSTRUCTORS     */
    public CreateRentalRequestDto() {

    }

    /*      GETTERS     */
    public UUID getCarUid() {
        return carUid;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    /*      SETTERS     */
    public void setCarUid(UUID carUid) {
        this.carUid = carUid;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

}
