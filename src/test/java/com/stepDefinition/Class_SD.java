package com.stepDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;
import com.pageObject.BatchModule;
import com.pageObject.ClassModule;
import com.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class_SD {
	
	String uName="Sdet@gmail.com";
	String pwsd="LmsHackathon@2024";
	
	  private WebDriverWait wait;
	  	   private WebDriver driver;
	   private TestContext context;
	   private ClassModule cp;
	   private BatchModule batchModule;
	   boolean status;
	   
	  
	
	   public Class_SD(TestContext context) {
		   this.context = context; 
	        this.driver = context.getDriver(); 
	       //this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		     this.cp = new ClassModule(driver,context);
		     this.batchModule = new BatchModule(driver, context);
		}

	   
	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
		cp.addUsername(uName);
		cp.addPassword(pwsd);
		cp.clickLoginBtn();

	}
	  /* @Given("Admin launch the browser and Admin is in login Page")
	    public void admin_is_in_login_Page() {
	        applicationURL = context.getApplicationURL();
	        driver.get(applicationURL);
	       System.out.println("The login page URL is :" + driver.getCurrentUrl());


	    }*/

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_Class_Navigation_bar_in_the_Header() {
				cp.clickClassBtn();
	}

	
	@Then("Admin should see the headers heading like {string}")
	public void admin_should_see_the_datatable_heading_like(String header) {
		
		    WebElement headerElement = cp.getHeaderElement(header); 
		    boolean isValid = cp.validateHeader(headerElement, header);
		    Assert.assertTrue(header, isValid);
		    Log.logInfo("Actual headr is "+headerElement.getText());
		}

	
	@Then("Admin should see the showing entries and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table() {
	    assertTrue(cp.validateShowingEnteries());
	    Log.logInfo("Footer is displayed");
	    
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_Sort_icon_of_all_the_field_in_the_datatable() {
		status=cp.validateSortingBtn();
		assertTrue(status);
		Log.logInfo("Sorting button are visible");
		
	}

	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_Delete_button_under_the_Manage_class_page_header() {
		status=cp.deleteBtnDisplayed();
		assertTrue(status);
		Log.logInfo("Delete button is visible");
		
		
	}

	@Then("Admin should see Total no of classes in below of the data table")
	public void admin_should_see_Total_no_of_classes_in_below_of_the_data_table() {
		assertTrue(cp.validateFooter());
		
	}
	
	//**********************Add New Class**********************************************	    
	
	
	@When("clicks add new class under the class menu bar")
		public void clicks_add_new_class_under_the_class_menu_bar() throws InterruptedException {
			Thread.sleep(2000);
			cp.clickAddNewClass();
		}


		@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
		public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_SAVE_and_CANCEL_button_and_Close_X_Icon_on_the_top_right_corner_of_the_window() {
			assertTrue(cp.cancelDisp());
			Log.logInfo("Cancel button is visible");
			assertTrue(cp.saveDisp());
			Log.logInfo("Save button is visible");
			assertTrue(cp.crossBtnDisp());
			Log.logInfo("Save button is visible");
			
		}


		@Then("Admin should see few input fields and their respective text boxes in the class details window")
		public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
			assertTrue(cp.batchNameOnPopupDisp());
			Log.logInfo("BatchName is visible");
			assertTrue(cp.classTopicOnPopupDisp());
			Log.logInfo("Class Topic is visible");
		    
		}

		
		/*@When("Admin enters mandatory fields in the form and clicks on save button")
		public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() throws InterruptedException {
		   cp.addingMandatoryFields();
		}*/

		@When("Admin enters mandatory fields {string} {string} {string} {string} {string} {string} {string} {string} {string} in the form and clicks on save button")
		public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String batchName, String classTopic,
				String classDescription,String month,String date1,String date2,String staffName,String Status,String expectedMsg) throws InterruptedException {
		    
		    assertTrue(cp.addingMandatoryFields(batchName, classTopic,classDescription,month,date1,date2,staffName,Status).equals(expectedMsg));
			}
		
		@Then("Admin gets message Class added Successfully")
		public void admin_gets_message_Class_added_Successfully() {
		    Log.logInfo("Class created successfully");
		}
		
		@When("Admin selects class {string} {string} {string} in date picker")
		public void admin_selects_class_date_in_date_picker(String month,String date1,String date2) {
			cp.noOfClasses(month,date1,date2);
		   
		}

		@Then("Admin should see no of class value is added automatically")
		public void admin_should_see_no_of_class_value_is_added_automatically() {
		   cp.validateNoOfClassessUpdated();
		}
		@When("Admin clicks date picker")
		public void admin_clicks_date_picker() {
					    
		}

		@Then("Admin should see weekend dates are disabled")
		public void admin_should_see_weekend_dates_are_disabled() {
			//assertTrue(cp.verifyWeekendDatesDisabled());
		    
		}

		@When("Admin skips to add value in mandatory field and enter only the optional field {string} {string} {string}")
		public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field(String comments,String notes,String recording) {
		   cp.selectOptionalFields(comments,notes,recording);
		}

		@Then("Admin should see error message below the test field and the field will be highlighed in red color {string} {string} {string} {string} {string}")
		public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color(String expectedBatchNameText, String expectedClassTopicText, 
                String expectedClassDateText, String expectedStaffNameText,String expectedNoOfClassesText) {
			Assert.assertEquals("Batch Name is required", expectedBatchNameText, cp.getBatchNameReqText());
	        Assert.assertEquals("Class Topic is required", expectedClassTopicText, cp.getClassTopicReqText());
	        Assert.assertEquals("Class Date is required", expectedClassDateText, cp.getClassDateReqText());
	        Assert.assertEquals("Staff Name is required", expectedStaffNameText, cp.getStaffNameReqText());
	        Assert.assertEquals("No. of Classes is required", expectedNoOfClassesText, cp.getNoOfClassesReqText());
		}

    @When("Admin clicks on save button without entering data")
    public void admin_clicks_on_save_button_without_entering_data() {
    	cp.clickOnSave();    	
    }
    
    @When("Admin clicks Cancel Icon on class Details form")
    public void admin_clicks_cancel_icon() {
    	cp.cancelDisp();
    	
    }
		@Then("Class Details popup window should be closed without saving")
		public void class_details_popup_window_should_be_closed_without_saving() {
			 status=cp.onManagePage();
			assertTrue(status);
			Log.logInfo("Admin is on manage class page"); 
			 
		}
		
//**************************************Edit Class Details****************************
		
		@When("Admin clicks on the edit icon")
		public void admin_clicks_on_the_edit_icon() {
		    cp.clickOnEdit();
		}

		@Then("A new pop up with class details appears")
		public void a_new_pop_up_with_class_details_appears() {
			status=cp.editPopup();
			assertTrue(status);
			Log.logInfo("edit popup window opens");
		}

		@Then("Admin should see batch name field is disabled")
		public void admin_should_see_batch_name_field_is_disabled() {
				assertFalse(cp.batchNameDisabled());
			Log.logInfo("Batch Name is disabled");
		}
		
		@Then("Admin should see class topic field is disabled")
		public void admin_should_see_class_topic_field_is_disabled() {
			status=cp.classTopicDisabled();
			assertFalse(status);
			Log.logInfo("Class Topic is disabled");
		}

		@Given("Admin is on the Edit Class Popup window")
		public void admin_is_on_the_Edit_Class_Popup_window() {
		    cp.clickOnEdit();
		}

		@When("Update the fields with valid data {string} and click save")
		public void update_the_fields_with_valid_data_and_click_save(String editClass) {
			cp.editClassDetails(editClass);			
		    
		}

		@Then("Admin gets message {string} and see the updated values in data table")
		public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
			
			Assert.assertEquals("Updated class Successfully", string, cp.saveEditClass());
		
		}

		@When("Update the optional fields with valid values {string} {string} {string} and click save")
		public void update_the_optional_fields_with_valid_values_and_click_save(String comments,String notes,String recording) {
		    cp.selectOptionalFields(comments,notes,recording);
		}

			
		@When("Admin clicks Cancel button on edit popup")
		public void admin_clicks_Cancel_button_on_edit_popup() {
		    cp.cancelDisp();
		}

		@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
		public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_Class() {
			status=cp.onManagePage();
			assertTrue(status);
			Log.logInfo("Admin is on manage class page");
		}
		
//*********************************Delete class***************************************
		

		@When("Admin clicks on the delete icon on class module page")
		public void admin_clicks_on_the_delete_icon_on_class_module_page() {
			cp.clickOnDeleteIcon();
		   
		}

		@Then("Admin able to delete by clicking yes to confirmation pop up on Class module")
		public void admin_able_to_delete_by_clicking_yes_to_confirmation_pop_up() {
		    cp.deleteSingleProgram();
		}	


		@Then("Admin able to delete by clicking No to confirmation pop up on Class module")
		public void admin_able_to_delete_by_clicking_No_to_confirmation_pop_up() {
		    cp.DropDeleteSingleProgram();
		}

		

		@When("Admin clicks on the multiple checkboxes on class module page")
		public void admin_clicks_on_the_multiple_checkboxes_on_class_module_page() {
		    cp.SelectCheckBoxes();
		}

		@When("Admin clicks  on the left delete button on class module page")
		public void admin_clicks_on_the_left_delete_button_on_class_module_page() {
			cp.MultipleDelete();
		    
		}

		@Then("Admin able to delete multiple class by clicking yes to confirm")
		public void admin_able_to_delete_multiple_class_by_clicking_yes_to_confirm() {
			cp.DeleteSuccess();
		   
		}
		
		@When("Admin clicks on Logout link on Manage class page")
		public void admin_clicks_on_Logout_link_on_Manage_class_page() throws InterruptedException {
			cp.logoutClick();
		    
		}

		@Then("Admin is re-directed to Login page")
		public void admin_is_re_directed_to_Login_page() {
		Assert.assertEquals("Admin is on login page",driver.getCurrentUrl());
		    
		}
		
// Search by batch name class topic and staff name
		@When("Admin enter the {string} {string} in search textbox")
		public void admin_enter_the_in_search_textbox(String field, String value) throws InterruptedException {
		    cp.searhBoxValidation(field, value);
		}

		@Then("Admin should see Class details are searched by given fields")
		public void admin_should_see_class_details_are_searched_by() {
			
		}

// Sorting 

@When("Admin clicks on Arrow next to Batch Name of Class module page for sort")
public void admin_clicks_on_Arrow_next_to_Batch_Name_of_Class_module_page_for_sort() {
	cp.clickBatchNameSort();
    
}

@Then("Admin See the Batch Name is sorted Ascending order in Class module page for sort")
public void admin_See_the_Batch_Name_is_sorted_Ascending_order_in_Class_module_page_for_sort() {
	List<String> originalList = cp.getOriginalList("BatchName");
	List<String> sortedList = cp.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));

}

@When("Admin clicks on Arrow next to Batch Name of Class module page for sort descend")
public void admin_clicks_on_Arrow_next_to_Batch_Name_of_Class_module_page_for_sort_descend() {
	cp.clickBatchNameSortDec();
    
}

@Then("Admin See the Batch Name is sorted Descending order in Class module page")
public void admin_See_the_Batch_Name_is_sorted_Descending_order_in_Class_module_page() {
	List<String> originalList = cp.getOriginalList("BatchName");
	List<String> sortedList = cp.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));
    
}

@When("Admin clicks on Arrow next to Class Topic of Class module page for sort")
public void admin_clicks_on_Arrow_next_to_Class_Topic_of_Class_module_page_for_sort() {
	cp.clickclassTopicSort();
}

@Then("Admin See the Class Topic is sorted Ascending order in Class module page")
public void admin_See_the_Class_Topic_is_sorted_Ascending_order_in_Class_module_page() {
	List<String> originalList = cp.getOriginalList("ClassTopic");
	List<String> sortedList = cp.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));
    
}

@When("Admin clicks on Arrow next to Class Topic of Class module page for sort descend")
public void admin_clicks_on_Arrow_next_to_Class_Topic_of_Class_module_page_for_sort_descend() {
	cp.clickclassTopicSortDes();
}

@Then("Admin See the Class Topic is sorted Descending order in Class module page")
public void admin_See_the_Class_Topic_is_sorted_Descending_order_in_Class_module_page() {
	
	List<String> originalList = cp.getOriginalList("ClassTopic");
	List<String> sortedList = cp.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));
    
}

@When("Admin clicks on Arrow next to Class Description of Class module page for sort")
public void admin_clicks_on_Arrow_next_to_Class_Description_of_Class_module_page_for_sort() {
	cp.clickclassDescriptionSort();
    
}

@Then("Admin See the Class Description is sorted Ascending order in Class module page")
public void admin_See_the_Class_Description_is_sorted_Ascending_order_in_Class_module_page() {
	List<String> originalList = cp.getOriginalList("Classdescription");
	List<String> sortedList = cp.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));
   
}

@When("Admin clicks on Arrow next to Class Description of Class module page for sor descend")
public void admin_clicks_on_Arrow_next_to_Class_Description_of_Class_module_page_for_sor_descend() {
	cp.clickclassDescriptionSortDes();
   
}

@Then("Admin See the Class Description is sorted Descending order in Class module page")
public void admin_See_the_Class_Description_is_sorted_Descending_order_in_Class_module_page() {
	List<String> originalList = cp.getOriginalList("ClassDescription");
	List<String> sortedList = cp.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));
    
}
//Pagination
		@When("^Admin clicks the (Next|Last|Previous|First) link on the data table in class page$")
	    public void adminClicksPageLink_program(String pageLink) {
	    	
	      	//cp.clickClassBtn();
	      	
	        switch (pageLink.toLowerCase()) {
	            case "next":
	            	cp.clickNextPage();
	                break;
	            case "last":
	                cp.clickLastPage();
	                break;
	            case "previous":
	            	cp.clickPreviousPage();
	                break;
	            case "first":
	            	cp.clickFirstPage();
	                break;
	        }
	    }
		@Then("^Admin should see the (.*) on the data table in class module$")
	    public void adminShouldSeeResults_program(String expectedResult) {
	    	
	    	
	
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


}
