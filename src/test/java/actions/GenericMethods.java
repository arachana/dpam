package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;

public class GenericMethods {
	WebDriverWait xwait;
	
		//Method to input value in a text box
	public void inputValue(WebDriver driver, WebElement element, String value,String elementName)throws NoSuchElementException {
		xwait = new WebDriverWait(driver, 30);
		
		try {
			xwait.until(ExpectedConditions.visibilityOf(element));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
			element.clear();
			element.sendKeys(value);
			ATUReports.add("Entering value in "+elementName+" textbox", value,"-","-",false,LogAs.INFO);
		} catch (NoSuchElementException e) {
			ATUReports.add("Verify presence of element "+elementName+" textbox","","Should be present" ,"Element is not present",false,LogAs.INFO);
			Assert.assertEquals("Element is not present", "Element should have been present");
		}
		
	}
	
	//Method to click on a button or a link
	public void click(WebDriver driver, WebElement locator,String elementName){
		xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		try {
			ATUReports.add("Clicking on "+elementName,"","-","-",false,LogAs.INFO);
			locator.click();			
		} catch (NoSuchElementException e) {
			ATUReports.add("Verify presence of element "+elementName+" textbox","","Should be present" ,"Element is not present",false,LogAs.INFO);
			Assert.assertEquals("Element is not present", "Element should have been present");
		}catch (WebDriverException e) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",locator);
		}
		
	}
	
	public void javascriptClick(WebDriver driver, String xpath,String elementName){
		WebElement element=driver.findElement(By.xpath(xpath));		
		ATUReports.add("Clicking on "+elementName,"","-","-",false,LogAs.INFO);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);			
		
	}
	
	public void click(WebDriver driver, String xpathText,String elementName){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		WebElement elementToClick=driver.findElement(By.xpath(xpathText));
		xwait.until(ExpectedConditions.visibilityOf(elementToClick));
		GenericMethods.Waitformilliseconds(1000);
		try {
			ATUReports.add("Clicking on "+elementName,"","-","-",false,LogAs.INFO);
			elementToClick.click();
		} catch (NoSuchElementException e) {
			ATUReports.add("Verify presence of element "+elementName+" textbox","","Should be present" ,"Element is not present",false,LogAs.INFO);
			Assert.assertEquals("Element is not present", "Element should have been present");
		}catch (WebDriverException e) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",elementToClick);
		}
	}
	
	//Method to mouse hover on any element on a web page
	public void mouseHover(WebDriver driver, WebElement locator,String elementName){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		ATUReports.add("Mouse hover  on "+elementName,"","-","-",false,LogAs.INFO);
		/*Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();*/
		//WebElement hoverElement=locator;
		mouseHoverJScript(driver, locator);
	}

	public void doubleClick(WebDriver driver, WebElement locator){
		/*WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));*/
		
		Actions action = new Actions(driver);
	    action.doubleClick(locator);
	  
	}
	
	public void rightClick(WebDriver driver, WebElement locator){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		Actions action = new Actions(driver);
	    action.contextClick().build().perform();
	  
	}
	public void offsetClick(WebDriver driver, WebElement locator ,int x, int y){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		Actions action = new Actions(driver);
		action.moveToElement(locator, x, y).click().build().perform();
	}

	//Method to select value from drop down based on visible text
	public void selectDropdown(WebElement locator, String value,String elementName){
		
		Select dropdown = new Select(locator);
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",locator);
		ATUReports.add("Selecting "+value+" from "+elementName+" dropdown","","-","-",false,LogAs.INFO);
		dropdown.selectByVisibleText(value);
	}
	
	//Method to get text for any element on a web page
	public String getText(WebDriver driver, WebElement locator){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		return locator.getText();
	}
	
	//Method to get text for any element on a web page using xpath
	public String getText(WebDriver driver, String xpath){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		WebElement element=driver.findElement(By.xpath(xpath));
		xwait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	//Method to get the Title of the web page
	public String getTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	//Method to wait for specific amount of time (forceful wait)
	public static void Waitformilliseconds(long timeInMilliseconds){
		try {
			Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isElementVisible(WebDriver driver,By by){
        boolean value = false;    
        if (driver.findElement(by).isDisplayed()) {
            value = true;
        }
        
        driver.findElement(By.xpath(""));
        
        return value;
    }
	
	public String getColor(WebDriver driver,WebElement locator){
		WebDriverWait xwait = new WebDriverWait(driver, 30);
		xwait.until(ExpectedConditions.visibilityOf(locator));
		String color = locator.getCssValue("color");
		String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		String color_locator = (r +","+g +","+ b);
		return color_locator;
	}
	
	public String isElementPresent(WebDriver driver, String xpathLocator){
		GenericMethods.Waitformilliseconds(1000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			GenericMethods.Waitformilliseconds(1000);
	      driver.findElement(By.xpath(xpathLocator));
	      
	      return "present";
	    } catch (NoSuchElementException e) {
	      return "notpresent";
	    }  
	  }

	  public boolean isAlertPresent(WebDriver driver) {
		  GenericMethods.Waitformilliseconds(1000);
		  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    } 
	  }

	  public String closeAlertAndGetItsText(WebDriver driver, boolean acceptNextAlert) {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	public static void SendKeysXTimeswithLocator(WebDriver driver,WebElement webElement,int keyCode, int XTimes)
	{
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=1;i<=XTimes;i++){
			GenericMethods.Waitformilliseconds(1000);
			new Actions(driver).moveToElement(webElement).perform();
			robot.keyPress(keyCode);
		}
	}
	
	public static void SendKeysXTimes(int keyCode, int XTimes){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=1;i<=XTimes;i++){
			GenericMethods.Waitformilliseconds(1000);
			robot.keyPress(keyCode);
		}
	}
	
	public static void waitForPageLoaded(WebDriver driver) {
	     ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

	        public Boolean apply(WebDriver driver) {
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,30);
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              
	      }
	 }
	
	public static void waitForPageLoaded1(WebDriver driver) {
	     Wait<WebDriver> wait = new WebDriverWait(driver,30);
	      try {
	              wait.until(new ExpectedCondition<Boolean>() {

	      	        public Boolean apply(WebDriver driver) {
	      	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	      	        }
	      	      });
	      } catch(Throwable error) {
	              
	      }
	 }
  	
	public boolean checkEqual(String actual,String expected ){
	boolean output;
		if (actual.equalsIgnoreCase(expected)) {
			output=true;
		}else {
			output=false;
		}		
		return output;	
	}
  	
	public boolean getTextAndCompare(WebDriver driver, WebElement element, String baseText){
		if (getText(driver, element).equals(baseText)) {
			return true;
		}else {
			return false;
		}		
	}
	
	public static String getMyPagetitle(WebDriver driver){
			return driver.getTitle();
		}	
	  	
//====================================================================================================	
	  	public void mouseHoverJScript(WebDriver driver,WebElement HoverElement) {
			try {
				if (isElementPresentforMouseHover(HoverElement)) {
					
					String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					((JavascriptExecutor) driver).executeScript(mouseOverScript,HoverElement);

				} else {
					System.out.println("Element was not visible to hover " + "\n");

				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + HoverElement+ "is not attached to the page document"+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + HoverElement + " was not found in DOM"+ e.getStackTrace());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error occurred while hovering"+ e.getStackTrace());
			}
		}

		public boolean isElementPresentforMouseHover(WebElement element) {
			boolean flag = false;
			try {
				if (element.isDisplayed()||element.isEnabled())
					flag = true;
			} catch (NoSuchElementException e) {
				flag = false;
			} catch (StaleElementReferenceException e) {
				flag = false;
			}
			return flag;
		}
	
//====================================================================================================	
		public void findVisibleElementandClick(WebDriver driver,String xpathString){
			GenericMethods genericMethods=new GenericMethods();
			GenericMethods.Waitformilliseconds(3000);		
			
			ArrayList<WebElement> Element1 = new ArrayList<WebElement>();  
		    Element1.addAll(driver.findElements(By.xpath(xpathString)));  
	  				
		    for(int i=0;i<Element1.size();i++) {
		    	if(Element1.get(i).getSize().getHeight() ==0){
		    		//Do nothing
		    	}else {
		    		GenericMethods.Waitformilliseconds(2000);
		    		genericMethods.click(driver, Element1.get(i),"visible element");
		    		break;
				}			    				    	
		    }
		}
		
		public String switchTabAndgetH1text(WebDriver driver){
			String window1Header;
			ArrayList<String> openTabs = new ArrayList<String> (driver.getWindowHandles());
			
		    driver.switchTo().window(openTabs.get(openTabs.size()-1));
		    waitForPageLoaded(driver);
		    window1Header=driver.findElement(By.xpath("//h1")).getText();
		    driver.close();
		    driver.switchTo().window(openTabs.get(0));	
			return window1Header;			
		}
		
		public String switchTabAndgetPageTitle(WebDriver driver){
			String window1Title;
			ArrayList<String> openTabs = new ArrayList<String> (driver.getWindowHandles());
			
		    driver.switchTo().window(openTabs.get(openTabs.size()-1));
		    waitForPageLoaded(driver);
		    window1Title=driver.getTitle();
		    driver.close();
		    driver.switchTo().window(openTabs.get(0));	
			return window1Title;
			
		}
		
		public String getHeaderText(WebDriver driver){
			String headerText;
			GenericMethods.Waitformilliseconds(2000);
			waitForPageLoaded(driver);
		    headerText=driver.findElement(By.xpath("//h1")).getText();
			return headerText;			
		}
		
	public void assertAndReport(String description,String expected, String actual) {
		if (expected.equals(actual)) {
			ATUReports.add(description, "", expected, actual, true, LogAs.PASSED);
		}else {
			ATUReports.add(description, "", expected, actual, true, LogAs.FAILED);
			Assert.assertEquals(actual, expected);
		}
	}
	
	public void assertAndReport(String description,int expected, int actual) {
		if (expected==actual) {
			ATUReports.add(description, "", "Expected: "+expected, "Actual:" +actual, true, LogAs.PASSED);
		}else {
			ATUReports.add(description, "", "Expected: "+expected, "Actual:" +actual, true, LogAs.FAILED);
			Assert.assertEquals(actual, expected);
		}
	}
	
	public void assertAndReport(String description,boolean expected, boolean actual) {
		if (expected==actual) {
			ATUReports.add(description, "", "Expected: "+expected, "Actual:" +actual, true, LogAs.PASSED);
		}else {
			ATUReports.add(description, "", "Expected: "+expected, "Actual:" +actual, true, LogAs.FAILED);
			Assert.assertEquals(actual, expected);
		}
	}
		
	}
