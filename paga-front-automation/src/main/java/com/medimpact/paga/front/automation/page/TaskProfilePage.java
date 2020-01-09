package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskProfilePage extends BasePage{

	public TaskProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//mat-tab-header/div[2]/div/div/div[2]/div")
	private WebElement AddPath;
	
	public void click_AddPath(){
		this.click(AddPath);
	}
}
