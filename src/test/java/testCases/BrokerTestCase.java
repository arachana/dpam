package testCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.ExcelUtil;
import helper.BrokerPageHelper;
import setup.MultipleBrowser;

public class BrokerTestCase extends MultipleBrowser{
	BrokerPageHelper brokerPageHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/en/brokers");		
	}	
	
	@Test(groups="test",priority=20,dataProvider="LoginRegister")
	public void brokerFormValidationwithoutfile(String txtFirstName,String txtLastName, String txtEmail
			,String txtPhone,String txtCompany,String txtRealEstateNo, String txtBrokerRegistrationNo) {
		brokerPageHelper = new BrokerPageHelper(driver);
		brokerPageHelper.dataInput("txtFirstName", txtFirstName);
		brokerPageHelper.dataInput("txtLastName", txtLastName);
		brokerPageHelper.dataInput("txtEmail", txtEmail);
		brokerPageHelper.dataInput("txtPhone", txtPhone);
		brokerPageHelper.dataInput("txtCompany", txtCompany);
		brokerPageHelper.dataInput("txtRealEstateNo", txtRealEstateNo);
		brokerPageHelper.dataInput("txtBrokerRegistrationNo", txtBrokerRegistrationNo);
		brokerPageHelper.formSubmission();	
		brokerPageHelper.emailAkn();
	}
		
	@Test(groups="test",priority=19)
	public void brokerErrorValidation() {
		brokerPageHelper = new BrokerPageHelper(driver);
		brokerPageHelper.errorValidation("txtFirstName-error","First Name is a required field");
		brokerPageHelper.errorValidation("txtLastName-error","Last Name is a required field");
		brokerPageHelper.errorValidation("txtEmail-error", "Email Address is a required field");
		brokerPageHelper.errorValidation("txtPhone-error", "Contact No is a required field");
		brokerPageHelper.errorValidation("txtCompany-error", "Company Name is a required field");
		brokerPageHelper.errorValidation("txtRealEstateNo-error", "Real Estate Registration No is a required field");
		brokerPageHelper.errorValidation("txtBrokerRegistrationNo-error", "Broker Registration No is a required field");
		brokerPageHelper.errorValidation("checkbox-error", "Please accept the Terms of Use");
	}
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
	
	@DataProvider(name = "LoginRegister")
	 public static Object[][] provideDataToRegisterTC(){    
	     ExcelUtil returnData1=new ExcelUtil();
	     return returnData1.readExcelData("src/test/java/testDataFiles/brokerFromValidation.xlsx","testdata");  
	  }
}

