package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.ExcelUtil;
import actions.GenericMethods;
import helper.ContactUsPageHelper;
import setup.MultipleBrowser;

public class ContactUsTestCase extends MultipleBrowser{
	ContactUsPageHelper contactUsPageHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/");		
	}	

	@Test(groups="test",priority=21,dataProvider="ContactUs")
	public void contactUsformYardi(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber) {
		contactUsPageHelper = new ContactUsPageHelper(driver);
		contactUsPageHelper.clickOnEnquire();
		contactUsPageHelper.dataInput("txtFirstName", txtFirstName);
		contactUsPageHelper.dataInput("txtLastName", txtLastName);
		contactUsPageHelper.dataInput("txtEmail", txtEmail);
		contactUsPageHelper.dataInput("txtPhoneNumber", txtPhoneNumber);	
		contactUsPageHelper.yardiDataInput();
		contactUsPageHelper.formSubmission();
	}
		
	
	@Test(groups="test",priority=22,dataProvider="ContactUs")
	public void contactUsformCustomer(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber) {
		contactUsPageHelper = new ContactUsPageHelper(driver);
		contactUsPageHelper.clickOnEnquire();
		contactUsPageHelper.dataInput("txtFirstName", txtFirstName);
		contactUsPageHelper.dataInput("txtLastName", txtLastName);
		contactUsPageHelper.dataInput("txtEmail", txtEmail);
		contactUsPageHelper.dataInput("txtPhoneNumber", txtPhoneNumber);	
		contactUsPageHelper.customerInput();
		contactUsPageHelper.formSubmission();
	}
	
	@Test(groups="test",priority=23,dataProvider="ContactUs")
	public void contactUsformOther(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber) {
		contactUsPageHelper = new ContactUsPageHelper(driver);
		contactUsPageHelper.clickOnEnquire();
		contactUsPageHelper.dataInput("txtFirstName", txtFirstName);
		contactUsPageHelper.dataInput("txtLastName", txtLastName);
		contactUsPageHelper.dataInput("txtEmail", txtEmail);
		contactUsPageHelper.dataInput("txtPhoneNumber", txtPhoneNumber);
		contactUsPageHelper.otherInput();
		contactUsPageHelper.formSubmission();
	}
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	
	}
	
	@DataProvider(name = "ContactUs")
	 public static Object[][] provideDataToRegisterTC(){    
	     ExcelUtil returnData1=new ExcelUtil();
	     return returnData1.readExcelData("src/test/java/testDataFiles/contactUsInput.xlsx","testdata");  
	  }
	
	
	
}

