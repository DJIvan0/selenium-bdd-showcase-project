Feature: Product review

	Product review functionalities

  Scenario: Leaving a review with all mandatory fields filled
    Given User is on desired product page for review
    When User clicks on review tab
    And User fills out all mandatory fields for review
    And User clicks to submit the review
    Then User should be notified that the review is submitted
    
  Scenario: Leaving a review without any fields filled
   	Given User is on desired product page for review
    When User clicks on review tab
    And User clicks to submit an empty review
    Then Message about required field not being filled should appear for mandatory fields
