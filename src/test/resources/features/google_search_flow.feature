Feature: Google Search and Product Add to Cart

  Scenario: Search for a product on Google and add it to the cart
    Given I am on the Google search page "https://www.google.com"
    When I search for "glock 19x 9mm concealed carry belt"
    And I click on the search result with text "Holsters"
    And I click on a product link
    When I select a product option "41454879703093"
    And I add the product to the cart
    Then I should see a confirmation that the product was added to the cart
