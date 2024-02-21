package com.matheuslincon.employercreatorspring.services;

import com.matheuslincon.employercreatorspring.controllers.EmployeeController;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeCreateDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeUpdateDTO;
import com.matheuslincon.employercreatorspring.exceptions.RequiredObjectIsNullException;
import com.matheuslincon.employercreatorspring.exceptions.ResourceNotFoundException;
import com.matheuslincon.employercreatorspring.model.Employee;
import com.matheuslincon.employercreatorspring.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    PagedResourcesAssembler<EmployeeDTO> assembler;

    public PagedModel<EntityModel<EmployeeDTO>> findAll(Pageable pageable) {
        Page<Employee> employeePage = repository.findAll(pageable);

        var employeesDTOPage = employeePage.map(e -> mapper.map(e, EmployeeDTO.class));

        employeesDTOPage.map(e -> e.add(linkTo(methodOn(EmployeeController.class).findById(e.getId())).withSelfRel()));

        Link link = linkTo(methodOn(EmployeeController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(employeesDTOPage, link);
    }

    public PagedModel<EntityModel<EmployeeDTO>> findEmployeesByName(String firstName, Pageable pageable) {

        Page<Employee> employeePage = repository.findEmployeesByName(firstName, pageable);

        var employeesDTOPage = employeePage.map(e -> mapper.map(e, EmployeeDTO.class));

        employeesDTOPage.map(e -> e.add(linkTo(methodOn(EmployeeController.class).findById(e.getId())).withSelfRel()));

        Link link = linkTo(methodOn(EmployeeController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(employeesDTOPage, link);
    }

    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
        EmployeeDTO dto = mapper.map(employee, EmployeeDTO.class);
        dto.add(linkTo(methodOn(EmployeeController.class).findById(id)).withSelfRel());
        return dto;
    }

    public EmployeeDTO create(EmployeeCreateDTO data) {

        if(data == null) throw new RequiredObjectIsNullException();

        Employee newEmployee = mapper.map(data, Employee.class);
        Employee createdEmployee = repository.save(newEmployee);
        EmployeeDTO dto = mapper.map(createdEmployee, EmployeeDTO.class);
        dto.add(linkTo(methodOn(EmployeeController.class).findById(createdEmployee.getId())).withSelfRel());
        return dto;
    }

    public EmployeeDTO update(Long id, EmployeeUpdateDTO data) {

        if(data == null) throw new RequiredObjectIsNullException();

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

        EmployeeDTO dto = mapper.map(this.repository.save(employee), EmployeeDTO.class);
        dto.add(linkTo(methodOn(EmployeeController.class).findById(id)).withSelfRel());
        return dto;
    }

    public void delete(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
        repository.delete(employee);
    }
}
