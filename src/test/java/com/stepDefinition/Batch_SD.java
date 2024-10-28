package com.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import com. utilities.*;
import io.cucumber.datatable.DataTable;
import java.util.Map;
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

 String batchname ="java";
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
	//Add new batch pop up  label validation
	 @When("^Admin clicks on \"([^\"]*)\" under the Batch menu bar$")
	 public void admin_clicks_on_add_new_batch(String button) {
		 Log.debug("label validation.");
		 batchModule.navigateToBatch();
		 batchModule.clickAddNewBatchButton();
		 
	 }
	 
	 
	 @Then("^Admin should see the Batch Details pop-up window should include the fields \"([^\"]*)\"$")
	    public void admin_should_see_fields_in_popup(String field) {
		 Log.debug("pop label.");
		 Assert.assertTrue("Field not found in popup: " + field, batchModule.isFieldDisplayed(field));
	    }
	 
	 
	//Add new batch
	    
	 
	  

	    @When("Admin leaves one mandatory field blank and clicks the save button")
	    public void admin_leaves_one_mandatory_field_blank_and_clicks_the_save_button() {
	    	Log.debug("batchpopvalidation.");
	    	 batchModule.navigateToBatch();
	    	 batchModule.enterDescription(""); 
		        batchModule.enterNumberOfClasses(""); 
		        batchModule.clickSaveButton(); 
	    }

	  
	    @Then("Admin should see a error message {string}")
	    public void admin_should_see_a_error_message(String string) {
	        Log.error("Errormessage");
	        Assert.assertTrue("Error message should be displayed under the description field", 
	                batchModule.isDescriptionErrorDisplayed());
	        Assert.assertTrue("Error message should be displayed under the number of classes field", 
	                batchModule.isNumberOfClassesErrorDisplayed());
	    
	    }


	    @When("Admin enters valid data in all mandatory fields and clicks the save button")
	    public void admin_enters_valid_data_in_all_mandatory_fields_and_clicks_the_save_button() {
	    	Log.logInfo("value entered in mandatory field");
	        batchModule.enterValidDataAllMandatoryFields();
	        batchModule.clickSaveButton();
	    }

	    @Then("Admin should see a successful message {string}")
	    public void admin_should_see_a_successful_message(String string) {
	    	Log.logInfo("Success message batch creation assertion");
	    	  Assert.assertTrue("SuccessMessage:batch created successfully", 
		                batchModule.isSuccessMessageDisplayed());
	       
	    }

	  
	    @When("Admin enters valid data in all mandatory fields and clicks the cancel button")
	    public void admin_enters_valid_data_in_all_mandatory_fields_and_clicks_the_cancel_button() {
	    	 batchModule.enterValidDataAllMandatoryFields();
	    	 batchModule.clickCancelButton();
	    }

	    @Then("Admin should see the Batch Details pop-up closes without creating any batch")
	    public void admin_should_see_the_Batch_Details_pop_up_closes_without_creating_any_batch() {
	 
	    }

	 
	 
	 
	 
	 
	 
/**********************************/	
	 
	 //Add new batch pop field input validation
	 
	 
	 @When("Admin selects program name present in the dropdown")
	    public void admin_selects_program_name_present_in_the_dropdown() {
		 Log.logInfo("Dropdown");
		 batchModule.navigateToBatch();
		 batchModule.clickAddNewBatchButton();
		 batchModule.selectProgramFromDropdown();
	      
	    }

	 @Then("Admin should see the selected program name in the batch name prefix box")
	 public void admin_should_see_the_selected_program_name_in_the_batch_name_prefix_box() {
		 Log.error("prefix validation."); 
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

	  @When("Admin should see the Batch details pop-up window by clicking the edit icon for any batch")
	    public void admin_should_see_the_Batch_details_pop_up_window_by_clicking_the_edit_icon_for_any_batch() {
	        batchModule.navigateToBatch(); 
	        batchModule.clickEditButton();
	      //  Assert.assertTrue("Batch details pop-up should be displayed", batchModule.isBatchDetailsPopupVisible());
	    }

	  @Then("Admin should see the Program name field  abn batchname prefix field disabled for editing")
	  public void admin_should_see_the_Program_name_field_abn_batchname_prefix_field_disabled_for_editing()  {
	        Assert.assertTrue("Program name field should be disabled", batchModule.isProgramNameFieldDisabled());
	        Assert.assertTrue("Batch name field should be disabled", batchModule.isBatchNameFieldDisabled());
	    }

	  @When("Admin updates the description and No. of classes fields with and clicks the save button")
	  public void admin_updates_the_description_and_No_of_classes_fields_with_and_clicks_the_save_button()  {
	        batchModule.enterDescription(""); 
	        batchModule.enterNumberOfClasses(""); 
	        batchModule.clickSaveButton(); 
	    }


           @Then("Admin should get  message batch updated")
            public void admin_should_get_message_batch_updated() {
	        //Assert.assertTrue("Error message should be displayed under the description field", 
	       //         batchModule.isDescriptionErrorDisplayed());
	       // Assert.assertTrue("Error message should be displayed under the number of classes field", 
	      //          batchModule.isNumberOfClassesErrorDisplayed());
        	   Assert.assertTrue("Batch details pop-up should be closed", batchModule.isSuccessMessageDisplayed()); 
        	   
	    }

	    @Given("Admin is on the Batch Details pop-up window")
	    public void admin_is_on_the_Batch_Details_pop_up_window() {
	       
	        batchModule.navigateToBatch(); 
	        batchModule.clickEditButton(); 
	      //  Assert.assertTrue("Batch details pop-up should be displayed", batchModule.isBatchDetailsPopupVisible());
	    }

	    @When("Admin enters data clicks the cancel button")
	    public void admin_enters_data_clicks_the_cancel_button() {
	        batchModule.enterValidDataInMandatoryFields(); 
	        batchModule.clickCancelButton(); 
	    }


@Then("Admin should see the Batch Details pop-up closes without editing the batch")
public void admin_should_see_the_Batch_Details_pop_up_closes_without_editing_the_batch()  {
	        Assert.assertFalse("Batch details pop-up should be closed", batchModule.isSuccessMessageDisplayed());
	    }
	

	    
	    
	    
// Single row delete and multi row delete and No Delete validation
		

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

       @When("Admin clicks on the delete icon on  batch page")
       		public void admin_clicks_on_the_delete_icon_on_batch_page() {
    	   		batchModule.navigateToBatch();
    	   			batchModule.clickDeleteIconForSpecificBatch();
       }

      @Then("Admin should not be able to delete  the batch by clicking No to to go back the batch page")
    public void admin_should_not_be_able_to_delete_the_batch_by_clicking_No_to_to_go_back_the_batch_page() {
    batchModule.cancelDeletion();
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
	    	

	    	/*switch (expectedResult.toLowerCase()) {
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
	    }*/
	
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
	        case "last results":
	            Assert.assertTrue("Expected to see results on the last page.", batchModule.hasNextPageResults());
	            break;
	        case "previous results":
	            Assert.assertTrue("Expected to see results on the previous page.", batchModule.hasNextPageResults());
	            break;
	        case "first results":
	            Assert.assertTrue("Expected to see results on the first page.", batchModule.hasNextPageResults());
	            break;
	        default:
	            Assert.fail("Unexpected result description: " + expectedResult);
	    }
	    }
	    
	    
	    
//Search
	    @When("^Admin enters the (.*) in the search text box$")
	    public void admin_enters_the_batch_name_in_the_search_text_box(String batchname){
	    //	String batchname ="java";
	    	 // this.batchname = batchName; // Store the batch name for later use
	          batchModule.navigateToBatch();
	          batchModule.searchInBatchPage(batchname); 
	    	   
	   
	    }

	    @Then("^Admin should see the filtered batches in the data table$")
	    public void admin_should_see_the_filtered_batches_in_the_data_table() {
	        Assert.assertNotNull("Batch name should not be null", batchname); 
	        boolean isBatchDisplayed = batchModule.isBatchDisplayed(batchname);
	        Assert.assertTrue("Expected batch name not found in the displayed results: " + batchname, isBatchDisplayed);
	    }

	  
	  

	  


	  

}

	  
	  
	  
	  
	  
	  
