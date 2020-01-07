package com.paga.util;




import org.openqa.selenium.WebDriver;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


/**
 * @Description: Methods to be used for each test case
 */
public class BaseTest extends AbstractTestNGSpringContextTests{
	
	public static WebDriver driver;
	
	/**
	 * 获取driver
	 */
	@BeforeClass
	public static WebDriver initDriver() {
		Config config = new Config("application.properties");
		//Set system properties and obtain browser type through configuration
		System.setProperty("integritytech.test.browser",config.getConfig("integritytech.test.browser"));
		driver = DriverUtil.getDriver();
		//window maximizing
		DriverUtil.windowMax();
		DriverUtil.waitTime(10);
		
		return driver;
		
	}
	/**
	 * Close browser
	 */
	@AfterClass
	public static void clossDriver() {
		driver.quit();
	}
	/**
	 * Close service after executing Suite
	 */
	@AfterSuite
	public static void clossService() {
		DriverUtil.stopService();
	}
	
}
