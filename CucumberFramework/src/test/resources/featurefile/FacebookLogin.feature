#Author: Rohit Bhargava

Feature: Login To Facebook
   
  Scenario: Login with valid credentials
    Given User navigates to Facebook.com
    When User enters "Username" and "Password"
    And click on login button
    Then User is able to successfull login

    Scenario: Login with invalid credentials
    Given User navigates to Facebook.com
    When User enters "Username" and "Password"
    And click on login button
    Then User is not able to successfull login 