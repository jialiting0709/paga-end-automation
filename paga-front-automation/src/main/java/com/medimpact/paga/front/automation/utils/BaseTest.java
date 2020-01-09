package com.medimpact.paga.front.automation.utils;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



/**
 * @Description: Methods to be used for each test case
 */
public class BaseTest extends AbstractTestNGSpringContextTests{
	
	public WebDriver driver;
		
	@Value("${browser}")
	private String browser;
	
	@Autowired
    private RemoteDriver driverUtil;
	
	/**
	 * get driver
	 * @throws MalformedURLException 
	 */
	@BeforeClass
	public WebDriver initDriver() throws MalformedURLException {
		//Set system properties and obtain browser type through configuration
		System.setProperty("integritytech.test.browser",browser);
		driver = driverUtil.getDriver();
		//window maximizing
		driverUtil.windowMax();
		driverUtil.waitTime(10);
		
		return driver;
		
	}
	/**
	 * Close browser
	 */
	@AfterClass
	public void clossDriver() {
		driver.quit();
	}
	/**
	 * Close service after executing Suite
	 */
//	@AfterSuite
//	public static void clossService() {
//		DriverUtil.stopService();
//	}
//	
}
