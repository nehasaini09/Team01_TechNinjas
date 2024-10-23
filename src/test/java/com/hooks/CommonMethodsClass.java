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
	
	
}