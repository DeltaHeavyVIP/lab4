package com.example.payment.converter;

import com.example.common.PaymentInfo;
import com.example.payment.models.Payment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PaymentToPaymentInfo implements Converter<Payment, PaymentInfo> {
    @Override
    public PaymentInfo convert(Payment payment) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentUid(payment.getPaymentUid());
        paymentInfo.setPrice(payment.getPrice());
        paymentInfo.setStatus(payment.getStatus());
        return paymentInfo;
    }
}
