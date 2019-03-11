package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.ExcelUtil;
import helper.CommunityListPageHelper;
import setup.MultipleBrowser;

public class CommunityListTestCase extends MultipleBrowser{
	CommunityListPageHelper communityListHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/en/our-communities");		
	}
	
	@Test(groups="test",priority=13)
	public void sortVerification() {
		communityListHelper=new CommunityListPageHelper(driver);
		communityListHelper.sortVerification();
			
	}
	

	
	@Test(groups="test",priority=14)
	public void RIerrorVerification() {
		communityListHelper=new CommunityListPageHelper(driver);
		communityListHelper.formRIverification("Shorooq");
		communityListHelper.errorValidation();
		communityListHelper.formRIverification("Shorooq");
		communityListHelper.errorValidationwithoutUnitType();
	}
	
	@Test(groups="test",priority=15,dataProvider="CommunityListRI")
	public void formVerification(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhoneNumber) {
		communityListHelper=new CommunityListPageHelper(driver);
		communityListHelper.formRIverification("Shorooq");
		communityListHelper.formRIdataInput("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInput("txtLastName", txtLastName);
		communityListHelper.formRIdataInput("txtEmail", txtEmail);
		communityListHelper.formRIdataInput("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmission();
		
		
		communityListHelper.formRIverification("Layan");
		communityListHelper.formRIdataInput("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInput("txtLastName", txtLastName);
		communityListHelper.formRIdataInput("txtEmail", txtEmail);
		communityListHelper.formRIdataInput("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmission();
		
		communityListHelper.formRIverification("Remraam");
		communityListHelper.formRIdataInputwithoutUnitType("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInputwithoutUnitType("txtLastName", txtLastName);
		communityListHelper.formRIdataInputwithoutUnitType("txtEmail", txtEmail);
		communityListHelper.formRIdataInputwithoutUnitType("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmissionwithoutunitType();
		
		communityListHelper.formRIverification("Ghoroob");
		communityListHelper.formRIdataInputwithoutUnitType("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInputwithoutUnitType("txtLastName", txtLastName);
		communityListHelper.formRIdataInputwithoutUnitType("txtEmail", txtEmail);
		communityListHelper.formRIdataInputwithoutUnitType("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmissionwithoutunitType();
		

		communityListHelper.formRIverification("Al Khail Gate");
		communityListHelper.formRIdataInputwithoutUnitType("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInputwithoutUnitType("txtLastName", txtLastName);
		communityListHelper.formRIdataInputwithoutUnitType("txtEmail", txtEmail);
		communityListHelper.formRIdataInputwithoutUnitType("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmissionwithoutunitType();
		
		communityListHelper.formRIverification("Dubai Wharf");
		communityListHelper.formRIdataInputwithoutUnitType("txtFirstName", txtFirstName);
		communityListHelper.formRIdataInputwithoutUnitType("txtLastName", txtLastName);
		communityListHelper.formRIdataInputwithoutUnitType("txtEmail", txtEmail);
		communityListHelper.formRIdataInputwithoutUnitType("txtPhoneNumber", txtPhoneNumber);
		communityListHelper.formSubmissionwithoutunitType();
		
	
	}
	
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}


	@DataProvider(name = "CommunityListRI")
	 public static Object[][] provideDataToRegisterTC(){    
	     ExcelUtil returnData1=new ExcelUtil();
	     return returnData1.readExcelData("src/test/java/testDataFiles/communityDetailsInput.xlsx","testdata");  
	  }



}
