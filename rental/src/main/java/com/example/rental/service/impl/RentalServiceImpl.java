package com.example.rental.service.impl;

import com.example.common.PaymentInfo;
import com.example.enums.RentalStatus;
import com.example.exception.CarAlreadyUsedException;
import com.example.exception.ResourceNotFoundException;
import com.example.rental.feign.CarService;
import com.example.rental.feign.PaymentService;
import com.example.rental.models.Rental;
import com.example.rental.repositories.RentalRepo;
import com.example.rental.service.RentalService;
import com.example.response.CarResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepo rentalRepo;

    private final CarService carService;

    private final PaymentService paymentService;

    public RentalServiceImpl(RentalRepo rentalRepo, CarService carService, PaymentService paymentService) {
        this.rentalRepo = rentalRepo;
        this.carService = carService;
        this.paymentService = paymentService;
    }

    @Override
    public List<Rental> getAllRental(String userName) {
        return rentalRepo.findAllByUsername(userName);
    }

    @Override
    public Rental createRental(String userName, Rental rental) {
        CarResponseDto car = carService.getCarByCarUid(rental.getCarUid());

        if (!car.getAvailable()) {
            throw new CarAlreadyUsedException(String.format("Car with carUid %s already in used", rental.getCarUid().toString()));
        }
        carService.updateCarStatusByCarUid(rental.getCarUid());

        PaymentInfo paymentInfo = paymentService.createPayment(TimeUnit.DAYS.convert(Math.abs(rental.getDateTo().getTime() - rental.getDateFrom().getTime()),
                TimeUnit.MILLISECONDS) * car.getPrice());

        rental.setRentalUid(UUID.randomUUID());
        rental.setUsername(userName);
        rental.setPaymentUid(paymentInfo.getPaymentUid());
        rental.setStatus(RentalStatus.IN_PROGRESS);
        return rentalRepo.save(rental);
    }

    @Override
    public Rental getRentalByUid(String userName, UUID rentalUid) {
        return rentalRepo.findByRentalUidAndUsername(rentalUid, userName).orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find " +
                "rental with rentalUid %s for this userName %s", rentalUid.toString(), userName)));
    }

    @Override
    public void removeRentalByUid(String userName, UUID rentalUid) {
        Rental rental = getRentalByUid(userName, rentalUid);
        rental.setStatus(RentalStatus.CANCELED);
        rentalRepo.save(rental);
        carService.updateCarStatusByCarUid(rental.getCarUid());
        paymentService.cancelPaymentStatusByPaymentUid(rental.getPaymentUid());
    }

    @Override
    public void finishRentalByUid(String userName, UUID rentalUid) {
        Rental rental = getRentalByUid(userName, rentalUid);
        rental.setStatus(RentalStatus.FINISHED);
        rentalRepo.save(rental);
        carService.updateCarStatusByCarUid(rental.getCarUid());
    }
}
