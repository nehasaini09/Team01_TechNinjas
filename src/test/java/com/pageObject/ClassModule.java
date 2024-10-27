package com.pageObject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.CommonMethodsClass;

public class ClassModule {

	private WebDriver driver;
	private WebDriverWait wait;
   // JavascriptExecutor	js;// = (JavascriptExecutor) driver;

	CommonMethodsClass common = new CommonMethodsClass();

	@FindBy(id = "username")	
	private WebElement userName;
	@FindBy(id = "password")	
	private WebElement password;
	@FindBy(xpath = "//span[text()='Class']")	
	private WebElement classBtn;
	@FindBy(className = "login-button")
	private WebElement loginBtn;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	private WebElement appHeader;
	@FindBy(xpath = "//div[text()=' Manage Class']")
	private WebElement manageClassHeader;
	@FindBy(xpath = "//th[text()=' Batch Name ']")
	private WebElement batchNameHeader;
	@FindBy(xpath = "//th[text()='Class Topic ']")
	private WebElement classTopicHeader;
	@FindBy(xpath = "//th[text()='Class Description ']")
	private WebElement classDescriptionHeader;
	@FindBy(xpath = "//th[text()=' Status ']")
	private WebElement statusHeader;
	@FindBy(xpath = "//th[text()=' Class Date ']")
	private WebElement classDateHeader;
	@FindBy(xpath = "//th[text()=' Staff Name ']")
	private WebElement staffNameHeader;
	@FindBy(css = ".p-paginator-current.ng-star-inserted")
	private WebElement showingEnteries;
	@FindBy(xpath = "//p-sorticon[@field='batchName']")
	private WebElement sortBatchNameBtn;
	@FindBy(className = "p-sortable-column-icon")
	private List<WebElement> sortingBtn;
	@FindBy(css = "button[class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteBtnMC;

	// popup new window elements
	@FindBy(xpath = "//button[text()='Add New Class']")
	private WebElement addNewClassBtn;
	@FindBy(xpath = "//button[@label='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//button[@label='Save']")
	private WebElement saveBtn;
	@FindBy(css = ".p-dialog-header-close")
	private WebElement crossBtn;
	@FindBy(css = ".p-datatable-footer.ng-star-inserted")
	private WebElement footer;
	@FindBy(xpath = "//label[text()='Batch Name']")
	private WebElement batchNamePopup;
	@FindBy(xpath = "//label[text()='Class Topic ']")
	private WebElement classTopicPopup;
	@FindBy(xpath="//div[normalize-space()='Manage Class']")
	private WebElement managePage;

//Mandatory fields
	// @FindBy(xpath="//div[@class='p-dropdown-trigger ng-tns-c171-9']")
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	private WebElement batchNameDrpdw;;
	@FindBy(xpath = "//input[@id='classTopic']")
	private WebElement classTopic;
	@FindBy(xpath = "//input[@id='classDescription']")
	private WebElement classDescription;
	@FindBy(xpath = "//input[@id='icon']") // ="//span[@class='p-button-icon pi pi-calendar']")
	private WebElement datePicker;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	private WebElement calenderBtn;
	@FindBy(xpath = "//span[@class='p-datepicker-month ng-tns-c178-41 ng-star-inserted']")
	private WebElement month;
	@FindBy(xpath = "//span[@class='p-datepicker-next-icon pi pi-chevron-right ng-tns-c178-41']")
	private WebElement nextMonth;
	@FindBy(css = ".ng-tns-c178-41.ng-star-inserted")
	private List<WebElement> dateSel;
	@FindBy(xpath = "//input[@id='classNo']")
	private WebElement noOfClasses;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	private WebElement staffName;
	@FindBy(className = "p-radiobutton-box")
	private WebElement statusActive;
	@FindBy(xpath = "(//div[@ng-reflect-ng-class='[object Object]'])[15]")
	private WebElement statusInActive;
	@FindBy(xpath = "//p-dropdownitem[@class='ng-tns-c171-12 ng-star-inserted']")
	private List<WebElement> batchNameList;
	@FindBy(id = "saveClass")
	private WebElement saveAddClass;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement classCreated;

	// optional fields
	@FindBy(xpath = "//input[@id='classComments']")
	private WebElement classComments;
	@FindBy(xpath = "//input[@id='classNotes']")
	private WebElement notes;
	@FindBy(xpath = "//input[@id='classRecordingPath']")
	private WebElement recording;
	// required fields
	@FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
	private WebElement batchNameReq;
	@FindBy(xpath = "//small[normalize-space()='Class Topic is required.']")
	private WebElement classTopicReq;
	@FindBy(xpath = "//small[normalize-space()='Class Date is required.']")
	private WebElement classDateReq;
	@FindBy(xpath = "//small[normalize-space()='Staff Name is required.']")
	private WebElement staffNameReq;
	@FindBy(xpath = "//small[normalize-space()='No. of Classes is required.']")
	private WebElement noOfClassesReq;
	
	//Edit Window
	@FindBy(xpath="//button[@icon='pi pi-pencil']")
	private WebElement editBtn;
	@FindBy(xpath="//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")
	private WebElement editPopup;
	/*@FindBy(css=".ng-tns-c168-40.p-dialog-content")
	private WebElement editPopup;
	@FindBy(css=".ng-tns-c168-40.p-dialog-content")
	private WebElement editPopup;
	@FindBy(css=".ng-tns-c168-40.p-dialog-content")
	private WebElement editPopup;
	@FindBy(css=".ng-tns-c168-40.p-dialog-content")
	private WebElement editPopup;*/
	
	//Delete
	
	 @FindBy(xpath = "(//button[@icon='pi pi-trash'])[2]")private WebElement deletebtn;
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
	     
	     //Logout
	     @FindBy(id="logout")
	     private WebElement logoutBtn;

	public ClassModule(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addUsername(String uName) {
		userName.sendKeys(uName);
		;
	}

	public void addPassword(String pwsd) {
		password.sendKeys(pwsd);
	}

	public void clickLoginBtn() {
		common.click(loginBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickClassBtn() {

		common.click(classBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public WebElement getHeaderElement(String headerName) {
		switch (headerName) {
		case "LMS - Learning Management System":
			return appHeader;
		case "Manage class":
			return manageClassHeader;
		case "Batch Name":
			return batchNameHeader;
		case "Class Topic":
			return classTopicHeader;
		case "Class Description":
			return classDescriptionHeader;
		case "Status":
			return statusHeader;
		case "Class Date":
			return classDateHeader;
		case "Staff Name":
			return staffNameHeader;
		default:
			return null;

		}
	}

	public boolean validateShowingEnteries() {
		return showingEnteries.isDisplayed();

	}

	public boolean validateFooter() {
		return footer.isDisplayed();

	}

	public boolean validateSortingBtn() {
		return common.isSortingbuttonDisplayed(sortingBtn);
	}

	public boolean deleteBtnDisplayed() {
		return deleteBtnMC.isDisplayed();
	}

	public void clickAddNewClass() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// addNewClassBtn.click();
		for (int i = 0; i < 3; i++) {
			try {
				addNewClassBtn.click();
				break;
			} catch (ElementClickInterceptedException e) {
				Thread.sleep(500);
			}
		}

	}

	public boolean cancelDisp() {
		return cancelBtn.isDisplayed();
	}

	public boolean saveDisp() {
		return saveBtn.isDisplayed();
	}

	public boolean crossBtnDisp() {
		return crossBtn.isDisplayed();
	}

	public boolean batchNameOnPopupDisp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js=	(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchNamePopup);
		return batchNamePopup.isDisplayed();
	}

	public boolean classTopicOnPopupDisp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js=	(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchNamePopup);
		return classTopicPopup.isDisplayed();
	}

	public String addingMandatoryFields(String batchName, String ClassTopic, String ClassDescription, String ClassDate,
			String StaffName, String Status) throws InterruptedException {
		batchNameDrpdw.click();
		common.sendKeysToElement(batchNameDrpdw, batchName);
		classTopic.click();
		common.sendKeysToElement(classTopic, ClassTopic);
		classDescription.click();
		common.sendKeysToElement(classDescription, ClassDescription);
		datePicker.click();

		datePicker.sendKeys(ClassDate, Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", noOfClasses);

		staffName.click();
		staffName.sendKeys(StaffName);
		if (Status.equals("Active")) {
			statusActive.click();
		} else {
			statusInActive.click();

		}
		saveAddClass.click();

		return classCreated.getText();
	}

	public void noOfClasses() {

		datePicker.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement nextIcon =
		// wait.until(ExpectedConditions.elementToBeClickable(nextMonth));
		// nextIcon.click();
		while (!month.getText().contains("October")) {
			nextMonth.click();
		}

		int count = dateSel.size();
		for (int i = 0; i < count; i++) {
			String text = dateSel.get(i).getText();
			if (text.equalsIgnoreCase("28") || text.equalsIgnoreCase("29")) {
				dateSel.get(i).click();
			}
		}

	}

	public void selectOptionalFields(String comments, String Notes, String Recording) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", statusInActive);
		common.sendKeysToElement(classComments, comments);
		common.sendKeysToElement(notes, Notes);
		common.sendKeysToElement(recording, Recording);

		saveAddClass.click();

	}
	
	 public String getBatchNameReqText() {
	        return getTextFromMandatoryFields(batchNameReq);
	    }

	    public String getClassTopicReqText() {
	        return getTextFromMandatoryFields(classTopicReq);
	    }

	    public String getClassDateReqText() {
	        return getTextFromMandatoryFields(classDateReq);
	    }

	    public String getStaffNameReqText() {
	        return getTextFromMandatoryFields(staffNameReq);
	    }

	    public String getNoOfClassesReqText() {
	        return getTextFromMandatoryFields(noOfClassesReq);
	    }

	       private String getTextFromMandatoryFields(WebElement element) {
	    	   JavascriptExecutor js=	(JavascriptExecutor) driver;
	    	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	        return element.getText();
	    }
	       
	       public void clickOnSave() {
	    	   saveAddClass.click();
	       }
	       
	       public boolean onManagePage() {
	    	 return  managePage.isDisplayed();
	       }
	       
	       public void clickOnDeleteIcon() {
		    	  Actions actions = new Actions(driver);
		    	  actions.doubleClick(deletebtn).perform();	    	 
		     }
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
		    	 Actions actions = new Actions(driver);
		    	 actions.doubleClick(checkbox1).perform();	
		    	 checkbox2.click(); 
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
		     
		     public void clickOnEdit() {
		    	 Actions actions = new Actions(driver);
		    	  actions.doubleClick(editBtn).perform();	 
		     }
		     
		     public boolean editPopup() {
		    	 return editPopup.isDisplayed();
		     }
		     
		     public boolean batchNameDisabled() {
		    	 return batchNameDrpdw.isEnabled();
		     }
		     public boolean classTopicDisabled() {
		    	 return classTopic.isEnabled();
		     }
		     public void editClassDetails(String editClass) {
		    	 common.sendKeysToElement(classDescription,editClass);
		    	 
		     }
		     
		     public String saveEditClass() {
		    	 saveAddClass.click();

		 		return classCreated.getText();
		     }
		     
		     
		     public void logoutClick() throws InterruptedException {
		    	 //Thread.sleep(2000);
		    	 common.click(logoutBtn);
		     }
		     
		     
		     
	}
	

		
	
	
	
	
	
	

