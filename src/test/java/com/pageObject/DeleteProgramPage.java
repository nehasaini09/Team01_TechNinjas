package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProgramPage {
	private WebDriver driver;
	 private WebDriverWait wait;
	 Actions action;
	 	//login
	     @FindBy(xpath = "//input[@id='username']")private WebElement userName;
	     @FindBy(xpath = "//input[@id='password']")private WebElement passWord;
	     @FindBy(xpath = "//button[@id='login']")private WebElement loginBtn;
	     
	    //delete single program locators
	  
	     @FindBy(xpath = "//button//span[text()='Program']")private WebElement programclick;
	     @FindBy(xpath = "//tr[1]//*[@id=\"deleteProgram\"]/span[1]")private WebElement deletebtn;
	    // @FindBy(xpath = "//button//span[@class='pi pi-times ng-tns-c204-7']")private WebElement confirmX;
	     @FindBy(xpath = "//button//span[text()='Yes']")private WebElement confirmyes;
	     @FindBy(xpath = "//button//span[text()='No']")private WebElement confirmno;
	     @FindBy(xpath = "//div[text()='Successful']")private WebElement successdelete;
	     
	     //delete multiple program locators
	     @FindBy (xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]") private WebElement checkbox1;
	     @FindBy (xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]") private WebElement checkbox2;
		 @FindBy (xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")private WebElement dubdelete_icon;
	     @FindBy (xpath = "//button//span[text()='Yes']")private WebElement dubdelete_yes;
	     @FindBy (xpath = "//div/p-toastitem/div/div/div/div[2]")private WebElement success_dbdelete;
	    
	     
	     
	     public DeleteProgramPage(WebDriver driver) {
		 this.driver=driver;
		 this.action = new Actions(driver);
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     PageFactory.initElements(driver, this);
		 }
	      
	     public void loginPortal(String username, String password) {
			 wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(username);
		        wait.until(ExpectedConditions.visibilityOf(passWord)).sendKeys(password);
		        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	     
	
	     //delete single program method
	     //given
	     public void clickOnProgramModule() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        wait.until(ExpectedConditions.elementToBeClickable(programclick)).click();  	
	     
	     }
	     
	     //when
	     public void clickOnDeleteIcon() {
	    	 // Actions actions = new Actions(driver);
	    	  action.doubleClick(deletebtn).perform();	    	 
	     }
	     
	     //then
	     public void deleteSingleProgram() {
	    	 confirmyes.click();
	    	 String text1; 
	    	 text1 = successdelete.getText();
	    	 System.out.println(text1);
	    }
	     
	     public void DropDeleteSingleProgram() {
	    	 confirmno.click();	   
	    	 
	    		     }
	     public void SelectCheckBoxes() {
	    	// Actions actions = new Actions(driver);
	    	 action.doubleClick(checkbox1).perform();	
	    	 //checkbox1.click();
	    	 checkbox2.click();
//	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		     wait.until(ExpectedConditions.elementToBeClickable(checkbox1)).click(); 
//	    	 wait.until(ExpectedConditions.elementToBeClickable(checkbox2)).click(); 
	    	 System.out.println("this function executed:");
	    		 
	     
	     }
	     
	     public void MultipleDelete() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		     wait.until(ExpectedConditions.elementToBeClickable(dubdelete_icon)).click(); 
	    	 
	     }
	     
	     public void DeleteSuccess() {
	    	 dubdelete_yes.click();
	    	 String text2; 
	    	 text2 = success_dbdelete.getText();
	    	 System.out.println(text2);
	     }
	     
	     }
	     
	     

