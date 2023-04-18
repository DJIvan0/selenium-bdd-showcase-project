Feature: Adding an item to the shopping cart

	Scenario: Picking color and size of the item and adding it to the shopping cart
	Given User clicks on a certain product from the home page
	When User selects the size for the chosen product
	And Selects the color for the chosen product
	And Clicks on the add to cart button
	Then User is notified that the item is added
