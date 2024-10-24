package com.stepDefinition;

import com.hooks.BaseClass;
import com.hooks.CommonMethodsClass;
import com.pageObject.Class_Page_Validation;
import com.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Class_SD extends BaseClass{
	
	String uName = "Sdet@gmail.com";
	String pwsd ="LmsHackathon@2024";
	
	Class_Page_Validation cp =new Class_Page_Validation();
	CommonMethodsClass comm = new CommonMethodsClass();

	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
		cp.addUsername(uName);
		cp.addPassword(pwsd);
		cp.clickLoginBtn();

	}

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_Class_Navigation_bar_in_the_Header() {
				cp.clickClassBtn();
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_Title(String string) {
	Assert.assertEquals( string,cp.validateTitle());	
	Log.logInfo("Actual Title is "+cp.validateTitle());
	}

	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_Header(String header) {
		Assert.assertEquals( header,cp.validatemanageClassHeader());	
		Log.logInfo("Actual Title is "+cp.validatemanageClassHeader());
	   
	    
	}

	@Then("Admin should see the datatable heading like {string}")
	public void admin_should_see_the_datatable_heading_like(String header) {
		
		    WebElement headerElement = cp.getHeaderElement(header); 
		    boolean isValid = comm.validateHeader(headerElement, header);
		    Assert.assertTrue(header, isValid);
		    Log.logInfo("Actual headr is "+headerElement.getText());
		}

	
	

	@Then("Admin should see the {string} and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
		
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_Sort_icon_of_all_the_field_in_the_datatable() {
		
	}

	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_Delete_button_under_the_Manage_class_page_header() {
		
	}

	@Then("Admin should see Total no of classes in below of the data table")
	public void admin_should_see_Total_no_of_classes_in_below_of_the_data_table() {
		
	}

}
