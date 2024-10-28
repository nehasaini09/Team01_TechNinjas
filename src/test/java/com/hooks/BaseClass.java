package com.hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utilities.Log;
import com.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class BaseClass {

	private TestContext context;
	private ReadConfig readConfig;

	// inject TestContext constructor
	public BaseClass(TestContext context) {
		this.Context = context;
		this.readConfig = new ReadConfig();

	}

	@Before
	public void setUp() {
		Log.logInfo("Initializing WebDriver");
		String browserName = readConfig.getbrowser();
		WebDriver driver = context.getDriverFactory().initialiseBrowser(browserName);
		context.setDriver(driver);
		Log.logInfo("Navigating to: " + readConfig.getApplicationURL());
		context.getDriver().get(readConfig.getApplicationURL());
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			Log.logInfo("Scenario failed: capturing screenshot.");
			byte[] sourcePath = ((TakesScreenshot) context.getDriver()).getScreenshotAs(OutputType.BYTES);

			Allure.addAttachment("Failed Screenshot: " + scenario.getName(), new ByteArrayInputStream(sourcePath));
		}
           Log.logInfo("Closing WebDriver");
		context.closeDriver();
	}

	/*
	 * @After public void tearDown() { Log.logInfo("Closing WebDriver");
	 * Context.closeDriver(); }
	 */
}
