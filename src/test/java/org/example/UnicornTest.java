package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UnicornTest {
    @BeforeAll
    public static void SetupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/9d6195226a0a4952a5a3524799e8fd7d";
        RestAssured.defaultParser = Parser.JSON;
    }
 //Create Unicorn
    @Test
    public void UserShouldBeAbleToCreateUnicorn() {
        UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tail_colour\": \"Yellow\"\n" +
                "}");

    }
    @Test
    public void UserShouldBeAbleToDeleteUnicorn() {
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tail_colour\": \"Yellow\"\n" +
                "}");
      UnicornRequests.DeleteUnicorn(id);
        //Check that unicorn is deleted
        given()
                .get("/unicorn/" +id)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    //Change tail_colour
    @Test
    public void UserShouldBeAbleToUpdateTailColour() {
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tail_colour\": \"Yellow\"\n" +
                "}");
        UnicornRequests.UpdateTailColour(id, "Pink");
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tail_colour", equalTo("Pink"));

    }

    //Step 2: Update tail colour




    }


        //Step 3: Check tail colour

        //Step 3.1: Get unicorn
        //Step 3.2: Check tail colour (compare through equals?)



        //

