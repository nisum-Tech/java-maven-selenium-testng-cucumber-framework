Feature: PakWheels Navigation

  Scenario: User navigates through PakWheels website from Google Search
    Given user is on google search page
    When user searches for "pakwheels"
    And user clicks on the pakwheels link
    And user clicks on certified cars
    And user clicks on repositories
    And user clicks on setup button
    Then the navigation flow is completed
