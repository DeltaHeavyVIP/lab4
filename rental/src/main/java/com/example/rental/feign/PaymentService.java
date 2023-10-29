package com.example.rental.feign;

import com.example.common.PaymentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "payment-service", url = "http://gateway:8080/api/v1/payment")
public interface PaymentService {

    String URL_GET_PAYMENT_INFO_BY_PAYMENTUID = "/{paymentUid}";
    String URL_CREATE_PAYMENT = "/{price}";
    String URL_CANCEL_PAYMENT_STATUS_BY_PAYMENTUID = "/cancel/{paymentUid}";

    @GetMapping(URL_GET_PAYMENT_INFO_BY_PAYMENTUID)
    PaymentInfo getPaymentInfoByPaymentUid(@PathVariable UUID paymentUid);

    @PostMapping(URL_CREATE_PAYMENT)
    PaymentInfo createPayment(@PathVariable Long price);

    @PostMapping(URL_CANCEL_PAYMENT_STATUS_BY_PAYMENTUID)
    void cancelPaymentStatusByPaymentUid(@PathVariable UUID paymentUid);

}

