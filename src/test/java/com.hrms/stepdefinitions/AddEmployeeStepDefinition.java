package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class AddEmployeeStepDefinition extends CommonMethods {

    @When("click on PIM")
    public void click_on_PIM() {
        dashboardPage.clickOnPIM();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashboardPage.clickOnAddEmployeeBtn();
    }

    @Then("enter first and last name")
    public void enter_first_and_last_name() {
        addEmployeePage.empIDTextbox.clear ();
        addEmployeePage.enterFirstAndLastName("nabila", "tata");
    }

    @Then("click on save button")
    public void click_on_save_button() throws InterruptedException {
        Thread.sleep ( 2000 );
        addEmployeePage.clickOnSaveBtn();

    }
    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
        String actualProfileName = personalDetailsPage.getUserProfileName ();
        Assert.assertEquals("Verifying profile name", "nabila tata", actualProfileName);

    }
    @When("click on create login details checkbox")
    public void click_on_create_login_details_checkbox() {
        addEmployeePage.createLoginCheckbox.click ();

    }
    @Then("enter first and middle name and last name")
    public void enter_first_and_middle_name_and_last_name() {
        addEmployeePage.enterFirstMiddleAndLastName ( "nabila","nana","tata" );

    }

    @Then("create username and password and confirm password")
    public void create_username_and_password_and_confirm_password() throws InterruptedException {
        addEmployeePage.createUsernamePasswordAndConfirmPassword ( "MohamedAlger5","Algiers@12345!$toto7","Algiers@12345!$toto7" );
        //Thread.sleep ( 2000 );

    }
    @Then("enter first name {string}, middle name {string} and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName,
                                                           String lastName) {
       // addEmployeePage.empIDTextbox.clear ();
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) {
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) throws InterruptedException {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
        Thread.sleep ( 2000 );
    }

    @Then("verify {string}, {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
        String fullName = firstName + " " + middleName + " " + lastName;
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();

        for(Map<String, String> employeeName: employeeNames) {
            String firstName = employeeName.get("FirstName");
            String middleName = employeeName.get("MiddleName");
            String lastName = employeeName.get("LastName");
            String employeeId = employeeName.get("EmployeeId");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeId(employeeId);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = personalDetailsPage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashboardPage.clickOnAddEmployeeBtn();
            Thread.sleep(2000);
        }

    }

    @When("add multiple employees from excel {string} sheet and verify they are added")
    public void add_multiple_employees_from_excel_sheet_and_verify_they_are_added(String sheetName) throws InterruptedException {
        List<Map<String, String>> excelData = ExcelUtils.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);

        for(Map<String, String> excelEmpName: excelData) {
            String firstName = excelEmpName.get("FirstName");
            String middleName = excelEmpName.get("MiddleName");
            String lastName = excelEmpName.get("LastName");
            String employeeId = excelEmpName.get("Employee ID");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeId(employeeId);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = personalDetailsPage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashboardPage.clickOnAddEmployeeBtn();
            Thread.sleep(2000);
        }

    }

}
