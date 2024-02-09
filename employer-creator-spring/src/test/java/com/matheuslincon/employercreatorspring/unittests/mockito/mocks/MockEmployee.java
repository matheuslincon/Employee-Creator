package com.matheuslincon.employercreatorspring.unittests.mockito.mocks;

import com.matheuslincon.employercreatorspring.data.dto.EmployeeCreateDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeUpdateDTO;
import com.matheuslincon.employercreatorspring.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MockEmployee {

    public Employee mockEntity() {
        return mockEntity(0);
    }

    public EmployeeDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Employee> mockEntityList() {
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) {
            employees.add(mockEntity(i));
        }
        return employees;
    }

    public List<EmployeeDTO> mockVOList() {
        List<EmployeeDTO> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employees.add(mockDTO(i));
        }
        return employees;
    }

    public Employee mockEntity(Integer number) {
        Employee employee = new Employee();
        employee.setId(number.longValue());
        employee.setFirstName("First Name Test" + number);
        employee.setMiddleName("Middle Name Test" + number);
        employee.setLastName("Last Name Test" + number);
        employee.setEmail("Email Test" + number);
        employee.setMobile("Mobile Test" + number);
        employee.setAddress("Address Test" + number);
        employee.setContractType("Contract Type Test" + number);
        employee.setStartDate("Start Date Test" + number);
        employee.setFinishDate("Finish Date Test" + number);
        employee.setHoursType("HoursType Test" + number);
        employee.setHoursPerWeek(20 + number);
        return employee;
    }

    public EmployeeDTO mockDTO(Integer number) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(number.longValue());
        employee.setFirstName("First Name Test" + number);
        employee.setMiddleName("Middle Name Test" + number);
        employee.setLastName("Last Name Test" + number);
        employee.setEmail("EmailTest" + number);
        employee.setMobile("Mobile Test" + number);
        employee.setAddress("Address Test" + number);
        employee.setContractType("Contract Type Test" + number);
        employee.setStartDate("Start Date Test" + number);
        employee.setFinishDate("Finish Date Test" + number);
        employee.setHoursType("HoursType Test" + number);
        employee.setHoursPerWeek(20 + number);
        return employee;
    }

    public EmployeeCreateDTO mockCreateDTO(Integer number) {
        EmployeeCreateDTO employee = new EmployeeCreateDTO();
        employee.setFirstName("First Name Test" + number);
        employee.setMiddleName("Middle Name Test" + number);
        employee.setLastName("Last Name Test" + number);
        employee.setEmail("EmailTest" + number);
        employee.setMobile("Mobile Test" + number);
        employee.setAddress("Address Test" + number);
        employee.setContractType("Contract Type Test" + number);
        employee.setStartDate("Start Date Test" + number);
        employee.setFinishDate("Finish Date Test" + number);
        employee.setHoursType("HoursType Test" + number);
        employee.setHoursPerWeek(20 + number);
        return employee;
    }

    public EmployeeUpdateDTO mockUpdateDTO(Integer number) {
        EmployeeUpdateDTO employee = new EmployeeUpdateDTO();
        employee.setFirstName("First Name Test" + number);
        employee.setMiddleName("Middle Name Test" + number);
        employee.setLastName("Last Name Test" + number);
        employee.setMobile("Mobile Test" + number);
        employee.setAddress("Address Test" + number);
        employee.setContractType("Contract Type Test" + number);
        employee.setStartDate("Start Date Test" + number);
        employee.setFinishDate("Finish Date Test" + number);
        employee.setHoursType("HoursType Test" + number);
        employee.setHoursPerWeek(20 + number);
        return employee;
    }

}
