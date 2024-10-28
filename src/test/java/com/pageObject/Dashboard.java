package com.pageObject;

import com.hooks.DriverFactory;
import com.hooks.TestContext;
import com.utilities.ReadConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Dashboard extends DriverFactory {
    private TestContext context;
    WebDriver driver;
    private WebDriverWait wait;
    private Login login;
    String expectedTitle="LMS - Learning Management System";
    ReadConfig config = new ReadConfig();

    public Dashboard(WebDriver driver){
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.login = new Login(driver);
        PageFactory.initElements(driver, this);
    }
    public void validateResponseTime(){
     long startTime= System.currentTimeMillis();
        String credentials="valid credentials";
        login.validLogin(credentials);
        String homepage_URL= config.getDashboardurl();
        wait.until(ExpectedConditions.urlToBe(homepage_URL));
        long endTime = System.currentTimeMillis();
        long totaltime = endTime - startTime;
        Assert.assertTrue(totaltime<30000,"Navigation time exceeds 30s");



    }
    public void getDashboardTitle(){

        String pagetitle= driver.getTitle();
        Assert.assertEquals(pagetitle,expectedTitle,"Page title does not match");
    }
}
