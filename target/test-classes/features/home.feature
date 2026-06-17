Feature: Home Page Functionality

  Scenario: Verify products are displayed on home page
    Given user is logged in
    When user lands on home page
    Then product list should be visible

  Scenario: Search product
    Given user is on home page
    When user searches for "iPhone"
    Then relevant search results should be displayed

  Scenario: Add product to cart from home page
    Given user is on home page
    When user adds first product to cart
    Then product should be added successfully