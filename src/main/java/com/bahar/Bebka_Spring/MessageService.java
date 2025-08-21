package com.bahar.Bebka_Spring;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessagePrinter printer;
    // Constructor Injection
    public MessageService(MessagePrinter printer) {
        this.printer = printer;
    }
    public String getMessage() {
        return printer.printMessage();
    }
}
