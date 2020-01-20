package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTheClientDetailsPage extends BasePage{

	public AddTheClientDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//form/p[1]/mat-form-field[1]/div/div[1]/div[3]/input")
	private WebElement HQ_header;
	
	@FindBy(xpath="//mat-pseudo-checkbox")
	private WebElement HQ_header_mat_option;
	
	@FindBy(xpath="//form/p[1]/mat-form-field[2]/div/div[1]/div[3]/mat-select/div/div[2]")
	private WebElement HQ_code;
	
	@FindBy(xpath="//mat-option")
	private WebElement HQ_code_mat_option;

	@FindBy(xpath="//form/p[3]/mat-form-field/div/div/div[3]/mat-select/div/div[2]")
	private WebElement Guideline_Set;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/mat-option")
	private WebElement Guideline_Set_mat_option;
	
	@FindBy(xpath="//form/p[3]/mat-form-field/div/div/div[3]/mat-select/div/div[2]/div")
	private WebElement Line_of_Business;//Line of Business
	
	@FindBy(xpath="//body/div/div[2]/div/div/div/mat-option")
	private WebElement click_Line_of_Business_mat_option;
	
	@FindBy(xpath="//*[@ng-reflect-name='numberOfGuidelines']")
	private WebElement number_Of_Guidelines;
	
	@FindBy(xpath="//*[@ng-reflect-name='effectiveDate']")
	private WebElement effective_Date;
	
	@FindBy(xpath="//body/div[2]/div/div/div/mat-option")
	private WebElement MDT;
	
	public void clisk_MDT(){
		this.click(MDT);
	}
	
	public void send_effective_Date(String s){
		this.sendkeys(effective_Date, s);
	}
	
	
	public void send_number_Of_Guidelines(String s){
		this.sendkeys(number_Of_Guidelines, s);
	}
	
	public void click_click_Line_of_Business_mat_option(){
		this.click(click_Line_of_Business_mat_option);
	}
	
	public void click_Line_of_Business(){
		this.click(Line_of_Business);
	}

	public void click_Guideline_Set_mat_option(){
		this.click(Guideline_Set_mat_option);
	}
	
	public void click_Guideline_Set(){
		this.click(Guideline_Set);
	}
		
	public void click_mat_option_code(){
		this.click(HQ_header_mat_option);
	}
	
	public void click_HQ_code(){
		this.click(HQ_code);
	}
	
	public void click_HQ_header(){
		this.click(HQ_header);
	}

	public void input_HQ_header(String s){
		this.sendkeys(HQ_header, s);
	}
	

}
