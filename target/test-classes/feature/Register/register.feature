@register
Feature: Register Functionality

  Scenario: Register
    Given User navigate to webshop registration page
    When User should input valid credentials
    And User click register button
    Then Verify registration is complete
