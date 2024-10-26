package com.stepDefinition;

import com.hooks.DriverFactory;
import com.hooks.TestContext;
import com.pageObject.Login;
import com.utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginValidateSD {

   private TestContext context;
   private Login login;

   private WebDriver driver;
    private WebDriverWait wait;
    private final ReadConfig config;
    String uName="";
    String pwd="";
    String applicationURL;

    public LoginValidateSD(TestContext testcontext){
        this.context= testcontext;
        this.driver= context.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.login = new Login(driver);
        this.config = new ReadConfig();

    }
    @Given("Admin is in login Page")
    public void admin_is_in_login_Page() {
        applicationURL = context.getApplicationURL();
        driver.get(applicationURL);
       System.out.println("The login page URL is :" + driver.getCurrentUrl());


    }

    @When("Admin enter valid {string} and clicks login button")
    public void admin_enter_valid_and_clicks_login_button(String credentials) {

        switch(credentials) {
            case "valid credentials":
                System.out.println("Enter valid credentials");
                uName = config.getUSername();
                pwd = config.getpassword();
                break;
            case "invalid credentials":
                System.out.println("Enter invalid credentials");
                uName = config.getinvalidUSername();
                pwd = config.getinvalidpassword();
                break;
            case "password":
                System.out.println("Enter only the password");
                pwd = config.getpassword();
                break;
            case "username":
                System.out.println("Enter only the username");
                uName = config.getUSername();
                break;
        }login.validLogin(uName,pwd);

        Assert.assertEquals(applicationURL,driver.getCurrentUrl());
        }


    @Then("Admin should see the {string}")
    public void admin_should_see_the(String expectedResult) {
       switch(expectedResult){
           case "Admin should land on dashboard page":
              break;

       }
    }

    @When("Admin enter valid credentials  and clicks login button through keyboard")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
        uName = config.getUSername();
        pwd = config.getpassword();
        login.loginKeyboard(uName,pwd);

    }

    @Then("Admin should land on dashboard page")
    public void admin_should_land_on_dashboard_page() {
        String Homepageurl= config.getDashboardurl();
        String currentUrl= driver.getCurrentUrl();
        Assert.assertEquals(Homepageurl,currentUrl);

    }

    @When("Admin enter valid credentials  and clicks login button through mouse")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
        uName = config.getUSername();
        pwd = config.getpassword();
        login.loginMouse(uName,pwd);

    }

}
