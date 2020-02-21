package com.mvelyka.up42.api.client;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class JobClient {

    //TODO move baseUri to run params or env variable
    private String baseUri = "https://api.up42.com/projects/8ff281a4-21f2-49e5-9ee4-606e6735d670";

    public String createAndRunJob(String bearerToken) {
        //TODO move json to proper dto class
        JSONObject jsonObj1 = new JSONObject()
                .put("ids", JSONObject.NULL)
                .put("time", "2018-01-01T00:00:00+00:00/2020-12-31T23:59:59+00:00")
                .put("limit", 1)
                .put("time_series", JSONObject.NULL)
                .put("max_cloud_cover", 100)
                .put("intersects", JSONObject.NULL);
        JSONObject jsonObj2 = new JSONObject()
                .put("sobloo-s2-l1c-fullscene:1",jsonObj1);

        String path = given()
                .baseUri(baseUri)
                .auth().oauth2(bearerToken)
                .contentType(ContentType.JSON)
                .body(jsonObj2.toString())
                .when()
                //TODO move workflow id as run parameter or env variable
                .post("/workflows/c5353bba-28de-4423-bc97-041cfd8ee214/jobs")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().asString();
        //Job id is returned
        return JsonPath.with(path).get("data.id");
    }

    public String getJobStatus(String jobId, String bearerToken) {
        String path = given()
                .baseUri(baseUri)
                .auth().oauth2(bearerToken)
                .when()
                .get(String.format("/jobs/%s", jobId))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().asString();

        return JsonPath.with(path).get("data.status");
    }





}
