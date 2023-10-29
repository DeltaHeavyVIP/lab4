package com.example.response;

import java.util.UUID;

public class CarResponseDto {
    private UUID carUid;
    private String brand;
    private String model;
    private String registrationNumber;
    private Integer power;
    private String type;
    private Integer price;
    private Boolean available;

    /*      CONSTRUCTORS     */
    public CarResponseDto() {

    }

    /*      GETTERS     */
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

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }

    /*      SETTERS     */
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

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
