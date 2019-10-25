package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy (xpath="//button[@class='ui linkedin button' and contains(text(),'New')]")
	WebElement newContacts;
	
	@FindBy (name="first_name")
	WebElement fName;
	
	@FindBy (name="last_name")
	WebElement lName;
	
	@FindBy (xpath="//i[@class='save icon']")
	WebElement saveBtn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
public void clickNewContacts()
{
	newContacts.click();
	System.out.println("Clicked on new Contacts");
}

public void createUser(String firstName,String lastName)
{
	fName.sendKeys(firstName);
	lName.sendKeys(lastName);
	saveBtn.click();
}
}
