package com.stepDefinition;

import com.hooks.TestContext;
import com.pageObject.Dashboard;
import com.pageObject.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Dashboard_SD {
    private TestContext context;
    WebDriver driver;
    private WebDriverWait wait;
    Map<String, String> result= new HashMap<>();
    private Dashboard homepage;
    private Login login;

    public Dashboard_SD(TestContext testcontext){
        this.context= testcontext;
        this.driver= context.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.homepage= new Dashboard(driver,context);
        this.login= new Login(driver,context);
    }
    @When("Admin enter valid credentials and clicks login button")
    public void admin_enter_valid_credentials_and_clicks_login_button() {
        String credentials="valid credentials";
        result=login.validLogin(credentials);
    }
@When("Admin logins to validate the navigation time")
public void Maxnavigationtime(){
    homepage.validateResponseTime();

}

    @Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
    public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {

    }

    @Then("Admin should see LMS -Learning management system as title")
    public void admin_should_see_LMS_Learning_management_system_as_title() {
        homepage.getDashboardTitle();
    }

    @Then("LMS title should be on the top left corner of page")
    public void lms_title_should_be_on_the_top_left_corner_of_page() {
        homepage.LMSTitleLocation();
    }

    @Then("Admin should see correct spelling in navigation bar text")
    public void admin_should_see_correct_spelling_in_navigation_bar_text() {
        homepage.getNavItems();
    }

    @Then("Admin should see correct spelling and space in LMS title")
    public void admin_should_see_correct_spelling_and_space_in_LMS_title() {
       homepage.LMSTItleSpellcheck();
    }

    @Then("Admin should see the navigation bar text on the top right side")
    public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
    	homepage.getNavbar();
    }


    @Then("Admin should see Home in the 1st place")
    public void admin_should_see_Home_in_the_1st_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see program in order")
    public void admin_should_see_navbarText() {
        homepage.getNavItems();
    }

    @Then("Admin should see batch in the 3rd place")
    public void admin_should_see_batch_in_the_3rd_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see class in the 4th place")
    public void admin_should_see_class_in_the_4th_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see logout in the 5th place")
    public void admin_should_see_logout_in_the_5th_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
