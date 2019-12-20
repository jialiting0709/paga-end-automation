package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位User Name输入框
	@FindBy(xpath="//input[@formcontrolname='userName']")
	private WebElement userName;
	
	//定位User Password
	@FindBy(xpath="//input[@formcontrolname='password']")
	private WebElement userPassword;
	
	//定位登陆按钮
	@FindBy(xpath="//app-root/app-login/div/div/div/button/span")
	private WebElement Log_in;
	
	//点击Log_in按钮
	public void click_Log_in(){
		this.click(Log_in);
	}
	
	//输入User Name
	public void input_userName(String s){
		this.sendkeys(userName, s);
	}
	
	//输入userPassword
	public void input_userPassword(String s){
		this.sendkeys(userPassword, s);
	}
		
}
