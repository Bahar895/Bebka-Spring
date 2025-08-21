package com.bahar.Bebka_Spring;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public String printMessage() {
        return "Merhaba Spring IoC! Nesneyi Spring oluşturdu.";
    }
}
