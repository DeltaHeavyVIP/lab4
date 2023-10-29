package com.example.gateway.feign;

import com.example.request.CreateRentalRequestDto;
import com.example.response.CreateRentalResponseDto;
import com.example.response.RentalResponseDto;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "rental-service", url = "http://rental:8060/api/v1/rental")
public interface RentalService {

    String URL_GET_ALL_RENTAL = "";
    String URL_CREATE_RENTAL = "";
    String URL_GET_RENTAL_BY_UID = "/{rentalUid}";
    String URL_REMOVE_RENTAL_BY_UID = "/{rentalUid}";
    String URL_FINISH_RENTAL_BY_UID = "/{rentalUid}/finish";

    @GetMapping(URL_GET_ALL_RENTAL)
    List<RentalResponseDto> getAllRental(@RequestHeader("X-User-Name") String userName);

    @PostMapping(URL_CREATE_RENTAL)
    CreateRentalResponseDto createRental(@RequestHeader("X-User-Name") String userName,
                                         @RequestBody CreateRentalRequestDto createRentalRequestDto);

    @GetMapping(URL_GET_RENTAL_BY_UID)
    RentalResponseDto getRentalByUid(@RequestHeader("X-User-Name") String userName,
                                     @PathVariable UUID rentalUid);

    @DeleteMapping(URL_REMOVE_RENTAL_BY_UID)
    ResponseEntity<String> removeRentalByUid(@RequestHeader("X-User-Name") String userName,
                                             @PathVariable UUID rentalUid);

    @PostMapping(URL_FINISH_RENTAL_BY_UID)
    ResponseEntity<String> finishRentalByUid(@RequestHeader("X-User-Name") String userName,
                                             @PathVariable UUID rentalUid);
}
