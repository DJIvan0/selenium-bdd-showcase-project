Feature: Shopping cart

	Shopping cart functionalities

	Scenario: Adding product to cart with all mandatory fields filled
		Given User is on desired product page for shopping cart
		When User fills out all mandatory fields for shopping cart
		And User clicks on add to cart button
		And User clicks on shopping cart page link
		Then User should be taken to shopping cart page and see added product displayed
	
	Scenario: Adding product to cart without any fields filled
		Given User is on desired product page for shopping cart
		And User clicks on add to cart button without any fields filled
		Then Message about required fields not being filled should appear
