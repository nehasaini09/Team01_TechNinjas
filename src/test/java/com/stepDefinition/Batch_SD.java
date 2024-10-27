package com.stepDefinition;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

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
        
        this.batchModule = new BatchModule(driver, context); // Passes driver to BatchModule
    }

	
	@Given("Admin is logged into the LMS portal and on the dashboard page")
	public void admin_is_logged_into_the_LMS_portal_and_on_the_dashboard_page() {
		Log.logInfo("Navigating to application URL");
	 context.getApplicationURL(); 
       // context.get(applicationURL);
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
	//Add new batch pop up  validation
	 @When("^Admin clicks on \"([^\"]*)\" under the Batch menu bar$")
	 public void admin_clicks_on_add_new_batch(String button) {
		 batchModule.navigateToBatch();
		 batchModule.clickAddNewBatchButton();
		 
	 }
	 
	 
	 @Then("^Admin should see the Batch Details pop-up window should include the fields \"([^\"]*)\"$")
	    public void admin_should_see_fields_in_popup(String field) {
		 Assert.assertTrue("Field not found in popup: " + field, batchModule.isFieldDisplayed(field));
	    }
	 
/**********************************/	
	 
	 //Add new batch pop field validation
	 
	 
	 @When("Admin selects program name present in the dropdown")
	    public void admin_selects_program_name_present_in_the_dropdown() {
		 batchModule.navigateToBatch();
		 batchModule.clickAddNewBatchButton();
		 batchModule.selectProgramFromDropdown();
	      
	    }

	 @Then("Admin should see the selected program name in the batch name prefix box")
	 public void admin_should_see_the_selected_program_name_in_the_batch_name_prefix_box() {
		 
		 boolean isReflected = batchModule.isSelectedProgramReflected();
		    Assert.assertTrue("The selected program name should be reflected in the batch name prefix box", isReflected);
	 


	 }
	 
	  @When("^Admin enters (.+) in the batch name suffix box$")
	 // @When("Admin enters {string} in the batch name suffix box")
	  public void admin_enters_input_in_the_batch_name_suffix_box(String input) {
		  batchModule.navigateToBatch();
		  
			 batchModule.clickAddNewBatchButton();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 //batchModule.selectProgramFromDropdown();
	        batchModule.enterBatchNameSuffix(input);
	    }

	   // @Then("Admin should get an (.*)")
	  @Then("^Admin should get an (.+)$")
	 // @Then("Admin should get an {string}")
	    public void checkExpectedMessage(String expectedMessage) {
		  
		  Log.debug("Validating expected text in the AddnewBatch popup Page: " + expectedMessage);
		
		      String actualMessage = batchModule.getErrorMessage().trim(); // Ensure to trim whitespace
		      
		      // Check if we expect an error message or if it should be empty
		      if (expectedMessage.equals("(no message)") || expectedMessage.isEmpty()) {
		          // No error message is expected for valid inputs
		          assertTrue("Expected no error message but got: " + actualMessage, actualMessage.isEmpty());
		      } else {
		          // An error message is expected for invalid inputs
		          assertEquals("Expected error message does not match", expectedMessage, actualMessage);
		      }
		  }
	  
	  
	//Edit icon Steps

	    @Given("Admin is on the Batch page")
	    public void admin_is_on_the_batch_page() {
	    	 batchModule.navigateToBatch();
	    }

	  @When("Admin clicks the edit icon for any batch")
	  public void admin_clicks_edit_icon() {
		 
		   batchModule.clickEditButton();
	  }

	  @Then("Admin should see the Batch details pop-up window with program name and Batch name field disabled")
	  public void admin_should_see_batch_details_popup() {
	      
		  assert(batchModule.isProgramNameFieldDisabled());
		  assert(batchModule.isBatchNameFieldDisabled());
	    
	  }
//Delete icon steps
	  
	  
	  
	  @When("^Admin clicks the Delete icon for any batch$")
	    public void admin_clicks_the_Delete_icon() {
		  	 batchModule.navigateToBatch();
		  	context.getWait();
		  batchModule.clickOnDeleteIcon();
	    }
	  
	  @Then("^Admin should see the confirm alert box with yes and no button$")
	    public void admin_should_see_the_confirm_alert_box() {
		  
		  Assert.assertTrue("Confirm alert box is not displayed", batchModule.isAlertBoxDisplayed());
	  
	    }

	  /*  @Then("^Admin should see the message (.+)$")
	    public void admin_should_see_the_message(String message) {
	       
	    }*/

	    @When("^Admin clicks the (.+) button on the confirm alert box$")
	    public void admin_clicks_button_on_confirm_alert_box(String action) {
	    	batchModule.confirmDeletion();
	    	if ("yes".equalsIgnoreCase(action)) {
	            batchModule.confirmDeletion(); // Click yes
	        } else if ("no".equalsIgnoreCase(action)) {
	            batchModule.cancelDeletion(); // Click no
	        } else {
	            System.out.println("Invalid button option: " +action);
	        }
	        }

	    @Then("^Admin should see a successful message and the batch should be deleted$")
	    public void admin_should_see_successful_message() {
	    	  Assert.assertTrue("Success message not displayed or batch deletion failed", batchModule.isSuccessMessageDisplayed());
	    }

	    @Then("^Admin should see the alert box closed$")
	    public void admin_should_see_alert_box_closed() {
	    	Assert.assertFalse("Alert box is still displayed.", batchModule.isAlertBoxDisplayed());
	        
	    }

	    @Then("^Admin should see the alert box closed and the batch is not deleted$")
	    public void admin_should_see_alert_box_closed_and_not_deleted()  {
	    	Assert.assertFalse("Alert box is still displayed.", batchModule.isAlertBoxDisplayed());

	    }
	  //Single row delete and multi row delete
	    

	    @When("Admin  clicks the delete icon by selecting the checkbox for a specific batch")
	    public void admin_clicks_the_delete_icon_by_selecting_the_checkbox_for_a_specific_batch() {
	    	batchModule.navigateToBatch();
	       batchModule.clickDeleteIconForSpecificBatch();
	    }

	    @Then("The respective row in the table should be deleted")
	    public void the_respective_row_in_the_table_should_be_deleted() {
	    	boolean isDeleted = batchModule.isRowDeleted(); // Call the method that checks if the row is deleted

	        Assert.assertTrue("The batch should be deleted but is still present.", isDeleted);
	    }

	    @When("Admin clicks the delete icon under the Manage Batch header by selecting the checkboxes for multiple batches")
	    public void admin_clicks_the_delete_icon_under_the_Manage_Batch_header_by_selecting_the_checkboxes_for_multiple_batches()  {
	    	batchModule.navigateToBatch();
	    	batchModule. multipleDeleteAction();
	    }

	    

	    @Then("The respective rows in the table should be deleted")
	    public void the_respective_rows_in_the_table_should_be_deleted() {
	    	boolean allDeleted = batchModule.areAllRowsDeleted(); // Call the method to verify deletion
	    	
	    	
	        
	        Assert.assertTrue("Not all rows were deleted.", allDeleted);
	    }
	    
	  //pagination
	    

	    @When("^Admin clicks the (Next|Last|Previous|First) link on the data table$")
	    public void adminClicksPageLink(String pageLink) {
	    	
	      	batchModule.navigateToBatch();
	      	
	        switch (pageLink.toLowerCase()) {
	            case "next":
	            	batchModule.clickNextPage();
	                break;
	            case "last":
	                batchModule.clickLastPage();
	                break;
	            case "previous":
	            	batchModule.clickPreviousPage();
	                break;
	            case "first":
	            	batchModule.clickFirstPage();
	                break;
	        }
	    }

	    // Verify the results based on the <results> description
	    @Then("^Admin should see the (.*) on the data table$")
	    public void adminShouldSeeResults(String expectedResult) {
	    	

	    	switch (expectedResult.toLowerCase()) {
	        case "next enabled link":
	            Assert.assertTrue("Expected 'Next' button to be enabled.", batchModule.isNextButtonEnabled());
	            break;
	        case "last page link with next disabled":
	            Assert.assertFalse("Expected 'Next' button to be disabled.", batchModule.isNextButtonEnabled());
	            break;
	        case "previous page":
	            Assert.assertTrue("Expected 'Previous' button to be enabled.", batchModule.isPrevButtonEnabled());
	            break;
	        case "very first page":
	            Assert.assertFalse("Expected 'Previous' button to be disabled.", batchModule.isPrevButtonEnabled());
	            break;
	        case "next results":
	            Assert.assertTrue("Expected to see results for the next page.", batchModule.hasNextPageResults());
	            break;
	        default:
	            Assert.fail("Unexpected result description: " + expectedResult);
	    }
	
	    }
	    
	    
	    
	    
	    
	    
}
	  
	  
  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
