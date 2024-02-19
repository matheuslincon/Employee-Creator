package com.matheuslincon.employercreatorspring.repositories;

import com.matheuslincon.employercreatorspring.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE LOWER(CONCAT ('%',:firstName,'%'))")
    Page<Employee> findEmployeesByName(@Param("firstName") String firstName, Pageable pageable);
}
