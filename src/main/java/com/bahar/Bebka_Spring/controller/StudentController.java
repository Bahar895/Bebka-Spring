package com.bahar.Bebka_Spring.controller;

import com.bahar.Bebka_Spring.dto.request.StudentRequest;
import com.bahar.Bebka_Spring.dto.response.StudentResponse;
import com.bahar.Bebka_Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@Valid @RequestBody StudentRequest request) {
        return service.create(request);
    }

    // READ - LIST
    @GetMapping
    public List<StudentResponse> list() {
        return service.findAll();
    }

    // READ - BY ID
    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
