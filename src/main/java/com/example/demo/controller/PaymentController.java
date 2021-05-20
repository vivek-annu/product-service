package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by v on 20/5/21.
 */@RestController
@RequestMapping
public class PaymentController {

     @GetMapping("/home")
    public String welcome(){
         return "welcome to cloud payment-service";
     }
}
