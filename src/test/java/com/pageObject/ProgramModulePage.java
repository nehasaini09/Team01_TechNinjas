package com.pageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProgramModulePage {
	private WebDriver driver;
	List<String> menuItems;
	 List<WebElement> manageProgramMenuItems=new ArrayList<>();
	 WebElement popup;
	 WebElement closeButton;
	 WebElement searchBar;
	 boolean isDisplayed;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public  ProgramModulePage(WebDriver  driver) {
		this.driver=driver;
		}
	
	//-----------------------ELEMENTS--------------------------------------//

	By userName=By.id("username");
	By passWord=By.id("password");
	By Login=By.id("login");
	 By programBtn=By.id("program");
	 By addNewPgm=By.xpath("//*[@id='mat-menu-panel-0']/div/button");
	 By searchbtn=By.xpath("//*[@id='filterGlobal']");
	           //----------------Menubar-------------------------------//
	 By appHeader=By.xpath("//span[text()=' LMS - Learning Management System ']");//same for class module
	 By menu=By.xpath("//div[@class='ng-star-inserted']");
	             //---------------------manage program------------------------------
	 By manageProgram=By.xpath("//app-program/div/mat-card/mat-card-title/div[1]");
	 By mangeprogramTable=By.xpath(" //*[@class='p-datatable-thead']/tr");
	 By multipleDelete=By.xpath("//app-program/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]");
	 By pCheckBox=By.xpath("//app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]");
	 By tableCheckbox=By.cssSelector("p-tablecheckbox");  
	 By tableSorticon= By.cssSelector("p-sorticon");
	 By tablebody=By.cssSelector(".p-datatable-tbody");
	 By editProgram=By.cssSelector("#editProgram");
	 By deleteProgram=By.cssSelector("#deleteProgram");
	 By paginationfooter=By.xpath("//p-table/div/div[2]/div");
	 By paginationInfoUI=By.xpath("//p-table/div/p-paginator/div/span[1]");
	 By doubleLeftIcon=By.xpath("//p-table/div/p-paginator/div/button[1]/span");
	 By doubleRightIcon=By.xpath("//p-table/div/p-paginator/div/button[4]/span");
	 By leftIcon=By.xpath("//p-table/div/p-paginator/div/button[2]");
	 By rightIcon=By.xpath("//p-table/div/p-paginator/div/button[3]");
	 //-----------------------------------Manage AddNewProgram------------------------------
	 By popUp=By.xpath("//app-program/p-dialog/div/div");
	 By cancelButton=By.xpath("//app-program/p-dialog/div/div/div[3]/button[1]/span[2]");
	 By TitlePopUp=By.xpath("//span[text()='Program Details']");
	 By programName=By.xpath("//app-program/p-dialog/div/div/div[2]/div[1]/label");
     By astreik=By.xpath("//app-root/app-program/p-dialog/div/div/div[2]/div[1]/label/span");
     By saveProgram=By.id("saveProgram");
	 By requiredText=By.xpath("//app-program/p-dialog/div/div/div[2]/div[1]/small");
	 By pname=By.xpath("//*[@id='programName']");
	 By pDescription=By.xpath("//*[@id='programDescription']");
	 By active=By.cssSelector("#category div div.p-radiobutton-box");
	 By inActive=By.cssSelector("#category");
	 By save=By.xpath("//*[@id='saveProgram']/span[2]");
	 By successMsg=By.xpath("//app-program/p-toast/div/p-toastitem/div/div/div/div[2]");
	 
	 By enteredPName=By.xpath("//app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[2]") ;
	 
	By Xbutton=By.xpath("//app-program/p-dialog/div/div/div[1]/div/button/span");
	 
	 
	 
	 
	 //Actions
	
	public void login() {
		driver.findElement(userName).sendKeys("Sdet@gmail.com");
		
		driver.findElement(passWord).sendKeys("LmsHackathon@2024");
		driver.findElement(Login).click();
	}
	 
	 public void ProgramClick(){
		 wait.until(ExpectedConditions.visibilityOfElementLocated(programBtn));
			driver.findElement(programBtn).click();
			 }
	 public String programPageTitle() {
	 String TitleAfterClickProgram=driver.getCurrentUrl();
		//System.out.println("Title of program page :"+TitleAfterClickProgram);
		return TitleAfterClickProgram;
	 }
	 
	 
	 //--------------------------------MENU BAR---------------------------------------------------------
	 
	 public String verifyHeader() {
		String headerText=driver.findElement(appHeader).getText();
		//System.out.println("Header of program page :"+headerText);
		return headerText;
	 }
	 
	 
	 public void testListContainsElements() {
		 String menuBar=driver.findElement(menu).getText();
		 
			 menuItems = Arrays.asList(menuBar.split("\\s+"));

	        Assert.assertTrue(menuItems.contains("Batch"));
	        Assert.assertTrue(menuItems.contains("Program"));
	        Assert.assertTrue(menuItems.contains("Class"));
	        
	    }
	 
	 public void testLogoutIsPresent() {
		 
		 Assert.assertTrue(menuItems.contains("Logout"));
	 }
	 public void testAddNewProgramsIsPresent() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-menu-panel-0']/div/button")));
		String AddNewProgramUI= driver.findElement(addNewPgm).getText() ;
		Assert.assertEquals("Add New Program", AddNewProgramUI);
	 }
	 
	 //MANAGE PROGRAM
	 public void testManageHeader() {
		 String manageprogramUI=driver.findElement(manageProgram).getText();
		 Assert.assertEquals("Manage Program", manageprogramUI);
	 }
	 
	 public void testManageProgramMenu() {
		 WebElement manageProgramMenu = driver.findElement(mangeprogramTable); 
      
		 manageProgramMenuItems = manageProgramMenu.findElements(By.tagName("th"));
         List<String>itemTextList=new ArrayList<>();
         for (WebElement item : manageProgramMenuItems) {
             String itemText = item.getText(); 
             itemTextList.add(itemText);
                      }
         
         Assert.assertTrue(itemTextList.contains("Program Name"));
	        Assert.assertTrue(itemTextList.contains("Program Description"));
	        Assert.assertTrue(itemTextList.contains("Program Status"));
		 
	 }
	 public void testMultipleDeleteIsDisabled() {
	 WebElement multipleDeleteButton =driver.findElement(multipleDelete);
     boolean isEnabled = multipleDeleteButton.isEnabled();
     System.out.println("Is Delete button enabled? " + isEnabled);

     boolean isDisabled = !isEnabled;
     System.out.println("Is Delete button disabled? " + isDisabled);
     Assert.assertTrue("The Delete button should be disabled",isDisabled);
		//Assertion is failed
	 }
	 
	 public void testSearchBar() {
		 WebElement searchBar=driver.findElement(searchbtn);
         Assert.assertTrue("Search bar should be visible", searchBar.isDisplayed());
         String placeholderText = searchBar.getAttribute("placeholder");
          Assert.assertEquals( "Search...", placeholderText);
		 	 }
	 public void testPDefaultCheckbox() {
		 WebElement pcheckbox =driver.findElement(pCheckBox);
		 boolean isChecked = pcheckbox.isSelected();
	     System.out.println("Is CHECKBOX button enabled? " + isChecked);

	     boolean isDisabled = !isChecked;
	     
	     Assert.assertTrue("The CHECKBOX button should be disabled",isDisabled); 
	 }
	 
	 public void checkboxesAreUnchecked() {
	 
		 List<WebElement> checkboxes = driver.findElements(tableCheckbox);

			for (WebElement checkbox : checkboxes) {
             Assert.assertFalse("Checkbox is checked when it should be unchecked", checkbox.isSelected());
         }
         System.out.println("All checkboxes are unchecked as expected.");
}
	    public void testSortArrowsVisibility() {
	    	for (WebElement item : manageProgramMenuItems) {
	             String itemText = item.getText(); 
	             boolean hasSortArrow =item.findElements(tableSorticon).size() > 0;
	             System.out.println(itemText+","+hasSortArrow);
	             // Assert that sort arrows are present except for "Edit" and "Delete"
	                if ("Edit / Delete".equals(itemText)|| itemText.isEmpty()) {
	                    Assert.assertFalse("Sort arrow should not be present for column: " + itemText, hasSortArrow);
	                } else {
	                    Assert.assertTrue("Sort arrow should be present for column: " + itemText, hasSortArrow);
	                }  
	             
	         }
	    }
	    
	    public void testEditDeleteButtonsPresence() {
	    	List<WebElement> rows = driver.findElements(tablebody);
			 for (WebElement row : rows) {
				 
			 WebElement editButton = row.findElement(editProgram); 
			 WebElement deleteButton = row.findElement(deleteProgram);
			    Assert.assertTrue("Edit button should be visible", editButton.isDisplayed());
               Assert.assertTrue("Delete button should be visible", deleteButton.isDisplayed());

			 System.out.println("Edit button should be visible:"+editButton.isDisplayed());
               System.out.println("Delete button should be visible:"+deleteButton.isDisplayed());
               
			 }
	    	
	    }
	    public void testPaginationTextIcons() {
	    	 
			WebElement paginationInfo= driver.findElement(paginationInfoUI); 
			String paginationText=paginationInfo.getText();
        	String expectedPattern = "Showing \\d+ to \\d+ of \\d+ entries";
			Assert.assertTrue("Pagination text format is correct", paginationText.matches(expectedPattern));
          
            WebElement doubleLeftButton = driver.findElement(doubleLeftIcon); 
            WebElement doubleRightButton  = driver.findElement(doubleRightIcon); // Adjust selector
            WebElement previousButton = driver.findElement(leftIcon); // Adjust selector
            WebElement nextButton  = driver.findElement(rightIcon); // Adjust selector
            // Validate that pagination icons are displayed
            Assert.assertTrue("Previous button should be visible", previousButton.isDisplayed());
            Assert.assertTrue("Next button should be visible", nextButton.isDisplayed());
            Assert.assertTrue("DoublePrevious button should be visible", doubleLeftButton.isDisplayed());
            Assert.assertTrue("DoubleNext button should be visible", doubleRightButton.isDisplayed());
	    }
	    public void testpaginationfooter() {
	    	WebElement paginationInfoFooter= driver.findElement(paginationfooter);
	    	String paginationTextfooter = paginationInfoFooter.getText();
	    	 System.out.println("Pagination Text: " + paginationTextfooter);
	           
	    	 String expectedPatternfooter = "In total there are \\d+ programs.";
	    	 
				Assert.assertTrue("Pagination text format is correct", paginationTextfooter.matches(expectedPatternfooter)); 
	            
	    }
	    //------------------------------------Manage AddNewProgram---------------------------------//
	    public void clickAddNewProgram() {
	    	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(addNewPgm));

			driver.findElement(addNewPgm).click();
	    }
	    public void VerifyaddNewProgram() {
	    	
			// Wait for the pop-up to be displayed
            popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popUp)); // Adjust selector

            // Verify the pop-up contains expected text or elements
            String expectedText = "Program Details"; 
            String actualText = popup.getText();
            System.out.println(actualText);
            Assert.assertTrue("Pop-up does not contain expected text.", actualText.contains(expectedText));

            
             
	    }
	    
	    public void VerifyTitleOfAddNewPopwindow() {
	    	
	          
	          wait.until(ExpectedConditions.visibilityOfElementLocated(TitlePopUp));
	          String programHeader=driver.findElement(TitlePopUp).getText();
	          System.out.println(programHeader);
	         Assert.assertEquals( "Program Details", programHeader);
	    		    	
	    }
	    
	    public void testMandatoryFieldAsterisk() {
	    	
	    	
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(programName)); // Adjust selector
            WebElement asterisk = driver.findElement(astreik); 
                                   
            Assert.assertTrue("Asterisk should be displayed", asterisk.isDisplayed());

            String asteriskColor = asterisk.getCssValue("color");
           Assert.assertEquals("Asterisk color should be red", "rgba(255, 0, 0, 1)", asteriskColor); 
	    	
	    }
	    
	    public void testRequiredFieldMessage() {
	    	driver.findElement(saveProgram).click();
			String  fieldText=driver.findElement(requiredText).getText();
            String expectedMessage = "Program name is required."; // Adjust this to match the expected message
            Assert.assertEquals( expectedMessage,fieldText );
	    }
	     public void cancelbuttonclick() {
	    	 
	    	 closeButton = popup.findElement(cancelButton); // Adjust selector
	           
	            closeButton.click();
	     }
	    public void IsPopUpDisplayed() {
	    	//Assert.assertTrue("Program Details form should be visible", popup.isDisplayed());
	    	 boolean isDisplayed = popup.isDisplayed();
	    	 Assert.assertTrue("Program Details form should be visible", isDisplayed);
	    }
	    
	    public void IspopupNotDisplayed() {
	    	
	    	wait.until(ExpectedConditions.invisibilityOf(popup));
		    //add softassertion here
		    Assert.assertFalse("Program Details form should no longer be visible",  isDisplayed);
	    }
	    public String ProgramNameEntryTest(String Name)
	    {
	    	
	    	WebElement programNameTextBox=driver.findElement(pname);
			 programNameTextBox.sendKeys(Name);
			 String enteredText = programNameTextBox.getAttribute("ng-reflect-model");
	    	return enteredText;
	    	//Assert.assertEquals("The entered program name should match.", "SalesBI", enteredText);
	    	
	    }
	    
	    public String DescriptionEntryTest(String Description) {
	    	WebElement descriptionBox=driver.findElement(pDescription);
	    	descriptionBox.sendKeys(Description);
	    	String enteredText = descriptionBox.getAttribute("ng-reflect-model");
			return enteredText;
			//Assert.assertEquals("The entered description should match.", descriptionText, enteredText);

	    	
	    }
	    
	   
	    

	    // Method to check if a status is selected
	    public boolean isStatusSelected() {
	    	WebElement statusRadioButton = driver.findElement(active);
			 statusRadioButton.click();
		   statusRadioButton.isSelected();
		   //Assert.assertFalse("The radio button for active selected.",statusRadioButton.isSelected());
		  return statusRadioButton.isSelected();
		  //add soft assertion here too
		 
	    }
	    public void clickSaveButton() {
	    	WebElement saveButton = driver.findElement(save);
	    	saveButton.click();
	    }
	    public String  successMsgSave() {
	    	
	    	WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	    	return successMessageElement.getText();
	    }
	    
	    public void clickSearch() {
	    	WebElement searchBar=driver.findElement(searchbtn);
	    	searchBar.click();
	    		    }
	    public String searchForProgram(String programname) {
	    	
	    	searchBar.sendKeys(programname);   	
	    	    	
	    	WebElement programRecord=driver.findElement(enteredPName);
	    	String searchText=programRecord.getText();
	    	System.out.println(searchText);
	    	return searchText;
	    	//assertion will fail text wont match
	    	
	    }
	    public void clickXbutton() {
	    	WebElement XButton = popup.findElement(Xbutton); // Adjust selector
	           
	    	 XButton.click();
	    	 System.out.println(popup.isDisplayed());
	    	 //assertion fail
	    }
	    
	 
}