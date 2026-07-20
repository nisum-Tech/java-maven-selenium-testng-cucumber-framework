Feature: PUT /ops/features/{uuid} API

  Scenario: [Positive] Returns 200 OK
    Given a valid UUID
    When a valid PUT request is sent to /ops/features/{uuid} with a valid body
    Then the response status should be 200
    And the response body should be valid against the schema

  Scenario: [Negative] Returns 400 Bad Request
    Given a valid UUID
    When a PUT request is sent to /ops/features/{uuid} with an invalid body
    Then the response status should be 400
    And the error response body should be well-formed
