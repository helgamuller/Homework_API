package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.example.api.UnicornRequests.uniToJson;
import static org.example.api.UnicornRequests.updateTailColour;
import static org.hamcrest.Matchers.equalTo;

public class UnicornTest {
    @BeforeAll
    public static void SetupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/962812dda5ca4589a0fcaa885bf98dbc";
        RestAssured.defaultParser = Parser.JSON;
    }
 //Create Unicorn
    @Test
    public void UserShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("Un1").tail_colour("Violet").build();
        UnicornRequests.createUnicorn(unicorn);

    }
    @Test
    public void UserShouldBeAbleToDeleteUnicorn() {
       Unicorn unicorn = Unicorn.builder().name("Un1").tail_colour("Violet").build();
       Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.DeleteUnicorn(createdUnicorn.getId());
        /* Check that unicorn is deleted */
        given()
                .get("/unicorn/" +createdUnicorn.getId())
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    //Change tail_colour
    @Test

    public void UserShouldBeAbleToUpdateTailColour() {
        Unicorn unicorn = Unicorn.builder().name("Un5").tail_colour("Orange").build();
        Unicorn createdUnicorn =  UnicornRequests.createUnicorn(unicorn);
        Unicorn updatedUnicorn = UnicornRequests.updateTailColour(createdUnicorn.getId(), "Pink");


        given()
                .get("/unicorn/" + createdUnicorn.getId())
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

