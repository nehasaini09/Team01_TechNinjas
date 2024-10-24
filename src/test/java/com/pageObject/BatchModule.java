package com.pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchModule {

	private WebDriver driver;
	 private WebDriverWait wait;

	 //manage page validation locators
	    @FindBy(xpath = "//thead/tr[1]/th[2]")private WebElement nameHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[3]")private WebElement descriptionHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[4]")private WebElement statusHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[5]")private WebElement NoofclassesHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[6]")private WebElement programNameHeader;

	    @FindBy(xpath = "//thead/tr[1]/th[7]")private WebElement editDeleteHeader;
	    
	    @FindBy(xpath="//body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-title[1]/div[1]")
	    private WebElement HeaderElement;

	    @FindBy(xpath=" //body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[2]/div[1]")
	    private WebElement FooterElement;
	    
	    @FindBy(xpath="//body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/p-paginator[1]/div[1]")
	    private WebElement PaginationElement;

	    @FindBy(xpath="//body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-title[1]/div[2]/div[1]/button[1]")
	    private WebElement MultipleDeleteElement;
	    
	    @FindBy(xpath="//input[@id='filterGlobal']")private WebElement search;
	    
	    @FindBy (xpath="//button[span[text()='Batch']]")private  WebElement batchicon ;
	  
	public BatchModule(WebDriver driver) {
		this.driver=driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    PageFactory.initElements(driver, this);
	}
	
	
	    public void login(String username, String password) {
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	       // driver.findElement(By.xpath("//button[@id='login']")).click(); // Login button
	       // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#login"))).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
	        loginButton.click();


	    }
	    
	    public void clickBatchIcon() {
	        wait.until(ExpectedConditions.elementToBeClickable(batchicon)); // Wait until the button is clickable
	        batchicon.click(); // Click the Batch button
	    }
		public boolean isTextPresentOnBatchPage(String expectedText) {
			String pageSource = driver.getPageSource(); // Get the page source
	        return pageSource.contains(expectedText);
		}
	
		public boolean validateHeaders() {
			/*
			 * System.out.println("Name Header: " + nameHeader.getText());
			 * System.out.println("Description Header: " + descriptionHeader.getText());
			 * System.out.println("Status Header: " + statusHeader.getText());
			 * System.out.println("Classes Header: " +NoofclassesHeader.getText());
			 * System.out.println("Program Name Header: " + programNameHeader.getText());
			 * System.out.println("Edit/Delete Header: " + editDeleteHeader.getText());
			 */
	        return nameHeader.isDisplayed() && descriptionHeader.isDisplayed() &&
	               statusHeader.isDisplayed() && NoofclassesHeader.isDisplayed() &&
	               programNameHeader.isDisplayed() && editDeleteHeader.isDisplayed();
	    }

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
