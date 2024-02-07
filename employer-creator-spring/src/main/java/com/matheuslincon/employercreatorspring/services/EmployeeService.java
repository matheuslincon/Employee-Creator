package com.matheuslincon.employercreatorspring.services;

import com.matheuslincon.employercreatorspring.data.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.model.Employee;
import com.matheuslincon.employercreatorspring.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<EmployeeDTO> findAll() {
        List<Employee> employeeList = repository.findAll();
        return employeeList.stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO create(EmployeeDTO employee) {

        Employee newEmployee = mapper.map(employee, Employee.class);
        Employee createdEmployee = repository.save(newEmployee);
        return mapper.map(createdEmployee, EmployeeDTO.class);
    }
}
