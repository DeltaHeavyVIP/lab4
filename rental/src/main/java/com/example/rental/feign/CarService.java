package com.example.rental.feign;

import com.example.response.CarResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "car-service", url = "http://gateway:8080/api/v1/cars")
public interface CarService {
    String URL_GET_CAR_BY_CARUID = "/{carUid}";

    String URL_UPDATE_CAR_STATUS_BY_CARUID = "/{carUid}";

    @GetMapping(URL_GET_CAR_BY_CARUID)
    CarResponseDto getCarByCarUid(@PathVariable UUID carUid);

    @PostMapping(URL_UPDATE_CAR_STATUS_BY_CARUID)
    void updateCarStatusByCarUid(@PathVariable UUID carUid);

}
