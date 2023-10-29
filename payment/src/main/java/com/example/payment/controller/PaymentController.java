package com.example.payment.controller;

import com.example.common.PaymentInfo;
import com.example.payment.service.PaymentService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    private final PaymentService paymentService;

    private final ConversionService conversionService;

    public PaymentController(PaymentService paymentService, ConversionService conversionService) {
        this.paymentService = paymentService;
        this.conversionService = conversionService;
    }

    @GetMapping("/{paymentUid}")
    public PaymentInfo getPaymentInfoByPaymentUid(@PathVariable UUID paymentUid) {
        return conversionService.convert(paymentService.getPaymentInfoByPaymentUid(paymentUid), PaymentInfo.class);
    }

    @PostMapping("/{price}")
    public PaymentInfo createPayment(@PathVariable Integer price) {
        return conversionService.convert(paymentService.createPayment(price), PaymentInfo.class);
    }

    @PostMapping("cancel/{paymentUid}")
    public ResponseEntity<String> cancelPaymentStatusByPaymentUid(@PathVariable UUID paymentUid) {
        paymentService.cancelPaymentStatusByPaymentUid(paymentUid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
