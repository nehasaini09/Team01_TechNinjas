package com.pageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Collections;

public class SortProgramPage {
	  
	private WebDriver driver;
	private WebDriverWait wait;
	Actions action;
	//login
    @FindBy(xpath = "//input[@id='username']")private WebElement user_Name;
    @FindBy(xpath = "//input[@id='password']")private WebElement pass_Word;
    @FindBy(xpath = "//button[@id='login']")private WebElement login_Btn;
	//sort element locators
	@FindBy(xpath = "//button//span[text()='Program']")private WebElement programpgclick;
	//sort 
	@FindBy(xpath = "//thead//tr//th[2]//i")private WebElement progNameSort;
	@FindBy(xpath = "//thead//tr//th[3]//i")private WebElement progDescrpSort;
	@FindBy(xpath = "//thead//tr//th[4]//i")private WebElement progStatusSort;
	//list
	@FindBy(xpath = "//tbody//td[2]")private List<WebElement> programnameList;
	@FindBy(xpath = "//tbody//td[3]")private List<WebElement> descriptionnmList;
	@FindBy(xpath = "//tbody//td[4]")private List<WebElement> programstatusList;


	public SortProgramPage(WebDriver driver) {
		this.driver = driver;		 
		 this.action = new Actions(driver);
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     PageFactory.initElements(driver, this);
	}
	
	
	public void loginforSort(String username, String password) {
		 wait.until(ExpectedConditions.visibilityOf(user_Name)).sendKeys(username);
	        wait.until(ExpectedConditions.visibilityOf(pass_Word)).sendKeys(password);
	        wait.until(ExpectedConditions.elementToBeClickable(login_Btn)).click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }
	public void clickOnProgramModuleSort() {
   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.elementToBeClickable(programpgclick)).click();  	
    
    }
	
	public void clickProgramNameSort(){			
		action.doubleClick(progNameSort).perform();
		
	}
	
	public void clickProgramDescrSort(){			
		action.doubleClick(progDescrpSort).perform();
		
	}
	
	public void clickProgramStatusSort(){			
		action.doubleClick(progStatusSort).perform();
		
	}
	
//get and return original list	
	public List<String> getOriginalList(String type) {
		List<String> originalList = null;
		
		if(type.equals("progName")) {
			originalList = printWebElements(programnameList);
		
		}else if(type.equals("ProgramDescription")) {
			originalList = printWebElements(descriptionnmList);
		
		}else {
			originalList = printWebElements(programstatusList);
		}
		return originalList;	
	}
	
	
// this method will sort the given list
	public List<String> getSortedList(List<String> originalList){
		System.out.println("Original List Before sorting is"+ originalList);
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted List After sorting is"+ sortedList);
        return sortedList;
	}	
	
// covert web element to java string list	
	public List<String> printWebElements(List<WebElement> options) {
		List<String> texts = new ArrayList<String>();
		int i=0;
		for(WebElement option: options) {
			texts.add(i,option.getText());
			i++;
		}
		System.out.println("The number of items in the list are: "+ texts.size());
		return texts;
	}
	
	
}//class end