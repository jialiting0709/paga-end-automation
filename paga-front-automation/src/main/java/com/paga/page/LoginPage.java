package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@formcontrolname='userName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	private WebElement userPassword;
	
	@FindBy(xpath="//app-login/div/div/div/div/button")
	private WebElement Log_in;
	
	public void click_Log_in(){
		this.click(Log_in);
	}
	
	public void input_userName(String s){
		this.sendkeys(userName, s);
	}
	
	public void input_userPassword(String s){
		this.sendkeys(userPassword, s);
	}
		
}
