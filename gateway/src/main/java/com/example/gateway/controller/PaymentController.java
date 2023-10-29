package com.example.gateway.controller;

import com.example.common.PaymentInfo;
import com.example.gateway.feign.PaymentService;
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

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{paymentUid}")
    public PaymentInfo getPaymentInfoByPaymentUid(@PathVariable UUID paymentUid) {
        return paymentService.getPaymentInfoByPaymentUid(paymentUid);
    }

    @PostMapping("/{price}")
    public PaymentInfo createPayment(@PathVariable Long price) {
        return paymentService.createPayment(price);
    }

    @PostMapping("cancel/{paymentUid}")
    public ResponseEntity<String> cancelPaymentStatusByPaymentUid(@PathVariable UUID paymentUid) {
        paymentService.cancelPaymentStatusByPaymentUid(paymentUid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
