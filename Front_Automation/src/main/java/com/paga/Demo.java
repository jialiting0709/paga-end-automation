package com.paga;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo {
	public static void main(String[] args) throws MalformedURLException {
		System.getProperty("integritytech.test.browser", "chrome");
		WebDriver driver = new RemoteWebDriver(new URL(String.format("http://10.129.0.141:%d", 9515)),DesiredCapabilities.chrome());
		driver.get("http:www.baidu.com");
	}
}
