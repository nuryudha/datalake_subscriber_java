package com.datalake.datalake_subscriber_java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getMethodHello() {
        return "Datalake Subscriber Java is Running!";
    }

}
