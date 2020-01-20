package com.medimpact.paga.front.automation.page;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementPage extends BasePage{

	public ManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button[1]/span[1]/mat-icon[1]")
	private WebElement Task_menu;
	
	@FindBy(xpath="//*[contains(text(),'Task Management')]")
	private WebElement Task_Management;
	
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/button[1]")
	private WebElement My_Workbench;


	public void click_My_Workbench(){
		this.click(My_Workbench);
	}
		

	@FindBy(xpath="//mat-toolbar/button[2]/span/mat-icon")
	private WebElement Task_add_button;
	
	

	public void click_Task_menu(){
		this.click(Task_menu);
	}
	

	public void clic_Task_Management(){
		this.click(Task_Management);
	}
	

	public void click_Task_add_button(){
		this.click(Task_add_button);
	}
	
	
	
	
}
