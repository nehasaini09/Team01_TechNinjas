package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./src/test/resources/Properties/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
    //get URL from config                    
	public String getApplicationURL() {
		String url = pro.getProperty("url");
		return url;
	}
	
	//get browser from config
	public String getbrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}
	

}
