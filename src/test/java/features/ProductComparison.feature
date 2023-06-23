Feature: Product comparison

	Product comparison functionalities

  Scenario: Adding product to comparison list and viewing it by clicking the link from confirmation message
    Given User is on desired product page
    When User clicks on add to compare button
    And User clicks on confirmation message link
    Then User should be taken to compare products page and see added product displayed
    
  Scenario: Adding product to comparison list and viewing it by clicking the header link
  	Given User is on desired product page
    When User clicks on add to compare button
    And User clicks on header link
    Then User should be taken to compare products page and see added product displayed
    
  Scenario: Remove product from comparison list
  	Given User is on compare products page
  	When User clicks to remove desired product
  	And User confirms their decision within popup
  	Then User should be notified that removal was successful
