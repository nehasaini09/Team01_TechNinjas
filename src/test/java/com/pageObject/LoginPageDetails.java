package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDetails {

    WebDriver driver;

    public LoginPageDetails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
