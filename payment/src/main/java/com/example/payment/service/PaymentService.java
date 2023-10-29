package com.example.payment.service;

import com.example.payment.models.Payment;

import java.util.UUID;

public interface PaymentService {

    Payment getPaymentInfoByPaymentUid(UUID paymentUid);

    Payment createPayment(Integer price);

    void cancelPaymentStatusByPaymentUid(UUID paymentUid);
}
