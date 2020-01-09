package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignTheTaskPage extends BasePage{

	public AssignTheTaskPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@ng-reflect-name='design']")
	private WebElement Design;
	
	@FindBy(xpath="//body/div[2]/div/div/div/mat-option/span")
	private WebElement Design_list;	
		
	@FindBy(xpath="//app-add-task-step/mat-toolbar/button[2]")
	private WebElement Design_button;
	
	public void click_Design_next(){
		this.click(Design_button);
	}
	
	public void click_Design_list(){
		this.click(Design_list);
	}	
	
	public void input_Design(String s){
		this.sendkeys(Design, s);
	}
	
}
