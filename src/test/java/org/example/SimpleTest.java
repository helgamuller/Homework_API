package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/9d6195226a0a4952a5a3524799e8fd7d";

        //DRY - Don't repeat yourself
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        //given-when-then BDD
        StudentRequests.createStudent("{\n" + "  \"name\": \"Kate Petrova\",\n" + "  \"grade\": 3\n" + "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {

        //ПРИНЦИПЫ РАЗРАБОТКИ API ТЕСТОВ:
        //1. ATOMIC TESTS
        //2. TEST CREATES TEST DATA FOR ITSELF
        //3. FAIL FIRST


        //ШАГ 1 создание студента
        String id = StudentRequests.createStudent("{\n" + "  \"name\": \"Kate Petrova\",\n" + "  \"grade\": 3\n" + "}");

        //STEP 2: DELETE STUDENT
        StudentRequests.deleteStudent(id);

        //STEP 3: Check then student  doesn't exist anymore
        given()
                .get("/student/" +id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

}
