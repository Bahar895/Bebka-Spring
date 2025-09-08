package com.bahar.Bebka_Spring.repository;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bahar.Bebka_Spring.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameContaining(String name);

    List<Employee> findByDepartment(String department);

    // JPQL
    @Query("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> findBySalaryGreaterThan(@Param("amount") BigDecimal amount);

    // Native SQL
    @Query(value = "SELECT * FROM employee WHERE department = :dept", nativeQuery = true)
    List<Employee> findByDepartmentNative(@Param("dept") String dept);

}