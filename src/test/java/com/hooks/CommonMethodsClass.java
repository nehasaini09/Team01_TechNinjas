package com.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethodsClass extends BaseClass{
	
	
	public void sendKeysToElement(WebElement element, String text) {
        element.clear(); 
        element.sendKeys(text);
}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public String getText(WebElement element) {
		String textValue = "";
		if(element.isDisplayed()) {
			textValue=element.getText();
			System.out.println("Text value:- "+textValue);
		}
		else {
			System.out.println("Element is not visible");
		}
		
		return textValue;
	}


	public boolean validateHeader(WebElement element, String header) {
	    String headerText = "";
	    if (element.isDisplayed()) {
	        headerText = element.getText();
	        if (headerText.equals(header)) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        return false; 
	    }
	}

	
	public String text(WebElement element) {
		return getText(element);
	}


		
	}

	
	
	
