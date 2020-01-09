package com.paga.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverUtil {
//	private static DriverService service;
	
	//Used to get and save the value of user settings in system properties
	private static String browser;
	
	private static WebDriver driver;

	private static final Logger logger = LogManager.getLogger();

	

	/**
	 * Provide the user with getting the browser driver object and return the corresponding driver object
	 * @throws MalformedURLException 
	 */
	public static WebDriver getDriver() throws MalformedURLException {
		Config config = new Config("application.properties");
		String driverUrl = config.getConfig("driverUrl");
		browser = System.getProperty("integritytech.test.browser", "chrome");
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL(String.format(driverUrl, 9515)),DesiredCapabilities.firefox());
			logger.info("Get firefox driver successfully");
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL(String.format(driverUrl, 9515)),DesiredCapabilities.chrome());
			logger.info("Get chrome driver successfully");
		}else {
			
		}
		return driver;	 
	}

//	public static void stopService() {
//		service.stop();
//	}

	public static void windowMax() {
		driver.manage().window().maximize();
	}

	public static void waitTime(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
}
