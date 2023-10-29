package com.example.rental.controller;

import com.example.rental.models.Rental;
import com.example.rental.service.RentalService;
import com.example.request.CreateRentalRequestDto;
import com.example.response.CreateRentalResponseDto;
import com.example.response.RentalResponseDto;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
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

    //Почему final для String? Потому что Spring тупой и требует константу!
    private final String X_User_Name_HEADER = "X-User-Name";

    private final RentalService rentalService;
    private final ConversionService conversionService;

    public RentalController(RentalService rentalService, ConversionService conversionService) {
        this.rentalService = rentalService;
        this.conversionService = conversionService;
    }


    @GetMapping("")
    public List<RentalResponseDto> getAllRental(@RequestHeader(X_User_Name_HEADER) String userName) {
        return rentalService.getAllRental(userName).stream().map(rental -> conversionService.convert(rental,
                RentalResponseDto.class)).toList();
    }

    @PostMapping("")
    public CreateRentalResponseDto createRental(@RequestHeader(X_User_Name_HEADER) String userName,
                                                @RequestBody CreateRentalRequestDto createRentalRequestDto) {
        return conversionService.convert(rentalService.createRental(userName,
                conversionService.convert(createRentalRequestDto,
                        Rental.class)), CreateRentalResponseDto.class);
    }

    @GetMapping("/{rentalUid}")
    public RentalResponseDto getRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                            @PathVariable UUID rentalUid) {
        return conversionService.convert(rentalService.getRentalByUid(userName, rentalUid), RentalResponseDto.class);
    }

    @DeleteMapping("/{rentalUid}")
    public ResponseEntity<String> removeRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                                    @PathVariable UUID rentalUid) {
        rentalService.removeRentalByUid(userName, rentalUid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{rentalUid}/finish")
    public ResponseEntity<String> finishRentalByUid(@RequestHeader(X_User_Name_HEADER) String userName,
                                                    @PathVariable UUID rentalUid) {
        rentalService.finishRentalByUid(userName, rentalUid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
