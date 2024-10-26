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
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public  ProgramModulePage(WebDriver  driver) {
		this.driver=driver;
		}
	
	//ELEMENTS
	
	 By programBtn=By.id("program");
	 By addNewPgm=By.xpath("//*[@id='mat-menu-panel-0']/div/button");
	 By searchbtn=By.xpath("//*[@id='filterGlobal']");
	           //Menubar
	 By appHeader=By.xpath("//span[text()=' LMS - Learning Management System ']");//same for class module
	 By menu=By.xpath("//div[@class='ng-star-inserted']");
	             //manage program
	 By manageProgram=By.xpath("//app-program/div/mat-card/mat-card-title/div[1]");
	 By mangeprogramTable=By.xpath(" //*[@class='p-datatable-thead']/tr");
	 By multipleDelete=By.xpath("//app-program/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]");
	 By pCheckBox=By.xpath("//app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]");
	 By tableCheckbox=By.cssSelector("p-tablecheckbox");  
	 By tableSorticon= By.cssSelector("p-sorticon");
	 By tablebody=By.cssSelector(".p-datatable-tbody");
	 By editProgram=By.cssSelector("#editProgram");
	 By deleteProgram=By.cssSelector("#deleteProgram");
	 
	 
	 
	 //Actions
	 
	 public void ProgramClick(){
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("program")));
			driver.findElement(programBtn).click();
			 }
	 public String programPageTitle() {
	 String TitleAfterClickProgram=driver.getCurrentUrl();
		//System.out.println("Title of program page :"+TitleAfterClickProgram);
		return TitleAfterClickProgram;
	 }
	 
	 //MENU BAR
	 
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
      
         //List<WebElement> manageProgramMenuItems = manageProgramMenu.findElements(By.tagName("th"));
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
	    
	    
	    
	 
}