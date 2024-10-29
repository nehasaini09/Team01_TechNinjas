package com.hooks;
import com.utilities.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.utilities.ReadConfig;
import io.cucumber.java.Scenario;
import com.utilities.Screenshot;
public class BaseClass {

	
		private TestContext context;
		   private ReadConfig readConfig; 
		
	 // inject TestContext constructor
	    public BaseClass(TestContext Context) {
	        this.context = Context;
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
	        Log.logInfo("Screenshots for failed");
	        if (scenario.isFailed()) {
	            // Use context.getDriver() to take a screenshot
	            Screenshot.takeScreenshot(context.getDriver(), scenario.getName());
	        }
	        Log.logInfo("Closing WebDriver");
	        context.closeDriver(); 
	    }
	    // to attach screeshots in allure
	    @Attachment(value = "Screenshot", type = "image/png")
	    public byte[] attachScreenshot(WebDriver driver) {
	        // Capture the screenshot and return it as bytes
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	}

