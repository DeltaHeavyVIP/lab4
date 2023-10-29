package com.example.rental.converter;

import com.example.rental.feign.PaymentService;
import com.example.rental.models.Rental;
import com.example.response.CreateRentalResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class RentalToCreateRentalResponseDto implements Converter<Rental, CreateRentalResponseDto> {

    private final PaymentService paymentService;
    private SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RentalToCreateRentalResponseDto(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public CreateRentalResponseDto convert(Rental rental) {
        CreateRentalResponseDto createRentalResponseDto = new CreateRentalResponseDto();
        createRentalResponseDto.setRentalUid(rental.getRentalUid());
        createRentalResponseDto.setStatus(rental.getStatus());
        createRentalResponseDto.setCarUid(rental.getCarUid());
        createRentalResponseDto.setDateFrom(DateFormat.format(rental.getDateFrom()));
        createRentalResponseDto.setDateTo(DateFormat.format(rental.getDateTo()));
        createRentalResponseDto.setPayment(paymentService.getPaymentInfoByPaymentUid(rental.getPaymentUid()));
        return createRentalResponseDto;
    }
}
