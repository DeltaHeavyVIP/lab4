package com.example.cars.controller;

import com.example.cars.service.CarService;
import com.example.response.CarResponseDto;
import com.example.response.PaginationResponseDto;
import jakarta.validation.constraints.Min;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CarController {

    private final CarService carService;
    private final ConversionService conversionService;

    public CarController(CarService carService, ConversionService conversionService) {
        this.carService = carService;
        this.conversionService = conversionService;
    }

    @GetMapping("")
    public PaginationResponseDto getAllAvailabilityCar(@RequestParam(name = "page") @Min(1) Integer page,
                                                       @RequestParam(name = "size") @Min(0) Integer size,
                                                       @RequestParam(name = "showAll") boolean showAll) {

        List<CarResponseDto> carResponseDtos =
                carService.getAllAvailabilityCar(page, size, showAll).stream().map(car -> conversionService.convert(car,
                        CarResponseDto.class)).toList();
        return new PaginationResponseDto(page, size, carResponseDtos.size(), carResponseDtos);
    }

    @GetMapping("/{carUid}")
    public CarResponseDto getCarByCarUid(@PathVariable UUID carUid) {
        return conversionService.convert(carService.getCarByCarUid(carUid), CarResponseDto.class);
    }

    @PostMapping("/{carUid}")
    public void updateCarStatusByCarUid(@PathVariable UUID carUid) {
        carService.updateCarStatusByCarUid(carUid);
    }

}
