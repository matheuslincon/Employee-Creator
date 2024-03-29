package com.matheuslincon.employercreatorspring.unittests.mockito.services;

import com.matheuslincon.employercreatorspring.data.dto.EmployeeCreateDTO;
import com.matheuslincon.employercreatorspring.data.dto.EmployeeUpdateDTO;
import com.matheuslincon.employercreatorspring.exceptions.RequiredObjectIsNullException;
import com.matheuslincon.employercreatorspring.exceptions.ResourceNotFoundException;
import com.matheuslincon.employercreatorspring.model.Employee;
import com.matheuslincon.employercreatorspring.repositories.EmployeeRepository;
import com.matheuslincon.employercreatorspring.services.EmployeeService;
import com.matheuslincon.employercreatorspring.unittests.mockito.mocks.MockEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    MockEmployee input;

    @InjectMocks
    private EmployeeService service;

    @Spy
    ModelMapper mapper;

    @Mock
    EmployeeRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockEmployee();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void findById() {
        Employee entity = input.mockEntity(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(entity.getId());

        verify(repository, times(1)).findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/employee/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Middle Name Test1", result.getMiddleName());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("Mobile Test1", result.getMobile());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Contract Type Test1", result.getContractType());
        assertEquals("Start Date Test1", result.getStartDate());
        assertEquals("Finish Date Test1", result.getFinishDate());
        assertEquals("HoursType Test1", result.getHoursType());
        assertEquals(21, result.getHoursPerWeek());
    }

    @Test
    void create() {
        Employee entity = input.mockEntity(1);

        EmployeeCreateDTO dto = input.mockCreateDTO(1);

        when(repository.save(any(Employee.class))).thenReturn(entity);

        var result = service.create(dto);

        verify(repository, times(1)).save(any(Employee.class));

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/employee/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Middle Name Test1", result.getMiddleName());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("Mobile Test1", result.getMobile());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Contract Type Test1", result.getContractType());
        assertEquals("Start Date Test1", result.getStartDate());
        assertEquals("Finish Date Test1", result.getFinishDate());
        assertEquals("HoursType Test1", result.getHoursType());
        assertEquals(21, result.getHoursPerWeek());
    }

    @Test
    void testCreateWithNullEmployee() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        Employee entity = input.mockEntity(1);

        EmployeeUpdateDTO dto = input.mockUpdateDTO(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(any(Employee.class))).thenReturn(entity);

        var result = service.update(1L, dto);

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Employee.class));

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/employee/1>;rel=\"self\"]"));

        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Middle Name Test1", result.getMiddleName());
        assertEquals("Mobile Test1", result.getMobile());
        assertEquals("Address Test1", result.getAddress());
        assertEquals("Contract Type Test1", result.getContractType());
        assertEquals("Start Date Test1", result.getStartDate());
        assertEquals("Finish Date Test1", result.getFinishDate());
        assertEquals("HoursType Test1", result.getHoursType());
        assertEquals(21, result.getHoursPerWeek());
    }

    @Test
    void testUpdateWithNullEmployee() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(1L,null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Employee entity = input.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(entity);

        assertThrows(ResourceNotFoundException.class, () -> service.delete(2L));
    }
}