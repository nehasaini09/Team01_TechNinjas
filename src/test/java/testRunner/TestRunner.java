package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(tags="@logout2",
		    features ={"src/test/resources/features/"},
            glue = {"com.hooks","com.stepDefinition"},
             monochrome = true,
            plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"html:target/Cucumber.html",
		"json:target/cucumber.json"})

public class TestRunner {

	}


