
package com.pageObject;

import com.hooks.DriverFactory;
import com.hooks.TestContext;
import com.utilities.ReadConfig;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends DriverFactory {
    private TestContext context;
    WebDriver driver;
    private WebDriverWait wait;
    private Login login;
    String expectedTitle="LMS - Learning Management System";
    ReadConfig config = new ReadConfig();

    public Dashboard(WebDriver driver){
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.login = new Login(driver);
        PageFactory.initElements(driver, this);
    }
    public void validateResponseTime(){
     long startTime= System.currentTimeMillis();
        String credentials="valid credentials";
        login.validLogin(credentials);
        String homepage_URL= config.getDashboardurl();
        wait.until(ExpectedConditions.urlToBe(homepage_URL));
        long endTime = System.currentTimeMillis();
        long totaltime = endTime - startTime;
        Assert.assertTrue("Navigation time exceeds 30s",totaltime<30000);



    }
    public void getDashboardTitle(){

        String pagetitle= driver.getTitle();
        Assert.assertEquals(pagetitle,expectedTitle,"Page title does not match");
    }
    public void getNavbar() {
    	WebElement navbarText= driver.findElement(By.xpath("//mat-toolbar//div"));
    	if (navbarText.isDisplayed()){
    		System.out.println("Navbar is visible.");
    		Point location= navbarText.getLocation();
    		int x= location.getX();
    		int y = location.getY();
    		System.out.println("Navbar x coordinate location :" +x +"and "+y);
    		int totalPageWidth= driver.manage().window().getSize().getWidth();
    		System.out.println("totalPageWidth :"+totalPageWidth);
    		if(y<=50 && (totalPageWidth - x) <= 350) {
    			System.out.println("Navbar is correctly positioned at the top-right corner.");
    		}
    		else {
    			System.out.println("Navbar is NOT in the correct position.");
    		}
    	}
    }
    
    public void getNavItems() {
    	 List<String> expectedTexts = Arrays.asList("Program", "Batch", "Class", "Logout");
    	WebElement navbarText= driver.findElement(By.xpath("//mat-toolbar//div"));
    	List<WebElement> navItems = navbarText.findElements(By.xpath(".//span[normalize-space()]"));
    	for(int i=0;i<navItems.size();i++) {
    		String NavbarText =navItems.get(i).getText().trim();
    		 Assert.assertEquals(NavbarText, expectedTexts.get(i));	 
    	}
    	 System.out.println("All the navigation bar items are in order and are with correct spelling");
    }
    
    public void LMSTitleLocation() {
    	
    	WebElement LMStitleLoc= driver.findElement(By.xpath("//mat-toolbar/span[1]"));
    	if(LMStitleLoc.isDisplayed()) {
    		Point location= LMStitleLoc.getLocation();
    		int x= location.getX();
    		int y = location.getY();
    		System.out.println("LMStitleLoc x coordinate location :" +x +"and "+y);
    			System.out.println("LMStitleLoc is correctly positioned at the top-left corner.");
    			 Assert.assertTrue("Title is not aligned to the left. X: " + x, x <= 50);
    	            Assert.assertTrue("Title is not aligned to the top. Y: " + y, y <= 50);
    			System.out.println("LMStitle location is NOT in the correct position.");
    		}
    	}
    
    public void LMSTItleSpellcheck() {
    	WebElement LMs=driver.findElement(By.xpath("//mat-toolbar/span[1]"));
    	System.out.println("title :"+LMs.getText());
        Assert.assertEquals(LMs.getText(),expectedTitle,"Page title spelling is wrong");
    }
   
    }
  
