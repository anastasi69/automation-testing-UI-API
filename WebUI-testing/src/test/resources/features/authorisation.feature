Feature: Authorisation on site
  check positive and negative tests

  Scenario Outline: Authorisation with valid credentials of existed user
    Given I open authorisation page
    When I enter "<email>" and click Continue button
    And I enter "<password>" and click Sign-In button
    Then I see the main page and my "<name>" in the header
Examples:
    |email                |password    |name      |
    |joyajat572@dkt1.com  |1111111111  |AmazonTest|

  Scenario: Submit empty SignIn form
    Given I open authorisation page
    When I click on the button
    Then The error message about empty field is displayed

  Scenario Outline: Authorisation with valid email of unexisted user
    Given I open authorisation page
    When I enter "<email>" and click Continue button
    Then The error message about nonexistent account with that email is displayed
    Examples:
    |email                |
    |joyaaajat572@dkt1.com|

  Scenario Outline: Failed authorisation with incorrect password
    Given I open authorisation page
    When I enter "<email>" and click Continue button
    And I enter "<invalid password>" and click Sign-In button
    Then The error message about incorrect is displayed
    Examples:
      |email              |invalid password |
      |joyajat572@dkt1.com|123              |