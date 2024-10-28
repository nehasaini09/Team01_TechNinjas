package com.stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;
import com.pageObject.Login;
import com.pageObject.Logout;
import com.utilities.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSD {

	private TestContext context;
    WebDriver driver;
    private Login login;
    private WebDriverWait wait;
    Logout lg;
    String finalURL;
    
	 public LogoutSD(TestContext testcontext){
	        this.context= testcontext;
	        this.driver= context.getDriver();
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.login = new Login(driver);
	        this.lg = new Logout(driver);
	       
	    }

    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
      finalURL=lg.getLogout();
    }

    @Then("Admin should be redirected to login page")
    public void admin_should_be_redirected_to_login_page() {
    	String applicationURL = context.getApplicationURL();
        Assert.assertEquals(applicationURL,finalURL);
    }


    @When("Admin clicks  browser back button")
    public void admin_clicks_browser_back_button() {
        
    	 driver.navigate().back();
    	 try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Then("Admin should receive error message")
    public void admin_should_receive_error_message() {
    	
    	
    }


}
