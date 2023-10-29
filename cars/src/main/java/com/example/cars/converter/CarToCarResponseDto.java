package com.example.cars.converter;

import com.example.cars.models.Car;
import com.example.response.CarResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarToCarResponseDto implements Converter<Car, CarResponseDto> {
    @Override
    public CarResponseDto convert(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setCarUid(car.getCarUid());
        carResponseDto.setBrand(car.getBrand());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setRegistrationNumber(car.getRegistrationNumber());
        carResponseDto.setPower(car.getPower());
        carResponseDto.setType(car.getType().toString());
        carResponseDto.setPrice(car.getPrice());
        carResponseDto.setAvailable(car.isAvailability());
        return carResponseDto;
    }
}
