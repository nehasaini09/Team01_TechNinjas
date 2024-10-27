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
	

	private TestContext Context;
	   private ReadConfig readConfig; 
	
 // inject TestContext constructor
    public BaseClass(TestContext Context) {
        this.Context = Context;
        this.readConfig = new ReadConfig();
        
    }
    
    @Before
    public void setUp() {
        Log.logInfo("Initializing WebDriver");
        String browserName = readConfig.getbrowser(); 
         WebDriver driver = Context.getDriverFactory().initialiseBrowser(browserName); 
        Context.setDriver(driver); 
        Log.logInfo("Navigating to: " + readConfig.getApplicationURL());
        Context.getDriver().get(readConfig.getApplicationURL());
    }

    @After
    public void tearDown() {    	
    	 Log.logInfo("Closing WebDriver");
        Context.closeDriver();
    }
}

