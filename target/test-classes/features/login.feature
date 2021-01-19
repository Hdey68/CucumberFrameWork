
@featureTag  @login  # feature level tag
Feature: Login Functionality


    @validCreds  # scenario level tag
  Scenario: Login With Valid Credentials
     # Given Navigate to HRMS login page
    When Enter valid credentials
    And Click on login button
    Then Validate dashboard is displayed
   # And Close browser

     @smoke @invalidCreds @whatever  @regression  #  adding multiple scenario level tags
   Scenario: Login With Invalid Credentials
    # Given Navigate to HRMS login page
     When Enter invalid credentials
     And Click on login button
     Then Validate error message equals expected result
     #And Close browser

  # Scenario:  Login with Empty Username
   #  Given Navigate to HRMS login page
    # When Leave an empty username
  #   And Click on login button
    # Then Validate error message for empty Username
    # And Close browser

  # Scenario: Login with Empty Password
    # Given Navigate to HRMS login page
   #  When Leave an empty password
   #  And Click on login button
   #  Then Validate error message for Empty Password
   #  And Close browser

