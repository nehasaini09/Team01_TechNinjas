package com.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethodsClass {

	

	    // Locators for headers common to Batch and Program
	    @FindBy(xpath = "//thead/tr[1]/th[2]")
	    private WebElement nameHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[3]")
	    private WebElement descriptionHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[4]")
	    private WebElement statusHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[5]")
	    private WebElement classesHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[6]")
	    private WebElement programNameHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[7]")
	    private WebElement editDeleteHeader;

	    // Initialize elements in the constructor
	    public CommonMethodsClass(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    // Method to validate headers for Batch or Program
	    public boolean validateHeaders() {
	        return nameHeader.isDisplayed() && descriptionHeader.isDisplayed() &&
	               statusHeader.isDisplayed() && classesHeader.isDisplayed() &&
	               programNameHeader.isDisplayed() && editDeleteHeader.isDisplayed();
	    }
	}


