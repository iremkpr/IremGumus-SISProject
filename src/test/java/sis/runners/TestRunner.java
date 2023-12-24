package sis.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// we can specify which feature/features to run
		features = "src/test/resources/features/",

		// we can specify where the code for the features are located
		glue = "sis.steps",

		// if true, it does not run the java classes. Only checks the feature files
		// if they are glued to some java code
		dryRun = true,

		// tags can do the same thing groups on TestNG do

		tags = "@positive and @negative",


		monochrome = true,

		plugin = {
				// Prints the gherkin steps to the console
				"pretty",
				// with that you'll keep report on target file
				"html:target/cucumber-default-report.html",
				// Stores every step of the execution to a json file
				"json:target/cucumber.json"

		})

public class TestRunner {

}
