package com.matheuslincon.employercreatorspring.integrationtests.controller;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheuslincon.employercreatorspring.config.TestConfig;
import com.matheuslincon.employercreatorspring.integrationtests.dto.EmployeeCreateDTO;
import com.matheuslincon.employercreatorspring.integrationtests.dto.EmployeeDTO;
import com.matheuslincon.employercreatorspring.integrationtests.testcontainers.AbstractIntegrationTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest extends AbstractIntegrationTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    @Order(1)
    public void testCreate() throws JsonProcessingException {
        EmployeeCreateDTO employee = new EmployeeCreateDTO();
        employee.setFirstName("Matheus");
        employee.setMiddleName("Lincon");
        employee.setLastName("Andrade");
        employee.setEmail("matheus@email.com");
        employee.setMobile("123123123");
        employee.setAddress("New York City, New York, US");
        employee.setContractType("Permanent");
        employee.setStartDate("21/01/2000");
        employee.setFinishDate("21/01/2010");
        employee.setHoursType("Full-time");
        employee.setHoursPerWeek(40);

        specification = new RequestSpecBuilder()
                .addHeader(TestConfig.HEADER_PARAM_ORIGIN, "http://localhost:5173")
                .setBasePath("/employee")
                .setPort(TestConfig.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content = given().spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .body(employee)
                .when()
                    .post()
                .then()
                    .statusCode(201)
                .extract()
                    .body()
                        .asString();

        EmployeeDTO persistedEmployee = objectMapper.readValue(content, EmployeeDTO.class);

        Assertions.assertNotNull(persistedEmployee);
        Assertions.assertNotNull(persistedEmployee.getId());
        Assertions.assertNotNull(persistedEmployee.getFirstName());
        Assertions.assertNotNull(persistedEmployee.getLastName());
        Assertions.assertNotNull(persistedEmployee.getAddress());

        assertTrue(persistedEmployee.getId() > 0);

        assertEquals("Matheus", persistedEmployee.getFirstName());
        assertEquals("Andrade", persistedEmployee.getLastName());
        assertEquals("New York City, New York, US", persistedEmployee.getAddress());
    }

    @Test
    @Order(2)
    public void testCreateWithWrongOrigin() throws JsonProcessingException {
        EmployeeCreateDTO employee = new EmployeeCreateDTO();
        employee.setFirstName("Matheus");
        employee.setMiddleName("Lincon");
        employee.setLastName("Andrade");
        employee.setEmail("matheus@email.com");
        employee.setMobile("123123123");
        employee.setAddress("New York City, New York, US");
        employee.setContractType("Permanent");
        employee.setStartDate("21/01/2000");
        employee.setFinishDate("21/01/2010");
        employee.setHoursType("Full-time");
        employee.setHoursPerWeek(40);

        specification = new RequestSpecBuilder()
                .addHeader(TestConfig.HEADER_PARAM_ORIGIN, "https://matheuslincon.com")
                .setBasePath("/employee")
                .setPort(TestConfig.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content = given().spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .body(employee)
                .when()
                    .post()
                .then()
                    .statusCode(403)
                .extract()
                    .body()
                        .asString();


        Assertions.assertNotNull(content);

        assertEquals("Invalid CORS request", content);
    }

    @Test
    @Order(3)
    public void testFindById() throws JsonProcessingException {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(1L);
        employee.setFirstName("Matheus");
        employee.setMiddleName("Lincon");
        employee.setLastName("Andrade");
        employee.setEmail("matheus@email.com");
        employee.setMobile("123123123");
        employee.setAddress("New York City, New York, US");
        employee.setContractType("Permanent");
        employee.setStartDate("21/01/2000");
        employee.setFinishDate("21/01/2010");
        employee.setHoursType("Full-time");
        employee.setHoursPerWeek(40);

        specification = new RequestSpecBuilder()
                .addHeader(TestConfig.HEADER_PARAM_ORIGIN, "http://localhost:5173")
                .setBasePath("/employee")
                .setPort(TestConfig.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content = given().spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .pathParam("id", employee.getId())
                .when()
                    .get("{id}")
                .then()
                    .statusCode(200)
                .extract()
                    .body()
                        .asString();

        EmployeeDTO persistedEmployee = objectMapper.readValue(content, EmployeeDTO.class);

        Assertions.assertNotNull(persistedEmployee);
        Assertions.assertNotNull(persistedEmployee.getId());
        Assertions.assertNotNull(persistedEmployee.getFirstName());
        Assertions.assertNotNull(persistedEmployee.getLastName());
        Assertions.assertNotNull(persistedEmployee.getAddress());

        assertEquals(1L, persistedEmployee.getId());
        assertEquals("Matheus", persistedEmployee.getFirstName());
        assertEquals("Andrade", persistedEmployee.getLastName());
        assertEquals("New York City, New York, US", persistedEmployee.getAddress());
    }

    @Test
    @Order(4)
    public void testFindByIdWithWrongOrigin() throws JsonProcessingException {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(1L);
        employee.setFirstName("Matheus");
        employee.setMiddleName("Lincon");
        employee.setLastName("Andrade");
        employee.setEmail("matheus@email.com");
        employee.setMobile("123123123");
        employee.setAddress("New York City, New York, US");
        employee.setContractType("Permanent");
        employee.setStartDate("21/01/2000");
        employee.setFinishDate("21/01/2010");
        employee.setHoursType("Full-time");
        employee.setHoursPerWeek(40);

        specification = new RequestSpecBuilder()
                .addHeader(TestConfig.HEADER_PARAM_ORIGIN, "https://matheuslincon.com")
                .setBasePath("/employee")
                .setPort(TestConfig.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content = given().spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .pathParam("id", employee.getId())
                .when()
                    .get("{id}")
                .then()
                    .statusCode(403)
                .extract()
                    .body()
                        .asString();


        Assertions.assertNotNull(content);

        assertEquals("Invalid CORS request", content);
    }
}
