package com.bahar.Bebka_Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")        // sınıf seviyesinde /api
public class HelloController {

    @GetMapping("/hello")      // burada SADECE /hello
    public String sayHello() {
        return "Merhaba Spring Boot!!";
    }
}
