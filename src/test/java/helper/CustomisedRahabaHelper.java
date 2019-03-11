package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;
import pageObjects.CommunityListPageObjects;

public class CustomisedRahabaHelper {
	
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public CustomisedRahabaHelper(WebDriver driver) {
		this.driver=driver;

}
	public void formRISliderverification() {
	genericMethods=new GenericMethods();
	xplicitWait=new WebDriverWait(driver, 0);
	GenericMethods.Waitformilliseconds(1000);
	genericMethods.javascriptClick(driver, "//a[@class='open-slider btn-dark contacts request-callback-btn']","RI slider");
	}
	
	public void formRIOvervireVerification() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		GenericMethods.Waitformilliseconds(1000);
		genericMethods.javascriptClick(driver, "//div[@class='livin-btn']/button[@class='btn-link btn-small req-callback open-slider request-callback-btn']","RI Overview");
		}
	
	public void clipArt() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2860)");
		String headingText=genericMethods.getText(driver, "//div[@class='find-home-details']//h2");
		genericMethods.assertAndReport("SubHeading Text Verification", "Not what", headingText);
		String subHeadingText=genericMethods.getText(driver, "//div[@class='find-home-details']//span[@class='sub-text']");
		genericMethods.assertAndReport("SubHeading Text Verification", "YOU'RE LOOKING FOR?", subHeadingText);
		genericMethods.javascriptClick(driver, "//div[@class='find-home-details']//a","View All Communities");
		GenericMethods.Waitformilliseconds(1000);
		String pageTitle=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
		genericMethods.assertAndReport("View All communities Link", "Staff Accommodation", pageTitle);
		
	}
}