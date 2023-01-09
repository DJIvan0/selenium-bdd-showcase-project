Feature: Comparing two different products

  Scenario Outline: Adding two products to a comparing list and viewing the list
    Given User selects the first product from the home page
    When User adds the first product to the comparing list
    And User goes back to the home page
    And User selects the second product from the home page
    And User adds the second product to the comparing list
    Then User clicks on the comparing list and views two added products inside