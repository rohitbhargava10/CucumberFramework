#Author: Rohit Bhargava

Feature: Login To Facebook
   
  Scenario: Login with valid credentials
    Given User navigates to Facebook.com
    When User enters "rohitbhargava10@yahoo.in" and "positive"
    And click on login button
    Then User is able to successfull login
