package com.example.gateway.controller;

import com.example.gateway.feign.CarService;
import com.example.response.CarResponseDto;
import com.example.response.PaginationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public PaginationResponseDto getAllAvailabilityCar(@RequestParam(name = "page") Integer page,
                                                       @RequestParam(name = "size") Integer size,
                                                       @RequestParam(name = "showAll") boolean showAll) {
        return carService.getAllAvailabilityCar(page, size, showAll);
    }

    @GetMapping("/{carUid}")
    public CarResponseDto getCarByCarUid(@PathVariable UUID carUid) {
        return carService.getCarByCarUid(carUid);
    }

    @PostMapping("/{carUid}")
    public ResponseEntity<String> updateCarStatusByCarUid(@PathVariable UUID carUid) {
        carService.updateCarStatusByCarUid(carUid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
