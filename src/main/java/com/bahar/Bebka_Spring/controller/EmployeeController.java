package com.bahar.Bebka_Spring.controller;

import com.bahar.Bebka_Spring.model.Employee;
import com.bahar.Bebka_Spring.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return service.create(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return service.findByFirstNameContaining(name);
    }
    @GetMapping("/search/department/{department}")
    public List<Employee> searchByDepartment(@PathVariable String department) {
        return service.findByDepartment(department);
    }
}
