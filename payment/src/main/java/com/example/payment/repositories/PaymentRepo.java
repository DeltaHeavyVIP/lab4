package com.example.payment.repositories;

import com.example.payment.models.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {

    Optional<Payment> findByPaymentUid(UUID paymentUid);

}
