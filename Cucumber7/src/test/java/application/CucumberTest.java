package application;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue= "cucumberSteps",	
		dryRun= false,
		tags= "@boekreis",
		features="src/test/resources/Feature/cucumber7.feature")
public class CucumberTest {}