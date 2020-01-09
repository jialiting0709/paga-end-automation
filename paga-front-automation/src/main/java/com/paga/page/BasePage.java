package com.paga.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    private final int timeOut = 10;//waiting time

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    /* Override click method */
    public void click(WebElement element) {
    	new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
//        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    /* Override the senkeys method */
    public void sendkeys(WebElement element, String s) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(s);
    }
    
    /*Drop down the scroll bar to the bottom of the specified element*/
    public void elementScroll(WebElement element) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
