Feature: Find needed product
  check how functionality of finding products works

  Scenario Outline: search product by keyword
    Given I enter "<keyword>" in the search field
    When I click on the search button
    Then I see searched product by "<keyword>"
  Examples:
    |keyword          |
    |Bedtime Originals|

  Scenario Outline: search for invalid keyword
    Given I enter "<keyword>" in the search field
    When I click on the search button
    Then I see no result
  Examples:
    |keyword     |
    |qazwsxedcrfv|