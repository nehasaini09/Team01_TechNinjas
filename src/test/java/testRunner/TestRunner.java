package testRunner;


import com.hooks.DriverFactory;
import com.hooks.TestContext;
import com.utilities.ReadConfig;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



@CucumberOptions(tags="@validLogin",
		    features ={"src/test/resources/features/"},
            glue = {"com.hooks","com.stepDefinition"},
             monochrome = true,
            plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"html:target/Cucumber.html",
		"json:target/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests {


	}


