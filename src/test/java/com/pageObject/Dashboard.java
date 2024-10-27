package com.pageObject;

import com.hooks.DriverFactory;
import com.hooks.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard extends DriverFactory {
    private TestContext context;
    WebDriver driver;
    private WebDriverWait wait;

    public Dashboard(TestContext testcontext){
        this.context= testcontext;
        this.driver= context.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
}
