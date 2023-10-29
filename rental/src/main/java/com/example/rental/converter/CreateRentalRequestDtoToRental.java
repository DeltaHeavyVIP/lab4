package com.example.rental.converter;

import com.example.rental.models.Rental;
import com.example.request.CreateRentalRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class CreateRentalRequestDtoToRental implements Converter<CreateRentalRequestDto, Rental> {

    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Rental convert(CreateRentalRequestDto createRentalRequestDto) {
        Rental rental = new Rental();
        rental.setCarUid(createRentalRequestDto.getCarUid());
        rental.setDateFrom(createRentalRequestDto.getDateFrom());
        rental.setDateTo(createRentalRequestDto.getDateTo());
        return rental;
    }
}
