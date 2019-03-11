package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import helper.HomePageHelper;
import setup.MultipleBrowser;

public class HomepageTestCase extends MultipleBrowser{
HomePageHelper homepageHelper;
	
	@BeforeClass(groups = "beforeClass")
	@Parameters({"BROWSER"})
	public void Start(String browser){
		super.setup(browser,"http://qa3.dpam");		
	}
	
	@Test(groups="test",priority=1)
	public void homePageMenuVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickTopNavMenus("OUR COMMUNITIES", "Our Communities");
		homepageHelper.clickTopNavMenus("Staff Accommodation", "Staff Accommodation");
		homepageHelper.clickTopNavMenus("ABOUT US", "Making Dubai Home");
		homepageHelper.clickTopNavMenus("ABOUT DUBAI HOLDING", "Making Dubai Home");
		homepageHelper.mouseHoverTopNavMenus("/en/brokers", "Broker registration");
		homepageHelper.mouseHoverTopNavMenus("/en/procurement", "Procurement");
		
	}
	
	@Test(groups="test",priority=2)
	public void homeSliderVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
		homepageHelper.homeHeroSliderVerification("1 of 4", "Live by the Water");
		homepageHelper.homeHeroSliderVerification("2 of 4", "Convenience of Rent");
		homepageHelper.homeHeroSliderVerification("3 of 4", "Homes for You");
		homepageHelper.homeHeroSliderVerification("4 of 4", "Perfect for Corporates");
		
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult1() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		homepageHelper.clickOnLogo();
		//driver.navigate().refresh();
		String[] communityList= {"Shorooq","Remraam"};
		String[] unitTypeList= {"Apartments","Villas"};
		String[] sizeList= {"Studio","1 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		js.executeScript("window.scrollBy(0,200)");
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 2 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult2() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
	
		String[] communityList= {"Shorooq","Remraam","Layan"};
		String[] unitTypeList= {"Apartments"};
		String[] sizeList= {"Studio","1 Bed","3 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 3 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult3() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		
		homepageHelper.clickOnLogo();
		String[] communityList= {"Shorooq","Remraam","Layan"};
		String[] unitTypeList= {"Villas"};
		String[] sizeList= {"Studio","1 Bed","2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 2 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult4() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
	
		String[] communityList= {"All communities"};
		String[] unitTypeList= {"All unit types"};
		String[] sizeList= {"Any size"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 6 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult5() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
		
		String[] communityList= {"Shorooq","Remraam","Layan","Ghoroob","Al Khail Gate","Dubai Wharf"};
		String[] unitTypeList= {"Apartments","Villas"};
		String[] sizeList= {"Studio","1 Bed","2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 6 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult6() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
		
		String[] communityList= {"Shorooq","Layan"};
		String[] unitTypeList= {"Villas"};
		String[] sizeList= {"Studio","1 Bed","2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 2 communities");
	}
	
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult7() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
	
		String[] communityList= {"Shorooq","Remraam","Layan","Ghoroob","Al Khail Gate","Dubai Wharf"};
		String[] unitTypeList= {"Apartments","Villas"};
		String[] sizeList= {"Studio","1 Bed","2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 6 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult8() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();

		String[] communityList= {"Ghoroob","Al Khail Gate","Dubai Wharf"};
		String[] unitTypeList= {"Villas"};
		String[] sizeList= {"Studio","1 Bed","2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 0 communities");
	}
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult9() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
	
		String[] communityList= {"Layan"};
		String[] unitTypeList= {"Villas"};
		String[] sizeList= {"2 Bed","3 Bed","4 Bed"};
		
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 1 communities");
	}
	
	
	@Test(groups="test",priority=3)
	public void selectFiltersResult10() throws InterruptedException {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
	
		String[] communityList= {"Shorooq","Layan","Al Khail Gate"};
		String[] unitTypeList= {"Apartments","Villas"};
		String[] sizeList= {"Studio","1 Bed","4 Bed"};
			
		homepageHelper.selectCommunityFilter(communityList);
		homepageHelper.selectUnitType(unitTypeList);
		homepageHelper.selectSize(sizeList);
		homepageHelper.clickSearchButtonAndVerifyResult("Showing 3 communities");
	}
	
	@Test(groups="test",priority=4)
	public void livetheSectionVerification()  {
		homepageHelper=new HomePageHelper(driver);	
		
		homepageHelper.liveTheDiffVerification();
	}
	
	@Test(groups="test",priority=5)
	public void readyToFindVerification()  {
		homepageHelper=new HomePageHelper(driver);	
	
		homepageHelper.readyToFindVerification();
	}
		
	@Test(groups="test",priority=6)
	public void knowUsBetterVerification() {
		homepageHelper=new HomePageHelper(driver);	
	
		homepageHelper.knowUsTabMenusVerification("/en/about-us#who-we-are", "#who-are-we", "#who-are-we", "Making Dubai Home");
		homepageHelper.knowUsTabMenusVerification("/en/about-us#leadership", "#our-leadership", "#our-leadership", "Making Dubai Home");
		homepageHelper.knowUsTabMenusVerification("/en/about-us#about-dubai-holding", "#about-dubai-holding", "#about-dubai-holding", "Making Dubai Home");
	}
		
	@Test(groups="test",priority=7)
	public void staffAccommadtionVerification() {
		homepageHelper=new HomePageHelper(driver);	
		
		homepageHelper.staffAccommVerification();
	}
	
	@Test(groups="test",priority=8)
	public void homePageTestFooterMenuVerification() {
		homepageHelper=new HomePageHelper(driver);
	
		homepageHelper.clickFooterMenus("/en/our-communities", "Our Communities");
		homepageHelper.clickFooterMenus("/en/staff-accommodation", "Staff Accommodation");
		homepageHelper.clickFooterMenus("/en/about-us", "Making Dubai Home");
		homepageHelper.clickFooterMenus("/en/about-us#work-with-us", "Making Dubai Home");
		homepageHelper.clickFooterMenus("/en/brokers", "Broker registration");
		homepageHelper.clickFooterMenus("/en/procurement", "Procurement");
		homepageHelper.clickFooterMenus("/en/media-center", "Media center");
		homepageHelper.clickFooterMenus("/en/faqs", "Questions?");
	}
	
	@Test(groups="test1",priority=9)
	public void socialFeedVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.checkSocialFeed();
	}
	
	@Test(groups="test",priority=10)
	public void copyrigthMenusVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickCopyrigthMenus();
	}
	
	
	@Test(groups="test",priority=11)
	public void legelinfoMenusVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clicklegelinfoMenus();
	}
	
	
	@Test(groups="test",priority=12)
	public void socialMediaLinkVerification() {
		homepageHelper=new HomePageHelper(driver);
		homepageHelper.clickOnLogo();
		homepageHelper.checkSocialMediaLink("https://www.facebook.com/Dubaiamlife/", "https://www.facebook.com/Dubaiamlife/");
		driver.navigate().to("http://qa3.dpam/");
		homepageHelper.checkSocialMediaLink("https://www.instagram.com/Dubaiamlife/", "https://www.instagram.com/Dubaiamlife/");
		driver.navigate().to("http://qa3.dpam/");
		homepageHelper.checkSocialMediaLink("https://www.linkedin.com/company/dubai-asset-management", "https://www.linkedin.com/company/dubai-asset-management");
		driver.navigate().to("http://qa3.dpam/");
		homepageHelper.checkSocialMediaLink("https://www.youtube.com/channel/UCZlHlNmWhso6fYNu5LPRTAw", "https://www.youtube.com/channel/UCZlHlNmWhso6fYNu5LPRTAw");
	}
	
	
	@AfterClass(groups = "afterClass")
	public void shutdown(){
		driver.quit();		
	}
}
