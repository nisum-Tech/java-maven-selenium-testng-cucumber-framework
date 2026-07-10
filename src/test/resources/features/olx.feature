Feature: OLX Website interaction

  Scenario: Verify elements on OLX after navigation
    Given user navigates to "https://www.olx.com.pk"
    When user clicks on the Bikes link
    And user clicks on a generic element
    Then user should see the email field
