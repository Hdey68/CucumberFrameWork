Feature: Login Functionality

  Scenario: Login With Valid Credentials
    Given Navigate to HRMS login page
    When Enter valid credentials
    And Click on login button
    Then Validate dashboard is displayed
    And Close browser

   Scenario: Login With Invalid Credentials
     Given Navigate to HRMS login page
     When Enter invalid credentials
     And Click on login button
     Then Validate error message equals expected result
     And Close browser
