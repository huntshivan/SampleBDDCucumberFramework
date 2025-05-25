package com.qa.opencart.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources/parallel"},
		glue = {"parallel"},
		plugin = {"pretty",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"},
		tags = "not @skip"
		
		)

public class TestRunner {
	
	
	

}
