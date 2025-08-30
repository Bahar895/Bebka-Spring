package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Employee;
import com.bahar.Bebka_Spring.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee create(Employee e) {
        return repo.save(e);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee update(Long id, Employee e) {
        Employee cur = repo.findById(id).orElse(null);
        if (cur == null) return null;
        cur.setFirstName(e.getFirstName());
        cur.setLastName(e.getLastName());
        cur.setEmail(e.getEmail());
        return repo.save(cur);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

        @Override
        public List<Employee> findByFirstNameContaining(String name) {
            return repo.findByFirstNameContaining(name);
        }
        @Override
        public List<Employee> findByDepartment(String department) {
            return repo.findByDepartment(department); }

    @Override
    public List<Employee> findBySalaryGreaterThan(BigDecimal amount) {
        return repo.findBySalaryGreaterThan(amount); }

    @Override
    public List<Employee> findByDepartmentNative(String dept) {
        return repo.findByDepartmentNative(dept); }
    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
    }








