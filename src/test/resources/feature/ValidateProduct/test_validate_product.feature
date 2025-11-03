@dropdowntest
Feature: Login Functionality

  Scenario: Login
    Given User navigate to webshop login page
    |strategyType	|locatorTag	|message	|
    |text					|a					|Log in		|
    When User should input valid login credentials
      | username           | password |
      | fornis@email.com   | james123 |
    And User should click on the shopping cart link
    And User select country
      | strategyType | locatorValue | selectedValue |
      | text         | CountryId    | Canada        |
      | value        | CountryId    | 86            |
      | index        | CountryId    | 5             |

      
      