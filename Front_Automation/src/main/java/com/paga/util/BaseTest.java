package com.paga.util;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


/**
 * @Description: 每个测试用例都要用的方法
 */
public class BaseTest{
	
	public static WebDriver driver;
	
	/**
	 * 获取driver
	 */
	@BeforeClass
	public static WebDriver initDriver() {
		Config config = new Config("config.properties");
		//设置系统属性，通过配置获取浏览器类型
		System.setProperty("integritytech.test.browser",config.getConfig("integritytech.test.browser"));
		driver = DriverUtil.getDriver();
		//窗口最大化
		DriverUtil.windowMax();
		DriverUtil.waitTime(10);
		
		return driver;
		
	}
	/**
	 * 关闭浏览器
	 */
	@AfterClass
	public static void clossDriver() {
		driver.quit();
	}
	/**
	 * 执行完suite(测试套件)关闭service
	 */
	@AfterSuite
	public static void clossService() {
		DriverUtil.stopService();
	}
	
}
