package com.hrms.api.Testing;

import com.hrms.utils.apiConstants;
import com.hrms.utils.apiPayloadConstants;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class apiTestingFinalSteps {
    RequestSpecification request;
    Response response;
    static String employeeID;
   //RequestSpecification requestToRetrieveCreatedEmployee;
    //Response responseToRetrieveCreatedEmployee;

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        //preparing request to create employee
        request=given()
                .header ( apiConstants.Header_Content_type,apiConstants.Content_type)
                .header ( apiConstants.Header_Authorization,generateTokenSteps.token )
                .body ( apiPayloadConstants.createEmployeeBody ( ) );

    }
    @When("a POST call is made to create an Employee")
    public void a_POST_call_is_made_to_create_an_Employee() {
        //sending the request to create employee
        response=request.when ().post ( apiConstants.CREATE_EMPLOYEE_URI);

    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int status_code) {
        //assert the the status code is 201
        response.then ().assertThat ().statusCode ( status_code );

    }
    @Then("the employee is created contains key {string} and value {string}")
    public void the_employee_is_created_contains_key_and_value(String key, String value) {
        //assert that the message contains entry created
        response.then().assertThat().body(key,equalTo(value));

    }
    @Then("the employeeID {string} is stored in the global variable to be used for other calls")
    public void the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls(String value) {
        // extract the emploeeID from the json response
        employeeID=response.jsonPath().getString(value);
    }

    //-------------------------------------------------------Scenario: Retrieving the created Employee-----------------------------------------------

    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {
        // preparing the request to retrieving the created employee
        request = given ( )
                 .header ( apiConstants.Header_Content_type, apiConstants.Content_type )
                 .header ( apiConstants.Header_Authorization, generateTokenSteps.token )
                 .queryParam ( "employee_id",employeeID );

    }
    @When("a GET call is made to retrieve the created Employee")
    public void a_GET_call_is_made_to_retrieve_the_created_Employee() {
        //sending the request to retrieve the created employee
        response=request.when ().get (apiConstants.GET_ONE_EMPLOYEE_URI);

    }
    @Then("the status code for retrieving the created employee is {int}")
    public void the_status_code_for_retrieving_the_created_employee_is(int status_code) {
        //assert the the status code is 200
        response.then ().assertThat ().statusCode ( status_code );

    }
    @Then("the retrieved EmployeeID {string} matches the globally stored EmployeeID")
    public void the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID(String value) {
        //assert that employee id is the same as the one stored globally
        response.then().assertThat().body(value,equalTo(employeeID));

    }
    @Then("the retrieved data matches the data used to create the employee")
    public void the_retrieved_data_matches_the_data_used_to_create_the_employee() {
        //
        //response.then ().assertThat ().body ( "employee[0].emp_firstname",equalTo ( "nabila" ) );
        JsonPath jpath=response.jsonPath ();
        String emp_first_name=jpath.getString ( "employee[0].emp_firstname" );
        String emp_last_name=jpath.getString ( "employee[0].emp_lastname" );
        String emp_middle_name=jpath.getString ( "employee[0].emp_middle_name" );
        String emp_birthday=jpath.getString ( "employee[0].emp_birthday" );
        String emp_gender=jpath.getString ( "employee[0].emp_gender" );
        String emp_status=jpath.getString ( "employee[0].emp_status" );
        String emp_job_title=jpath.getString ( "employee[0].emp_job_title" );

        assertThat(emp_first_name,equalTo ( "nabila" ));
        assertThat(emp_last_name,equalTo ( "tata" ));
        assertThat(emp_middle_name,equalTo ( "nana" ));
        assertThat(emp_birthday,equalTo ( "1973-02-15" ));
        assertThat(emp_gender,equalTo ( "Female" ));
        assertThat(emp_status,equalTo ( "Employee" ));
        assertThat(emp_job_title,equalTo ( "Accountant" ));


    }
    }


