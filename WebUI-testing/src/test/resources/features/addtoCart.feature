Feature: Add Product to Card
  check the functionality of adding to card

  Scenario Outline: search for the product
    Given I enter "<keyword>" in the search field
    When I click on the search button
    And I open random product
    And click on the Add to Cart button
    Then I see 1 item in the cart
  Examples:
    |keyword|
    |candle |