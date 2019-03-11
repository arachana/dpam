package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import helper.FAQSPageHelper;
import setup.MultipleBrowser;

public class FAQSCategoryTestCase extends MultipleBrowser {
	FAQSPageHelper faqsPageHelper;
	
	@BeforeClass(groups="beforeClass")
	@Parameters({"BROWSER"})
	public void Start (String broswer) {
		super.setup(broswer,"http://qa3.dpam/en/faqs");
		}
	
		
		@Test(groups="test",priority=40)
		public void verificationOffaqsCat() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#Looking-for-home", "LOOKING FOR HOME");
		faqsPageHelper.FAQsCategory("#Moving-In", "MOVING IN");
		faqsPageHelper.FAQsCategory("#Renewal", "RENEWAL");
		faqsPageHelper.FAQsCategory("#Moving-Out", "MOVING OUT");
		faqsPageHelper.FAQsCategory("#In-your-home", "IN YOUR HOME");
		faqsPageHelper.FAQsCategory("#In-the-community", "IN THE COMMUNITY");
		faqsPageHelper.FAQsCategory("#Miscellaneous", "MISCELLANEOUS");
	}
		
		@Test(groups="test",priority=41)
		public void verificationQuestion1LookingForHome() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.que("Looking-for-home']//div[@class='question", 
				"Looking-for-home']//div[@class='question-list", 
				"Looking-for-home']//div[@class='question']//span[@class='text",18);
		}
	
		
		@Test(groups="test",priority=42)
		public void verificationQuestion2MovingIN() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#Moving-In", "MOVING IN");
		faqsPageHelper.que("Moving-In']//div[@class='question", 
				"Moving-In']//div[@class='question-list", 
				"Moving-In']//div[@class='question']//span[@class='text",5);
		}
		
		

		@Test(groups="test",priority=43)
		public void verificationQuestion3Renewal() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#Renewal", "RENEWAL");
		faqsPageHelper.que("Renewal']//div[@class='question", 
				"Renewal']//div[@class='question-list", 
				"Renewal']//div[@class='question']//span[@class='text",9);
		}
		
		@Test(groups="test",priority=44)
		public void verificationQuestion4MovingOut() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#Moving-Out", "MOVING OUT");
		faqsPageHelper.que("Moving-Out']//div[@class='question", 
				"Moving-Out']//div[@class='question-list", 
				"Moving-Out']//div[@class='question']//span[@class='text",6);
		}
		
		
		@Test(groups="test",priority=45)
		public void verificationQuestion5InOurHome() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#In-your-home", "IN YOUR HOME");
		faqsPageHelper.que("In-your-home']//div[@class='question", 
				"In-your-home']//div[@class='question-list", 
				"In-your-home']//div[@class='question']//span[@class='text",9);
		}
		
		@Test(groups="test",priority=46)
		public void verificationQuestion6InTheCommunity() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#In-the-community", "IN THE COMMUNITY");
		faqsPageHelper.que("In-the-community']//div[@class='question", 
				"In-the-community']//div[@class='question-list", 
				"In-the-community']//div[@class='question']//span[@class='text",5);
		}
		
		@Test(groups="test",priority=47)
		public void verificationQuestion8Miscellaneous() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.FAQsCategory("#Miscellaneous", "MISCELLANEOUS");
		faqsPageHelper.que("Miscellaneous']//div[@class='question", 
				"Miscellaneous']//div[@class='question-list", 
				"Miscellaneous']//div[@class='question']//span[@class='text",11);
		}
		

		@Test(groups="test2",priority=48)
		public void verificationAns1LookingForHome() {
		faqsPageHelper=new FAQSPageHelper (driver);
		faqsPageHelper.Answer("Looking-for-home']//div[@class='answer short-desc", 
				"Looking-for-home']//div[@class='answer short-desc", 
				"Looking-for-home']//div[@class='answer short-desc']//p//node()",
				"Looking-for-home']//span[@class='icon minus");
		}
		
		
		@AfterClass(groups = "afterClass")
		public void shutdown(){
			driver.quit();		
		}
}
