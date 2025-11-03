Feature: Validate Multiple Products Functionality

  Scenario: Multiple Products
    Given User navigate to webshop
    When User should search for a product and click add to cart
    |keyword |item              |
    |laptop  |14.1-inch Laptop  |
    |book    |Health Book       |
    |belt    |Casual Golf Belt  |
    And User should click the shopping cart
    Then Verify added products
    |item             |price    |
    |14.1-inch Laptop |1590.00  |
    |Health Book      |10.00    |
    |Casual Golf Belt |1.00     |