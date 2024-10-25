package com.pageObject;


import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Arrays;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.Log;

public class BatchModule {

	private WebDriver driver;
	 private WebDriverWait wait;
	 //Locators for login
	 	@FindBy(xpath = "//input[@id='username']")private WebElement usernameField;

	    @FindBy(xpath = "//input[@id='password']")private WebElement passwordField;

	    @FindBy(xpath = "//button[@id='login']")private WebElement loginButton;
	    
	    
        @FindBy (xpath="//mat-toolbar[@color='primary']//span[contains(text(), 'LMS - Learning Management System')]")
        private WebElement toolbar;

        @FindBy (xpath="button[@class='p-button-danger p-button p-component p-button-icon-only']")
        private WebElement Multipledelete;
	 //manage page validation locators
	    
       
        
	    @FindBy(xpath = "  //th[@psortablecolumn='batchName']")private WebElement nameHeader;
	    
	    @FindBy(xpath = ".//th[contains(text(), 'Batch Name')]//i[contains(@class, 'p-sortable-column-icon')]")
        private WebElement batchNameSortingIcon;
	  
	    @FindBy(xpath = "//th[@psortablecolumn='batchDescription']")private WebElement descriptionHeader;
	    @FindBy(xpath = ".//th[contains(text(), 'Batch Description')]//i[contains(@class, 'p-sortable-column-icon')]")
	    private WebElement batchDescriptionSortingIcon;

	    @FindBy(xpath = "//th[@psortablecolumn='batchStatus']")private WebElement statusHeader;
	    @FindBy(xpath = ".//th[contains(text(), 'Batch Status')]//i[contains(@class, 'p-sortable-column-icon')]")
	    private WebElement batchStatusSortingIcon;

	    @FindBy(css = "th[psortablecolumn='batchNoOfClasses']")private WebElement NoofclassesHeader;
	    @FindBy(xpath = ".//th[contains(text(), 'No Of Classes')]//i[contains(@class, 'p-sortable-column-icon')]")
	    private WebElement noOfClassesSortingIcon;
	    
	    @FindBy(xpath = "//th[contains(text(), 'Program Name')]")private WebElement programNameHeader;
	    @FindBy(xpath = ".//th[contains(text(), 'Program Name')]//i[contains(@class, 'p-sortable-column-icon')]")
	    private WebElement programNameSortingIcon;

	    @FindBy(xpath = "//th[contains(text(), 'Edit / Delete')]")private WebElement editDeleteHeader;
	    
	    @FindBy(xpath = "//div[@role='checkbox']")private WebElement checkboxHeader;
	    
	    
	    private List<String> expectedHeaders = Arrays.asList(
	            "Batch Name", 
	            "Batch Description", 
	            "Batch Status", 
	            "No Of Classes", 
	            "Program Name", 
	            "Edit / Delete"
	        );
	    @FindBy(xpath="//div[text()=' Manage Batch']")private WebElement HeaderElement;

	    @FindBy(xpath=" //div[contains(@class, 'p-datatable-footer')]//div[contains(text(), 'batches')]")
	    private WebElement FooterElement;
	    
	    @FindBy(xpath="//p-table//p-paginator/div")private WebElement PaginationElement;

	    @FindBy(xpath="//input[@id='filterGlobal']")private WebElement search;
	    
	    @FindBy (xpath="//span[text()='Batch']")private  WebElement batchicon ;
	    
	    @FindBy(className = "cdk-overlay-backdrop")private WebElement overlayBackdrop;
	    
	    //Row locators
	    @FindBy(xpath=" //div[@class='p-checkbox-box p-component']")private WebElement checkbox;
	 
	    
	    
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
	    
	 // Locator for the entire table
	    @FindBy(xpath = "//p-table//table/tbody/tr")
	    private List<WebElement> rows;

	    // Locator for the edit buttons within each row
	    @FindBy(xpath = ".//button[contains(@class, 'p-button-success')]")
	    private List<WebElement> editButtons;

	    // Locator for the delete buttons within each row
	    @FindBy(xpath = ".//button[contains(@class, 'p-button-danger')]")
	    private List<WebElement> deleteButtons;

	    // Locator for the checkboxes within each row
	    @FindBy(xpath = ".//div[@role='checkbox']")
	    private List<WebElement> checkboxes;

	    
	    
	    
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

	    // Dropdown
	    public void openProgramDropdown() {
	        Programdropdowntrigger.click();  // Interact with the dropdown
	    }
	    
	    
	    public boolean isPaginationVisible() {
	        return PaginationElement.isDisplayed();
	    }
	    
	  
	    public boolean toolbarVisible() {
	        return toolbar.isDisplayed();
	    }
	    
	    public boolean isMultipleDeleteIconDisabled() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            wait.until(ExpectedConditions.visibilityOf(Multipledelete));
	            return Multipledelete.isEnabled() == false; // Check if it is disabled
	        } catch (NoSuchElementException e) {
	            return false; // Handle if the button is not found
	        }
	    }
	    
	    public List<String> getActualHeaders() {
	    	//wait.until(ExpectedConditions.visibilityOf(checkboxHeader));
	    	wait.until(ExpectedConditions.visibilityOf(nameHeader));
	        wait.until(ExpectedConditions.visibilityOf(descriptionHeader));
	        wait.until(ExpectedConditions.visibilityOf(statusHeader));
	        wait.until(ExpectedConditions.visibilityOf(NoofclassesHeader));
	        wait.until(ExpectedConditions.visibilityOf(programNameHeader));
	        wait.until(ExpectedConditions.visibilityOf(editDeleteHeader));

	        return List.of(
	        	
	            nameHeader.getText().trim(),
	            descriptionHeader.getText().trim(),
	            statusHeader.getText().trim(),
	            NoofclassesHeader.getText().trim(),
	            programNameHeader.getText().trim(),
	            editDeleteHeader.getText().trim()
	        );
	        
	    }
	    

	  /*  public boolean validateHeaders() {
	        List<String> actualHeaders = getActualHeaders();
	        return actualHeaders.equals(expectedHeaders);
	        
	    }*/
	    
	    public void validateHeaders() {
	        List<String> actualHeaders = getActualHeaders();

	        // Log both actual and expected headers for debugging
	        System.out.println("Actual Headers: " + actualHeaders);
	        System.out.println("Expected Headers: " + expectedHeaders);

	        // Assertion to check for header equality
	        if (!actualHeaders.equals(expectedHeaders)) {
	            throw new AssertionError("Batch page validation failed. Expected headers: " + expectedHeaders + 
	                                     ", but found: " + actualHeaders);
	        }
	    }


		public boolean arePaginationControlsEnabled() {
			 return PaginationElement.isDisplayed();
		}


		 // Check if all edit buttons are displayed
	    public boolean areEditButtonsDisplayed() {
	        for (WebElement editButton : editButtons) {
	            wait.until(ExpectedConditions.visibilityOf(editButton)); // Wait for edit button to be visible
	            if (!editButton.isDisplayed()) {
	                return false; // Return false if any edit button is not displayed
	            }
	        }
	        return true; // All edit buttons are displayed
	    }

	    // Check if all delete buttons are displayed
	    public boolean areDeleteButtonsDisplayed() {
	        for (WebElement deleteButton : deleteButtons) {
	            wait.until(ExpectedConditions.visibilityOf(deleteButton)); // Wait for delete button to be visible
	            if (!deleteButton.isDisplayed()) {
	                return false; // Return false if any delete button is not displayed
	            }
	        }
	        return true; // All delete buttons are displayed
	    }

	    // Check if all checkboxes are displayed
	    public boolean areCheckboxesDisplayed() {
	        for (WebElement checkbox : checkboxes) {
	            wait.until(ExpectedConditions.visibilityOf(checkbox)); // Wait for checkbox to be visible
	            if (!checkbox.isDisplayed()) {
	                return false; // Return false if any checkbox is not displayed
	            }
	        }
	        return true; // All checkboxes are displayed
	    }
	    //dataheader checkbox and sort 
	    public boolean isCheckboxHeaderDisplayed() {
	        // Wait for the checkbox header to be visible
	        wait.until(ExpectedConditions.visibilityOf(checkboxHeader));
	        // Check if the checkbox header is displayed
	        return checkboxHeader.isDisplayed();
	    }

	    
	 // Method to check if sorting is enabled 
	    public boolean areSortingIconsDisplayed() {
	        return batchNameSortingIcon.isDisplayed() &&
	               batchDescriptionSortingIcon.isDisplayed() &&
	               noOfClassesSortingIcon.isDisplayed() &&
	               batchStatusSortingIcon.isDisplayed() &&
	               programNameSortingIcon.isDisplayed();
	    }

	   
	    public boolean isHeaderTextCorrect(String expectedText) {
	        return  HeaderElement.getText().trim().equals(expectedText);
	    }
	    
	    public boolean isToolbarTextCorrect(String expectedText) {
	        return toolbar.getText().trim().equals(expectedText);
	    }
	    
	    public String getFooterText() {
	        return FooterElement.getText().trim();
	    }
	    
	    public boolean isFooterTextCorrect(String expectedText) {
	        return FooterElement.getText().trim().equals(expectedText);
	    }
}
	    
	    
	    
	    
	    