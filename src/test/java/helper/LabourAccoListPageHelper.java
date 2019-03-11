package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;
import pageObjects.HomePageObjects;

public class LabourAccoListPageHelper {
	
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	HomePageObjects homepageObject;
	public LabourAccoListPageHelper (WebDriver driver) {
		this.driver=driver;

}
	public void clickOnViewDetail() {
		genericMethods=new GenericMethods();
		GenericMethods.Waitformilliseconds(1000);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		genericMethods.javascriptClick(driver, "//div[@class='community-tile-action-btn button']//a[@href='/en/staff-accommodation/labour-accomodation/nuzul']", "NuzulViewDetail");
		String pageTitle=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
		GenericMethods.Waitformilliseconds(1000);
		genericMethods.assertAndReport("Check explore Option","Nuzul" ,pageTitle);
		System.out.println(pageTitle);
		driver.navigate().back();
		genericMethods.javascriptClick(driver, "//div[@class='community-tile-action-btn button']//a[@href='/en/staff-accommodation/labour-accomodation/al-quoz']", "NuzulViewDetail");
		String pageTitle1=genericMethods.getText(driver, "//div[@class='banner-content']/h1");
		genericMethods.assertAndReport("Check explore Option","Al Quoz Accommodation" ,pageTitle1);
		System.out.println(pageTitle1);
	}
}
