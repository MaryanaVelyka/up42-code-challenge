package com.mvelyka.up42.api.client;

import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;

public class AuthClient {

    public String createToken() {
        return given()
                //TODO move baseUri to run params or env variable
                .baseUri("https://8ff281a4-21f2-49e5-9ee4-606e6735d670:yiOIjHaD.QEout1i3lOaGh2bnmmty5OnquJhZFnCNlPu@api.up42.com")
                .contentType(ContentType.URLENC)
                .when()
                .formParam("grant_type", "client_credentials")
                .post("/oauth/token")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getString("access_token");
    }
}
