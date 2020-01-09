package com.medimpact.paga.front.automation.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RemoteDriver {
//	private static DriverService service;
	
	//Used to get and save the value of user settings in system properties
	private String browser;
	
	private WebDriver driver;

	private final Logger logger = LogManager.getLogger();
	
	@Value("${driverUrl}")
	private String driverUrl;
	
	@Value("${driverPort}")
	private String driverPort;
	
	/**
	 * Provide the user with getting the browser driver object and return the corresponding driver object
	 * @throws MalformedURLException 
	 */

	public WebDriver getDriver() throws MalformedURLException {
		browser = System.getProperty("integritytech.test.browser", "chrome");
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL(String.format(driverUrl, Integer.parseInt(driverPort))),DesiredCapabilities.firefox());
			logger.info("Get firefox driver successfully");
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL(String.format(driverUrl, Integer.parseInt(driverPort))),DesiredCapabilities.chrome());
			logger.info("Get chrome driver successfully");
		}else {
			
		}
		return driver;	 
	}

//	public static void stopService() {
//		service.stop();
//	}

	public void windowMax() {
		driver.manage().window().maximize();
	}

	public void waitTime(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
}
