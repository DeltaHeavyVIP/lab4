package com.example.cars.service;

import com.example.cars.models.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<Car> getAllAvailabilityCar(Integer page, Integer size, Boolean showAll);

    Car getCarByCarUid(UUID carUid);

    void updateCarStatusByCarUid(UUID carUid);

}
