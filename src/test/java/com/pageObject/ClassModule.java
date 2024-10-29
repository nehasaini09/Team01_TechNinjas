package com.pageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hooks.TestContext;

public class ClassModule {

	private WebDriver driver;
	private WebDriverWait wait;
	Actions action;

	TestContext context;
	// JavascriptExecutor js = (JavascriptExecutor) driver;

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
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
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
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement managePage;

	// Mandatory fields

	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	private WebElement batchNameDrpdw;
	@FindBy(xpath = "//input[@id='classTopic']")
	private WebElement classTopic;
	@FindBy(xpath = "//input[@id='classDescription']")
	private WebElement classDescription;
	@FindBy(xpath = "//input[@id='icon']")
	private WebElement datePicker;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	private WebElement calenderBtn;
	@FindBy(xpath = "//label[normalize-space()='Staff Name']")
	private WebElement staffnameheader;
	@FindBy(className = "p-datepicker-month")
	private WebElement month;
	@FindBy(className = "pi-chevron-right")
	private WebElement nextMonth;
	@FindBy(xpath = "//span[normalize-space()='21']")
	private WebElement date;
	@FindBy(xpath = "//td[@ng-reflect-ng-class='[object Object]']")
	private List<WebElement> dateSel;
	@FindBy(xpath = "//input[@id='classNo']")
	private WebElement noOfClasses;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	private WebElement staffName;
	@FindBy(xpath = "//label[text()='No of Classes']")
	private WebElement noOfClassesHeader;
	@FindBy(xpath = "//input[@ng-reflect-model]")
	private WebElement noOfClassesTextBox;
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

	// Edit Window
	@FindBy(xpath = "//button[@icon='pi pi-pencil']")
	private WebElement editBtn;
	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")
	private WebElement editPopup;

	// Delete

	@FindBy(xpath = "(//button[@icon='pi pi-trash'])[2]")
	private WebElement deletebtn;
	@FindBy(xpath = "//button//span[text()='Yes']")
	private WebElement confirmyes;
	@FindBy(xpath = "//button//span[text()='No']")
	private WebElement confirmno;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement successdelete;

	// delete multiple program locators
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox1;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox2;
	@FindBy(xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
	private WebElement dubdelete_icon;
	@FindBy(xpath = "//button//span[text()='Yes']")
	private WebElement dubdelete_yes;
	@FindBy(xpath = "//div/p-toastitem/div/div/div/div[2]")
	private WebElement success_dbdelete;

	// Search box
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBox;
	@FindBy(xpath = "(//div[@class='action'])")
	private List<WebElement> noOfRows;
	@FindBy(xpath = "//input[@placeholder]")
	private WebElement searchBx;
	@FindBy(xpath = "//input[@placeholder]")
	private WebElement searchox;
	@FindBy(xpath = "//tbody//td[2]")
	List<WebElement> listOfBatchNames;
	@FindBy(xpath = "//tbody//td[3]")
	List<WebElement> listOfClassTopic;
	@FindBy(xpath = "//tbody//td[7]")
	List<WebElement> listOfStaffNames;

	// sort element locators
	// sort
	@FindBy(xpath = "//thead//tr//th[2]//i")
	private WebElement BatchNameSort;
	@FindBy(xpath = "//thead//tr//th[3]//i")
	private WebElement classTopicSort;
	@FindBy(xpath = "//thead//tr//th[4]//i")
	private WebElement classDescripSort;
	// list
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> BatchNameList;
	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> classTopicList;
	@FindBy(xpath = "//tbody//td[4]")
	private List<WebElement> classDescripList;

	// Logout
	@FindBy(id = "logout")
	private WebElement logoutBtn;

	public ClassModule(WebDriver driver,TestContext context) {
		
		this.driver = context.getDriver();
		
		this.context=context;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
		// this.js=context.getJs();
	}

	public void addUsername(String uName) {
		userName.sendKeys(uName);

	}

	public void addPassword(String pwsd) {
		password.sendKeys(pwsd);
	}

	public void clickLoginBtn() {
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickClassBtn() {

		classBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js=context.getJs();
		js.executeScript("document.body.style.zoom='80%'");

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
		return isSortingbuttonDisplayed(sortingBtn);
	}

	public boolean deleteBtnDisplayed() {
		return deleteBtnMC.isDisplayed();
	}

	public void clickAddNewClass() throws InterruptedException {

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchNamePopup);
		return batchNamePopup.isDisplayed();
	}

	public boolean classTopicOnPopupDisp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchNamePopup);
		return classTopicPopup.isDisplayed();
	}

	public String addingMandatoryFields(String batchName, String ClassTopic, String ClassDescription, String month,
			String date1, String date2, String StaffName, String Status) throws InterruptedException {
		batchNameDrpdw.click();
		batchNameDrpdw.sendKeys(batchName);
		classTopic.click();
		classTopic.sendKeys(ClassTopic);
		classDescription.click();
		classDescription.sendKeys(ClassDescription);
		noOfClasses(month, date1, date2);
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

	// Date picker
	public void noOfClasses(String Month, String date1, String date2) {

		datePicker.click();
		do {
			nextMonth.click();
		} while (!month.getText().contains(Month));
		for (int i = 0; i < dateSel.size(); i++) {
			List<WebElement> dates = driver.findElements(By.xpath("//td[@ng-reflect-ng-class='[object Object]']"));
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase(date1) || text.equalsIgnoreCase(date2)) {
				dates.get(i).click();
			}
		}
		noOfClassesHeader.click();
	}

	
	
	/*public boolean verifyWeekendDatesDisabled() {
	    datePicker.click();
	    
	       do {
	        nextMonth.click();
	    } while (!month.getText().contains(""));

	     int[] weekendIndexs = {1, 7, 8, 14, 15, 21, 22, 28, 29, 35};

	       for (int index : weekendIndexs) {
	    WebElement date = driver.findElement(By.xpath("(//td[@class='ng-tns-c178-19 ng-star-inserted'])[1]"));
	        
	           if (date.isEnabled()) {
	            System.out.println("Enabled weekend date found at index: " + index + ", Date: " + date.getText());
	            return false;
	        }
	    }

	        return true;
	}*/



	

	public void validateNoOfClassessUpdated() {

		String modelValue = noOfClassesTextBox.getAttribute("ng-reflect-model");
		if (modelValue.equals("2")) {
			System.out.println("No. of classess updated as expected.");
		} else {
			System.out.println("Validation failed");
		}

	}

	public void selectOptionalFields(String comments, String Notes, String Recording) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", statusInActive);
		classComments.sendKeys(comments);
		notes.sendKeys(Notes);
		recording.sendKeys(Recording);

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}

	public void clickOnSave() {
		saveAddClass.click();
	}

	public boolean onManagePage() {
		return managePage.isDisplayed();
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
		// Actions actions = new Actions(driver);
		action.doubleClick(editBtn).perform();
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
		classDescription.sendKeys(editClass);
	}

	public String saveEditClass() {
		saveAddClass.click();
		return classCreated.getText();
	}

	public void logoutClick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();

	}

	public void searhBoxValidation(String field, String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBox);
		boolean found = false;
		switch (field) {
		case "Batch Name":
			searchBox.sendKeys(value);
			logicForValidatingSearch(listOfBatchNames, value);
			break;
		case "Class Topic":
			searchBox.sendKeys(value);
			logicForValidatingSearch(listOfClassTopic, value);
			break;
		case "Staff Name":
			searchBox.sendKeys(value);
			logicForValidatingSearch(listOfStaffNames, value);
			break;
		}
	}

	public void logicForValidatingSearch(List<WebElement> searchedValues, String value) {
		boolean found = false;
		for (WebElement v : searchedValues) {
			if (v.getText().equalsIgnoreCase(value)) {
				System.out.println("Search is success for value: " + value);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Search is not success for value: " + value);
		}
	}

	public void clickBatchNameSort() {
		action.click(BatchNameSort).perform();
		action.click(BatchNameSort).perform();
	}

	public void clickBatchNameSortDec() {
		action.click(BatchNameSort).perform();
		action.click(BatchNameSort).perform();
		action.click(BatchNameSort).perform();

	}

	public void clickclassTopicSort() {
		action.click(classTopicSort).perform();
		action.click(classTopicSort).perform();

	}

	public void clickclassTopicSortDes() {
		action.click(classTopicSort).perform();
		action.click(classTopicSort).perform();
		action.click(classTopicSort).perform();

	}

	public void clickclassDescriptionSort() {
		action.click(classDescripSort).perform();
		action.click(classDescripSort).perform();

	}

	public void clickclassDescriptionSortDes() {
		action.click(classDescripSort).perform();
		action.click(classDescripSort).perform();
		action.click(classDescripSort).perform();

	}

//get and return original list	
	public List<String> getOriginalList(String type) {
		List<String> originalList = null;

		if (type.equals("BatchName")) {
			originalList = printWebElements(BatchNameList);

		} else if (type.equals("ClassTopic")) {
			originalList = printWebElements(classTopicList);

		} else {
			originalList = printWebElements(classDescripList);
		}
		return originalList;
	}

// this method will sort the given list
	public List<String> getSortedList(List<String> originalList) {
		System.out.println("Original List Before sorting is" + originalList);
		List<String> sortedList = new ArrayList<>(originalList);
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted List After sorting is" + sortedList);
		return sortedList;
	}

	public List<String> getSortedListDescending(List<String> originalList) {

		System.out.println("Original List Before sorting is" + originalList);
		List<String> sortedList = new ArrayList<>(originalList);
//        Collections.sort(sortedList, (s1, s2) -> s2.compareToIgnoreCase(s1));
//        Collections.sort(sortedList, Collections.reverseOrder());
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println("Sorted List After sorting is" + sortedList);
		return sortedList;
	}

// covert web element to java string list	
	public List<String> printWebElements(List<WebElement> options) {
		List<String> texts = new ArrayList<String>();
		int i = 0;
		for (WebElement option : options) {
			texts.add(i, option.getText());
			i++;
		}
		System.out.println("The number of items in the list are: " + texts.size());
		return texts;
	}

	public boolean validateHeader(WebElement element, String header) {
		String headerText = "";
		if (element.isDisplayed()) {
			headerText = element.getText();
			if (headerText.equals(header)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isSortingbuttonDisplayed(List<WebElement> elements) {
		boolean flag = true;
		if (elements.size() > 1) {
			for (int i = 1; i < elements.size(); i++) {
				WebElement element = elements.get(i);
				if (!element.isDisplayed()) {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

}
