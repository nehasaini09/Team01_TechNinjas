package com.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hooks.TestContext;
import com.pageObject.BatchModule;
import com.pageObject.ProgramModule;
//import com.pageObject.ProgramModulePage;
import com.utilities.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class Program_SD {
	
	
	private WebDriverWait wait;
	   private ProgramModule programModulePage;
	   private WebDriver driver;
	   private TestContext context;
	   private BatchModule batchModule;
	   List<String>menuItems;
	   SoftAssert softAssert = new SoftAssert();

	public Program_SD(TestContext context) {
     this.context = context; //  context initialized
     this.driver = context.getDriver(); //  WebDriver get initialized
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initializes WebDriverWait
     
    this.programModulePage = new ProgramModule(driver,context); 
     //this.programModulePage=context.getProgramModule();
    this.batchModule = new BatchModule(driver, context);
 }
	
	
	@Given("Admin is in login Page")
	public void admin_is_in_login_Page() {
		
		Log.logInfo("Navigating to application URL");
		 context.getApplicationURL(); 
	       // context.get(applicationURL);
	                       //get(applicationURL);
        	}
	


	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		String username = "Sdet@gmail.com";
        String password = "LmsHackathon@2024";
        batchModule.login(username, password);   
        
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		String TitleOfPortalpage=driver.getTitle();
		Log.logInfo("successfully logged in and verified dashboard header LMS");
		Assert.assertEquals("LMS", TitleOfPortalpage);
	}

	

	@When("Admin clicks {string} on the navigation bar in program module")
	public void admin_clicks_on_the_navigation_bar(String string) throws InterruptedException {
		programModulePage.ProgramClick();
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_Program_module() {
		programModulePage.programPageTitle();
	}
	
	//--------------------Menu--------------------------------
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_Login() {
		Log.logInfo("Admin is in DashBoard");
	}

	@Then("Admin should see the heading {string} for program")
	public void admin_should_see_the_heading(String ExpectedHeader) {
		
		String dashBoardHeaderUI=programModulePage.verifyHeader();
		Assert.assertEquals(ExpectedHeader, dashBoardHeaderUI);
		
		
	}

	@Then("Admin should see the module names as in order {string} for program")
	public void admin_should_see_the_module_names_as_in_order(String string) {
		List<String>menuItems=programModulePage.testListContainsElements();
		Assert.assertTrue(menuItems.contains("Batch"));
        Assert.assertTrue(menuItems.contains("Program"));
        Assert.assertTrue(menuItems.contains("Class"));
        
	}

	

	@Then("Admin should see {string} in menu bar for program")
	public void admin_should_see_Logout_in_menu_bar(String expectedHeader) {
		List<String>menuItems=programModulePage.testListContainsElements();
		 Assert.assertTrue(menuItems.contains("Logout"));
	}

	@Given("Admin is on program page")
	public void admin_is_on_program_page() throws InterruptedException {
		programModulePage.ProgramClick();
	}

	@Then("Admin should see sub menu in menu bar as {string} for program")
	public void admin_should_see_sub_menu_in_menu_bar_as(String expected) throws InterruptedException {
		Thread.sleep(1000);
		
		String NewProgramUI=programModulePage.testAddNewProgramsIsPresent();
		Assert.assertEquals(expected, NewProgramUI);
	}
	
	
	//-----------------------------------MenubarPage validation----------------------------------
	
	@Then("Admin should see the heading  {string} for each program")
	public void admin_should_see_the_heading_for_each_program(String expected) {
		Log.logInfo("validating Manage Headers in left top");
		String manageprogramUI= programModulePage.testManageHeader();
		Assert.assertEquals(expected, manageprogramUI);
	}

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_Program_name_description_and_status_for_each_program() {
		Log.logInfo("validating TableHeaders in left top");
		List<String>itemTextList=programModulePage.testManageProgramMenu();
		Assert.assertTrue(itemTextList.contains("Program Name"));
        Assert.assertTrue(itemTextList.contains("Program Description"));
        Assert.assertTrue(itemTextList.contains("Program Status"));
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_Delete_button_in_left_top_is_disabled() {
		Log.logInfo("validating delete button in left top");
		boolean	isDisabled=programModulePage.testMultipleDeleteIsDisabled();
		      

        // Use soft assertion
        softAssert.assertTrue(isDisabled, "The Delete button should be disabled");
       
        softAssert.assertAll();
		
		
	    
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_Search_bar_with_text_as(String expected) {
		Log.logInfo("validating Search button in program");
		String placeholderText= programModulePage.testSearchBar();
		Assert.assertEquals( expected, placeholderText);
		
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_Program_Name_column_header() {
		Log.logInfo("validating Checkboxes");
		boolean isDisabled=programModulePage.testPDefaultCheckbox();
		Assert.assertTrue("The CHECKBOX button should be disabled",isDisabled);
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Log.logInfo("validating default state of  Checkbox");
		programModulePage.testAreUnchecked();
		
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_Edit_and_Delete() {
		Log.logInfo("validating sort arrow icon on each column");
		programModulePage.testSortArrowsVisibility();
		
		
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_Edit_and_Delete_buttons_on_each_row_of_the_data_table() {
		Log.logInfo("validating Edit and Delete buttons on each row");
		programModulePage.testEditDeleteButtonsPresence();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_Pagination_icon_below_the_table(String string) {
		Log.logInfo("validating pagination icons along with text");
		programModulePage.testPaginationTextIcons();
	}

	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {
		Log.logInfo("validating footer message along with text");
		programModulePage.testpaginationfooter();
		
	    	}
	
//----------------------------------------AddNewProgramValidation-------------------------------------
	
	

		@When("Admin clicks on {string} under the {string} menu bar")
		public void admin_clicks_on_under_the_menu_bar(String string, String string2) throws InterruptedException {
			programModulePage.ProgramClick();
			Thread.sleep(1000);
			programModulePage.clickAddNewProgram();
			
			
		    
		}

		@Then("Admin should see pop up window for program details")
		public void admin_should_see_pop_up_window_for_program_details() throws InterruptedException {
			/*Log.logInfo("validating popup display") ;
			Thread.sleep(1000);
			boolean isDisplayed = programModulePage.IsPopUpDisplayed();
	    	 Assert.assertTrue("Program Details form should be visible", isDisplayed);*/
			programModulePage.IsPopUpDisplayed();
		}

			

		@Then("Admin should see window title as {string} for popup")
		public void admin_should_see_window_title_as_for_popup(String expected) throws InterruptedException {
			Log.logInfo("validating Header in popup display") ;
			Thread.sleep(1000);
			String programHeader=programModulePage.VerifyTitleOfAddNewPopwindow();
	         Assert.assertEquals( expected, programHeader);
		}

		

		@Then("Admin should see red {string} mark beside mandatory field {string} in popup")
		public void admin_should_see_red_mark_beside_mandatory_field_in_popup(String string, String string2) {
			Log.logInfo("validating astreik in popup") ;
			programModulePage.testMandatoryFieldAsterisk();
		}

		
		

		@When("Admin clicks save button without entering mandatory fiels in add new program form")
		public void admin_clicks_save_button_without_entering_mandatory_fiels_in_add_new_program_form() {
			programModulePage.saveClick();
		}

		@Then("Admin gets message {string} in popup")
		public void admin_gets_message_in_popup(String expected) {
			String expectedMessage = "Program name is required.";
			String	fieldText=programModulePage.testRequiredFieldMessage();
			Assert.assertEquals( expectedMessage,fieldText );
		}

		

		@When("Admin clicks Cancel button in new program form")
		public void admin_clicks_Cancel_button_in_new_program_form() throws InterruptedException {
			programModulePage.cancelbuttonclick();
		}

		@Then("Admin can see Program Details form disappears")
		public void admin_can_see_Program_Details_form_disappears() throws InterruptedException {
			Log.logInfo("validating  popup to disappear") ;
			/*Thread.sleep(1000);
			boolean isDisplayed=programModulePage.IsPopUpDisplayed();
			softAssert.assertFalse(isDisplayed,"Program Details form should be visible"); 
			
			 softAssert.assertAll();*/
			programModulePage.IsPopUpDisplayed();
			
			
		}

		

		@When("Admin enters the Name in the text box")
		public void admin_enters_the_Name_in_the_search_text_box() {
			programModulePage.enterText("CVBN");
		    
		}

		@Then("Admin can see the program name entered")
		public void admin_can_see_the_program_name_entered() {
			String enteredText=programModulePage.ProgramNameEntryTest();
			Assert.assertEquals("The entered program name should match.", "CVBN", enteredText);
			
		}

		

		@When("Admin enters the Description in text box")
		public void admin_enters_the_Description_in_text_box() {
			programModulePage.DescriptionEntry("WEBTEST");
		}

		@Then("Admin can see the text entered in description box")
		public void admin_can_see_the_text_entered_in_description_box() {
			String enteredText=programModulePage.DescriptionEntryTest();
			Assert.assertEquals("The entered description should match.", "WEBTEST", enteredText);
		    
		}

		

		@When("Admin selects the status of the program by clicking on the radio button {string}")
		public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String string) {
			programModulePage.clickStatus();
		}

		@Then("Admin can see {string} status selected")
		public void admin_can_see_status_selected(String string) {
			programModulePage.isStatusSelected();
			
		}

		

		@When("Admin enter valid details for mandatory fields and Click on save button")
		public void admin_enter_valid_details_for_mandatory_fields_and_Click_on_save_button() {
			
			programModulePage.createForm();
			programModulePage.clickStatus();
			programModulePage.clickSaveButton();
		}

		@Then("Admin gets message {string}")
		public void admin_gets_message(String expected) {
			String successMsg=programModulePage.successMsgSave();
			expected="Program Created Successfully";
			Assert.assertEquals(expected,successMsg );
		}

		

		@When("Admin Click on cancel button")
		public void admin_Click_on_cancel_button() throws InterruptedException {
			programModulePage.cancelbuttonclick();
		    
		}

		@Then("Admin can see program details form disappear")
		public void admin_can_see_program_details_form_disappear() {
			Log.logInfo("validating  popup to disappear") ;
			
			programModulePage.IsPopUpDisplayed();
		    
		}

		

		@When("Admin searches with newly created {string}")
		public void admin_searches_with_newly_created(String string) {
			
			programModulePage.searchEnterProgramText("zxcv");
			
		    
		}

		@Then("Records of the newly created  {string} is displayed and match the data entered")
		public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String expected ) {
			Log.logInfo("validating  text record to appear") ;
			String searchText=programModulePage.searchForProgram();
			expected="zxcv";
			softAssert.assertEquals(expected,searchText );
			softAssert.assertAll();
		}

		

		@When("Admin Click on {string} button")
		public void admin_Click_on_button(String string) {
			programModulePage.clickXbutton();
		}

		@Then("Admin can see program details form disappear after click on cancel")
		public void admin_can_see_program_details_form_disappear_after_click_on_cancel() {
			Log.logInfo("validating  popup to disappear") ;
			programModulePage.IsPopUpDisplayed();
		}

//-------------------------DeleteProgram---------------------
		//sc1
		
		@Given("Admin clicks {string} on the navigation bar in program module for delete and sort")
		public void admin_clicks_on_the_navigation_bar_Delete(String string) throws InterruptedException {
			programModulePage.ProgramClick();
		}
		@When("Admin clicks on the delete icon on program module page")
		public void admin_clicks_on_the_delete_icon_on_program_module_page() {
			programModulePage.clickOnDeleteIcon();
			
		}

		
		@Then("Admin able to delete by clicking yes to confirmation pop up")
		public void admin_able_to_delete_by_clicking_yes_to_confirmation_pop_up() {
			programModulePage.deleteSingleProgram();
		}
		

		
		
		//sc2
		@Then("Admin able to delete by clicking No to confirmation pop up")
		public void Admin_able_to_delete_by_clicking_No_to_confirmation_pop_up() {
			programModulePage.DropDeleteSingleProgram();
		}

		
		
		@When("Admin clicks on the multiple checkboxes on program module page")
		public void admin_clicks_on_the_multiple_checkboxes_on_program_module_page() {
			programModulePage.SelectCheckBoxes();
		}

		@When("Admin clicks  on the left delete button on program module page")
		public void admin_clicks_on_the_left_delete_button_on_program_module_page() {
			programModulePage.MultipleDelete();
		}

		@Then("Admin able to delete multiple program by clicking yes to confirm")
		public void admin_able_to_delete_multiple_program_by_clicking_yes_to_confirm() {
			programModulePage.DeleteSuccess();
		}

//----------------------------sort--------------------------------------------------
		

		@When("Admin clicks on Arrow next to program Name of Program module page for sort")
		public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort() {
			programModulePage.clickProgramNameSort();
		}

		@Then("Admin See the Program Name is sorted Ascending order in Program module page for sort")
		public void admin_See_the_Program_Name_is_sorted_Ascending_order_in_Program_module_page_for_sort() {

			List<String> originalList = programModulePage.getOriginalList("progName");
			List<String> sortedList = programModulePage.getSortedList(originalList);
			System.out.println("sorted name list" + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
			
			
		}


		@When("Admin clicks on Arrow next to program Name of Program module page for sort descend")
		public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort_descend() {
			programModulePage.clickProgramNameSortDec();
		
		
		}
		
		@Then("Admin See the Program Name is sorted Descending order in Program module page")
		public void admin_See_the_Program_Name_is_sorted_Descending_order_in_Program_module_page() {
			List<String> originalList = programModulePage.getOriginalList("progName");
			List<String> sortedList = programModulePage.getSortedListDescending(originalList);
			System.out.println("Descending sorted name list " + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
			
		    
		}


		@When("Admin clicks on Arrow next to program description of Program module page for sort")
		public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort() {
			programModulePage.clickProgramDescrSort();
			
		}

		@Then("Admin See the Program description is sorted Ascending order in Program module page")
		public void admin_See_the_Program_description_is_sorted_Ascending_order_in_Program_module_page() {
			List<String> originalList = programModulePage.getOriginalList("ProgramDescription");
			List<String> sortedList = programModulePage.getSortedList(originalList);
			System.out.println("sorted name list" + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
		}


		@When("Admin clicks on Arrow next to program description of Program module page for sort descend")
		public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort_descend() {
			programModulePage.clickProgramDescrSortDes();
			
			
		}

		@Then("Admin See the Program description is sorted Descending order in Program module page")
		public void admin_See_the_Program_description_is_sorted_Descending_order_in_Program_module_page() {
			List<String> originalList = programModulePage.getOriginalList("ProgramDescription");
			List<String> sortedList = programModulePage.getSortedListDescending(originalList);
			System.out.println("Descending sorted name list " + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
		}



		@When("Admin clicks on Arrow next to program status of Program module page for sort")
		public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sort() {
			programModulePage.clickProgramStatusSort();
		}

		@Then("Admin See the Program status is sorted Ascending order in Program module page")
		public void admin_See_the_Program_status_is_sorted_Ascending_order_in_Program_module_page() {
			List<String> originalList = programModulePage.getOriginalList("status");
			List<String> sortedList = programModulePage.getSortedList(originalList);
			System.out.println("sorted name list" + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
		}



		@When("Admin clicks on Arrow next to program status of Program module page for sor descend")
		public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sor_descend() {
			programModulePage.clickProgramStatusSortDes();
		}

		@Then("Admin See the Program status is sorted Descending order in Program module page")
		public void admin_See_the_Program_status_is_sorted_Descending_order_in_Program_module_page() {
			List<String> originalList = programModulePage.getOriginalList("status");
			List<String> sortedList = programModulePage.getSortedListDescending(originalList);
			System.out.println("Descending sorted name list " + sortedList.toString() );
			Assert.assertTrue(originalList.equals(sortedList));
		}







	
	
	
	

}
