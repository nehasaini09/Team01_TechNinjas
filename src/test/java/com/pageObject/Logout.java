package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	private WebDriver driver;
    private WebDriverWait wait;
	@FindBy (xpath="//*[@id='logout']/span[1]") WebElement logoutbnt;
	
	public Logout(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
	
	public String getLogout() {
		logoutbnt.isDisplayed();
		logoutbnt.click();
		return driver.getCurrentUrl();
		
	}
}
