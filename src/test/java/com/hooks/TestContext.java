package com.hooks;
import com.pageObject.ClassModule;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObject.BatchModule;
import com.pageObject.ProgramModule;
//import com.pageObject.ProgramModulePage;
import com.utilities.ReadConfig;
import org.openqa.selenium.interactions.Actions;


public class TestContext {
	
	private WebDriver driver;
    private DriverFactory driverFactory;
    private WebDriverWait wait;
    private ReadConfig readConfig;
    private ProgramModule programModulepage;
	 private ClassModule cp;
    private BatchModule batchModule;
    private Actions actions;
    
 // initializing the DriverFactory
    public TestContext() {
       this.driverFactory = new DriverFactory();
       //this.driver = driverFactory.initialiseBrowser("chrome"); 
       //this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       this.readConfig = new ReadConfig(); // config reader initilise
       
    }  
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        this.actions = new Actions(driver);
        this.programModulepage=new ProgramModule(driver, this);
        this.batchModule=new BatchModule(driver,this);
    }
    public DriverFactory getDriverFactory() {
        return driverFactory;
    }
 // WebDriver instance
    public WebDriver getDriver() {
    	
        return driver;
    }  
// driver close
    public void closeDriver() {
        driverFactory.closeDriver();
    }
    public WebDriverWait getWait() {
        return wait;
    }

    public String getApplicationURL() {
        return readConfig.getApplicationURL(); // Method to get URL
    }
    public ProgramModule getProgramModule() {
    	return programModulepage;
    }
    public BatchModule getBatchModule() {
        return batchModule; // Getter for BatchModule
    }
    public Actions getActions() {
        return actions;
    }
	public ClassModule getClassModule() {
    	return cp;
    }

    

}
