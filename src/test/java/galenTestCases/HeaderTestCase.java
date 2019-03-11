package galenTestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import galenHelper.HomeGalenHelper;

import setup.MultipleBrowser;

public class HeaderTestCase extends MultipleBrowser{
	HomeGalenHelper homeGalenHelper;
	
	@BeforeClass(groups="beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser) {
	super.setup(browser,"http://qa.mafcorpdemo.online/en");
	}
	
	
	@Test(groups="test123",priority=34)
	public void verificationofTabMenus() throws IOException {
		homeGalenHelper = new HomeGalenHelper(driver);
		homeGalenHelper.executeGalenSpec("specs/homepage_combined.gspec", "desktop");
		
	}
		
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
	
}
