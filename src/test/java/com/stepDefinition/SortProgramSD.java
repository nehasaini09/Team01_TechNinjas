package com.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;
import com.pageObject.DeleteProgramPage;
import com.pageObject.SortProgramPage;
import com.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SortProgramSD {
	
	private WebDriverWait wait;
	private SortProgramPage sortprogrampage;
	private WebDriver driver;
	private TestContext context;
	
	public SortProgramSD(TestContext context) {
		this.context= context;
		this.driver= context.getDriver();
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		this.sortprogrampage = new SortProgramPage(driver);
		
			
	}
	


	
	@Given("Admin logged into LMS portal for Program module sort function")
	public void Admin_logged_into_LMS_portal_for_Program_module_sort_function() {
		Log.logInfo("Navigate to application url");
	    String applicationURL = context.getApplicationURL();
	    driver.get(applicationURL);
	    String username = "Sdet@gmail.com";
	    String password = "LmsHackathon@2024";
		sortprogrampage.loginforSort(username, password);	
	}

	@Then("Admin is on Program Module for sorting")
	public void Admin_is_on_Program_Module_for_sorting() {
		sortprogrampage.clickOnProgramModuleSort();
	}

	@When("Admin clicks on Arrow next to program Name of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort() {
		sortprogrampage.clickProgramNameSort();
	}

	@Then("Admin See the Program Name is sorted Ascending order in Program module page for sort")
	public void admin_See_the_Program_Name_is_sorted_Ascending_order_in_Program_module_page_for_sort() {

		List<String> originalList = sortprogrampage.getOriginalList("progName");
		List<String> sortedList = sortprogrampage.getSortedList(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		
	}


	@When("Admin clicks on Arrow next to program Name of Program module page for sort descend")
	public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort_descend() {
		sortprogrampage.clickProgramNameSort();
	
	
	}

	
	
	
	@Then("Admin See the Program Name is sorted Descending order in Program module page")
	public void admin_See_the_Program_Name_is_sorted_Descending_order_in_Program_module_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@When("Admin clicks on Arrow next to program description of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort() {
		sortprogrampage.clickProgramDescrSort();
	}

	@Then("Admin See the Program description is sorted Ascending order in Program module page")
	public void admin_See_the_Program_description_is_sorted_Ascending_order_in_Program_module_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@When("Admin clicks on Arrow next to program description of Program module page for sort descend")
	public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort_descend() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin See the Program description is sorted Descending order in Program module page")
	public void admin_See_the_Program_description_is_sorted_Descending_order_in_Program_module_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	@When("Admin clicks on Arrow next to program status of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sort() {
		sortprogrampage.clickProgramStatusSort();
	}

	@Then("Admin See the Program status is sorted Ascending order in Program module page")
	public void admin_See_the_Program_status_is_sorted_Ascending_order_in_Program_module_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	@When("Admin clicks on Arrow next to program status of Program module page for sor descend")
	public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sor_descend() {
		sortprogrampage.clickProgramStatusSort();
	}

	@Then("Admin See the Program status is sorted Descending order in Program module page")
	public void admin_See_the_Program_status_is_sorted_Descending_order_in_Program_module_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}