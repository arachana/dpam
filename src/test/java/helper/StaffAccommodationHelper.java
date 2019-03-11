package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;
import pageObjects.CommunityListPageObjects;


public class StaffAccommodationHelper {
	CommunityListPageObjects communityListObject;
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public StaffAccommodationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void formID(String formName) {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		GenericMethods.Waitformilliseconds(1000);
		js.executeScript("window.scrollBy(0,250)");
		genericMethods.click(driver, "//button[@data-accomodation='"+formName+"']", "formType");
		
}
	
	public void dataInput(String formLabel,String data) {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='"+formLabel+"']")), data, "Feild Name");
}
	public void calender() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		genericMethods.click(driver, "//input[@id='rac-moveindate']", "moveindate");
		genericMethods.click(driver, "//a[contains (text(),'24')]", "24Feb2018");
	}
	
	public void formSubmission() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//textarea[@id='txtComments']")), "RAC1", "COMMENT");
		genericMethods.click(driver, "//input[@id='Policycheckbox']", "checkbox");
		GenericMethods.Waitformilliseconds(3000);
		genericMethods.click(driver, driver.findElement(By.xpath("//input[@id='request-callback-submit-btn']")), "submit");		
		String thankuText=genericMethods.getText(driver, "//div[@class='thank-you-slider-heading']");
		genericMethods.assertAndReport("Check RAC Success Page", "Thank You",thankuText);
	}
	
	public void errorValidation(String feildId,String verificationText)
	{
		
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);	
		genericMethods.click(driver, driver.findElement(By.xpath("//input[@id='request-callback-submit-btn']")), "submit");	
		String errorText=genericMethods.getText(driver, "//label[@id='"+feildId+"']");
		genericMethods.assertAndReport("Check error validation", verificationText, errorText);
	
	}

	
	public void clickOnExploreOption(String exploreID,String verificationText) {
		genericMethods=new GenericMethods();
		GenericMethods.Waitformilliseconds(1000);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		genericMethods.click(driver, "//div[@class='explore-options hidden-xs']//a[@href='"+exploreID+"']", "exploreLink");
	
		String pageTitle=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
		genericMethods.assertAndReport("Check explore Option",verificationText ,pageTitle);
		
	}
}