package com.stepDefinition;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;
import com.pageObject.DeleteProgramPage;
import com.utilities.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DeleteProgramSD {
	
	private WebDriverWait wait;
	private DeleteProgramPage deleteprogrampage;
	private WebDriver driver;
	private TestContext context;
	
	public DeleteProgramSD(TestContext context) {
		this.context= context;
		this.driver= context.getDriver();
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		this. deleteprogrampage = new DeleteProgramPage(driver);
		
	}
	

    @Given("Admin logged into LMS portal for Program module delete function")
    public void Admin_logged_into_LMS_portal_for_Program_module_delete_function() {
    Log.logInfo("Navigate to application url");
    String applicationURL = context.getApplicationURL();
    driver.get(applicationURL);
    String username = "Sdet@gmail.com";
    String password = "LmsHackathon@2024";
    deleteprogrampage.loginPortal(username, password);
    } 

	
	//sc1
	@Given("Admin on the program module page after login")
	public void Admin_on_the_program_module_page_after_login() {
			deleteprogrampage.clickOnProgramModule();
		   
	    
	}

	@When("Admin clicks on the delete icon on program module page")
	public void admin_clicks_on_the_delete_icon_on_program_module_page() {
		deleteprogrampage.clickOnDeleteIcon();
		
	}

	
	@Then("Admin able to delete by clicking yes to confirmation pop up")
	public void admin_able_to_delete_by_clicking_yes_to_confirmation_pop_up() {
	    deleteprogrampage.deleteSingleProgram();
	}
	

	
	
	//sc2
	@Then("Admin able to delete by clicking No to confirmation pop up")
	public void Admin_able_to_delete_by_clicking_No_to_confirmation_pop_up() {
	    deleteprogrampage.DropDeleteSingleProgram();
	}

	
	//sc3
//	@Given("Admin on the program module page after login")
//	public void admin_on_the_program_module_page_after_login() {
//	    
//	}

	@When("Admin clicks on the multiple checkboxes on program module page")
	public void admin_clicks_on_the_multiple_checkboxes_on_program_module_page() {
	    deleteprogrampage.SelectCheckBoxes();
	}

	@When("Admin clicks  on the left delete button on program module page")
	public void admin_clicks_on_the_left_delete_button_on_program_module_page() {
	    deleteprogrampage.MultipleDelete();
	}

	@Then("Admin able to delete multiple program by clicking yes to confirm")
	public void admin_able_to_delete_multiple_program_by_clicking_yes_to_confirm() {
	    deleteprogrampage.DeleteSuccess();
	}

//


}
