package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn(String body) {
        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/unicorn/")
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().path("_id");
    }
    public static void UpdateTailColour(String id, String newColor) {

        given()
                .body("{\n" +
                        " \"tail_colour\": \"" + newColor + "\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);



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


