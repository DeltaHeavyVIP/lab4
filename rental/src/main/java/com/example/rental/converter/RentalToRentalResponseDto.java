package com.example.rental.converter;

import com.example.common.CarInfo;
import com.example.rental.feign.CarService;
import com.example.rental.feign.PaymentService;
import com.example.rental.models.Rental;
import com.example.response.CarResponseDto;
import com.example.response.RentalResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class RentalToRentalResponseDto implements Converter<Rental, RentalResponseDto> {

    private final CarService carService;

    private final PaymentService paymentService;

    private SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RentalToRentalResponseDto(CarService carService, PaymentService paymentService) {
        this.carService = carService;
        this.paymentService = paymentService;
    }

    @Override
    public RentalResponseDto convert(Rental rental) {
        RentalResponseDto rentalResponseDto = new RentalResponseDto();
        rentalResponseDto.setRentalUid(rental.getRentalUid());
        rentalResponseDto.setStatus(rental.getStatus());
        rentalResponseDto.setDateFrom(DateFormat.format(rental.getDateFrom()));
        rentalResponseDto.setDateTo(DateFormat.format(rental.getDateTo()));
        CarResponseDto carResponseDto = carService.getCarByCarUid(rental.getCarUid());
        rentalResponseDto.setCar(new CarInfo(carResponseDto.getCarUid().toString(), carResponseDto.getBrand(),
                carResponseDto.getModel(), carResponseDto.getRegistrationNumber()));
        rentalResponseDto.setPayment(paymentService.getPaymentInfoByPaymentUid(rental.getPaymentUid()));
        return rentalResponseDto;
    }
}
