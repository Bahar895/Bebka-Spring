package com.bahar.Bebka_Spring.controller;

import com.bahar.Bebka_Spring.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")        // sınıf seviyesinde /api
public class HelloController {

    private final MessageService service;
    public HelloController(MessageService service) {
    this.service = service;
    }
    @GetMapping("/hello")      // burada SADECE /hello
    public String sayHello() {
        return service.getMessage();
       }
    }

