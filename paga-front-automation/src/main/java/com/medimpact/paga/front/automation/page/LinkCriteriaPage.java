package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkCriteriaPage extends BasePage{

	public LinkCriteriaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//tfoot/tr/td/button/span")
	private WebElement Add_DRUG;
	
	@FindBy(xpath="//app-link-criteria-hicl-detail/div/mat-form-field/div/div/div/input")
	private WebElement HICL;
	
	@FindBy(xpath="//body/div[2]/div[3]/div/div/mat-option/span")
	private WebElement HICL_list;
	
	@FindBy(xpath="//tbody/tr/td[8]/p")
	private WebElement HICL_list_Delete;
	
	public String get_HICL_list_Delete_text(){
		return HICL_list_Delete.getText();
	}
	
	public void click_HICL_list(){
		this.click(HICL_list);
	}
	
	public void input_HICL(String s){
		this.sendkeys(HICL, s);
	}
	
	public void enter_HICL(){
		HICL.sendKeys(Keys.ENTER);
	}
		
	public void click_Add_DRUG(){
		this.click(Add_DRUG);
	}
	
}
