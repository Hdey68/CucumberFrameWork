package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.ConfigsReader;

public class LoginStepDefinition extends CommonMethods {

    @Given("Navigate to HRMS login page")
    public void navigate_to_hrms_login_page ( ) {
        setUp ( );
    }

    @When("Enter valid credentials")
    public void enter_valid_credentials ( ) {
        loginPage.login ( "Admin", "Hum@nhrm123" );
    }

    @When("Click on login button")
    public void click_on_login_button ( ) {
        loginPage.clickLoginButton ( );
    }

    @Then("Validate dashboard is displayed")
    public void validate_dashboard_is_displayed ( ) {
        Assert.assertTrue ( dashboardPage.welcomeMessage.isDisplayed ( ) );
    }

    @When("Enter invalid credentials")
    public void enter_invalid_credentials ( ) {
        loginPage.login ( "Admi", "synmat" );
    }

    @Then("Validate error message equals expected result")
    public void validate_error_message_equals_expected_result ( ) {
        Assert.assertEquals ( "Verifying error message", "Invalid credentials", loginPage.getErrorMessageText ( ) );
    }

    @Then("Close browser")
    public void close_browser ( ) {
        tearDown ( );
    }

    @When("Leave an empty username")
    public void leave_an_empty_username() {
        loginPage.login ( "","Hum@nhrm123" );
    }
    @Then("Validate error message for empty Username")
    public void validate_error_message_for_empty_username() {
        Assert.assertEquals ( "Verifying error message","Username cannot be empty",loginPage.getErrorMessageText () );

    }
    @When("Leave an empty password")
    public void leave_an_empty_password() {
        loginPage.login ( "Admin", "" );
    }
    @Then("Validate error message for Empty Password")
    public void validate_error_message_for_empty_password() {
        Assert.assertEquals ( "Verifying error message", "Password cannot be empty", loginPage.getErrorMessageText ( ) );
    }
}


