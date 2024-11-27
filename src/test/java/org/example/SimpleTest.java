package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/962812dda5ca4589a0fcaa885bf98dbc";

        //DRY - Don't repeat yourself
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        //given-when-then BDD

        //serialization from JSON to object and vice versa
        //Student student = new Student("Kate P", 2, "");
        Student student = Student.builder().name("Karina").grade(4).build();

        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {

        //ПРИНЦИПЫ РАЗРАБОТКИ API ТЕСТОВ:
        //1. ATOMIC TESTS
        //2. TEST CREATES TEST DATA FOR ITSELF
        //3. FAIL FIRST


        //ШАГ 1 создание студенta
        Student student = Student.builder().name("Katya").grade(2).build();
        Student createdStudent = StudentRequests.createStudent(student);

        //STEP 2: DELETE STUDENT
        StudentRequests.deleteStudent(createdStudent.getId());

        //STEP 3: Check then student  doesn't exist anymore
        given()
                .get("/student/" +createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

}
