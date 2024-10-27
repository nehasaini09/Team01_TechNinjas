package com.stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.BaseClass;
import com.hooks.TestContext;
import com.pageObject.BatchModule;
import com.pageObject.ProgramModulePage;
import com.utilities.Log;
import com.hooks.CommonMethodsClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_SD {
	
	
	private WebDriverWait wait;
	   private ProgramModulePage programModulePage;
	   private WebDriver driver;
	   private TestContext context;
	   //private BatchModule batchModule;

	public Program_SD(TestContext context) {
     this.context = context; //  context initialized
     this.driver = context.getDriver(); //  WebDriver get initialized
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initializes WebDriverWait
     
    this.programModulePage = new ProgramModulePage(driver); 
     //this.programModulePage=context.getProgramModule();
    //this.batchModule = new BatchModule(driver);
 }
	
	
	@Given("Admin is in login Page")
	public void admin_is_in_login_Page() {
		
		Log.logInfo("Navigating to application URL");
		//String applicationURL = "https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login";
		//String applicationURL = context.getApplicationURL(); 
		context.getApplicationURL();                  //get(applicationURL);
        	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		//String username = "Sdet@gmail.com";
        //String password = "LmsHackathon@2024";
        
       // batchModule.login(username, password);
       // context.login(username, password);
		programModulePage.login();
        
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		String TitleOfPortalpage=driver.getTitle();
		System.out.println(" Title of Login Page:"+TitleOfPortalpage);//LMS
		Assert.assertEquals("LMS", TitleOfPortalpage);
	}

	

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		programModulePage.ProgramClick();
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_Program_module() {
		programModulePage.programPageTitle();
	}



	
	
	
	

}
