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


import helper.CustomisedRahabaHelper;
import helper.StaffAccommodationHelper;
import setup.MultipleBrowser;


	
	public class CustomisedRahabaTestCase extends MultipleBrowser{
		CustomisedRahabaHelper customisedRahabaHelper;
		StaffAccommodationHelper staffAccommodationHelper;
		
		
		@BeforeClass(groups = "beforeClass")
		@Parameters({"BROWSER"})
		public void Start(String browser) {
			super.setup(browser,"http://qa3.dpam/en/staff-accommodation/rahaba");	
			GenericMethods.Waitformilliseconds(3000);
		}
		
		@Test(groups="test",priority=35,dataProvider="CustomisedRahabaRI")
		public void formVerificationOnDetailRISlider(String txtFirstName,String txtLastName, String txtEmail
				,String txtPhoneNumber,String txtCompany ,String txtNoOfEmployees) {
		customisedRahabaHelper=new CustomisedRahabaHelper(driver);
		staffAccommodationHelper = new StaffAccommodationHelper (driver);
		driver.navigate().refresh();
		customisedRahabaHelper.formRISliderverification();
		staffAccommodationHelper.dataInput("txtFirstName", txtFirstName);
		staffAccommodationHelper.dataInput("txtLastName", txtLastName);
		staffAccommodationHelper.dataInput("txtEmail", txtEmail);
		staffAccommodationHelper.dataInput("txtPhoneNumber", txtPhoneNumber);
		staffAccommodationHelper.dataInput("txtCompany", txtCompany);
		staffAccommodationHelper.dataInput("txtNoOfEmployees", txtNoOfEmployees);
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}
		
		@Test(groups="test",priority=36,dataProvider="CustomisedRahabaRI")
		public void formVerificationOnDetailOverview(String txtFirstName,String txtLastName, String txtEmail
				,String txtPhoneNumber,String txtCompany ,String txtNoOfEmployees) {
		customisedRahabaHelper=new CustomisedRahabaHelper(driver);
		staffAccommodationHelper = new StaffAccommodationHelper (driver);
		driver.navigate().refresh();
		customisedRahabaHelper.formRIOvervireVerification();
		staffAccommodationHelper.dataInput("txtFirstName", txtFirstName);
		staffAccommodationHelper.dataInput("txtLastName", txtLastName);
		staffAccommodationHelper.dataInput("txtEmail", txtEmail);
		staffAccommodationHelper.dataInput("txtPhoneNumber", txtPhoneNumber);
		staffAccommodationHelper.dataInput("txtCompany", txtCompany);
		staffAccommodationHelper.dataInput("txtNoOfEmployees", txtNoOfEmployees);
		staffAccommodationHelper.calender();
		staffAccommodationHelper.formSubmission();		
	}	
		@Test(groups="test",priority=37)
		public void clipArtVerification() {
			customisedRahabaHelper=new CustomisedRahabaHelper(driver);
			driver.navigate().refresh();
			customisedRahabaHelper.clipArt();
		}
		
		@AfterClass(groups = "afterClass")
		public void shutdown(){
			driver.quit();		
		
		}
		
		@DataProvider(name = "CustomisedRahabaRI")
		 public static Object[][] provideDataToRegisterTC(){    
		     ExcelUtil returnData1=new ExcelUtil();
		     return returnData1.readExcelData("src/test/java/testDataFiles/CustomisedRahabaRAC.xlsx","testdata");  
		  }
	
}
