package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FeatureApi {

    private static final String BASE_URI = "https://feature-toggle-api.com"; // Example API base URI

    private Response response;

    public void getFeatures() {
        response = given()
                .baseUri(BASE_URI)
                .when()
                .get("/ops/features");
    }

    public void getNonExistentResource() {
        response = given()
                .baseUri(BASE_URI)
                .when()
                .get("/ops/features/nonexistent");
    }

    public void putFeature(String uuid, String body) {
        response = given()
                .baseUri(BASE_URI)
                .pathParam("uuid", uuid)
                .contentType("application/json")
                .body(body)
                .when()
                .put("/ops/features/{uuid}");
    }

    public void assertStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validateSchema(String schemaPath) {
        // This step expects schema files to be present in src/test/resources/
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
    }

    public void validateErrorResponse() {
        // Assuming a generic error format, e.g., { "error": "message" }
        response.then().assertThat().body("error", org.hamcrest.Matchers.notNullValue());
    }

    public Response getResponse() {
        return response;
    }
}
