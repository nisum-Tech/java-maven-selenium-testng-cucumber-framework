Feature: Pakwheels Car Search

  Scenario: Recorded flow - Search for used cars in Lahore Johar Town Toyota
    Given user navigates to "https://www.pakwheels.com/"
    When user clicks "Find Used Cars for Sale"
    And user clicks "Lahore 17,881" field
    And user clicks "Johar Town 1,283" field
    And user clicks "Toyota 336" field
    Then a new tab should open with title "Toyata336"
