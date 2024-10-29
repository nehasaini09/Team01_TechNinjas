package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)



@CucumberOptions(features ={"src/test/resources/features"}, 
glue = {"com.hooks", "com.stepDefinition"},

monochrome = true, 
dryRun = false, 
plugin = {"pretty",
		
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
		"html:target/Cucumber.html",
		"json:target/cucumber.json",
		 "rerun:target/rerun.txt" 
		
})



public class TestRunner {
    
}
