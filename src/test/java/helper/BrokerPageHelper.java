package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;
import pageObjects.CommunityListPageObjects;

public class BrokerPageHelper {

	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public BrokerPageHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void dataInput(String formLabel,String data) {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='"+formLabel+"']")), data, "Feild Name");
}
	
	public void formSubmission() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		genericMethods.click(driver, "//input[@id='checkbox']", "checkbox");
		GenericMethods.Waitformilliseconds(3000);
		genericMethods.click(driver, driver.findElement(By.xpath("//button[@id='broker-submit']")), "Register Now");		
		String thankuText=genericMethods.getText(driver, "//div[@class='contact-us-form-msg']/p");
		genericMethods.assertAndReport("Check Broker Success Page", "Thank you for registration",thankuText);
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
public void emailAkn() {
	genericMethods=new GenericMethods();
	xplicitWait=new WebDriverWait(driver, 0);
	driver.get("http://www.yopmail.com/en/");
	GenericMethods.waitForPageLoaded(driver);
	genericMethods.javascriptClick(driver, "//input[@id='login']", "login");
	genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='login']")), "varma123", "mailID");
	genericMethods.javascriptClick(driver, "//input[@type='submit']", "Submit");
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ifinbox']")));
	GenericMethods.waitForPageLoaded(driver);
	
	genericMethods.javascriptClick(driver, "//div[@id='m1']//span[contains(text(),'adaptydubaiam')]", "subject");
	
	String subject=genericMethods.getText(driver, "//div[@id='m1']//span[contains(text(),'Broker Registration Request In Proces')]");
	System.out.println(subject);
	
	if(subject.equals("Broker Registration Request In Process"))
	
    {
    	System.out.println("Mail Sent");
    	
    }
    else{
       
    	System.out.println("Mail not Sent");
    }
   
    
}
}
	