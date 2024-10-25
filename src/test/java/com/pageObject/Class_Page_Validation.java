package com.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.BaseClass;
import com.hooks.CommonMethodsClass;

public class Class_Page_Validation  {
	
	private WebDriver driver;
	 private WebDriverWait wait;
	 
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
	@FindBy(css=".p-paginator-current.ng-star-inserted")
	private WebElement showingEnteries;
	@FindBy(xpath="//p-sorticon[@field='batchName']")
	private WebElement sortBatchNameBtn;
	@FindBy(className="p-sortable-column-icon")
	private List<WebElement> sortingBtn;
	@FindBy(css="button[class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteBtnMC;
	
	
	
	public Class_Page_Validation(WebDriver driver) {
		this.driver = driver;
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
	
				
	public WebElement getHeaderElement(String headerName) {
	    switch (headerName) {
	         case "LMS - Learning Management System":
                 return appHeader;
	         case "Manage class":
                 return manageClassHeader;   
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
	
	public String validateShowingEnteries() {
		return common.getText(showingEnteries);
		
	}
	
	public boolean validateSortingBtn() {
	return  common.isSortingbuttonDisplayed(sortingBtn);
	}

	public boolean deleteBtnDisplayed() {
	return	deleteBtnMC.isDisplayed();
	}

	

}
