package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.ExcelUtil;
import helper.LabourAccoListPageHelper;
import helper.StaffAccommodationHelper;
import setup.MultipleBrowser;

public class LabourAccoListTestCase extends MultipleBrowser{

	StaffAccommodationHelper staffAccommodationHelper;
	LabourAccoListPageHelper labourAccoListPageHelper ;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/en/staff-accommodation/labour-accomodation");		
	}	
	
	@Test(groups="test",priority=29)
	public void RACErrorValidation() {
		staffAccommodationHelper = new StaffAccommodationHelper(driver);
		staffAccommodationHelper.formID("Nuzul");
		staffAccommodationHelper.errorValidation("txtFirstName-error","First Name is a required field");
		staffAccommodationHelper.errorValidation("txtLastName-error","Last Name is a required field");
		staffAccommodationHelper.errorValidation("txtEmail-error", "Email Address is a required field");
		staffAccommodationHelper.errorValidation("txtPhoneNumber-error", "Contact No is a required field");
		staffAccommodationHelper.errorValidation("txtCompany-error", "Company Name is a required field");
		staffAccommodationHelper.errorValidation("txtNoOfEmployees-error", "Number Of Employees is a required field");
		staffAccommodationHelper.errorValidation("rac-moveindate-error", "Move-in Date is a required field");
		staffAccommodationHelper.errorValidation("checkbox-error", "Please accept the Terms of Use");
	}
	
	@Test(groups="test",priority=30,dataProvider="LabourAccoListRAC")
	public void StaffAccommodationRAC1(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber,String txtCompany,String txtNoOfEmployees) {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		driver.navigate().refresh();
		staffAccommodationHelper.formID("Nuzul");
		staffAccommodationHelper.dataInput("txtFirstName", txtFirstName);
		staffAccommodationHelper.dataInput("txtLastName", txtLastName);
		staffAccommodationHelper.dataInput("txtEmail", txtEmail);
		staffAccommodationHelper.dataInput("txtPhoneNumber", txtPhoneNumber);
		staffAccommodationHelper.dataInput("txtCompany", txtCompany);
		staffAccommodationHelper.dataInput("txtNoOfEmployees", txtNoOfEmployees);
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
		
	
	@Test(groups="test",priority=31,dataProvider="LabourAccoListRAC")
	public void StaffAccommodationRAC2(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber,String txtCompany,String txtNoOfEmployees) {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		driver.navigate().refresh();
		staffAccommodationHelper.formID("Al Quoz");
		staffAccommodationHelper.dataInput("txtFirstName", txtFirstName);
		staffAccommodationHelper.dataInput("txtLastName", txtLastName);
		staffAccommodationHelper.dataInput("txtEmail", txtEmail);
		staffAccommodationHelper.dataInput("txtPhoneNumber", txtPhoneNumber);
		staffAccommodationHelper.dataInput("txtCompany", txtCompany);
		staffAccommodationHelper.dataInput("txtNoOfEmployees", txtNoOfEmployees);
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
	
	@Test(groups="test",priority=32)
	public void exploreOptionVerification() {
	
		labourAccoListPageHelper = new LabourAccoListPageHelper(driver);
		labourAccoListPageHelper.clickOnViewDetail();


	
	}
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
	
	@DataProvider(name = "LabourAccoListRAC")
	 public static Object[][] provideDataToRegisterTC(){    
	     ExcelUtil returnData1=new ExcelUtil();
	     return returnData1.readExcelData("src/test/java/testDataFiles/LabourAccoListRAC.xlsx","testdata");  
	  }
	
	
	
}
