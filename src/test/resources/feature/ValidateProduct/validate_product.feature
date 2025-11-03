Feature: Validate Cart

  Scenario: Validate added product
    Given User navigate to webshop login page
    When User should input valid login credentials
        |username         |password |
    		|fornis@email.com |james123 |
    And Verify successfull login
		And User should click on Books category
			  | category |
  			| Books    |
		And User should locate Fiction book
			  | bookTitle |
  			| Fiction   |
		And User should locate the price
		And User should click add to cart
		And User should click on the shopping cart link
		And User should locate the remove checkbox
		And User should click the remove checkbox and update the cart
				| bookTitle |
  			| Fiction   |
		Then User should click logout