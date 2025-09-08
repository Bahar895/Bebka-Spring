package com.bahar.Bebka_Spring.controller;

import com.bahar.Bebka_Spring.model.Student;
import com.bahar.Bebka_Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student ceate(@RequestBody Student s) {
        return service.create(s);
    }
    @GetMapping
    public List<Student> list() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.findById(id); }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student s) {
        return service.update(id,s) ; }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id); }
    }

