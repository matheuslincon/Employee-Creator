package com.matheuslincon.employercreatorspring.integrationtests.controller;

import static io.restassured.RestAssured.given;

import com.matheuslincon.employercreatorspring.config.TestConfig;
import com.matheuslincon.employercreatorspring.integrationtests.dto.AccountCredentialsDTO;
import com.matheuslincon.employercreatorspring.integrationtests.dto.TokenDTO;
import com.matheuslincon.employercreatorspring.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class AuthControllerTest extends AbstractIntegrationTest {

    private static TokenDTO tokenDTO;

    @Test
    @Order(1)
    public void testSignin() throws JsonMappingException, JsonProcessingException {

        AccountCredentialsDTO user = new AccountCredentialsDTO("matheus", "admin123");

        tokenDTO = given()
                .basePath("/auth/signin")
                    .port(TestConfig.SERVER_PORT)
                    .contentType(TestConfig.CONTENT_TYPE_JSON)
                .body(user)
                    .when()
                .post()
                    .then()
                        .statusCode(200)
                            .extract()
                                .body()
                                    .as(TokenDTO.class);

        Assertions.assertNotNull(tokenDTO.getAccessToken());
        Assertions.assertNotNull(tokenDTO.getRefreshToken());
    }

    @Test
    @Order(2)
    public void testRefresh() throws JsonMappingException, JsonProcessingException {

        var newTokenDTO = given()
                .basePath("/auth/refresh")
                    .port(TestConfig.SERVER_PORT)
                    .contentType(TestConfig.CONTENT_TYPE_JSON)
                    .pathParam("username", tokenDTO.getUsername())
                    .header(TestConfig.HEADER_PARAM_AUTHORIZATION, "Bearer " + tokenDTO.getRefreshToken())
                    .when()
                .put("{username}")
                    .then()
                        .statusCode(200)
                            .extract()
                                .body()
                                    .as(TokenDTO.class);

        Assertions.assertNotNull(newTokenDTO.getAccessToken());
        Assertions.assertNotNull(newTokenDTO.getRefreshToken());
    }
}
