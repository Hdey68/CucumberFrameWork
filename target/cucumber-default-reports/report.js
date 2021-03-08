$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/addEmployee.feature");
formatter.feature({
  "name": "Add Employee Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify dashboard is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.verify_dashboard_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on PIM",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.click_on_PIM()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add employee button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.click_on_add_employee_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add employee without login details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addEmployeeWithoutLogin"
    }
  ]
});
formatter.step({
  "name": "enter first and last name",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.enter_first_and_last_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.click_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify employee is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.verify_employee_is_added_successfully()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: Verifying profile name expected:\u003c[nabila tata]\u003e but was:\u003c[Rock H Lee]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat com.hrms.stepdefinitions.AddEmployeeStepDefinition.verify_employee_is_added_successfully(AddEmployeeStepDefinition.java:55)\r\n\tat ✽.verify employee is added successfully(file:///C:/Users/sofiane/eclipse-workspace/CucumberFrameworkBatch8/src/test/resources/features/addEmployee.feature:14)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "Add employee without login details");
formatter.after({
  "status": "passed"
});
});