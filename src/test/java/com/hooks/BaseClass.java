package com.hooks;
import com.utilities.Log;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

	
		private TestContext context;
		   private ReadConfig readConfig; 
		
	 // inject TestContext constructor
	    public BaseClass(TestContext Context) {
	        this.context = Context;
	        this.readConfig = new ReadConfig();
	    }
	    
	    @Before
	    public void setUp() {
	        Log.logInfo("Initializing WebDriver");
	        String browserName = readConfig.getbrowser(); 
	        WebDriver driver = context.getDriverFactory().initialiseBrowser(browserName); 
	        context.setDriver(driver); 
	        Log.logInfo("Navigating to: " + readConfig.getApplicationURL());
	        context.getDriver().get(readConfig.getApplicationURL());
	    }

	    @After
	    public void tearDown() {
	    	 Log.logInfo("Closing WebDriver");
	        context.closeDriver();
	    }
	}




