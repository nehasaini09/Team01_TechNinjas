package com.stepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.CommonMethodsClass;
import com.hooks.TestContext;
import com.pageObject.Class_Page_Validation;
import com.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class_SD {
	
	String uName = "Sdet@gmail.com";
	String pwsd ="LmsHackathon@2024";
	
	  private WebDriverWait wait;
	  	   private WebDriver driver;
	   private TestContext context;
	   private Class_Page_Validation cp;
	   CommonMethodsClass comm = new   CommonMethodsClass() ;
	
	   public Class_SD(TestContext context) {
		   this.context = context; //  context initialized
	        this.driver = context.getDriver(); //  WebDriver get initialized
	       // this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		     this.cp = new Class_Page_Validation(driver);
		}


		

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

	
	@Then("Admin should see the headers heading like {string}")
	public void admin_should_see_the_datatable_heading_like(String header) {
		
		    WebElement headerElement = cp.getHeaderElement(header); 
		    boolean isValid = comm.validateHeader(headerElement, header);
		    Assert.assertTrue(header, isValid);
		    Log.logInfo("Actual headr is "+headerElement.getText());
		}

	
	@Then("Admin should see the showing \\{int} to \\{int} of \\{int} entries and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(int x, int y, int z) {
	    String expectedText = "showing " + x + " to " + y + " of " + z + " entries";
	    Assert.assertEquals(expectedText, cp.validateShowingEnteries());
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_Sort_icon_of_all_the_field_in_the_datatable() {
		boolean status=cp.validateSortingBtn();
		assertTrue(status);
		Log.logInfo("Sorting button are visible");
		
	}

	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_Delete_button_under_the_Manage_class_page_header() {
		boolean status=cp.deleteBtnDisplayed();
		assertTrue(status);
		Log.logInfo("Delete button is visible");
		
		
	}

	@Then("Admin should see Total no of classes in below of the data table")
	public void admin_should_see_Total_no_of_classes_in_below_of_the_data_table() {
		
	}

}
