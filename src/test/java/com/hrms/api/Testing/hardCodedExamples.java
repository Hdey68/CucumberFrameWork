package com.hrms.api.Testing;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matcher.*;


//given()
//when()
//then()

public class hardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQ4ODA4OTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDkyNDA5MiwidXNlcklkIjoiMjQ3NSJ9.WfCNIrAOwWHDnM7Mt2opOFYAw-Od_Tu-1YceuBDYxeA";
    @Test
    public void sampleTest ( ) {

        //RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
        //String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQ2MjkxNDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDY3MjM0NywidXNlcklkIjoiMjQ3NSJ9.nSG8-0X3kDHjc_G-48t0TU8uOW0lncALQws8BRqt9zQ";

        //preparing request to the endpoint
        RequestSpecification preparingGetOneEmployeeRequest = given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" )
                .queryParam ( "employee_id", "13009" );
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when ( ).get ( "/getOneEmployee.php" );
        //print the response
        getOneEmployeeResponse.prettyPrint ( );

        //Assert that status code is 200
        getOneEmployeeResponse.then ( ).assertThat ( ).statusCode ( 200 );
    }

    @Test
    public void aPostCreateEmployee () {

        //Preparing Create an Employee Request
        RequestSpecification createEmployeeRequest = given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" )
                .body ( " {\n" +
                        "\"emp_firstname\": \"nabila\",\n" +
                        "\"emp_lastname\": \"tata\",\n" +
                        "\"emp_middle_name\": \"nana\",\n" +
                        "\"emp_gender\": \"F\",\n" +
                        "\"emp_birthday\": \"1973-02-15\",\n" +
                        "\"emp_status\": \"employee\",\n" +
                        "\"emp_job_title\":\"Accountant\"\n" +
                        "}" );
        //Making a post call to create Employee
        Response createEmployeeResponse = createEmployeeRequest.when ( ).post ( "/createEmployee.php" );
        //printing the employee ID
        createEmployeeResponse.prettyPrint ();

        //Assert that status code is 201
        createEmployeeResponse.then ().assertThat ().statusCode ( 201 );
        //Get employee ID
        String employeeID =createEmployeeResponse.jsonPath ().getString ( "Employee[0].employee_id" );
        //print employee ID
        System.out.println (employeeID );
        //Assert that message contains entry created
        createEmployeeResponse.then ().assertThat ().body ( "Message",equalTo("Entry Created") );

        //Assert that employee ID is 17237A
        createEmployeeResponse.then ().assertThat ().body ( "Employee[0].emp_firstname",equalTo ( "nabila" ) );

        }

    @Test
    public void bgetCreatedEmployee(){

        RequestSpecification getCreatedEmployee = given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" ).queryParam ( "employee_id","17237A" );

         Response getEmployeeResponse=getCreatedEmployee.when().get ("/getOneEmployee.php");
         //getEmployeeResponse.prettyPrint ();
        String empID=getEmployeeResponse.body ().jsonPath ().getString ("employee[0].employee_id");
        //we are checking if the emp ID is equal to the one mentioned in string
        boolean VerifyEmployeeID=empID.equalsIgnoreCase ( "17237A" );
        System.out.println (VerifyEmployeeID );

        Assert.assertTrue ( VerifyEmployeeID);
        //getEmployeeResponse.then ().assertThat ().body ( "employee[0].employee_id",equalTo ( "17237A" ) );





    }

    @Test
    public void cUpdateEmployee(){
        RequestSpecification updateEmployeeRequest = given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" )
                .body ( " {\n" +
                        "\"employee_id\": \"17237A\",\n" +
                        "\"emp_firstname\": \"samia\",\n" +
                        "\"emp_lastname\": \"tata\",\n" +
                        "\"emp_middle_name\": \"nana\",\n" +
                        "\"emp_gender\": \"F\",\n" +
                        "\"emp_birthday\": \"1973-02-15\",\n" +
                        "\"emp_status\": \"employee\",\n" +
                        "\"emp_job_title\":\"Accountant\"\n" +
                        "}" );

        Response UpdateEmployeeResponse = updateEmployeeRequest.when ( ).put ( "/updateEmployee.php" );
        UpdateEmployeeResponse.prettyPrint ();

        //Assert that the information is correct
        JsonPath js=UpdateEmployeeResponse.jsonPath ();
        String employee_firstname=js.getString ("employee[0].emp_firstname");
        System.out.println (employee_firstname );

        assertThat(employee_firstname,equalTo ( "samia" ));

        //in other way
        UpdateEmployeeResponse.then ().assertThat ().body ( "employee[0].emp_firstname",equalTo ( "samia" ) );
        //in other way
        //create boolean and use assert from junit
        boolean VerifyEmployeeFirstname=employee_firstname.equalsIgnoreCase ( "samia" );
        System.out.println (VerifyEmployeeFirstname );
    }

    @Test
    public void dPartiallyUpdateEmployee(){
        RequestSpecification partiallyUpdateRequest=given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" ).body ( " {\n" +
                "\"employee_id\": \"17398A\",\n" +
                "\"emp_lastname\": \"updatedname\"\n"+"}");
        Response PartiallyUpdatedEmployeeResponse = partiallyUpdateRequest.when ( ).patch ( "/updatePartialEmplyeesDetails.php" );
        PartiallyUpdatedEmployeeResponse.prettyPrint ();

        //assert that body contains the message entry updated
        JsonPath js=PartiallyUpdatedEmployeeResponse.jsonPath ();
        Object Message=js.get ( "Message" );
        System.out.println (Message );

        assertThat ( Message,equalTo ( "Entry updated" ) );
        //the other method
        PartiallyUpdatedEmployeeResponse.then ().body ( "Message",containsString ( "Entry updated" ) );

    }

    @Test
    public void  eDeleteEmployeeRequest(){

        RequestSpecification deleteEmployeeRequest=given ( ).header ( "Authorization", token )
                .header ( "Content-Type", "Application/json" ).queryParam ( "employee_id", "17226A");
        Response deleteEmployeeResponse = deleteEmployeeRequest.when ().delete ("/deleteEmployee.php");
        deleteEmployeeResponse.prettyPrint ();

        //assert that message contains entry deleted message :"Entry deleted"
        deleteEmployeeResponse.then ().assertThat ().body ( "message",containsString ( "Entry deleted" ) );


    }



    }


