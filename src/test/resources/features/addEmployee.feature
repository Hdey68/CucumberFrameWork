Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee button

  @addEmployeeWithoutLogin
  Scenario: Add employee without login details
    Then enter first and last name
    And click on save button
    Then verify employee is added successfully

  @addEmployeeWithLogin
  Scenario: Add employee with login credentials and with middle name
    Then enter first and middle name and last name
    When click on create login details checkbox
    Then create username and password and confirm password
    And click on save button
    Then verify employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middle name
    Then enter first name "nabila", middle name "nana" and last name "tata"
    And click on save button
    Then verify that "nabila nana tata" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter "<FirstName>", "<MiddleName>" and "<LastName>"
    And click on save button
    Then verify "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples:
      |FirstName|MiddleName|LastName|
      |Mark     |J         |Smith   |
      |John     |K         |Wick    |

  @dtWithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employees and verify they are added successfully
      |FirstName|MiddleName|LastName|EmployeeId|
      |Jack     |J         |Toronto |1111111111|
      |David    |K         |Wick    |2222222222|

  @excelTask
  Scenario: Adding multiple employees from excel
    When add multiple employees from excel "AddEmployee" sheet and verify they are added


