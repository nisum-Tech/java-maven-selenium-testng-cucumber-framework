Feature: Recorded OLX Flow

  Scenario: Navigate and interact with OLX website
    Given user is on the OLX home page
    When user clicks on Vehicles category
    And user hovers over vehicles in Pakistan
    And user clicks on a vehicle sub-category
    And user hovers over a generic element
    And user clicks on Gulshan-e-Iqbal Town
    Then user clicks on a search result
