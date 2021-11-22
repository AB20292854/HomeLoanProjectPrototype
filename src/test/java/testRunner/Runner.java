package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions

		(
		features=".//Features/CustomerLandingPage.feature",
		glue="StepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		
		)
public class Runner {

	
}
