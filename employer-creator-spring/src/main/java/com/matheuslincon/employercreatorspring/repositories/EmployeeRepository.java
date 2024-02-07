package com.matheuslincon.employercreatorspring.repositories;

import com.matheuslincon.employercreatorspring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
