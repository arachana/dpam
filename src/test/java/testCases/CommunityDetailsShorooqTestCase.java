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
import helper.CommunityDetailShorooqHelper;
import helper.CommunityListPageHelper;
import setup.MultipleBrowser;

public class CommunityDetailsShorooqTestCase extends MultipleBrowser{
	CommunityListPageHelper communityListHelper;
	CommunityDetailShorooqHelper communityDetailShorooqHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser) {
		super.setup(browser,"http://qa3.dpam/en/our-communities/al-khail-gate");	
		GenericMethods.Waitformilliseconds(3000);
	}
	
	@Test(groups="test",priority=16,dataProvider="CommunitydetailsRI")
	public void formVerificationOnDetailRISlider(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber) {
	communityListHelper=new CommunityListPageHelper(driver);
	driver.navigate().refresh();
	communityDetailShorooqHelper=new CommunityDetailShorooqHelper(driver);
	communityDetailShorooqHelper.formRISliderverification();
	communityListHelper.formRIdataInput("txtFirstName", txtFirstName);
	communityListHelper.formRIdataInput("txtLastName", txtLastName);
	communityListHelper.formRIdataInput("txtEmail", txtEmail);
	communityListHelper.formRIdataInput("txtPhoneNumber", txtPhoneNumber);
	communityListHelper.formSubmission();
	
	}
	
	@Test(groups="test",priority=17,dataProvider="CommunitydetailsRI")
	public void formVerificationOnDetailRIOverview(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber)  {
	communityListHelper=new CommunityListPageHelper(driver);
	communityDetailShorooqHelper=new CommunityDetailShorooqHelper(driver);
	communityDetailShorooqHelper.formRIOverviewVerification();
	communityListHelper.formRIdataInput("txtFirstName", txtFirstName);
	communityListHelper.formRIdataInput("txtLastName", txtLastName);
	communityListHelper.formRIdataInput("txtEmail", txtEmail);
	communityListHelper.formRIdataInput("txtPhoneNumber", txtPhoneNumber);
	communityListHelper.formSubmission();
	
	}
	
	@Test(groups="test",priority=18,dataProvider="CommunitydetailsRI")
	public void formVerificationOnDetailRIPricing(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber)  {
	communityListHelper=new CommunityListPageHelper(driver);
	communityDetailShorooqHelper=new CommunityDetailShorooqHelper(driver);
	driver.navigate().refresh();
	communityDetailShorooqHelper.formRIPricingVerification();
	communityListHelper.formRIdataInput("txtFirstName", txtFirstName);
	communityListHelper.formRIdataInput("txtLastName", txtLastName);
	communityListHelper.formRIdataInput("txtEmail", txtEmail);
	communityListHelper.formRIdataInput("txtPhoneNumber", txtPhoneNumber);
	communityListHelper.formSubmission();
	
	}
	
	@Test(groups="test",priority=49)	
	public void verificationOfFloorPlanAvilability() {
		communityDetailShorooqHelper=new CommunityDetailShorooqHelper(driver);
		communityDetailShorooqHelper.showLayout();
		
	}
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	
	}

	
	@DataProvider(name = "CommunitydetailsRI")
	 public static Object[][] provideDataToRegisterTC(){    
	     ExcelUtil returnData1=new ExcelUtil();
	     return returnData1.readExcelData("src/test/java/testDataFiles/communityListInput.xlsx","testdata");  
	  }





}