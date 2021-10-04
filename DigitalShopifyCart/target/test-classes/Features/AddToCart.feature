Feature: To add a product to cart and navigate to checkout

  Scenario: Adding products to cart through products page
    Given User is on homepage
    When User clicks on menu icon
    And User clicks on all products link
    Then User is redirected to products page and User selects a product
    And Details of products are displayed
    Then User add the item to cart
    And User Goes to my cart

  Scenario: Searching a product and then adding to cart
    Given User is on homepage
    When User enters the products name in search bar
    And User clicks on search icon
    Then User is redirected to products page and User selects a product
    And Details of products are displayed
    Then User add the item to cart
    And User Goes to my cart

  Scenario: Selecting a product from the homepage
    Given User is on homepage
    When User selects a product from homepage
    And Details of products are displayed
    Then User add the item to cart
    And User Goes to my cart
