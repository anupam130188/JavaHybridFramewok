package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage= null;
	HomePage homePage = null;
	ContactsPage contactsPage = null;
public ContactsPageTest ()
{
	super();
}

@BeforeMethod
public void setUp() throws Exception
{
	initializeDriver();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage = homePage.clickContacts();
	System.out.println("clicked on contacts");
}

@DataProvider
public Object[][] getCRMTestData()
{
	Object data[][] = TestUtil.getTestData("Sheet1");
	return data;
}

@Test(dataProvider="getCRMTestData")
public void validateCreateContact(String fName,String lName)
{
	System.out.println("entered create contacts");
	contactsPage.clickNewContacts();
	contactsPage.createUser(fName, lName);
}

@AfterMethod
public void tearDown()
{
	//driver.quit();
}
}
