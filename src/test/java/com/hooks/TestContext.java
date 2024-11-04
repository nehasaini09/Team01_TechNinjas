package com.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObject.BatchModule;
import com.pageObject.ClassModule;
import com.pageObject.Dashboard;
import com.pageObject.Login;
import com.pageObject.Logout;
import com.pageObject.ProgramModule;
import com.utilities.ReadConfig;

public class TestContext {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private WebDriverWait wait;
	private ReadConfig readConfig;
	private BatchModule batchModule;
	private Actions actions;
	private ProgramModule programModulepage;
	private ClassModule cp;
	private Dashboard homepage;
	private Login login;
	private Logout lg;

	// initializing the DriverFactory
	public TestContext() {
		this.driverFactory = new DriverFactory();
		this.readConfig = new ReadConfig(); // config reader initilise

	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.actions = new Actions(driver); // Initialize Actions here, after driver is set
		this.batchModule = new BatchModule(driver, this);
		this.programModulepage = new ProgramModule(driver, this);
		this.cp = new ClassModule(driver, this);
		this.lg = new Logout(driver, this);
		this.login = new Login(driver, this);
		this.homepage = new Dashboard(driver, this);

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

	// public BatchModule getBatchModule() {
	// return batchModule; // Getter for BatchModule
	// }
	public Actions getActions() {
		return actions;
	}

	public ProgramModule getProgramModule() {
		return programModulepage;
	}

	public BatchModule getBatchModule() {
		return batchModule; // Getter for BatchModule
	}

	public ClassModule getClassModule() {
		return cp;
	}

	public Dashboard getDashboard() {
		return homepage;
	}

	public Login getLogin() {
		return login;
	}

	public Logout getLogout() {
		return lg;
	}
}
