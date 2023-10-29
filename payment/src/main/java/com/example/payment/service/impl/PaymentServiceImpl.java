package com.example.payment.service.impl;

import com.example.enums.PaymentStatus;
import com.example.exception.ResourceNotFoundException;
import com.example.payment.models.Payment;
import com.example.payment.repositories.PaymentRepo;
import com.example.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment getPaymentInfoByPaymentUid(UUID paymentUid) {
        return paymentRepo.findByPaymentUid(paymentUid).orElseThrow(() -> new ResourceNotFoundException(String.format(
                "Could not find payment with paymentUid %s", paymentUid.toString())));
    }

    @Override
    public Payment createPayment(Integer price) {
        Payment payment = paymentRepo.save(new Payment(UUID.randomUUID(), PaymentStatus.PAID, price));
        return payment;
    }

    @Override
    public void cancelPaymentStatusByPaymentUid(UUID paymentUid) {
        Payment payment =
                paymentRepo.findByPaymentUid(paymentUid).orElseThrow(() -> new ResourceNotFoundException(String.format(
                        "Could not find payment with paymentUid %s", paymentUid.toString())));
        payment.setStatus(PaymentStatus.CANCELED);
        paymentRepo.save(payment);
    }

}
