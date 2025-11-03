@login
Feature: Login Functionality

  Scenario: Login
    Given User navigate to webshop login page
      | strategyType | locatorTag | message |
      | text         | a          | Log in  |
    When User should input valid login credentials
      | username            | password      |
      | johndoe011@mail.com | secretuser123 |
    And Verify successfull login
    And User click logout button
    Then Verify successfull logout
