package com.example.rental.service;

import com.example.rental.models.Rental;

import java.util.List;
import java.util.UUID;

public interface RentalService {
    List<Rental> getAllRental(String userName);

    Rental createRental(String userName, Rental rental);

    Rental getRentalByUid(String userName, UUID rentalUid);

    void removeRentalByUid(String userName, UUID rentalUid);

    void finishRentalByUid(String userName, UUID rentalUid);
}
