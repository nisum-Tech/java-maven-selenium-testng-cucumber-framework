Feature: GET /ops/features API

  Scenario: [Positive] Returns 200 OK
    When a valid GET request is sent to /ops/features
    Then the response status should be 200
    And the response body should be valid against the schema

  Scenario: [Negative] Returns 404 Not Found
    When a GET request is sent to a non-existent resource
    Then the response status should be 404
    And the error response body should be well-formed
