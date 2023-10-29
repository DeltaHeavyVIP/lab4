package com.example.cars.service.impl;

import com.example.cars.models.Car;
import com.example.cars.repositories.CarRepo;
import com.example.cars.service.CarService;
import com.example.exception.ResourceNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;

    private final ConversionService conversionService;

    public CarServiceImpl(CarRepo carRepo, ConversionService conversionService) {
        this.carRepo = carRepo;
        this.conversionService = conversionService;
    }

    @Override
    public List<Car> getAllAvailabilityCar(Integer page, Integer size, Boolean showAll) {
        if (showAll) {
            return carRepo.findAll(PageRequest.of(page - 1, size)).getContent();
        } else {
            return carRepo.findAllByAvailability(true, PageRequest.of(page - 1, size));
        }
    }

    @Override
    public Car getCarByCarUid(UUID carUid) {
        return carRepo.findByCarUid(carUid).orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find " +
                "car with carUid %s", carUid.toString())));
    }

    @Override
    public void updateCarStatusByCarUid(UUID carUid) {
        Car car = carRepo.findByCarUid(carUid).orElseThrow(() -> new ResourceNotFoundException(String.format("Could " +
                "not find car with carUid %s", carUid.toString())));
        car.setAvailability(!car.isAvailability());
        carRepo.save(car);
    }

}
