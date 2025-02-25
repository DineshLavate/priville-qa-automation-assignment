package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features={"Priville_Automation/features",
	 },
		glue={"glueCode", "TestRunner"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","progress","summary"},
		monochrome= true,
		strict=false
		)
public class Priville_Test_Runner_Test {
	

}
