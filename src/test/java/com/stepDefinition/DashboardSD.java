package com.stepDefinition;

import com.hooks.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardSD {
    private TestContext context;
    WebDriver driver;
    private WebDriverWait wait;
    public DashboardSD(TestContext testcontext){
        this.context= testcontext;
        this.driver= context.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    @When("Admin enter valid credentials and clicks login button")
    public void admin_enter_valid_credentials_and_clicks_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see dashboard")
    public void admin_should_see_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
    public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see LMS -Learning management system as title")
    public void admin_should_see_LMS_Learning_management_system_as_title() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("LMS title should be on the top left corner of page")
    public void lms_title_should_be_on_the_top_left_corner_of_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see correct spelling in navigation bar text")
    public void admin_should_see_correct_spelling_in_navigation_bar_text() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see correct spelling and space in LMS title")
    public void admin_should_see_correct_spelling_and_space_in_LMS_title() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see the navigation bar text on the top right side")
    public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("Admin should see Home in the 1st place")
    public void admin_should_see_Home_in_the_1st_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see program in the 2nd place")
    public void admin_should_see_program_in_the_2nd_place() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
