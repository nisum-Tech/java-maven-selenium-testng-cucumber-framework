@bealls @guest
Feature: Bealls.com guest shopping experience
  As a guest shopper (no account)
  I want to browse, search, shop, and track orders
  So that I can complete my goals without logging in

  Background:
    Given the user is on the Bealls home page "https://www.bealls.com/"
    And the user has not signed in
  # --------------------------------------------------------------------------
  #  ADD TO CART PRODUCT AND CHECKOUT AS GUEST
  # --------------------------------------------------------------------------
  @search @smoke
  Scenario: Search for a product by keyword, add to bag and checkout as guest
    When the user enters "sandals" into the search field
    # Use id for search field: autocomplete-input
    And the user press the "Enter" button to search product
    Then User will wait for search results page and page heading should contain "Search results for"
    # Use x-path to validate search result page heading: //*[@id="content"]/div[2]/h1
    And the result count is greater than 0
    # Use x-path to get count of results: //*[@id="content"]/div[2]/div/div[2]/div
    # It has value in this format: "151" " items" but we need only count.
    And Wait for Add to bag button in list
    # Use x-path to wait for Add to bag button: .//button[text()='Add to bag']
    Then Scroll till Add to bag button in list and click on it
    # Use x-path to wait for Add to bag button: .//button[text()='Add to bag']
    And A pop-up is visible with message that the product is added
    # Use x-path to validated pop-up: //*[contains(text(),"Added")]
    And Wait pop-up is hide with message that the product is added
    # Use x-path to validated pop-up: //*[contains(text(),"Added")]
    Then Scroll till bag icon and click on bag icon
    # Use x-path to scroll and click on bag icon: /html/body/header/nav/div/div/div[1]/div[2]/div/ul/li[3]/div/div/a
    And Wait to be visible My Bag page and page heading contains text "My Bag"
    # Use x-path to get and validate text of page heading: //*[@id="content"]/div[3]/h1
    And The bag product count is greater than 0
    # Use x-path to get and validate product count in bag: //*[@id="content"]/div[3]/h1/span
    # Count is in this format (4)
    And Wait for Checkout as guest button is clickable
    # Use x-path for checkout as guest button: //*[@id="content"]/div[3]/div[1]/div/div[3]/button[2]
    Then Scroll to Checkout as guest button and click on it
    # Use x-path for checkout as guest button: //*[@id="content"]/div[3]/div[1]/div/div[3]/button[2]
    And Wait to be visible checkout page and page heading contains text "Secure Checkout"
    # Use x-path to get and validate text of page heading: //*[@id="content"]/h1
