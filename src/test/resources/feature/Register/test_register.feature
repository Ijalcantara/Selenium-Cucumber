@radioTest
Feature: Test Gender

  Scenario: Verify and select radio buttons
    Given User navigate to webshop registration page
    Then The following radio buttons should be selected:
      | locatorType | locatorValue |
      | id          | gender-male  |
      | value       | F            |
    When User should input valid credentials
      | firstName | lastName | email               | password  |
      | James     | Fornis   | Jtest1233@mail.com   | james1234 |
    And User click register button
    Then Verify registration is complete
