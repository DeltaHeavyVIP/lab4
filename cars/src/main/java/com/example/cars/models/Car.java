package com.example.cars.models;

import com.example.enums.CarType;
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
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "car_uid", nullable = false, unique = true)
    private UUID carUid;

    @Column(name = "brand", nullable = false, length = 80)
    private String brand;

    @Column(name = "model", nullable = false, length = 80)
    private String model;

    @Column(name = "registration_number", nullable = false, length = 20)
    private String registrationNumber;

    @Column(name = "power", nullable = true)
    private Integer power;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "type", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private CarType type;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    /*      CONSTRUCTORS     */
    public Car() {
    }

    /*      GETTERS     */
    public Integer getId() {
        return id;
    }

    public UUID getCarUid() {
        return carUid;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    public boolean isAvailability() {
        return availability;
    }

    /*      SETTERS     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarUid(UUID carUid) {
        this.carUid = carUid;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
