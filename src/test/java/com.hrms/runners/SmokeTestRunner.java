package com.hrms.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/addEmployee.feature", // need to give a path for our feature files
        glue = "com/hrms/stepdefinitions", // we need to glue our step definitions - implementation
        dryRun = false, // when set as true, will run over the feature steps and reveal unimplemented steps in console
        tags = "@smoke",// adding tag
        strict = true,
        plugin = {"pretty", // will print executed steps inside console
                "html:target/cucumber-default-reports", // generates default html report
                "rerun:target/FailedTests.txt", // generates a txt file with failed tests only
                "json:target/cucumber.json" // generates json report
        }
)
public class SmokeTestRunner {
}
