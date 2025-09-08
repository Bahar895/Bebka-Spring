package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Employee;
import com.bahar.Bebka_Spring.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Employee create(Employee e) {
        return repo.save(e);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
        @Transactional(readOnly = true)
        public List<Employee> findByFirstNameContaining(String name) {
            return repo.findByFirstNameContaining(name);
        }
        @Override
        @Transactional(readOnly = true)
        public List<Employee> findByDepartment(String department) {
            return repo.findByDepartment(department); }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findBySalaryGreaterThan(BigDecimal amount) {
        return repo.findBySalaryGreaterThan(amount); }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findByDepartmentNative(String dept) {
        return repo.findByDepartmentNative(dept); }
    @Override
    @Transactional(readOnly = true)
    public Page<Employee> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Employee createRequired(Employee e) {
        return repo.save(e); }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Employee createRequiresNew(Employee e) {
        return repo.save(e); }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Employee> readWithSupports() {
        return repo.findAll(); }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee createWithRollback(Employee e) {
        repo.save(e);
        //Simülasyon için hata fırlatalım
        if(true) {
            throw new RuntimeException("Simule hata- rollback çalışmalı"); }
        return e;
        }
        @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Employee> getEmployeesReadCommitted() {
        return repo.findAll(); }
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Employee> getEmployeesRepeatableRead() {
        return repo.findAll(); }
        }










