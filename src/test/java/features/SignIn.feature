Feature: User sign in

  Scenario Outline: User filling out required username and password and signing in
    Given User clicks on the sign in link on the home page
    When User enters required username
    And User enters required password
    And User clicks on the sign in button
    Then User signs in and gets returned to the home page
