package com.pageObject;
import java.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;

import java.time.Duration;

public class ProgramModulePage {
	private WebDriver driver;
	private TestContext context;
	private Actions  action;;
	private WebDriverWait wait;
	List<String> menuItems;
	String menuBar;
	 List<WebElement> manageProgramMenuItems=new ArrayList<>();
	// WebElement popup;
	// WebElement closeButton;
	// WebElement searchBar;
	// boolean isDisplayed;
	 WebElement statusRadioButton ;
   //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//public  ProgramModulePage(WebDriver  driver) {
	public ProgramModulePage(WebDriver driver , TestContext context) {	
	this.driver=driver;
		this.context=context;
		this.action = context.getActions();
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		}
	
	//-----------------------ELEMENTS--------------------------------------//

	By userName=By.id("username");
	By passWord=By.id("password");
	By Login=By.id("login");
	 //By programBtn=By.id("program");
	By programBtn=By.xpath("//*[@id='program']");
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
	 
	// ----------------------------------------Deleteprogram---------------------------------------
	 
	//By programclick=By.xpath ( "//button//span[text()='Program']") ;
	By deletebtn=By.xpath( "//tr[1]//*[@id=\"deleteProgram\"]/span[1]");
   // @FindBy(xpath = "//button//span[@class='pi pi-times ng-tns-c204-7']")private WebElement confirmX;
	By confirmyes=By.xpath( "//button//span[text()='Yes']");
	By confirmno=By.xpath(  "//button//span[text()='No']");
	By successdelete=By.xpath( "//div[text()='Successful']");
    
    //delete multiple program locators
	By checkbox1= By.xpath( "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]");
	By checkbox2=By.xpath( "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]"); 
	By dubdelete_icon=By.xpath( "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]") ;
    By dubdelete_yes=By.xpath(  "//button//span[text()='Yes']");
    By success_dbdelete=By.xpath( "//div/p-toastitem/div/div/div/div[2]") ;
    //----------------------SORT-----------------
    
	By progNameSort=By.xpath("//thead//tr//th[2]//i") ;
	By progDescrpSort=By.xpath( "//thead//tr//th[3]//i") ;
	By progStatusSort=By.xpath( "//thead//tr//th[4]//i") ;
	//list
	By programnameList=By.xpath( "//tbody//td[2]") ;
	By descriptionnmList=By.xpath( "//tbody//td[3]");
	By programstatusList=By.xpath( "//tbody//td[4]");
	
	
	public void clickProgramNameSort(){	
		WebElement proGNameSort=driver.findElement(progNameSort);
        action.click(proGNameSort).perform();
        action.click(proGNameSort).perform();
	}
	
	public void clickProgramNameSortDec(){
		WebElement proGNameSort=driver.findElement(progNameSort);
        action.click(proGNameSort).perform();
        action.click(proGNameSort).perform();
        action.click(proGNameSort).perform();
//      action.doubleClick(progNameSort).perform();
	}
	public void clickProgramDescrSort(){	
		WebElement progDescrpsort=driver.findElement(progDescrpSort);
        action.click(progDescrpsort).perform();
        action.click(progDescrpsort).perform();
		
	}
	public void clickProgramDescrSortDes(){		
		WebElement progDescrpsort=driver.findElement(progDescrpSort);
        action.click(progDescrpsort).perform();
        action.click(progDescrpsort).perform();
        action.click(progDescrpsort).perform();
		
	}
	public void clickProgramStatusSort(){	
		WebElement progStatussort=driver.findElement(progStatusSort);
        action.click(progStatussort).perform();
        action.click(progStatussort).perform();
		
	}
	public void clickProgramStatusSortDes(){	
		WebElement progStatussort=driver.findElement(progStatusSort);
        action.click(progStatussort).perform();
        action.click(progStatussort).perform();
        action.click(progStatussort).perform();
		
	}
	
	public List<String> getOriginalList(String type) {
		//List<String> originalList = null;
		List<String> originalList = new ArrayList<>();
		List<WebElement> programnameLisT =driver.findElements(programnameList);
		List<WebElement> programstatusLisT =driver.findElements(programstatusList);
		List<WebElement> descriptionnmLisT =driver.findElements(descriptionnmList);
		if(type.equals("progName")) {
			originalList=printWebElements(programnameLisT);
		
		}else if(type.equals("ProgramDescription")) {
			originalList = printWebElements(descriptionnmLisT);
		
		}else {
			originalList = printWebElements(programstatusLisT);
		}
		return originalList;	
	}
	
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
	
    
	
	public List<String> getSortedList(List<String> originalList){
		System.out.println("Original List Before sorting is"+ originalList);
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted List After sorting is"+ sortedList);
        return sortedList;
	}
	
public List<String> getSortedListDescending(List<String> originalList){
		
		System.out.println("Original List Before sorting is"+ originalList);
        List<String> sortedList = new ArrayList<>(originalList);
//        Collections.sort(sortedList, (s1, s2) -> s2.compareToIgnoreCase(s1));
//        Collections.sort(sortedList, Collections.reverseOrder());
        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println("Sorted List After sorting is"+ sortedList);
        return sortedList;
	}	



	
	

	//when
    public void clickOnDeleteIcon(){
   	 // Actions actions = new Actions(driver);
    	WebElement deleteBtn=driver.findElement(deletebtn);
   	  action.doubleClick(deleteBtn).perform();	    	 
    }
   //then
    public void deleteSingleProgram() {
    	WebElement	confirmYes=driver.findElement(confirmyes);
    			confirmYes.click();
   	 String text1;
   	WebElement	successDelete=driver.findElement(successdelete);
   	 text1 = successDelete.getText();
   	 System.out.println(text1);
   }
    
    public void DropDeleteSingleProgram() {
    	WebElement	confirmNo=driver.findElement(confirmno);
    	confirmNo.click();	   
   	 
   		     }
    
    public void SelectCheckBoxes() {
    	// Actions actions = new Actions(driver);
    	WebElement	checkBox1=driver.findElement(checkbox1);
    	 action.doubleClick(checkBox1).perform();	
    	 //checkbox1.click();
    	 WebElement	checkBox2=driver.findElement(checkbox2);
    	 checkBox2.click();
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	     wait.until(ExpectedConditions.elementToBeClickable(checkbox1)).click(); 
//    	 wait.until(ExpectedConditions.elementToBeClickable(checkbox2)).click(); 
    	 System.out.println("this function executed:");
    		 
     
     }
    
    public void MultipleDelete() {
   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   	 
	     wait.until(ExpectedConditions.elementToBeClickable(dubdelete_icon)).click(); 
   	 
    }
   
    public void DeleteSuccess() {
    	WebElement dubdelete_Yes=driver.findElement(dubdelete_yes);
      	 dubdelete_Yes.click();
   	 String text2; 
   	WebElement success_Dbdelete=driver.findElement(success_dbdelete);
   	 text2 = success_Dbdelete.getText();
   	 System.out.println(text2);
    }
	 
	 //Actions
	
	public void login() {
		driver.findElement(userName).sendKeys("Sdet@gmail.com");
		
		driver.findElement(passWord).sendKeys("LmsHackathon@2024");
		driver.findElement(Login).click();
	}
	 
	 public void ProgramClick() throws InterruptedException{
		 Thread.sleep(1000);
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(programBtn));
		  
			 WebElement button=driver.findElement(programBtn);
			JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", button);
			Thread.sleep(1000);
			
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
	 
	 
	 public List<String> testListContainsElements() {
		 String menuBar=driver.findElement(menu).getText();
		 
			 menuItems = Arrays.asList(menuBar.split("\\s+"));
return menuItems;
	        
	        
	    }
	 
	 public List<String>  testLogoutIsPresent() {
		 menuItems = Arrays.asList(menuBar.split("\\s+"));
			 return menuItems;
	 }
	 public String testAddNewProgramsIsPresent() {
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-menu-panel-0']/div/button")));
		String AddNewProgramUI= driver.findElement(addNewPgm).getText() ;
		
		return AddNewProgramUI;
	 }
	 
	 //MANAGE PROGRAM
	 public String testManageHeader() {
		 String manageprogramUI=driver.findElement(manageProgram).getText();
		return manageprogramUI;
	 }
	 
	 public List<String> testManageProgramMenu() {
		 WebElement manageProgramMenu = driver.findElement(mangeprogramTable); 
      
		 manageProgramMenuItems = manageProgramMenu.findElements(By.tagName("th"));
         List<String>itemTextList=new ArrayList<>();
         for (WebElement item : manageProgramMenuItems) {
             String itemText = item.getText(); 
             itemTextList.add(itemText);
                      }
         
         
	        return itemTextList;
		 
	 }
	 public boolean testMultipleDeleteIsDisabled() {
	 WebElement multipleDeleteButton =driver.findElement(multipleDelete);
     boolean isEnabled = multipleDeleteButton.isEnabled();
     //System.out.println("Is Delete button enabled? " + isEnabled);

     boolean isDisabled = !isEnabled;
     System.out.println("Is Delete button disabled? " + isDisabled);
     
		//Assertion is failed
     return isDisabled;
	 }
	 
	 public String testSearchBar() {
		 WebElement searchBar=driver.findElement(searchbtn);
         Assert.assertTrue("Search bar should be visible", searchBar.isDisplayed());
         String placeholderText = searchBar.getAttribute("placeholder");
          
          return placeholderText;
		 	 }
	 public boolean testPDefaultCheckbox() {
		 WebElement pcheckbox =driver.findElement(pCheckBox);
		 boolean isChecked = pcheckbox.isSelected();
	     System.out.println("Is CHECKBOX button enabled? " + isChecked);

	     boolean isDisabled = !isChecked;
	     return isDisabled;
	      
	 }
	 
	 public void testAreUnchecked() {
	 
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
	    public void clickAddNewProgram() throws InterruptedException {
	    	
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(addNewPgm));
Thread.sleep(1000);
			driver.findElement(addNewPgm).click();
	    }
	    public void VerifyaddNewProgram() throws InterruptedException {
	    	
			// Wait for the pop-up to be displayed
            //popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popUp)); // Adjust selector
          Thread.sleep(1000);
          WebElement popup=driver.findElement(popUp);
            // Verify the pop-up contains expected text or elements
            String expectedText = "Program Details"; 
            String actualText = popup.getText();
            System.out.println(actualText);
            Assert.assertTrue("Pop-up does not contain expected text.", actualText.contains(expectedText));

            
             
	    }
	    
	    public String VerifyTitleOfAddNewPopwindow() {
	    	
	          
	          //wait.until(ExpectedConditions.visibilityOfElementLocated(TitlePopUp));
	          String programHeader=driver.findElement(TitlePopUp).getText();
	          System.out.println(programHeader);
	         Assert.assertEquals( "Program Details", programHeader);
	          return programHeader;
	    		    	
	    }
	    
	    public void testMandatoryFieldAsterisk() {
	    	
	    	
            //WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(programName)); // Adjust selector
            WebElement asterisk = driver.findElement(astreik); 
                                   
            Assert.assertTrue("Asterisk should be displayed", asterisk.isDisplayed());

            String asteriskColor = asterisk.getCssValue("color");
           Assert.assertEquals("Asterisk color should be red", "rgba(255, 0, 0, 1)", asteriskColor); 
	    	
	    }
	    public void saveClick() {
	    	driver.findElement(saveProgram).click();
	    }
	    public String testRequiredFieldMessage() {
	    	
			String  fieldText=driver.findElement(requiredText).getText();
             
            return fieldText;
	    }
	     public void cancelbuttonclick() throws InterruptedException {
	    	 Thread.sleep(1000);
	    	// WebElement popup=driver.findElement(popUp); 
	    	 //closeButton = popup.findElement(cancelButton); // Adjust selector
	    	 WebElement closeButton=driver.findElement(cancelButton);
	           
	            closeButton.click();
	     }
	    public  void IsPopUpDisplayed() {
	    	//Assert.assertTrue("Program Details form should be visible", popup.isDisplayed());
	    	//WebElement popup=driver.findElement(popUp);
	    	 /*boolean isDisplayed = popup.isDisplayed();
	    	 Assert.assertTrue("Program Details form should be visible", isDisplayed);
	    	 return isDisplayed;*/
	    	 WebElement popup = driver.findElement(popUp); // Adjust the locator
	            
	    	 Assert.assertTrue("Program Details form should be visible", popup.isDisplayed());
	    	 
	    }
	    
	    public void IspopupNotDisplayed() {
	    	
	    	//wait.until(ExpectedConditions.invisibilityOf(popup));
		    //add softassertion here
	    	//boolean isDisplayed;
		   // Assert.assertFalse("Program Details form should no longer be visible",  isDisplayed);
	    }
	    public void enterText(String Name) {
	    	WebElement programNameTextBox=driver.findElement(pname);
			 programNameTextBox.sendKeys(Name);
	    }
	    public String ProgramNameEntryTest()
	    {
	    	
	    	WebElement programNameTextBox=driver.findElement(pname);
			// programNameTextBox.sendKeys(Name);
			 String enteredText = programNameTextBox.getAttribute("ng-reflect-model");
	    	return enteredText;
	    	//Assert.assertEquals("The entered program name should match.", "SalesBI", enteredText);
	    	
	    }
	    public void DescriptionEntry(String Description) {
	    	WebElement descriptionBox=driver.findElement(pDescription);
	    	descriptionBox.sendKeys(Description);
	    }
	    
	    
	    public String DescriptionEntryTest() {
	    	WebElement descriptionBox=driver.findElement(pDescription);
	    	//descriptionBox.sendKeys(Description);
	    	String enteredText = descriptionBox.getAttribute("ng-reflect-model");
			return enteredText;
			//Assert.assertEquals("The entered description should match.", descriptionText, enteredText);

	    	
	    }
	   
	    public void clickStatus() {
	    	WebElement statusRadioButton = driver.findElement(active);
			 statusRadioButton.click();
	    }

	    // Method to check if a status is selected
	    public boolean isStatusSelected() {
	    	WebElement statusRadioButton = driver.findElement(active);
		   statusRadioButton.isSelected();
		   Assert.assertFalse("The radio button for active selected.",statusRadioButton.isSelected());
		  return statusRadioButton.isSelected();
		  //add soft assertion here too
		 
	    }
	    public void clickSaveButton() {
	    	WebElement saveButton = driver.findElement(save);
	    	saveButton.click();
	    }
	    public String  successMsgSave() {
	    	
	    	//WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
	    	WebElement successMessageElement=driver.findElement(successMsg);
	    	return successMessageElement.getText();
	    }
	    
	    public void clickSearch() {
	    	WebElement searchBar=driver.findElement(searchbtn);
	    	searchBar.click();
	    		    }
	    
	    public void searchEnterProgramText(String programname) {
	    	WebElement searchBar=driver.findElement(searchbtn);
	    	searchBar.sendKeys(programname); 
	    }
	    public String searchForProgram() {
	    	  	
	    	    	
	    	WebElement programRecord=driver.findElement(enteredPName);
	    	String searchText=programRecord.getText();
	    	System.out.println(searchText);
	    	return searchText;
	    	//assertion will fail text wont match
	    	
	    }
	    public void clickXbutton() {
	    	WebElement popup=driver.findElement(popUp);
	    	WebElement XButton = popup.findElement(Xbutton); // Adjust selector
	           
	    	 XButton.click();
	    	 System.out.println(popup.isDisplayed());
	    	 //assertion fail
	    }
	    
	    public void createForm() {
	    	driver.findElement(pname).sendKeys("JOOG");;
	    	driver.findElement(pDescription).sendKeys("games");
	    	
	   	    	
	    }
	    
	 
}