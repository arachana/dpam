package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.AboutUsPageHelper;
import setup.MultipleBrowser;

public class AboutUsPageTestCase extends MultipleBrowser{
	AboutUsPageHelper aboutUsPageHelper;
	
	@BeforeClass(groups="beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser) {
	super.setup(browser,"http://qa3.dpam/en/about-us");
	}
	
	@Test(groups="test",priority=34)
	public void verificationofTabMenus() {
		aboutUsPageHelper = new AboutUsPageHelper(driver);
		aboutUsPageHelper.ClickonAboutUsTabMenu();
	}
		
	@Test(groups="test",priority=35)
	public void verificationofInfoTeaser() {
		aboutUsPageHelper = new AboutUsPageHelper(driver);
		aboutUsPageHelper.VerifyFactNumber("10", "10");
		aboutUsPageHelper.VerifyFactNumber("100,000+", "100,000+");
		aboutUsPageHelper.VerifyFactNumber("20m sqft", "20m sqft");
		aboutUsPageHelper.VerifyUnit("COMMUNITIES", "COMMUNITIES");
		aboutUsPageHelper.VerifyUnit("HAPPY TENANTS", "HAPPY TENANTS");
		aboutUsPageHelper.VerifyUnit("NET LEASABLE AREA", "NET LEASABLE AREA");
	}
	
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
	
}
