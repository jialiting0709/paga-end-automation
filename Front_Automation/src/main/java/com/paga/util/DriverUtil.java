package com.paga.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtil {
	//The service object is used to save the driverservice of different browsers created according to the system properties set by the user
	private static DriverService service;
	
	//Used to get and save the value of user settings in system properties
	private static String browser;
	
	private static WebDriver driver;

	private static final Logger logger = LogManager.getLogger();

	
	//Static loading
	static{
		browser = System.getProperty("integritytech.test.browser", "chrome");
		logger.info("Get system properties integritytech.test.browser，value"+browser);
		
		Config config = new Config("application.properties");
		String root = System.getProperty("user.dir");
		String driverFile = root+config.getConfig("driver");
		String FirefoxBinary = config.getConfig("FirefoxBinary");
		if(browser.equalsIgnoreCase("firefox")) {
			service  = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File(FirefoxBinary)))
					.usingDriverExecutable(new File(driverFile))
					.build();
		}else if(browser.equalsIgnoreCase("chrome")) {
			service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(driverFile))
					.build();
		}else {
			logger.error("Check system properties for supported browser types integritytech.test.browser");
			new RuntimeException("No executable browser");	
		}
		try {
			service.start();
			logger.info("driver Service started......");
			
		} catch (IOException e) {
			logger.error("The service could not be started successfully because"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	/**
	 * Provide the user with getting the browser driver object and return the corresponding driver object
	 */
	public static WebDriver getDriver() {
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		}else {
			
		}
		return driver;
		 
	}

	public static void stopService() {
		service.stop();
	}

	public static void windowMax() {
		driver.manage().window().maximize();
	}

	public static void waitTime(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
}
