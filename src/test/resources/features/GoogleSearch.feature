Feature: Google Search for Nisum

  Scenario: Search for Nisum on Google and navigate to Digital Strategy page
    Given user is on the Google search page
    When user searches for "nisum.com"
    And clicks the Nisum search result link
    And clicks the Digital Strategy link on the home page
    Then the Digital Strategy page is displayed
