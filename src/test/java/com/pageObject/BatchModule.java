package com.pageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Arrays;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.hooks.TestContext;
import com.utilities.Log;

public class BatchModule {

	private WebDriver driver;
	 private WebDriverWait wait;
	 private TestContext context;
	 private JavascriptExecutor js;
 //Locators for login
	 	@FindBy(xpath = "//input[@id='username']")private WebElement usernameField;

	    @FindBy(xpath = "//input[@id='password']")private WebElement passwordField;

	    @FindBy(xpath = "//button[@id='login']")private WebElement loginButton;
	    
	    
        @FindBy (xpath="//mat-toolbar[@color='primary']//span[contains(text(), 'LMS - Learning Management System')]")
        private WebElement toolbar;

        @FindBy (xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button")
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
	    @FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]")private WebElement checkbox1;
	 
	 @FindBy (xpath="/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkbox2;
	    
	    
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
	    
	    @FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	    private WebElement firstDeleteButton; 
	    
	    @FindBy(xpath = "//tbody/tr[1]//div[@class='p-checkbox-box p-component']")
	    private WebElement firstCheckbox;
	    
	    @FindBy(xpath = "//p-confirmdialog//button[text()='Yes']") 
	    private WebElement yesButton;
	    @FindBy(xpath = "//button//span[text()='No']") 
	    private WebElement noButton;

	    @FindBy(xpath="//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")private WebElement Deletepopup;
	    @FindBy(xpath = "//div[@role='alert']")
	    private WebElement alertMsg;
	    
 //Add new Batch pop locators
	    
	    @FindBy (xpath="//button[text()='Add New Batch']")private WebElement Addnewbatchbutton;
	    @FindBy (xpath="//div[@class='p-dialog-header ng-tns-c168-6 ng-star-inserted']")private WebElement PopupAddBatch;
	  @FindBy (xpath="//*[@id='programName']/div/input")private WebElement programnameinput;
	  
	    @FindBy(css = "span.p-dropdown-trigger-icon.pi.pi-chevron-down") private WebElement Programdropdowntrigger;
	    @FindBy(css = "ul.p-dropdown-items")private WebElement dropdownOptions;
	    @FindBy(tagName = "li") private List<WebElement> dropdownItems;
	    @FindBy(xpath="//input[@id='batchProg']")private WebElement batchprefixfield;
	    @FindBy (xpath="//*[@id='batchName']")private WebElement batchsuffixfield;
	    @FindBy (xpath="//small[text()='Batch Name is required.']")private WebElement batcherror;
	    @FindBy(xpath="//small[text()='Batch Description is required.']")private WebElement DescriptionError;
	 
	    @FindBy(xpath="//small[text()='Number of classes is required.']")private WebElement Noofclasseserror;
	    	
	    @FindBy(xpath="//small[text()='Status is required.']")private WebElement Statuserror;
//add batch label 
	    @FindBy(css = "label[for='programName']")private WebElement programNameLabel;
	    @FindBy(css = "label[for='batchName']")private WebElement batchNameLabel;

	    @FindBy(css= " label[for='batchDescription']")private WebElement batchdescription;
	   
	    @FindBy(xpath ="//div[@class='p-radiobutton-box']")private WebElement statusLabel;

	    @FindBy(css = "label[for='batchNoOfClasses']")private WebElement numberOfClassesLabel;
	    @FindBy(css = "input#batchNoOfClasses")private WebElement numberOfClassesInput;
	    @FindBy(css = "input#batchDescription")private WebElement batchDecriptioninput;
	    @FindBy(xpath="//input[@id='batchDescription']")private WebElement batchDescription;
	    @FindBy(xpath="//button[@label='Cancel']")private WebElement cancelButton;
	    
	    @FindBy(xpath ="//button[@label='Save']")private WebElement saveButton;
	    @FindBy (xpath="//button[@type='button' and contains(@class, 'p-dialog-header-close')]")private WebElement closeButton;
	  @FindBy(xpath="(//span[@class='p-radiobutton-icon'])[1]")private WebElement Activeradiobutton;
	  @FindBy(xpath="(//span[@class='p-radiobutton-icon'])[2]")private WebElement InActiveradiobutton;
	  //button[@label='Save']"
	   
	    @FindBy(xpath = "//div[contains(@class, 'ng-tns-c168-6 p-dialog-content')]")
	    private WebElement batchDetailsPopup;
	    @FindBy(xpath = "//div[text()='Successful']")
	    private WebElement successMessage;
	    @FindBy(xpath="/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]")private WebElement alertBox;
		private Actions actions;
		
		 @FindBy (xpath="//li[contains(@class, 'p-dropdown-item')]")   private List<WebElement> programOptions;
	  
	public BatchModule(WebDriver driver , TestContext context) {
		this.driver = context.getDriver();
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	this.context=context;
	    PageFactory.initElements(driver, this);
	    this.actions = context.getActions();
	    this.js = (JavascriptExecutor) driver;
	  
	}
	
	
	public void login(String username, String password) {
		 wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
	        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	    

	    
	    public void validateHeaders() {
	        List<String> actualHeaders = getActualHeaders();

	        //  actual and expected headers for debugging
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


		 //  all edit buttons are displayed method
	    public boolean areEditButtonsDisplayed() {
	        for (WebElement editButton : editButtons) {
	            wait.until(ExpectedConditions.visibilityOf(editButton)); // Wait for edit button to be visible
	            if (!editButton.isDisplayed()) {
	                return false; // Return false if any edit button is not displayed
	            }
	        }
	        return true; // All edit buttons are displayed return true
	    }

	    // all delete buttons are displayed method
	    public boolean areDeleteButtonsDisplayed() {
	        for (WebElement deleteButton : deleteButtons) {
	            wait.until(ExpectedConditions.visibilityOf(deleteButton)); // Wait for delete button to be visible
	            if (!deleteButton.isDisplayed()) {
	                return false; // not displeayed return false
	            }
	        }
	        return true; // All delete buttons are displayed return true
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
	    
	    //Add new batch pop validation
	    
	    public void clickAddNewBatchButton() {
	        Addnewbatchbutton.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }
	    

	    
	    
	    public boolean isFieldDisplayed(String fieldName) {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        switch (fieldName) {
	        
	            case "Batch Name":
	                return batchNameLabel.isDisplayed();
	            case "Number of classes":
	                return numberOfClassesLabel.isDisplayed() && numberOfClassesInput.isDisplayed();
	            case "Description as text box":
	                return batchdescription.isDisplayed();
	            case "Program Name as drop down":
	                return programNameLabel.isDisplayed() && Programdropdowntrigger.isDisplayed();
	            case "Status as radio button":
	                
	              
	                wait.until(ExpectedConditions.visibilityOf(statusLabel));
	                
	                return statusLabel.isDisplayed()&& statusLabel.isEnabled();
	            case "close":
	                return closeButton.isDisplayed() && closeButton.isEnabled();
	            case "save button": // Ensure consistent naming
	                //wait.until(ExpectedConditions.visibilityOf(saveButton)); 
	               // return saveButton.isDisplayed() && saveButton.isEnabled();
	                
	            	try {
	                    Log.debug("Trying to find the Save Button");
	                    
	                    wait.until(ExpectedConditions.visibilityOf(saveButton)); // Wait for visibility
	                    Log.debug("Save Button - Displayed: " + saveButton.isDisplayed());
	                    return saveButton.isDisplayed() && saveButton.isEnabled(); // Check if displayed and enabled
	                } catch (TimeoutException e) {
	                    Log.error("Save button not found or not visible: " + e.getMessage());
	                    return false;
	                }
	                  
	            case "cancelbutton":
	            	  wait.until(ExpectedConditions.visibilityOf(closeButton));
	                return cancelButton.isDisplayed() && cancelButton.isEnabled();
	            default:
	                return false;
}
	    
	        
	    
	    }
	  
	    private void ensureDropdownIsClosed() {
	        // Check if the dropdown is open and close it if necessary
	        String ariaExpanded = Programdropdowntrigger.getAttribute("aria-expanded");
	        if ("true".equals(ariaExpanded)) { // Ensure we're comparing to "true" safely
	            Programdropdowntrigger.click(); // Click to close the dropdown
	        }
	    }

	   //selected program is present in the prefix
	    public boolean isSelectedProgramReflected() {
	        wait.until(ExpectedConditions.visibilityOf(batchprefixfield));
	        return batchprefixfield.getAttribute("value").equalsIgnoreCase(dropdownItems.get(0).getText());
	    }
	
	    public String getBatchPrefixValue() {
	        // Wait for the batch prefix field to be visible
	        wait.until(ExpectedConditions.visibilityOf(batchprefixfield)).click();
	        // Return the value of the batch prefix field
	        return batchprefixfield.getAttribute("value");
	    }
	    

	    
	 
	    public String getErrorMessage() {
	        try {
	            // Wait until the error message element is visible
	            wait.until(ExpectedConditions.visibilityOf(batcherror));
	            return batcherror.getText(); // Return the actual error message text
	        } catch (Exception e) {
	            return ""; // Return an empty string if the error message is not found
	        }
	    }
//Edit validation
	    public void clickEditButton() {
	      
	      

	        //  list of edit buttons is not empty
	        if (!editButtons.isEmpty()) {
	           
	            waitUntilEditButtonIsClickable(editButtons.get(0));
	            
	           
	            editButtons.get(0).click();
	        } else {
	            throw new RuntimeException("No edit buttons found.");
	        }
	    }

	    // Wait 
	    private void waitUntilEditButtonIsClickable(WebElement button) {
	        wait.until(ExpectedConditions.elementToBeClickable(button));
	    }

	    //  program name field is disabled method
	    public boolean isProgramNameFieldDisabled() {
	        return !programnameinput.isEnabled();
	    }

	    //  batch name field is disabled method
	    public boolean isBatchNameFieldDisabled() {
	        return !batchprefixfield.isEnabled();
	    }
	    
	    public void clickSaveButton() {
	        saveButton.click();
	    }
	    
	    public void clickCancelButton() {
	        saveButton.click();
	    }
	    
	    public boolean isBatchErrorDisplayed() {
	        return batcherror.isDisplayed();
	    }

	    public boolean isDescriptionErrorDisplayed() {
	        return DescriptionError.isDisplayed();
	    }

	    public boolean isNumberOfClassesErrorDisplayed() {
	        return Noofclasseserror.isDisplayed();
	    }

	    public boolean isStatusErrorDisplayed() {
	        return Statuserror.isDisplayed();
	    }
	    public void enterValidDataInMandatoryFields() {
	        enterDescription("Valid Batch Description"); // Replace with actual valid data
	        enterNumberOfClasses("5"); // Replace with actual valid data
	    }

	    
//single delete 
	   
	    public void clickOnDeleteIcon() {
	      
	       // wait.until(ExpectedConditions.elementToBeClickable(firstDeleteButton));
	     //  context.getActions().doubleClick(firstDeleteButton).perform(); // Perform double click or use single click as per your requirement
	    	 if (context == null) {
	    	        throw new IllegalStateException("TestContext is not initialized");
	    	    }
	    	    Actions actions = context.getActions(); // Now it should work
	    	    actions.doubleClick(firstDeleteButton).perform();
	    }
	    public void confirmDeletion() {
	    	if (yesButton.isDisplayed() && yesButton.isEnabled()) {
	            System.out.println("Yes button is displayed and enabled.");
	        } else {
	            System.out.println("Yes button is not interactable.");
	            return; // Exit the method if the button isn't clickable
	        }
// creating object for action class
	      
	    	  Actions actions = context.getActions();

	        //movin gto Yes button and clicking
	        actions.moveToElement(yesButton).click().perform();

	        // Wait for the success message to be visible
	        wait.until(ExpectedConditions.visibilityOf(alertMsg));

	        // Capture the success message text
	        String successText = alertMsg.getText(); 
	        System.out.println(successText);
	    }
	   

	    public void cancelDeletion() {
	    
	        noButton.click();
	    }

	    public boolean isSuccessMessageDisplayed() {
	        // Check if the success message is displayed
	        return alertMsg.isDisplayed();
	    }

	    public String getSuccessMessageText() {
	        // alert message 
	        return alertMsg.getText();
	    }
	
	    public boolean isAlertBoxDisplayed() {
	        return alertBox.isDisplayed(); // Will return true if the alert box is displayed
	    }
	    //single row delete 
	    
	    
	    public void clickDeleteIconForSpecificBatch() {
	        
	        for (WebElement checkbox : checkboxes) {
	            if (firstCheckbox.isEnabled() && firstCheckbox.isDisplayed()) {
	            	  Actions actions = context.getActions();
	                actions.moveToElement(checkbox).click().perform(); //  the checkbox
	                break; // checkbox clik then break
	            }
	        }
	        actions.moveToElement(firstDeleteButton).click().perform(); // Click the delete icon
	    }

	    // Method to verify the row has been deleted
	    public boolean isRowDeleted() {
	        //  a list of all rows in table 
	        for (WebElement row : rows) {
	            
	            if (row.getText().contains("BatchIdentifier")) { 
	                return false; // Row still exists
	            }
	        }
	        return true; // Row has been deleted
	    }
	    
//multiple delete
	    public void multipleDeleteAction() {
	       
	        actions.moveToElement(checkbox1).click().perform();

	       
	        for (WebElement checkbox : checkboxes) {
	            if (checkbox.isEnabled() && checkbox.isDisplayed()) {
	               
	                actions.moveToElement(checkbox).click().perform();
	            }
	        }

	        // Move to the multiple delete button and click
	        if (Multipledelete.isEnabled() && Multipledelete.isDisplayed()) {
	            actions.moveToElement(Multipledelete).click().perform();
	            System.out.println("Multiple delete action performed.");
	        } else {
	            System.out.println("Multiple delete button is not clickable.");
	        }
	    
	}
	
	    // Method to verify that all rows have been deleted
	    public boolean areAllRowsDeleted() {
	        
	        for (WebElement row : rows) {
	            
	            if (row.getText().contains("batchIdentifier")) {
	                return false; 
	            }
	        }
	        return true; 
	    }
	    
	    //pagination
	    /*public void clickNextPage() {
	        if (isNextButtonEnabled()) {
	            doubleClick(nextButton);
	        }
	    }*/
	    public void clickNextPage() {
	        if (isNextButtonEnabled()) {
	            doubleClick(nextButton);
	          //  waitForResultsToLoad(); 
	        }// Ensure results load after clicking
	        }

	    // Method to click 'Previous' button
	    public void clickPreviousPage() {
	        if (isPrevButtonEnabled()) {
	        	  doubleClick (prevButton);
	        }
	    }

	    // Method to click 'First' button
	    public void clickFirstPage() {
	    	
	          doubleClick(firstButton);
	    }

	    // Method to click 'Last' button
	    public void clickLastPage() {
	        doubleClick(lastButton);
	    }

	    // Method to click a specific page number
	    public void clickPageNumber(int pageIndex) {
	    	 doubleClick(pageButtons.get(pageIndex - 1));
	    }

	    // Check if 'Next' button is enabled
	    public boolean isNextButtonEnabled() {
	        return !nextButton.getAttribute("class").contains("p-disabled");
	    }

	    // Check if 'Previous' button is enabled
	    public boolean isPrevButtonEnabled() {
	        return !prevButton.getAttribute("class").contains("p-disabled");
	    }

	    // Method to get current pagination text
	    public String getCurrentEntriesText() {
	        return currentEntriesText.getText();
	    }
	
	    public boolean hasNextPageResults() {
	        // Return true if there are results; false otherwise
	        return !rows.isEmpty(); 
	    }
	    private void doubleClick(WebElement element) {
	        Actions actions = new Actions(driver); // Create an Actions instance
	        actions.moveToElement(element).doubleClick().perform(); // Move to the element and double-click
	    }
	    private void waitForResultsToLoad() {
	    	wait.until(ExpectedConditions.visibilityOfAllElements(rows));
	    }
	    
	    

	
//Add new batch field validation
	  

	    public void enterDescription(String description) {
	    	batchDescription.clear();
	    	batchDescription.sendKeys(description);
	    }

	    public void enterNumberOfClasses(String numClasses) {
	    	numberOfClassesInput.clear();
	    	numberOfClassesInput.sendKeys(numClasses);
	    }

	    public void clickButton(String button) {
	        if (button.equalsIgnoreCase("save")) {
	            saveButton.click();
	        } else if (button.equalsIgnoreCase("cancel")) {
	            cancelButton.click();
	        }
	    }

	    //searchbox
	 //   String batchname ="java";
	    public void searchInBatchPage(String batchname) {
	    	
	        actions.doubleClick(search).perform(); // Double-click to activate search
	        search.clear();                        // Clear any existing text in the search box
	        search.sendKeys(batchname);            // Type in the batch name
	        search.sendKeys(Keys.RETURN);          // Hit Enter to initiate search
	    }

	    // Method to get all displayed rows in the table
	    public List<WebElement> getDisplayedRows() {
	        return rows; // Returns the currently displayed rows
	    }

	    // Method to check if a batch with the given name is displayed
	    public boolean isBatchDisplayed(String batchname) {
	        return rows.stream().anyMatch(row -> row.getText().equalsIgnoreCase(batchname));
	    }
	
	    
	    
	     public void enterBatchNameSuffix(String input) {
        wait.until(ExpectedConditions.visibilityOf(batchsuffixfield));
        batchsuffixfield.clear();
        batchsuffixfield.sendKeys(input);
    }
	     
	     public void selectProgramFromDropdown() {
		        // Click to open the dropdown
		        wait.until(ExpectedConditions.elementToBeClickable(Programdropdowntrigger)).click();

		        // Wait for dropdown items to be visible
		        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownItems));

		        // Ensure there are dropdown items to select
		        if (!dropdownItems.isEmpty()) {
		            dropdownItems.get(0).click(); // Click the first program in the list
		        } else {
		            System.out.println("Dropdown is empty");
		            throw new RuntimeException("No items in the dropdown");
		        }
		        ensureDropdownIsClosed();
		    }
	   
	     //
	     public void selectProgram(String programName) {
	       
	         Programdropdowntrigger.click();

	        
	         wait.until(ExpectedConditions.visibilityOfAllElements(programOptions));

	         boolean programFound = false; 

	      
	         for (WebElement option : programOptions) {
	         
	             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
	             wait.until(ExpectedConditions.elementToBeClickable(option)); 

	             if (option.getText().equals(programName)) {
	                 option.click(); 
	                 programFound = true; 
	                 break; // Exit the loop once the option is selected
	             }
	         }

	   
	         if (!programFound) {
	             throw new NoSuchElementException("Program option not found: " + programName);
	         }
	     }
	 
	     
	     
	     
	     public void enterValidDataAllMandatoryFields() {
	    	    
	    	    selectProgram("Java"); 
	    	    
	    	   
	    	    batchsuffixfield.sendKeys("12");

	    	    
	    	    numberOfClassesInput.sendKeys("5"); 

	    	  
	    	    Activeradiobutton.click();

	    	  
	    	    batchDescription.sendKeys("class for SDET.");
	    	}
	  
	     public boolean isPopupDisplayed() {
	    	   
	    	    return PopupAddBatch.isDisplayed();  
	    	}
	     public boolean isDeletePopUpDisplayed() {
	     return   Deletepopup.isDisplayed();  
	     }
}