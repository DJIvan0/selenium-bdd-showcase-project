Feature: Registration

  Registration page functionalities

  Scenario: Register without any fields filled
    Given User is on registration page
    When User clicks on Create an account button without filling out required fields
    Then Message about required field not being filled should appear for every mandatory field
    
  Scenario: Register with all mandatory fields filled
    Given User is on registration page
    When User fills out mandatory fields
    And User clicks on Create an account button
    Then User should be taken to Account page
    
  Scenario: Register with all mandatory fields filled and subscription checked
    Given User is on registration page
    When User fills out mandatory fields
    And User checks they want to sign up for newsletter
    And User clicks on Create an account button
    Then User should be taken to Account page
    
  Scenario: Invalid email input during registration
    Given User is on registration page
    When User inputs email of invalid format into email field
    And User clicks on Create an account button
    Then Message about changing the input to a valid format should appear
    
  Scenario: Valid email input during registration
    Given User is on registration page
    When User inputs email of valid format into email field
    And User clicks on Create an account button
    Then Message about changing the input to a valid format should not appear
    
  Scenario: Password input with smaller than minimal required length during registration
    Given User is on registration page
    When User inputs password with smaller than minimal required length into password field
    Then Message about required password length should appear
    
  Scenario: Password input of minimal required length during registration
    Given User is on registration page
    When User inputs password of minimal required length into password field
    Then Message about required password length should not appear
    
  Scenario: Password input with greater than minimal required length during registration
    Given User is on registration page
    When User inputs password with greater than minimal required length into password field
    Then Message about required password length should not appear
    
  Scenario: Matching passwords during registration
    Given User is on registration page
    When User inputs matching values into password and confirm password fields
    Then Message about passwords not matching should not appear
    
  Scenario: Passwords not matching during registration
    Given User is on registration page
    When User inputs different values into password and confirm password fields
    Then Message about passwords not matching should appear
    
  Scenario: Password strength is weak during registration
    Given User is on registration page
    When User inputs weak password 
    Then Strength meter should display that password is weak
    
  Scenario: Password strength is strong during registration
    Given User is on registration page
    When User inputs strong password 
    Then Strength meter should display that password is strong
    
  Scenario: Password strength is very strong during registration
    Given User is on registration page
    When User inputs very strong password 
    Then Strength meter should display that password is very strong
