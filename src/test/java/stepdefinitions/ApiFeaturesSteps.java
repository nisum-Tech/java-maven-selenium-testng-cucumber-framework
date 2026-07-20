package stepdefinitions;

import api.FeatureApi;
import io.cucumber.java.en.*;

public class ApiFeaturesSteps {

    private FeatureApi featureApi = new FeatureApi();
    private String uuid;
    private String currentApiCall;

    // GET Scenarios
    @When("a valid GET request is sent to /ops/features")
    public void a_valid_get_request_is_sent_to_ops_features() {
        featureApi.getFeatures();
        currentApiCall = "GET_FEATURES";
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        featureApi.assertStatusCode(statusCode);
    }

    @Then("the response body should be valid against the schema")
    public void the_response_body_should_be_valid_against_the_schema() {
        String schemaPath;
        if ("GET_FEATURES".equals(currentApiCall)) {
            // Assumes schema file is at src/test/resources/schemas/get_features_schema.json
            schemaPath = "schemas/get_features_schema.json";
        } else if ("PUT_FEATURE".equals(currentApiCall)) {
            // Assumes schema file is at src/test/resources/schemas/put_features_schema.json
            schemaPath = "schemas/put_features_schema.json";
        } else {
            throw new IllegalStateException("API call context not set for schema validation");
        }
        featureApi.validateSchema(schemaPath);
    }

    @When("a GET request is sent to a non-existent resource")
    public void a_get_request_is_sent_to_a_non_existent_resource() {
        featureApi.getNonExistentResource();
    }

    @Then("the error response body should be well-formed")
    public void the_error_response_body_should_be_well_formed() {
        featureApi.validateErrorResponse();
    }

    // PUT Scenarios
    @Given("a valid UUID")
    public void a_valid_uuid() {
        uuid = java.util.UUID.randomUUID().toString();
    }

    @When("a valid PUT request is sent to /ops/features/{uuid} with a valid body")
    public void a_valid_put_request_is_sent_to_ops_features_uuid_with_a_valid_body() {
        String requestBody = "{\"feature_name\": \"new-feature\", \"enabled\": true}";
        featureApi.putFeature(uuid, requestBody);
        currentApiCall = "PUT_FEATURE";
    }

    @When("a PUT request is sent to /ops/features/{uuid} with an invalid body")
    public void a_put_request_is_sent_to_ops_features_uuid_with_an_invalid_body() {
        String invalidBody = "{\"feature_name\": \"new-feature\", \"enabled\": \"not-a-boolean\"}";
        featureApi.putFeature(uuid, invalidBody);
    }
}
