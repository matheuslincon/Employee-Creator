package com.matheuslincon.employercreatorspring.services;

import com.matheuslincon.employercreatorspring.data.dto.EmployeeCreateDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeUpdateDTO;
import com.matheuslincon.employercreatorspring.exceptions.ResourceNotFoundException;
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

    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
        return mapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO create(EmployeeCreateDTO data) {

        Employee newEmployee = mapper.map(data, Employee.class);
        Employee createdEmployee = repository.save(newEmployee);
        return mapper.map(createdEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO update(Long id, EmployeeUpdateDTO data) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));

        employee.setFirstName(data.getFirstName());
        employee.setMiddleName(data.getMiddleName());
        employee.setLastName(data.getLastName());
        employee.setMobile(data.getMobile());
        employee.setAddress(data.getAddress());
        employee.setContractType(data.getContractType());
        employee.setStartDate(data.getStartDate());
        employee.setFinishDate(data.getFinishDate());
        employee.setHoursType(data.getHoursType());
        employee.setHoursPerWeek(data.getHoursPerWeek());

        return mapper.map(this.repository.save(employee), EmployeeDTO.class);
    }

    public void delete(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
        repository.delete(employee);
    }
}
