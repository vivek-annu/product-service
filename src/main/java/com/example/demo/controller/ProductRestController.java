package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest/product/")
public class ProductRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client")
    public String welcomeProduct(){
        System.out.println("Vivek app is in cloud now");
        return "WELCOME TO PRODUCT SERVICE";
    }


    @HystrixCommand(fallbackMethod = "welcomeFallback")
    @GetMapping
    public String welcome(){
        String URL= "http://SHOPPING-CART-SERVICE/shopping/";
        return restTemplate.getForObject(URL,String.class);
    }


    public String welcomeFallback(){
        return "Welcome to fallback method for shopping cart service";
    }
}
