package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;


public class ContactUsPageHelper {

	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public ContactUsPageHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnEnquire() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.javascriptClick(driver, "//a[@href='/en/contact-us']", "Enquire");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
	}
	public void dataInput(String formLabel,String data) {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='"+formLabel+"']")), data, "Feild Name");
	}
		public void yardiDataInput() {
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");
			Select enquiryType=new Select(driver.findElement(By.xpath("//select[@id='ddlRentingVilla']")));
			Select communityName=new Select(driver.findElement(By.xpath("//select[@name='CommunityType']")));
			Select unitType=new Select(driver.findElement(By.xpath("//select[@id='txtUnitType']")));
			Select bedType=new Select(driver.findElement(By.xpath("//select[@id='txtBedRoom']")));
			enquiryType.selectByValue("Renting an apartment or a villa");
			genericMethods.click(driver, "//input[@id='cu-moveindate']", "moveindate");
			genericMethods.click(driver, "//a[contains (text (),'24')]", "24Feb2018");
			communityName.selectByValue("Shorooq");
			unitType.selectByValue("0");
			bedType.selectByValue("1");
			
}
		public void customerInput() {
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");
			Select enquiryType=new Select(driver.findElement(By.xpath("//select[@id='ddlRentingVilla']")));
			enquiryType.selectByValue("Customer service");
			genericMethods.inputValue(driver,driver.findElement(By.xpath("//textarea[@id='txtContactMessage']")),"Conatct Us", "Message");
						
		}
		
		public void otherInput() {
			genericMethods=new GenericMethods();
			xplicitWait=new WebDriverWait(driver, 0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");
			Select enquiryType=new Select(driver.findElement(By.xpath("//select[@id='ddlRentingVilla']")));
			enquiryType.selectByValue("Other");
			genericMethods.inputValue(driver,driver.findElement(By.xpath("//textarea[@id='txtContactMessage']")),"Conatct Us", "Message");
						
		}
		
	public void formSubmission() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,360)");
		genericMethods.click(driver, "//input[@id='Policycheckbox']", "checkbox");
		GenericMethods.Waitformilliseconds(1000);
		genericMethods.click(driver, "//*[text()='Send your message']", "submit");
		GenericMethods.Waitformilliseconds(3000);
		String thankuText=genericMethods.getText(driver, "//div[@class='contact-us-thankyou-msg']/p");
		genericMethods.assertAndReport("Check contactUs Success Page", "Thanks for your query. We will get back to you soon!",thankuText);
	}
	
	public void errorValidation(String feildId,String verificationText)
	{
	
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,160)");
		genericMethods.click(driver, driver.findElement(By.xpath("//button[@id='broker-submit']")), "Register Now");	
		String errorText=genericMethods.getText(driver, "//label[@id='"+feildId+"']");
		genericMethods.assertAndReport("Check error validation", verificationText, errorText);
			
	}
	

}
