package com.example.rental.models;

import com.example.enums.RentalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rental_uid", nullable = false, unique = true)
    private UUID rentalUid;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "payment_uid", nullable = false)
    private UUID paymentUid;

    @Column(name = "car_uid", nullable = false)
    private UUID carUid;

    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    /*      CONSTRUCTORS     */
    public Rental() {
    }

    /*      GETTERS     */
    public Integer getId() {
        return id;
    }

    public UUID getRentalUid() {
        return rentalUid;
    }

    public String getUsername() {
        return username;
    }

    public UUID getPaymentUid() {
        return paymentUid;
    }

    public UUID getCarUid() {
        return carUid;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public RentalStatus getStatus() {
        return rentalStatus;
    }

    /*      SETTERS     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setRentalUid(UUID rentalUid) {
        this.rentalUid = rentalUid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPaymentUid(UUID paymentUid) {
        this.paymentUid = paymentUid;
    }

    public void setCarUid(UUID carUid) {
        this.carUid = carUid;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

}
