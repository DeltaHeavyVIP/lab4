package com.example.common;

public class CarInfo {

    private String carUid;

    private String brand;

    private String model;

    private String registrationNumber;

    /*      CONSTRUCTORS     */
    public CarInfo() {
    }

    public CarInfo(String carUid, String brand, String model, String registrationNumber) {
        this.carUid = carUid;
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    /*      GETTERS     */
    public String getCarUid() {
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

    /*      SETTERS     */
    public void setCarUid(String carUid) {
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

}
