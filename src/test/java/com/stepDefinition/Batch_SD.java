package com.stepDefinition;

import java.time.Duration;
import com. utilities.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pageObject.*;
import com.hooks.TestContext;
import io.cucumber.java.en.*;


public class Batch_SD {
	// private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);
	   private WebDriverWait wait;
	   private BatchModule batchModule;
	   private WebDriver driver;
	   private TestContext context;

	public Batch_SD(TestContext context) {
        this.context = context; //  context initialized
        this.driver = context.getDriver(); //  WebDriver get initialized
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initializes WebDriverWait
        
        this.batchModule = new BatchModule(driver); // Passes driver to BatchModule
    }

	
	@Given("Admin is logged into the LMS portal and on the dashboard page")
	public void admin_is_logged_into_the_LMS_portal_and_on_the_dashboard_page() {
		Log.logInfo("Navigating to application URL");
		String applicationURL = context.getApplicationURL(); 
        driver.get(applicationURL);
        String username = "Sdet@gmail.com";
        String password = "LmsHackathon@2024";
        batchModule.login(username, password);
       
	   
	}

	/*@Given("Admin navigates to the {string} page from the navigation bar clicking {string}")
	//@Given("^Admin navigates to the (.+?) page from the navigation bar clicking (.+?)$")
	public void admin_navigates_to_the_page_from_the_navigation_bar_clicking(String page, String menu) {
		
	}*/

	@When("Admin clicks on the Batch menu from the header")
	//@When("^Admin clicks on the (.+?) menu from the header$")
	public void admin_clicks_on_the_Batch_menu_from_the_header() {
		Log.debug("Performing action.");
		 batchModule.navigateToBatch();
	}

	@Then("^ Admin should see (.+) in the Batch Page $")
	public void admin_should_see_in_the_Batch_Page(String expectedText) {
		
		
		
		 boolean isBatchPageValid = batchModule.validateBatchPage();
		 Assert.assertTrue("Batch page validation failed. One or more elements are not displayed.", isBatchPageValid);
	}

	

}


