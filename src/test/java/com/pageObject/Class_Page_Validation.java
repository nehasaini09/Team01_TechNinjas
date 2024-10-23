package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hooks.BaseClass;
import com.hooks.CommonMethodsClass;

public class Class_Page_Validation extends BaseClass {
	
	//WebDriver driver;
    CommonMethodsClass common = new CommonMethodsClass();;	
	
	@FindBy(id="username")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath="//span[text()='Class']")
	private WebElement classBtn;
	@FindBy(className="login-button")
	private WebElement loginBtn;
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']")
	private WebElement appHeader;
	
	public Class_Page_Validation() {
        PageFactory.initElements(driver, this);  // Proper initialization
          // Initialize common actions with driver
    }

	
	
	public void addUsername(String uName) {
		userName.sendKeys(uName);;
	}
	
	public void addPassword(String pwsd) {
		password.sendKeys(pwsd);
	}
	
	public void clickLoginBtn() {
		common.click(loginBtn);
	}

}
