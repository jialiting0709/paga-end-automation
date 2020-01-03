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

/**
 * Driver类用于提供service的单例模式启动，并提供匹配不同浏览器的driver对象
 * @author jialiting
 *	
 */
public class DriverUtil {
	//service对象，用于保存根据用户设置的系统属性来创建不同浏览器的driverservice 
	private static DriverService service;
	
	//用于获取并保存用户设置在系统属性中的值 
	private static String browser;
	
	private static WebDriver driver;
	//定义日志对象
	private static final Logger logger = LogManager.getLogger();

	
	//静态加载
	static{
		//获取系统属性integritytech.test.browser的值，如果未设置，默认为firefox
		browser = System.getProperty("integritytech.test.browser", "chrome");
		//使用日志记录获取的参数值
		logger.info("获取系统属性integritytech.test.browser，值为"+browser);
		
		//根据browser，分别创建DriverService对象
		Config config = new Config("config.properties");
		String driverFile = config.getConfig("driver");
		//使用日志记录获取的参数值
		logger.info("获取配置文件中driver所在路径和文件名，值为"+driverFile);
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
			//通过日志记录浏览器配置信息是否正确
			logger.error("为支持的浏览器类型，请检查系统属性integritytech.test.browser");
			new RuntimeException("没有可执行浏览器");	
		}
		try {
			service.start();
			//通过日志记录服务是否正确启动
			logger.info("driver服务已启动......");
			
		} catch (IOException e) {
			logger.error("不能成功启动service,原因为"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	/**
	 * 向使用者提供获取浏览器driver对象
	 * @return 返回相应的driver对象
	 */
	public static WebDriver getDriver() {
	//根据browser，判断启动browser的类型。
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		}else {
			
		}
		return driver;
		 
	}
	/**
	 * 关闭service
	 */
	public static void stopService() {
		service.stop();
	}
	/**
	 * 浏览器窗口最大化
	 */
	public static void windowMax() {
		driver.manage().window().maximize();
	}
	/**
	 * 隐士等待时间
	 * @param time:等待的时间（单位为秒）
	 */
	public static void waitTime(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
}
