@olxUI
Feature: OLX Mobile Phone Search
  As a user
  I want to search for mobile phones in a specific location
  So that I can find relevant listings

  Scenario: Search for mobile phones in Gulshan-e-Iqbal Town, Karachi
    Given I am on the OLX home page
    When I click on the Mobiles category
    And I click on the Mobile Phones sub-category
    And I filter by location "Karachi"
    And I filter by sub-location "Gulshan-e-Iqbal Town"
    Then I should see search results for mobile phones in Gulshan-e-Iqbal Town
