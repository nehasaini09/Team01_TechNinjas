package com.hooks;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.utilities.ReadConfig;
/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/


public class BaseClass {

	
	/*static ReadConfig readconfig=new ReadConfig();
	public static String baseURL=readconfig.getApplicationURL();
	public static WebDriver driver;
	public static String browserName = readconfig.getbrowser();

	public static void Initialization() {

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}


	public static void teardown() {
		driver.close();
	}
}*/

	
		private TestContext Context;
		   private ReadConfig readConfig; 
		
	 // inject TestContext constructor
	    public BaseClass(TestContext Context) {
	        this.Context = Context;
	        this.readConfig = new ReadConfig();
	    }

	    @Before
	    public void setUp() {
	    	   WebDriverManager.chromedriver().setup();
	        Context.getDriver();
	        String browserName = readConfig.getbrowser(); 
	        
	        // Initialize the WebDriver using the browser specified in the properties file
	        WebDriver driver = Context.getDriverFactory().initialiseBrowser(browserName); 
	        Context.setDriver(driver); // Set the driver in TestContext

	        // Navigate to the URL from ReadConfig
	        Context.getDriver().get(readConfig.getApplicationURL());
	       
	    }

	    @After
	    public void tearDown() {
	        Context.closeDriver();
	    }
	}




