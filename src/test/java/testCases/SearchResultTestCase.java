package testCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import helper.SearchResultPageHelper;
import setup.MultipleBrowser;

public class SearchResultTestCase extends MultipleBrowser{

	SearchResultPageHelper searchResultPageHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam/en/staff-accommodation");		
	}	
	
	@Test(groups="test",priority=33)
	public void siteSearchResult() {
		searchResultPageHelper = new SearchResultPageHelper(driver);
		searchResultPageHelper.searchResultVerificationMetaData();
		searchResultPageHelper.searchResultVerificationMetaTitle();
		searchResultPageHelper.searchResultVerificationShowMore();
		
	}
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
	
}