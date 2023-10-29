package com.example.gateway.feign;

import com.example.response.CarResponseDto;
import com.example.response.PaginationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "car-service", url = "http://car:8070/api/v1/cars")
public interface CarService {

    String URL_GET_ALL_AVAILABILITY_CAR = "";

    String URL_GET_CAR_BY_CARUID = "/{carUid}";

    String URL_UPDATE_CAR_STATUS_BY_CARUID = "/{carUid}";

    @GetMapping(URL_GET_ALL_AVAILABILITY_CAR)
    PaginationResponseDto getAllAvailabilityCar(@RequestParam(name = "page") Integer page,
                                                @RequestParam(name = "size") Integer size,
                                                @RequestParam(name = "showAll") boolean showAll);

    @GetMapping(URL_GET_CAR_BY_CARUID)
    CarResponseDto getCarByCarUid(@PathVariable UUID carUid);

    @PostMapping(URL_UPDATE_CAR_STATUS_BY_CARUID)
    void updateCarStatusByCarUid(@PathVariable UUID carUid);

}
