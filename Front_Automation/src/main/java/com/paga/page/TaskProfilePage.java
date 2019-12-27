package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskProfilePage extends BasePage{

	public TaskProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位AddPath按钮
	@FindBy(xpath="//mat-tab-header/div[2]/div/div/div[2]/div")
	private WebElement AddPath;
	
	//点击AddPath按钮
	public void click_AddPath(){
		this.click(AddPath);
	}
}
