package com.pageObject;




import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchModule {

	private WebDriver driver;
	 private WebDriverWait wait;
	 //Locators for login
	 	@FindBy(xpath = "//input[@id='username']")private WebElement usernameField;

	    @FindBy(xpath = "//input[@id='password']")private WebElement passwordField;

	    @FindBy(xpath = "//button[@id='login']")private WebElement loginButton;

	 //manage page validation locators
	    
	    @FindBy(xpath = "  //th[@psortablecolumn='batchName']")private WebElement nameHeader;
	  
	    @FindBy(xpath = "//th[@psortablecolumn='batchDescription']")private WebElement descriptionHeader;

	    @FindBy(xpath = "//th[@psortablecolumn='batchStatus']")private WebElement statusHeader;

	    @FindBy(css = "th[psortablecolumn='batchNoOfClasses']")private WebElement NoofclassesHeader;
	    
	    @FindBy(xpath = "//th[contains(text(), 'Program Name')]")private WebElement programNameHeader;

	    @FindBy(xpath = "//th[contains(text(), 'Edit / Delete')]")private WebElement editDeleteHeader;
	    
	    @FindBy(xpath="//div[text()=' Manage Batch']")private WebElement HeaderElement;

	    @FindBy(xpath=" //body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[2]/div[1]")
	    private WebElement FooterElement;
	    
	    @FindBy(xpath="//body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/p-paginator[1]/div[1]")
	    private WebElement PaginationElement;

	    @FindBy(xpath="//body/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-title[1]/div[2]/div[1]/button[1]")
	    private WebElement MultipleDeleteElement;
	    
	    @FindBy(xpath="//input[@id='filterGlobal']")private WebElement search;
	    
	    @FindBy (xpath="//span[text()='Batch']")private  WebElement batchicon ;
	    
	    @FindBy(className = "cdk-overlay-backdrop")private WebElement overlayBackdrop;
	    
	    //Pagination frame locators
	    @FindBy(xpath = "//div[contains(@class, 'p-paginator')]")
	    private WebElement pagination;

	    @FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")
	    private WebElement currentEntriesText;

	    @FindBy(xpath = "//button[contains(@class, 'p-paginator-first')]")
	    private WebElement firstButton;

	    @FindBy(xpath = "//button[contains(@class, 'p-paginator-prev')]")
	    private WebElement prevButton;

	    @FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
	    private WebElement nextButton;

	    @FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")
	    private WebElement lastButton;

	    @FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")
	    private List<WebElement> pageButtons;
	    
	    
	    
	    //Add new Batch pop locators
	    @FindBy(css = "label[for='programName']")private WebElement programNameLabel;
	    @FindBy(css = "span.p-dropdown-trigger-icon.pi.pi-chevron-down") private WebElement Programdropdowntrigger;
	    @FindBy(css = "ul.p-dropdown-items")private WebElement dropdownOptions;
	    @FindBy(tagName = "li") private List<WebElement> dropdownItems;


	    @FindBy(css = "label[for='batchName']")private WebElement batchNameLabel;

	    @FindBy(css= " label[for='batchDescription']")private WebElement batchdescription;
	   
	    @FindBy(css = "label[for='online']")private WebElement statusLabel;

	    @FindBy(css = "label[for='batchNoOfClasses']")private WebElement numberOfClassesLabel;
	    @FindBy(css = "input#batchNoOfClasses")private WebElement numberOfClassesInput;


	    @FindBy(css = "button[ng-reflect-label='Cancel']")private WebElement cancelButton;
	    
	    @FindBy(css = "span.p-button-label")private WebElement saveButton;

	   

	  
	public BatchModule(WebDriver driver) {
		this.driver=driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    PageFactory.initElements(driver, this);
	}
	
	
	public void login(String username, String password) {
		 wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
	        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	/*
	 * public void waitForOverlayToDisappear() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * 
	 * wait.until(ExpectedConditions.invisibilityOf(overlayBackdrop)); }
	 */
	    public void  navigateToBatch() {
	    	// waitForOverlayToDisappear(); 
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.elementToBeClickable(batchicon)).click();
	        
	    }
	    public boolean validateBatchPage() {
	        // Validate header elements
	        boolean areHeadersValid = true;
	        try {
	            areHeadersValid = nameHeader.isDisplayed() &&
	                             descriptionHeader.isDisplayed() &&
	                             statusHeader.isDisplayed() &&
	                             NoofclassesHeader.isDisplayed() &&
	                             programNameHeader.isDisplayed() &&
	                             editDeleteHeader.isDisplayed();
	                 HeaderElement.isDisplayed();
	        } catch (NoSuchElementException e) {
	            System.out.println("One or more header elements are not displayed: " + e.getMessage());
	            areHeadersValid = false; // If any header element is not displayed, set to false
	        }

	        // Validate pagination elements
	        boolean isPaginationValid = true;
	        try {
	            isPaginationValid = pagination.isDisplayed() &&
	                               currentEntriesText.isDisplayed() &&
	                               firstButton.isDisplayed() &&
	                               prevButton.isDisplayed() &&
	                               nextButton.isDisplayed() &&
	                               lastButton.isDisplayed() &&
	                               !pageButtons.isEmpty();
	        } catch (NoSuchElementException e) {
	            System.out.println("One or more pagination elements are not displayed: " + e.getMessage());
	            isPaginationValid = false; // If any pagination element is not displayed, set to false
	        }

	        // Validate search element
	        boolean isSearchValid = true;
	        try {
	            isSearchValid = search.isDisplayed();
	        } catch (NoSuchElementException e) {
	            System.out.println("Search element is not displayed: " + e.getMessage());
	            isSearchValid = false; // If search element is not displayed, set to false
	        }

	        // Validate footer element
	        boolean isFooterValid = true;
	        try {
	            isFooterValid = FooterElement.isDisplayed();
	        } catch (NoSuchElementException e) {
	            System.out.println("Footer element is not displayed: " + e.getMessage());
	            isFooterValid = false; // If footer element is not displayed, set to false
	        }

	        
	        
	        // Final validation result
	        boolean isValid = areHeadersValid && isPaginationValid && isSearchValid && isFooterValid;

	        System.out.println("Debug: Batch page validation result: " + isValid);
	        return isValid;
	    }

	    

		//dropdown
			 public void openProgramDropdown() {
			        Programdropdowntrigger.click();  // Interact with the dropdown
			    }
		 
			 
				
				
		    
}