package com.stepDefinition;

import com.hooks.TestContext;
import com.pageObject.Login;
import com.utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginValidateSD {

   private TestContext context;
   private Login login;
    Map<String, String> result= new HashMap<>();

   private WebDriver driver;
    private WebDriverWait wait;
    private final ReadConfig config;
    String uName="";
    String pwd="";
    String applicationURL;
    String actualurl="";
    String homepage_URL="";
    String actualErrMsg="";

    public LoginValidateSD(TestContext testcontext){
        this.context= testcontext;
        this.driver= context.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.login = new Login(driver);
        this.config = new ReadConfig();

    }
    @Given("Admin launch the browser and Admin is in login Page")
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
        }
        result=login.validLogin(uName,pwd);

        }


    @Then("Admin should see the {string}")
    public void admin_should_see_the(String expectedResult) {

        if (result.containsKey("current_URL")) {
            actualurl=result.get("current_URL");
            homepage_URL= config.getDashboardurl();
        }
        if(result.containsKey("error_message")){
            actualErrMsg=result.get("error_message");
        }
       switch(expectedResult){
           case "Admin should land on dashboard page":
               Assert.assertEquals(homepage_URL,actualurl);
               System.out.println("Logged in successfully");
              break;

           case "Invalid username and password Please try again":
               System.out.println("actual error message :"+ actualErrMsg);
               Assert.assertTrue("Expected error message was not found",actualErrMsg.contains("Invalid username and password Please try again"));
               break;
           case "Please enter your password":
               System.out.println("actual error message :"+ actualErrMsg);
               Assert.assertTrue(actualErrMsg.contains("Please enter your user name"));
               break;
           case "Please enter your user name ":
               System.out.println("actual error message :"+ actualErrMsg);
               Assert.assertTrue(actualErrMsg.contains("Please enter your password"));
               break;

       }
    }

    @When("Admin enter valid credentials  and clicks login button through keyboard")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
        uName = config.getUSername();
        pwd = config.getpassword();
        result= login.loginKeyboard(uName,pwd);

    }

    @Then("Admin should land on dashboard page")
    public void admin_should_land_on_dashboard_page() {
        if (result.containsKey("current_URL")) {
            actualurl=result.get("current_URL");
            homepage_URL= config.getDashboardurl();
        }
        Assert.assertEquals(homepage_URL,actualurl);
        System.out.println("Logged in successfully");

    }

    @When("Admin enter valid credentials  and clicks login button through mouse")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
        uName = config.getUSername();
        pwd = config.getpassword();
        result= login.loginMouse(uName,pwd);

    }
    @Then("Admin should see correct spellings in all fields")
    public void admin_should_see_correct_spellings_in_all_fields() {
       String userLabel=login.spellcheckerpasswrd();
        Assert.assertEquals( "Password",userLabel);
        String pwdLabel=login.spellcheckerUSer();
        Assert.assertEquals("User",pwdLabel);
        String LoginLabel=login.spellcheckLoginbutton();
        Assert.assertEquals("Login",LoginLabel);
    }

    @Then("Admin should see logo on the left  side")
    public void admin_should_see_logo_on_the_left_side() {

       int xCoordinate= login.LogoValidate();
        Assert.assertTrue("logo is at left "+ xCoordinate,xCoordinate < 100);
    }
    @Then("Admin should see  LMS - Learning Management System")
    public void admin_should_see_LMS_Learning_Management_System() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Admin should see company name below the app name")
    public void admin_should_see_company_name_below_the_app_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Admin should see {string}")
    public void admin_should_see(String string) {
        login.LmsContentMsg();
    }
    @Then("Admin should see two text field")
    public void admin_should_see_two_text_field() {
        int count= login.CountTextFields();
        Assert.assertEquals(2,count);
    }
    @Then("Admin should see * symbol next to password text")
    public void admin_should_see_symbol_next_to_password_text() {
        login.Asteriskpassword();
    }
    @Then("Admin should see field mandatory asterisk symbol next to Admin text")
    public void admin_should_see_field_mandatory_asterisk_symbol_next_to_Admin_text() {
        login.asteriskUser();
    }
    @Then("Admin should see login button")
    public void admin_should_see_login_button() {
        login.loginBtnVisible();
    }

    @Then("Admin should see Admin in gray color")
    public void admin_should_see_Admin_in_gray_color() {
        login.USercolor();
    }

    @Then("Admin should see password in gray color")
    public void admin_should_see_password_in_gray_color() {
        login.Passwordcolor();
    }

    @Then("Admin should {string} in the first text field")
    public void admin_should_in_the_first_text_field(String string) {
        login.FirstTextField();
    }


    @Then("Admin should {string} in the second text field")
    public void admin_should_in_the_second_text_field(String string) {
        login.SecondTextField();
    }



    @Then("Admin should see input field on the centre of the page")
    public void admin_should_see_input_field_on_the_centre_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Then("Admin should see login button on the centre of the page")
    public void admin_should_see_login_button_on_the_centre_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Admin should receive {int} page not found error")
    public void admin_should_receive_page_not_found_error(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("HTTP response >= {int}. Then the link is broken")
    public void http_response_Then_the_link_is_broken(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Admin gives the invalid LMS portal URL")
    public void admin_gives_the_invalid_LMS_portal_URL() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
