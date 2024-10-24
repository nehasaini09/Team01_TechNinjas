package com.pageObject;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hooks.BaseClass;
import com.hooks.CommonMethodsClass;

import junit.framework.Assert;

public class Class_Page_Validation extends BaseClass {
	
	//WebDriver driver;
    CommonMethodsClass common = new CommonMethodsClass();
	
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
	@FindBy(xpath="//div[text()=' Manage Class']")
	private WebElement manageClassHeader;
	@FindBy(xpath="//th[text()=' Batch Name ']")
	private WebElement batchNameHeader;
	@FindBy(xpath="//th[text()='Class Topic ']")
	private WebElement classTopicHeader;
	@FindBy(xpath="//th[text()='Class Description ']")
	private WebElement classDescriptionHeader;
	@FindBy(xpath="//th[text()=' Status ']")
	private WebElement statusHeader;
	@FindBy(xpath="//th[text()=' Class Date ']")
	private WebElement classDateHeader;
	@FindBy(xpath="//th[text()=' Staff Name ']")
	private WebElement staffNameHeader;
	
	
	
	public Class_Page_Validation() {
        PageFactory.initElements(driver, this);  
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
	
	public void clickClassBtn() {
		common.click(classBtn);
	}
	
	public String validateTitle() {
		return common.getText(appHeader);		
	}
	
	public String validatemanageClassHeader() {
		return common.getText(manageClassHeader);		
	}
			
	public WebElement getHeaderElement(String headerName) {
	    switch (headerName) {
	        case "Batch Name":
	            return batchNameHeader;
	        case "Class Topic":
	            return classTopicHeader;
	        case "Class Description":
	            return classDescriptionHeader;
	        case "Status":
	            return statusHeader;
	        case "Class Date":
	            return classDateHeader;
	        case "Staff Name":
	            return staffNameHeader;
	       default:
	         return null;
	    
	    }
	}

	

}
