Feature: Leaving a review for a product

  Scenario: Going into review section for the selected product and filling out a review
    Given User selects a certain product from the home page
    When User goes to the review section on the product page
    And Enters a nickname for the review
    And Enters a summary for the review
    And Enters the text for the review itself
    And Leaves a star rating for the review
    And User submits the review
    Then The user is notified that the review is submitted
