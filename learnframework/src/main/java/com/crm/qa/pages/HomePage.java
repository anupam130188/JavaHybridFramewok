package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//// these are page libraries
public class HomePage extends TestBase {

	@FindBy (xpath="//span[@class='user-display']")
	WebElement userNameValue;
	
	@FindBy (xpath="//a[contains(@href,'/contact') and @class='item']")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(@href,'/deals') and @class='item']")
	WebElement dealsLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
	public ContactsPage clickContacts()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public String verifyUserName()
	{
		return	userNameValue.getText();
		
	}
}
