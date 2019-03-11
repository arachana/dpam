package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;

public class AboutUsPageHelper {
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;

	
	public AboutUsPageHelper(WebDriver driver){
		this.driver = driver;
		}

	public void ClickonAboutUsTabMenu()
	{
		genericMethods=new GenericMethods();
		xplicitWait = new WebDriverWait(driver,0);
		genericMethods.javascriptClick(driver, "//ul[@class='aboutus-tabs']//a[@href='#who-we-are']", "TabMenu1");
		String pageTitle=genericMethods.getText(driver, "//span[contains (text(),'Dubai Asset Management')]");
		genericMethods.assertAndReport("Tab1: Who We are", "DUBAI ASSET MANAGEMENT", pageTitle);
		GenericMethods.Waitformilliseconds(1000);
		genericMethods.javascriptClick(driver, "//ul[@class='aboutus-tabs']//a[@href='#work-with-us']", "TabMenu2");
		String pageTitle1=genericMethods.getText(driver, "//span[contains (text(),'ARE OUR STRENGTH')]");
		GenericMethods.Waitformilliseconds(1000);
		genericMethods.assertAndReport("Tab2: Work With US", "ARE OUR STRENGTH", pageTitle1);
		genericMethods.javascriptClick(driver, "//ul[@class='aboutus-tabs']//a[@href='#about-dubai-holding']", "TabMenu3");
		String pageTitle2=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
		genericMethods.assertAndReport("Tab2: About Dubai Holding", "Making Dubai Home", pageTitle2);
		GenericMethods.Waitformilliseconds(1000);
	}
	public void VerifyFactNumber(String FactNo,String verificationText)
	{
		genericMethods = new GenericMethods();
		xplicitWait = new WebDriverWait(driver,0);
		String actualText=genericMethods.getText(driver, "//span[contains(text(),'"+FactNo+"')]");
		genericMethods.assertAndReport("FactNumber", verificationText, actualText);
	}
	public void VerifyUnit(String Unit,String verificationText)
	{
		genericMethods = new GenericMethods();
		xplicitWait = new WebDriverWait(driver,0);
		String actualText=genericMethods.getText(driver, "//span[contains(text(),'"+Unit+"')]");
		genericMethods.assertAndReport("FactNumber", verificationText, actualText);
	}

}


