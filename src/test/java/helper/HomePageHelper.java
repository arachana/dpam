package helper;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actions.GenericMethods;
import pageObjects.HomePageObjects;
import setup.AssertCustom;

public class HomePageHelper {
	HomePageObjects homepageObject;
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public HomePageHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/*    ************** HeaderlinkVerification***********************************/
	
		public void clickTopNavMenus(String topNavName,String verificationText) {
		homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 30);
		
		genericMethods.javascriptClick(driver, "//ul[@class='primary-menu']/li/a[@title='"+topNavName+"']", verificationText);
		GenericMethods.Waitformilliseconds(9000);
		String pageTitle;
		try {
			xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
			pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
		} catch (StaleElementReferenceException e) {
			xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
			pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
		}
		genericMethods.assertAndReport("Check Page title", verificationText, pageTitle);
	
	}

		
		public void mouseHoverTopNavMenus(String topNavName,String verificationText) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
			genericMethods.mouseHoverJScript(driver, homepageObject.Header_Eservice_link);
			genericMethods.javascriptClick(driver, " //div[@class='dropdown-content corporate-dropdown']/ul/li/a[@href='"+topNavName+"']", verificationText);
			GenericMethods.Waitformilliseconds(3000);
			String pageTitle;
			try {
				xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
				pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			} catch (StaleElementReferenceException e) {
				xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
				pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			}
			genericMethods.assertAndReport("Check Page title", verificationText, pageTitle);
		
		}
		

		
	
		
/*    ************** HomeSliderVerification***********************************/
	
		public void clickOnLogo(){
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			genericMethods.click(driver,homepageObject.header_logo_img,"logo");
			GenericMethods.Waitformilliseconds(1000);	
		}
		
	public void homeHeroSliderVerification(String sliderLinkToClick,String verificationText){
		homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
		genericMethods=new GenericMethods();
		WebElement heroTextForVerification=driver.findElement(By.xpath("//div[@class='slick-slide']//*[contains(text(),'"+verificationText+"')]"));
		genericMethods.javascriptClick(driver, "//button[@aria-label='"+sliderLinkToClick+"']", verificationText);
		String heroSlider1Text=genericMethods.getText(driver,heroTextForVerification);		
		genericMethods.assertAndReport("Check Hero slider text", verificationText, heroSlider1Text);
	}
		 
		public void selectCommunityFilter(String[] commuityList) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			genericMethods.click(driver, homepageObject.AllCommunities_filter, "All Community Filter");
			
			for (int i = 0; i < commuityList.length; i++) {
				GenericMethods.Waitformilliseconds(1000);
				WebElement communityListOption=driver.findElement(By.xpath("//div[@id='dropdown-community']//ul//div/span[contains(text(),'"+commuityList[i]+"')]"));
				genericMethods.click(driver, communityListOption, commuityList[i]+" option");
				}
			GenericMethods.Waitformilliseconds(3000);
		}
		
		public void selectUnitType(String[] unitType) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			genericMethods.click(driver, homepageObject.AllUnitTypes_filter, "All Unit Types Filter");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			for (int i = 0; i < unitType.length; i++) {
				GenericMethods.Waitformilliseconds(1000);
				WebElement communityListOption=driver.findElement(By.xpath("//div[@id='dropdown-unit-type']//ul//div/span[contains(text(),'"+unitType[i]+"')]"));
				genericMethods.click(driver, communityListOption, unitType[i]+" option");
			}
			GenericMethods.Waitformilliseconds(3000);
		}
		
		public void selectSize(String[] sizeOptions) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			genericMethods.click(driver, homepageObject.AnySizeBed_filter, "All Unit Types Filter");
			
			for (int i = 0; i < sizeOptions.length; i++) {
				GenericMethods.Waitformilliseconds(1000);
				WebElement sizeListOption=driver.findElement(By.xpath("//div[@id='bedroom-count']/ul/li/span[contains(text(),'"+sizeOptions[i]+"')]"));
				genericMethods.click(driver, sizeListOption, sizeOptions[i]+" option");
			}
			GenericMethods.Waitformilliseconds(3000);
		}
		
		public void clickSearchButtonAndVerifyResult(String expectedString) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			genericMethods.click(driver, homepageObject.search_btn, "search button");
			String searchResultString=genericMethods.getText(driver, homepageObject.SearchResult_text);		
			genericMethods.assertAndReport("verify search result text", expectedString, searchResultString);
		}
		
	/* *********** All Communities Filter ****************/

		public void selectCommunityFilter(){
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
//			

		genericMethods.click(driver, homepageObject.search_btn, "search button");		
		String searchResultText=genericMethods.getText(driver, homepageObject.SearchResult_text);		
		Assert.assertEquals(searchResultText, "Showing 6 communities");
		
		/* ***********Scenario 2 "click on search after selecting "all"  as value" ***************/
		
		genericMethods.click(driver, homepageObject.AllCommunities_filter, "All Community Filter");
		genericMethods.click(driver, homepageObject.AllCommunities_dropDown0_value, "All communities");
		genericMethods.click(driver, homepageObject.AllUnitTypes_filter, "All Unit Types Filter");
		genericMethods.click(driver, homepageObject.AllUnitTypes_value, "All Unit Types");
		genericMethods.click(driver, homepageObject.AnySizeBed_filter,"Any Size Filter");	
		genericMethods.click(driver, homepageObject.Any_dropDown1_value, "any size");
		genericMethods.assertAndReport("verify search result text", "Showing 6 communities",searchResultText);
		
	}

		public void liveTheDiffVerification()  {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			genericMethods.click(driver,homepageObject.header_logo_img,"logo");
			GenericMethods.Waitformilliseconds(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			String LiveHeadingText=genericMethods.getText(driver, homepageObject.liveThe_text);
			Assert.assertEquals(LiveHeadingText, "Live the");
			String EnrichedLink=genericMethods.getText(driver, homepageObject.enriched_link);
			Assert.assertEquals(EnrichedLink, "ENRICHED LIVING");
			genericMethods.click(driver, homepageObject.convenience_link, "convenienceLink");
			GenericMethods.Waitformilliseconds(2000);
			String ConvenienceLink=genericMethods.getText(driver, homepageObject.convenience_link);
			Assert.assertEquals(ConvenienceLink, "CONVENIENCE");
			genericMethods.click(driver, homepageObject.Added_link, "AddedLink");
			GenericMethods.Waitformilliseconds(2000);
			String AddedValuelink=genericMethods.getText(driver, homepageObject.Added_link);
			Assert.assertEquals(AddedValuelink, "ADDED VALUE");
			genericMethods.click(driver, homepageObject.peachOfMind_link, "peaceOfMind");
			GenericMethods.Waitformilliseconds(2000);
			String PeaceOfMindLink = genericMethods.getText(driver, homepageObject.peachOfMind_link);
			Assert.assertEquals(PeaceOfMindLink, "PEACE OF MIND");
			
		}

		public void readyToFindVerification()  {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			genericMethods.click(driver,homepageObject.header_logo_img,"logo");
			GenericMethods.Waitformilliseconds(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1800)");
			String readyTofindtext=genericMethods.getText(driver, homepageObject.findHome_text);
			Assert.assertEquals( readyTofindtext, "Ready to find");
			genericMethods.click(driver, homepageObject.ViewAllCommunities_link, "ViewAllCommunitiesLink");
			GenericMethods.Waitformilliseconds(1000);
			String OurCommunities=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
			Assert.assertEquals(OurCommunities, "Our Communities");
		
		}

		/*    ************** KnowUsBetter***********************************/
		
		public void knowUsTabMenusVerification(String knowMoreLink,String tabNavName,String verificationText,String knowMoreVerificationPage1) {
		homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 30);
		genericMethods.click(driver,homepageObject.header_logo_img,"logo");
		GenericMethods.Waitformilliseconds(1000);
		String knowUsHeading=genericMethods.getText(driver, homepageObject.knowUs_text);
		Assert.assertEquals(knowUsHeading, "Know");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2400)");
		GenericMethods.Waitformilliseconds(2000);
		genericMethods.javascriptClick(driver, "//a[@href='"+tabNavName+"']", verificationText);
		GenericMethods.Waitformilliseconds(2000);
		genericMethods.javascriptClick(driver, "//a[@href='"+knowMoreLink+"']", "knowMoreLink");
		GenericMethods.Waitformilliseconds(2000);
		String knowMoreVerificationPage=genericMethods.getText(driver,homepageObject.aboutUs_page_text);
		Assert.assertEquals(knowMoreVerificationPage, knowMoreVerificationPage1);
	
	}
		
		public void staffAccommVerification() {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
			genericMethods.click(driver,homepageObject.header_logo_img,"logo");
			GenericMethods.Waitformilliseconds(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2800)");
			String staffaccommHeadingText=genericMethods.getText(driver, homepageObject.staff_CTA_heading);
			Assert.assertEquals(staffaccommHeadingText, "Staff accommodation");
			genericMethods.click(driver, homepageObject.staff_LearnMore_link, "learnMoreLink");
			String pageTitle=genericMethods.getText(driver, homepageObject.Header_staffAccommodation_link);
			Assert.assertEquals(pageTitle, "STAFF ACCOMMODATION");
		}

		/*    ************** Stackala Visibility***********************************/
		
		public void checkSocialFeed()
		{
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			driver.navigate().refresh();
			GenericMethods.Waitformilliseconds(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4500)");
			String socialfeedTitle= genericMethods.getText(driver, "//div[@class='section-heading']/h2");
			genericMethods.assertAndReport("Check Social Feed Visibility", "#DubaiAMLife", socialfeedTitle);
			
		}
		
		public void checkSocialMediaLink(String SocialLink,	String expectedURL)
		{
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4000)");
			genericMethods.javascriptClick(driver, "//a[@href='"+SocialLink+"']", "Link");
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
			GenericMethods.Waitformilliseconds(2000);
			driver.switchTo().window((String) tabs.get(1));
			GenericMethods.Waitformilliseconds(2000);
			String redirectURL=driver.getCurrentUrl();
//			String expectedURL = "https://www.facebook.com/Dubaiamlife/";
			genericMethods.assertAndReport("Socail Media link Verification", expectedURL, redirectURL);

		}
		
		public void clickFooterMenus(String footerLinkName,String verificationText) {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");
			genericMethods.javascriptClick(driver, "//div[@class='links']//a[@href='"+footerLinkName+"']", verificationText);
		
			GenericMethods.Waitformilliseconds(2000);
			String pageTitle;
			try {
				xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
				pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			} catch (StaleElementReferenceException e) {
				xplicitWait.until(ExpectedConditions.visibilityOf(homepageObject.topNavBannerPageHeader));
				pageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			}
			genericMethods.assertAndReport("Check Page title", verificationText, pageTitle);
		
		}

		public void clickCopyrigthMenus() {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");
			String copyrigthtext =genericMethods.getText(driver,homepageObject.copyright_text);
			genericMethods.assertAndReport("Verification of CopyRigth Text", "© 2018. DUBAI ASSET MANAGEMENT. BY DUBAI HOLDING.",copyrigthtext);
		}
		
		public void clicklegelinfoMenus() {
			homepageObject=PageFactory.initElements(driver, HomePageObjects.class);
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");
			genericMethods.click(driver, homepageObject.footer_TC_link, "Terms & conditions link");
			String PageTitle=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			genericMethods.assertAndReport("Verification of Terms and condition", "Legal information", PageTitle);
			genericMethods.click(driver, homepageObject.footer_privacyCookies_link, "privacyCookies link");
			String PageTitle1=genericMethods.getText(driver, homepageObject.topNavBannerPageHeader);
			genericMethods.assertAndReport("Verification of Terms and condition", "Legal information", PageTitle1);
		}
		
}

