package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String uniToJson (Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing object", e);
        }
    }
    public static Unicorn createUnicorn(Unicorn unicorn) {
        String uniJson = uniToJson(unicorn);
        return given()
                .body(uniJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/unicorn/")
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }
    public static Unicorn updateTailColour(String id, String newColor) {
        //get object by ID and extract it as a Uni class
        Unicorn existingUnicorn = given()
                .get("/unicorn/" + id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Unicorn.class, ObjectMapperType.GSON);

        // Update tail colour
        existingUnicorn.setTail_colour(newColor);

        //Send Uni back by PUT
        return given()
                .body(uniToJson(existingUnicorn))
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Unicorn.class, ObjectMapperType.GSON);

    }

    public static void DeleteUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    }


