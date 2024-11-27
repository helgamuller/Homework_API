package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {

    private static String studentToJson (Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing object", e);
        }
    }
    public static Student createStudent(Student student) {
        //exclude mapping to a separate method
        String studentJson = studentToJson(student);
        return given()
                .body(studentJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.GSON);
    }

    public static void deleteStudent(String id) {
        given()
                .delete("/student/" +id)
               .then()
               .assertThat()
               .statusCode(200);
    }
}
