package com.hooks;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CommonMethodsClass {
	
	
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

	public boolean isSortingbuttonDisplayed(List<WebElement> elements) {
		boolean flag = true; 
	       if (elements.size() > 1) {
	    	     for (int i = 1; i < elements.size(); i++) {
	            WebElement element = elements.get(i);	            
	              if (!element.isDisplayed()) {
	                flag = false;
	                break;  
	            }
	        }
	    } else {
	        flag = false;  
	    }
	    return flag;
	}
		
	}

		
	

	
	
	
