package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTasksPage extends BasePage{

	public SubTasksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位子任务操作按钮
	@FindBy(xpath="//app-sub-tasks/table/tbody/tr[1]/td[10]/button/span/mat-icon")
	private  WebElement sub_mat_icon;
	
	//定位子任务编辑按钮
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[1]/div[1]/button[2]")
	private  WebElement sub_edit;
	
	//定位编辑的input
	@FindBy(xpath="//mat-form-field/div/div[1]/div[1]/input")
	private  WebElement sub_input;
	
	//定位子任务保存按钮
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[1]/div[1]/button[3]")
	private  WebElement sub_save;
	
	//定位编辑后的input
	@FindBy(xpath="//app-sub-tasks/table/tbody/tr[1]/td[2]")
	private  WebElement td_text;
	
	//定位assign to me按钮
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div[1]/div[1]/button[1]")
	private  WebElement assign_to_me;
	
	//点击assign to me按钮
	public void click_assign_to_me(){
		this.click(assign_to_me);
	}
	
	//点击子任务保存按钮
	public void click_sub_save(){
		this.click(sub_save);
	}
	
	//获取编辑的input的text
	public String get_sub_name(){
		return td_text.getText();
	}		
	
	//输入编辑的input
	public void input_sub_name(String s){
		this.sendkeys(sub_input, s);
	}
		
	//点击子任务编辑按钮
	public void click_sub_edit(){
		this.click(sub_edit);
	}
	
	//下拉滚动条到指定操作按钮
	public void scroll(){
		this.elementScroll(sub_mat_icon);
	}
	
	//点击操作按钮
	public void click_sub_mat_icon(){
		this.click(sub_mat_icon);
	}
	

}
