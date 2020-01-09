package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPathPage extends BasePage{

	public AddPathPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Location Add Path button
	@FindBy(xpath="//app-add-path/div/p/button/span")
	private WebElement Add_Path;
	
	//Location PathName Input box
	@FindBy(xpath="//app-add-path-dialog/div/mat-form-field/div/div/div/input")
	private WebElement PathName;
	
	//Location status Drop-down box
	@FindBy(xpath="//app-add-path-dialog/div/div/mat-form-field/div/div/div/mat-select")
	private WebElement status_select;
	
	//Location status Drop down first
	@FindBy(xpath="//body/div[2]/div[4]/div/div/div/mat-option")
	private WebElement status_select_list;
	
	//Location Initial/Renewal Drop-down box
	@FindBy(xpath="//app-add-path-dialog/div/div/mat-form-field[2]/div/div/div/mat-select")
	private WebElement Initial_Renewal_select;
	
	@FindBy(xpath="//body/div[2]/div[4]/div/div/div/mat-option")
	private WebElement nitial_Renewal_select_list;	

	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Summary']")
	private WebElement Summary;
	
	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Instructions']")
	private WebElement Instructions;	

	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Approval Text']")
	private WebElement Approval_Text;
	
	@FindBy(xpath="//app-add-path-dialog/div/p/button")
	private WebElement Add_button;	

	@FindBy(xpath="//app-path-group-dialog/div[2]/button[2]")
	private WebElement OK_button;
	

	@FindBy(xpath="//app-add-path-dialog/div/table/tbody/tr/td[3]/p/mat-form-field/div/div/div/mat-select")
	private WebElement Criteria;
	
	@FindBy(xpath="//*[contains(text(),'Requested Drug')]")
	private WebElement Criteria_list;
	
	@FindBy(xpath="//mat-select[@ng-reflect-placeholder='Condition']")
	private WebElement Condition;
	

	@FindBy(xpath="//*[contains(text(),'The brand name of the requested drug is:')]")
	private WebElement Condition_list;
	
	@FindBy(xpath="//input[@placeholder='Value']")
	private WebElement Value;
	

	@FindBy(xpath="//*[contains(text(),'Save')]")
	private WebElement Save_button;
	
	@FindBy(xpath="//app-add-path/div/table/tbody/tr/td")
	private WebElement pathName_text;
	
	@FindBy(xpath="//app-in-harvesting/p/button")
	private WebElement Complete_button;
	

	@FindBy(xpath="//input[@ng-reflect-placeholder='Assign to']")
	private WebElement Assigon_to;	

	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assigon_button;
	
	@FindBy(xpath="//input[@autocomplete='off']")
	private WebElement Guideline_Name;
	
	@FindBy(xpath="//mat-select/div/div[2]")
	private WebElement Guideline_Type_sele;
		
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/mat-option/span")
	private WebElement Guideline_Type_sele_one;
	
	public void click_Guideline_Type_sele_one(){
		this.click(Guideline_Type_sele_one);
	}
	
	public void click_Guideline_Type_sele(){
		this.click(Guideline_Type_sele);
	}
	
	
	public void input_Guideline_Name(String s){
		this.sendkeys(Guideline_Name, s);
	}
	
	
	public void click_Assigon_button(){
		this.click(Assigon_button);
	}
	
	public void input_Assigon_to(String s){
		this.sendkeys(Assigon_to, s);
	}
	
	public void click_Complete_button(){
		this.click(Complete_button);
	}
	
	public String getPatnNameText(){
		return pathName_text.getTagName();
	}
	
	public void click_Save_button(){
		this.click(Save_button);
	}
	
	public void input_Value(String s){
		this.sendkeys(Value, s);
	}

	public void click_Condition_select_list(){
		this.click(Condition_list);
	}
	
	
	public void click_Condition_select(){
		this.click(Condition);
	}
	
	public void click_Criteria_select_list(){
		this.click(Criteria_list);
	}
	
	public void click_Criteria_select(){
		this.click(Criteria);
	}
	
	public void click_OK_button(){
		this.click(OK_button);
	}
	
	public void click_Add_button(){
		this.click(Add_button);
	}
	
	public void input_Approval_Text(String s){
		this.sendkeys(Approval_Text, s);
	}
	
	public void input_Instructions(String s){
		this.sendkeys(Instructions, s);
	}
	
	public void input_Summary(String s){
		this.sendkeys(Summary, s);
	}
	
	public void click_nitial_Renewal_select_list(){
		this.click(nitial_Renewal_select_list);
	}
	
	public void click_Initial_Renewal_select(){
		this.click(Initial_Renewal_select);
	}
	
	public void click_status_select_list(){
		this.click(status_select_list);
	}
	
	public void click_status_select(){
		this.click(status_select);
	}
	
	public void input_PathName(String s){
		this.sendkeys(PathName, s);
	}
	
	public void click_Add_Path(){
		this.click(Add_Path);
	}
	

}
