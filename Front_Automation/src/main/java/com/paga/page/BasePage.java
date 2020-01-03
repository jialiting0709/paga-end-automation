package com.paga.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    private final int timeOut = 10;//等待时间

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    /* 重写click方法 */
    public void click(WebElement element) {
        // 加入显式等待判断元素是否被点击
    	new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    /* 重写senkeys方法 */
    public void sendkeys(WebElement element, String s) {
    	// 加入显式等待元素是否可见
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));// 加入显式等待
        element.clear();// 先清空输入框
        element.sendKeys(s);// 输入数据
    }
    
    /*下拉滚动条到指定元素的最下方*/
    public void elementScroll(WebElement element) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
