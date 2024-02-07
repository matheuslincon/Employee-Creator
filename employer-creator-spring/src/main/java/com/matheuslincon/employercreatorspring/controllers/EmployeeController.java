package com.matheuslincon.employercreatorspring.controllers;

import com.matheuslincon.employercreatorspring.data.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employee) {
        return service.create(employee);
    }
}
