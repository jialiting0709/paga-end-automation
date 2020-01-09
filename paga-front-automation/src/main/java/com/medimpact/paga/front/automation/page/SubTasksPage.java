package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTasksPage extends BasePage{

	public SubTasksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//tbody/tr/td[9]/button/span/mat-icon")
	private  WebElement sub_mat_icon;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[1]/div[1]/button[2]")
	private  WebElement sub_edit;
	
	@FindBy(xpath="//mat-form-field/div/div[1]/div[1]/input")
	private  WebElement sub_input;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[1]/div[1]/button[3]")
	private  WebElement sub_save;
	
	@FindBy(xpath="//app-sub-tasks/table/tbody/tr[1]/td[2]")
	private  WebElement td_text;
	
	@FindBy(xpath="//*[contains(text(),'Assign to me')]")
	private  WebElement assign_to_me;
	
	@FindBy(xpath="//app-sub-tasks/table/thead/tr/th[9]/button")
	private  WebElement caozuo;
	
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/button")
	private  WebElement Assign_to;
	
	@FindBy(xpath="//input[@placeholder='Assign to']")
	private  WebElement Assign_to_input;
	
	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private  WebElement Assign_button;
	
	public void click_Assign_button(){
		this.click(Assign_button);
	}
	
	public void input_Assign_to(String s){
		this.sendkeys(Assign_to_input, s);
	}
	
	public void click_Assign_to(){
		this.click(Assign_to);
	}
	
	public void click_caozuo(){
		this.click(caozuo);
	}
	
	public void click_assign_to_me(){
		this.click(assign_to_me);
	}
	
	public void click_sub_save(){
		this.click(sub_save);
	}
	
	public String get_sub_name(){
		return td_text.getText();
	}		
	
	public void input_sub_name(String s){
		this.sendkeys(sub_input, s);
	}
		
	public void click_sub_edit(){
		this.click(sub_edit);
	}
	
	public void scroll(){
		this.elementScroll(sub_mat_icon);
	}
	
	public void click_sub_mat_icon(){
		this.click(sub_mat_icon);
	}
	

}
