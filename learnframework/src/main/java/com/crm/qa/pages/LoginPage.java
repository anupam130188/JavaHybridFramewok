package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement logInBtn;
	
	@FindBy(xpath="//*[@class='rd-navbar-panel']//a[@class='brand-name']")
	WebElement crmTitle;
	
	//Initialization of Page Objects
	public LoginPage() {
		PageFactory.initElements(driver,this); //or we can write PageFactory.initElements(driver,LoginPage.class);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUserName(String un)
	{
		username.sendKeys(un);	
	}
	
	public void enterpassWord(String pwd)
	{
		password.sendKeys(pwd);	
	}
	
	public void loginBtnClick()
	{
		loginBtn.click();	
	}
	
	public HomePage login(String un,String pwd)
	{
		logInBtn.click();
		username.sendKeys(un);	
		password.sendKeys(pwd);
		loginBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}
}

