
@featureTag  @login # feature level tag
Feature: Login Functionality

  @smoke # scenario level tag
  Scenario: Login with valid credentials
    Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    #Then quit the browser

  @regression  # adding multiple scenario level tags
  Scenario: Login with invalid credentials
    Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify error message
    Then quit the browser
