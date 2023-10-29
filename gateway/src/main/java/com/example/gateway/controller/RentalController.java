package com.example.gateway.controller;

import com.example.gateway.feign.RentalService;
import com.example.request.CreateRentalRequestDto;
import com.example.response.CreateRentalResponseDto;
import com.example.response.RentalResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/rental", produces = MediaType.APPLICATION_JSON_VALUE)
public class RentalController {

    private final RentalService rentalService;

    private final String X_User_Name_HEADER = "X-User-Name";

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("")
    public List<RentalResponseDto> getAllRental(@RequestHeader(X_User_Name_HEADER) String userName) {
        return rentalService.getAllRental(userName);
    }

    @PostMapping("")
    public CreateRentalResponseDto createRental(@RequestHeader(X_User_Name_HEADER) String userName,
                                                @RequestBody CreateRentalRequestDto createRentalRequestDto) {
        return rentalService.createRental(userName, createRentalRequestDto);
    }

    @GetMapping("/{rentalUid}")
    public RentalResponseDto getRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                            @PathVariable UUID rentalUid) {
        return rentalService.getRentalByUid(userName, rentalUid);
    }

    @DeleteMapping("/{rentalUid}")
    public ResponseEntity<String> removeRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                                    @PathVariable UUID rentalUid) {
        return rentalService.removeRentalByUid(userName, rentalUid);
    }

    @PostMapping("/{rentalUid}/finish")
    public ResponseEntity<String> finishRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                                    @PathVariable UUID rentalUid) {
        return rentalService.finishRentalByUid(userName, rentalUid);
    }

}
