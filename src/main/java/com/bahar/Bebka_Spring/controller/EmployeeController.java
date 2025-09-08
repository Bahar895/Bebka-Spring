package com.bahar.Bebka_Spring.controller;

import com.bahar.Bebka_Spring.model.Employee;
import com.bahar.Bebka_Spring.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
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
    @GetMapping("/search/salary/{amount}")
    public List<Employee> findBySalaryGreaterThan(@PathVariable BigDecimal amount) {
        return service.findBySalaryGreaterThan(amount); }
    @GetMapping("/search/native/{department}")
    public List<Employee> findByDepartmentNative(@PathVariable String department) {
        return service.findByDepartmentNative(department); }
    @GetMapping("/page")
    public Page<Employee> getAllPaged(Pageable pageable) {
        return service.getAll(pageable);
    }
    @PostMapping("/demo/required")
    public Employee demoRequired(@RequestBody Employee e) {
        return service.createRequired(e); }
    @PostMapping("/demo/requires-new")
    public Employee demoRequiresNew(@RequestBody Employee e) {
        return service.createRequiresNew(e); }
    @GetMapping("/demo/supports")
    public List<Employee> demoSupports() {
        return service.readWithSupports(); }
    @PostMapping("/demo/rollback")
    public Employee testRollback(@RequestBody Employee e) {
        return service.createWithRollback(e); }
    @GetMapping("/demo/read-committed")
    public List<Employee> testReadCommitted() {
        return service.getEmployeesReadCommitted(); }
    @GetMapping("/demo/repeatable-read")
    public List<Employee> testRepeatableRead() {
        return service.getEmployeesRepeatableRead(); }
    }


