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

	@Then("Admin should see the {string} in the Batch Page")
	public void admin_should_see_in_the_Batch_Page(String expectedText) {
		
		
		
//		 boolean isBatchPageValid = batchModule.validateHeaders();
//		 Assert.assertTrue("Batch page validation failed. One or more elements are not displayed.", isBatchPageValid);
//		 
	
	
	 Log.debug("Validating expected text in the Batch Page: " + expectedText);
     
   
     switch (expectedText) {
     	 case "LMS - Learning Management System":
     		 Assert.assertTrue("Toolbar text is incorrect.", batchModule.isToolbarTextCorrect("LMS - Learning Management System"));
         break;
     
         case "Manage Batch":
        	 Assert.assertTrue("Header text is incorrect.", batchModule.isHeaderTextCorrect("Manage Batch"));
         break; 
         
         case "datatable headers: Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete":
          
             batchModule.validateHeaders();
             break;

         case "disabled Delete Icon under the header ":
             Assert.assertTrue("Multiple Delete icon should be disabled.", batchModule.isMultipleDeleteIconDisabled());
             break;
             
         case "enabled pagination controls under the data table":
         
             Assert.assertTrue("Pagination controls are not enabled.", batchModule.arePaginationControlsEnabled());
             break;

         case "edit icon in each data row":
         
             Assert.assertTrue("Edit icons are not displayed in each data row.", batchModule.areEditButtonsDisplayed());
             break;
             

         case "delete icon in each data row":
            
             Assert.assertTrue("Delete icons are not displayed in each data row.", batchModule.areDeleteButtonsDisplayed());
             break;

         case "checkbox in each data row":
           
             Assert.assertTrue("Checkboxes are not displayed in each data row.", batchModule.areCheckboxesDisplayed());
             break;
 
         case "checkbox in the datatable header row":
             Assert.assertTrue("Checkbox in the header row is not displayed.", batchModule.isCheckboxHeaderDisplayed());
             break;
         case "sort icon next to all datatable headers":
             Assert.assertTrue("Sorting icons are not displayed for all columns.", batchModule.areSortingIconsDisplayed());
             break;
         case "Footer":
             Assert.assertTrue("Footer is missing.", batchModule.isFooterTextCorrect("Manage Batch"));
             break;
      
         default:
             Assert.fail("Unexpected element: " + expectedText);
     }

	}

}


