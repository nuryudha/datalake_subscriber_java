package com.datalake.datalake_subscriber_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.services.DatalakeService;

@RestController
public class HelloController {

    @Autowired
    private DatalakeService datalakeService;

    @GetMapping("/")
    public String getMethodHello() {
        return "Datalake Subscriber Java is Running!";
    }

    @GetMapping("/datalake/{order_id}")
    public DatalakeEntity getDatalakeEntity(@PathVariable String order_id) {
        return datalakeService.findByOrder_id(order_id);
    }

}
