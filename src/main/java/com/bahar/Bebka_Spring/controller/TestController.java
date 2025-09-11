package com.bahar.Bebka_Spring.controller;


import com.bahar.Bebka_Spring.exception.BusinessException;
import com.bahar.Bebka_Spring.exception.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/notfound")
    public String triggerNotFound() {
        throw new NotFoundException("Student bulunamadı");
    }
    @GetMapping("/business")
    public String triggerBusiness() {
        throw new BusinessException("Yaş 18'den küçük olamaz");
    }
    @GetMapping("/ok")
    public String ok() {
        return "Herşey yolunda!";

    }
}
