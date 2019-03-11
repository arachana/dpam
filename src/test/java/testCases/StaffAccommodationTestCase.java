package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import helper.StaffAccommodationHelper;
import setup.MultipleBrowser;

public class StaffAccommodationTestCase extends MultipleBrowser{

	StaffAccommodationHelper staffAccommodationHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/en/staff-accommodation");		
	}	
	
	@Test(groups="test",priority=24)
	public void RACErrorValidation() {
		staffAccommodationHelper = new StaffAccommodationHelper(driver);
		staffAccommodationHelper.formID("residential-units");
		staffAccommodationHelper.errorValidation("txtFirstName-error","First Name is a required field");
		staffAccommodationHelper.errorValidation("txtLastName-error","Last Name is a required field");
		staffAccommodationHelper.errorValidation("txtEmail-error", "Email Address is a required field");
		staffAccommodationHelper.errorValidation("txtPhoneNumber-error", "Contact No is a required field");
		staffAccommodationHelper.errorValidation("txtCompany-error", "Company Name is a required field");
		staffAccommodationHelper.errorValidation("txtNoOfEmployees-error", "Number Of Employees is a required field");
		staffAccommodationHelper.errorValidation("rac-moveindate-error", "Move-in Date is a required field");
		staffAccommodationHelper.errorValidation("checkbox-error", "Please accept the Terms of Use");
	}
	
	@Test(groups="test",priority=25)
	public void StaffAccommodationRAC1() {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		driver.navigate().refresh();
		staffAccommodationHelper.formID("residential-units");
		staffAccommodationHelper.dataInput("txtFirstName", "Arachana");
		staffAccommodationHelper.dataInput("txtLastName", "Varma");
		staffAccommodationHelper.dataInput("txtEmail", "archanaprajapati880@gmail.com");
		staffAccommodationHelper.dataInput("txtPhoneNumber", "111111111");
		staffAccommodationHelper.dataInput("txtCompany", "Sigma Solution Pvt Ltd");
		staffAccommodationHelper.dataInput("txtNoOfEmployees", "123");
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
		
	
	@Test(groups="test",priority=26)
	public void StaffAccommodationRAC2() {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		driver.navigate().refresh();
		staffAccommodationHelper.formID("labour-accommodation");
		staffAccommodationHelper.dataInput("txtFirstName", "Arachana");
		staffAccommodationHelper.dataInput("txtLastName", "Varma");
		staffAccommodationHelper.dataInput("txtEmail", "archanaprajapati880@gmail.com");
		staffAccommodationHelper.dataInput("txtPhoneNumber", "111111111");
		staffAccommodationHelper.dataInput("txtCompany", "Sigma Solution Pvt Ltd");
		staffAccommodationHelper.dataInput("txtNoOfEmployees", "123");
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
	
	@Test(groups="test",priority=27)
	public void StaffAccommodationRAC3() {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		driver.navigate().refresh();
		staffAccommodationHelper.formID("customised-accommodation");
		staffAccommodationHelper.dataInput("txtFirstName", "Arachana");
		staffAccommodationHelper.dataInput("txtLastName", "Varma");
		staffAccommodationHelper.dataInput("txtEmail", "archanaprajapati880@gmail.com");
		staffAccommodationHelper.dataInput("txtPhoneNumber", "111111111");
		staffAccommodationHelper.dataInput("txtCompany", "Sigma Solution Pvt Ltd");
		staffAccommodationHelper.dataInput("txtNoOfEmployees", "123");
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
	
	@Test(groups="test",priority=28)
	public void exploreOptionsVerification() {
		
		staffAccommodationHelper=new StaffAccommodationHelper(driver);
		
		staffAccommodationHelper.clickOnExploreOption("/en/our-communities", "Our Communities");
		driver.navigate().back();
		staffAccommodationHelper.clickOnExploreOption("/en/staff-accommodation/labour-accomodation", "Staff Accommodation");
		driver.navigate().back();
		staffAccommodationHelper.clickOnExploreOption("/en/staff-accommodation/rahaba", "Customised Staff Housing");
	}
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
}
