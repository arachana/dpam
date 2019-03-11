package helper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actions.GenericMethods;
import pageObjects.CommunityListPageObjects;
import setup.AssertCustom;

public class CommunityDetailShorooqHelper {

	CommunityListPageObjects communityListObject;

	
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public CommunityDetailShorooqHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void formRISliderverification() {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.javascriptClick(driver, "//a[@class='open-slider btn-dark contacts schedule-tour-btn']","RI slider");
		}
	
	public void formRIOverviewVerification() {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.javascriptClick(driver, "//div[@class='livin-btn']/button[@class='open-slider btn-dark schedule-tour-btn']","RI Overview");
		}
	
	public void formRIPricingVerification() {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,160)");
		genericMethods.javascriptClick(driver, "//div[@class='community-tile-action-btn button']/button[@class='open-slider btn-dark schedule-tour-btn']","RI Overview");
		}
	
	public void showLayout() {
		
		genericMethods=new GenericMethods();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,260)");
	        if( driver.findElement(By.xpath("//div[@class='layout-details']"))!= null){
	          System.out.println("Element is Present");
	        }
	   else {
	     System.out.println("Element is Absent");
	        
	}
	}
		
	}		
	