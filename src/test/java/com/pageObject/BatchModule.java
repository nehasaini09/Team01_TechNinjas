package com.pageObject;



import org.openqa.selenium.StaleElementReferenceException;


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

	    
	    @FindBy(xpath = "//div[@role='alert']")
	    private WebElement alertMsg;
	    
 //Add new Batch pop locators
	    
	    @FindBy (xpath="//button[text()='Add New Batch']")private WebElement Addnewbatchbutton;
	  @FindBy (xpath="//*[@id='programName']/div/input")private WebElement programnameinput;
	  
	    @FindBy(css = "span.p-dropdown-trigger-icon.pi.pi-chevron-down") private WebElement Programdropdowntrigger;
	    @FindBy(css = "ul.p-dropdown-items")private WebElement dropdownOptions;
	    @FindBy(tagName = "li") private List<WebElement> dropdownItems;
	    @FindBy(xpath="//input[@id='batchProg']")private WebElement batchprefixfield;
	    @FindBy (xpath="//*[@id='batchName']")private WebElement batchsuffixfield;
	    @FindBy (xpath="//*[@id='text-danger']")private WebElement batcherror;
	    @FindBy(xpath="//small[@class='p-invalid ng-star-inserted']")private WebElement DescriptionError;
	   
	   
//add batch label 
	    @FindBy(css = "label[for='programName']")private WebElement programNameLabel;
	    @FindBy(css = "label[for='batchName']")private WebElement batchNameLabel;

	    @FindBy(css= " label[for='batchDescription']")private WebElement batchdescription;
	   
	    @FindBy(xpath ="//div[@class='p-radiobutton-box']")private WebElement statusLabel;

	    @FindBy(css = "label[for='batchNoOfClasses']")private WebElement numberOfClassesLabel;
	    @FindBy(css = "input#batchNoOfClasses")private WebElement numberOfClassesInput;

	    
	    @FindBy(xpath="")private WebElement cancelButton;
	    
	    @FindBy(xpath = "//button[normalize-space(text())='Save']")private WebElement saveButton;
	    @FindBy (xpath="//button[@type='button' and contains(@class, 'p-dialog-header-close')]")private WebElement closeButton;
	  
	  //button[@label='Save']"
	   

	    @FindBy(xpath = "//div[text()='Successful']")
	    private WebElement successMessage;
	    @FindBy(xpath="/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]")private WebElement alertBox;
		private Actions actions;
	  
	public BatchModule(WebDriver driver , TestContext context) {
		this.driver=driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	this.context=context;
	    PageFactory.initElements(driver, this);
	    this.actions = context.getActions();
	    
	  
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
	                return false; // not displeayed return false
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
	    
	    //Add new batch pop validation
	    
	    public void clickAddNewBatchButton() {
	        Addnewbatchbutton.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }
	    
//	    public boolean isFieldDisplayed(String fieldName) {
//	        switch (fieldName) {
//	            case "Batch Name":
//	                return batchNameLabel.isDisplayed();
//	            case "Number of classes":
//	                return numberOfClassesLabel.isDisplayed() && numberOfClassesInput.isDisplayed();
//	            case "Description as text box":
//	                return batchdescription.isDisplayed();
//	            case "Program Name as drop down":
//	                return programNameLabel.isDisplayed() && Programdropdowntrigger.isDisplayed();
//	            case "Status as radio button":
//	                return statusLabel.isDisplayed();
//	            default:
//	                return false;
//	        }
//	    }
	    
	    
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
	        wait.until(ExpectedConditions.visibilityOf(batchprefixfield));
	        // Return the value of the batch prefix field
	        return batchprefixfield.getAttribute("value");
	    }
	    
	 // Check if the selected program is reflected in the batch prefix field
	 // Selected program is reflected in the prefix
	  

//	    public void selectProgramFromDropdown(){
//	        for (int attempts = 0; attempts < 3; attempts++) { // Retry up to 3 times
//	            try {
//	                wait.until(ExpectedConditions.elementToBeClickable(Programdropdowntrigger)).click();
//	                List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(dropdownItems));
//	                if (!items.isEmpty()) {
//	                    String selectedProgram = items.get(0).getText();
//	                    items.get(0).click(); // Click the first item
//	                    System.out.println("Selected program: " + selectedProgram);
//	                    ensureDropdownIsClosed();
//	                    return; // Exit after successful selection
//	                } else {
//	                    System.out.println("Dropdown is empty");
//	                    throw new RuntimeException("No items in the dropdown");
//	                }
//	            } catch (TimeoutException e) {
//	                System.out.println("Timeout while waiting for dropdown items. Retrying...");
//	            }
//	        }
//	        throw new RuntimeException("Failed to select program after multiple attempts.");
//	    }
//
//	    public boolean isSelectedProgramReflected() {
//	        while (true) {
//	            try {
//	                // Wait for the batch prefix field to be visible
//	                wait.until(ExpectedConditions.visibilityOf(batchprefixfield));
//
//	                // Get the value of the batch prefix field
//	                String prefixValue = batchprefixfield.getAttribute("value");
//	                System.out.println("Actual program name in prefix box: " + prefixValue);
//
//	                // Refetch the dropdown items before comparison
//	                List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(dropdownItems));
//	                if (!items.isEmpty()) {
//	                    String selectedProgramName = items.get(0).getText();
//	                    System.out.println("Expected program name: " + selectedProgramName);
//	                    return prefixValue.equalsIgnoreCase(selectedProgramName);
//	                } else {
//	                    System.out.println("Dropdown items are empty when checking the prefix.");
//	                    return false;
//	                }
//	            } catch (StaleElementReferenceException e) {
//	                System.out.println("StaleElementReferenceException caught. Retrying...");
//	                // Optionally, add a delay before retrying
//	                try {
//	                    Thread.sleep(100); // Wait a short time before retrying
//	                } catch (InterruptedException ie) {
//	                    Thread.currentThread().interrupt(); // Restore the interrupted status
//	                }
//	            } catch (Exception e) {
//	                System.out.println("An exception occurred: " + e.getMessage());
//	                return false; // Handle other exceptions appropriately
//	            }
//	        }
//	    }
//
//
//	    public String getBatchPrefixValue() {
//	        // Wait for the batch prefix field to be visible
//	        wait.until(ExpectedConditions.visibilityOf(batchprefixfield));
//	        return batchprefixfield.getAttribute("value");
//	    }
//
//	
//
//	   
//
//
//	    private void ensureDropdownIsClosed() {
//	        // Check if the dropdown is open and close it if necessary
//	        String ariaExpanded = Programdropdowntrigger.getAttribute("aria-expanded");
//	        if ("true".equals(ariaExpanded)) { // Ensure we're comparing to "true" safely
//	            Programdropdowntrigger.click(); // Click to close the dropdown
//        }
//
//}
	    
	    
	    public void enterBatchNameSuffix(String input) {
	        wait.until(ExpectedConditions.visibilityOf(batchsuffixfield));
	        batchsuffixfield.clear();
	        batchsuffixfield.sendKeys(input);
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
	        // Wait for any overlay to disappear before clicking
	      

	        // Check if the list of edit buttons is not empty
	        if (!editButtons.isEmpty()) {
	           
	            waitUntilEditButtonIsClickable(editButtons.get(0));
	            
	           
	            editButtons.get(0).click();
	        } else {
	            throw new RuntimeException("No edit buttons found.");
	        }
	    }

	    // Wait until a specific button is clickable
	    private void waitUntilEditButtonIsClickable(WebElement button) {
	        wait.until(ExpectedConditions.elementToBeClickable(button));
	    }

	    // Check if the program name field is disabled
	    public boolean isProgramNameFieldDisabled() {
	        return !programnameinput.isEnabled();
	    }

	    // Check if the batch name field is disabled
	    public boolean isBatchNameFieldDisabled() {
	        return !batchprefixfield.isEnabled();
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

	        // Create an Actions object
	    	  Actions actions = context.getActions();

	        // Move to the Yes button and click it
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

    
}