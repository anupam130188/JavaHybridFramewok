package com.crm.qa.testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase{

	LoginPage loginPage = null;
	HomePage homePage = null;
	ContactsPage contactsPage = null;
	public ExtentReports report;
	public ExtentTest test;
	String reportPath = new File("C:/Users/anchandan/JavaFMDev/learnframework").getAbsolutePath().toString().trim()+"/reports/";
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initializeDriver();
		//*********Extent Reports Implementation*************//
		report = new ExtentReports(reportPath+this.getClass().getSimpleName()+".html",false);
		//****starting logging of test******//
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		test = report.startTest(new Object() {} 
        .getClass() 
        .getEnclosingMethod() 
        .getName());
		String title = homePage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
		 test.log(LogStatus.PASS, "Validate Title match inside HomePage","Title matched");
	}
	
	
	
	@Test(priority=2)
	public void verifyUserNameValue()
	{
		test = report.startTest(new Object() {} 
        .getClass() 
        .getEnclosingMethod() 
        .getName());
		String userNameVal = homePage.verifyUserName();	
		System.out.println(userNameVal);
		Assert.assertEquals(userNameVal, "Anupam Chandan");
		test.log(LogStatus.PASS, "Verify Username displayed in HomePage","UserName is valid");
	}
	
/*	@Test(priority=3)
	public void clickContactsLink()
	{
		contactsPage = homePage.clickContacts();
		
	}*/
	
	
	@AfterMethod
	public void tearDown()
	{
		 report.endTest(test);
		 report.flush();
		 report.close();
		driver.quit();
	}
}
