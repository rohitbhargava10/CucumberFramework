@Regression
Feature: Signup on facebook

  Scenario Outline: Signup on facebook
    Given User navigates to Facebook.com
    When User enters firstname as "<fname>"
    And User enters lastname as "<lname>"
    And User enters mobile as "<number>"
    And User clicks on create account
    Then User should get error message
 
    Examples: 
      | fname  | lname    | number     |
      | Rohit  | Bhargava | 9718977739 |
      | Jitesh | Bhargava | 9912345678 |
