package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    @GetMapping("/manage/health")
    public String ping() {
        return "pong";
    }

}
