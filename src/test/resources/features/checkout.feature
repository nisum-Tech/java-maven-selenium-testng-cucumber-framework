Feature: Checkout Process

  Background:
    Given user has items in cart

  Scenario: Successful checkout with valid details
    When user proceeds to checkout
    And enters valid shipping details
    And confirms payment
    Then order should be placed successfully

  Scenario: Checkout without shipping details
    When user proceeds to checkout
    And leaves shipping details empty
    Then validation errors should be shown

  Scenario: Cancel checkout process
    When user opens checkout page
    And clicks cancel button
    Then user should be redirected to cart page