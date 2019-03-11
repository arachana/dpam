
package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.GenericMethods;



public class SearchResultPageHelper {
	
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
	public SearchResultPageHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchResultVerificationMetaData() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		genericMethods.javascriptClick(driver, "//li[@class='header-search-icon']", "searchIcon");
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='search-autocomplete-list']")), "rental", "searchBar");
		genericMethods.javascriptClick(driver, "//button[@type='submit']", "searchSubmit");
		GenericMethods.Waitformilliseconds(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		String SearchResult =genericMethods.getText(driver, "//div[@class='search-result-header']");
		genericMethods.assertAndReport("Search Result Verification", "Results for \"rental\": 5 pages have been found.", SearchResult);
		List<WebElement> outerLIElementList = driver.findElements(By.xpath("//div[@class='search-result-header']"));

		System.out.println(outerLIElementList.size());
	                             
		
		for (WebElement outerLIElement : outerLIElementList) {

		    // find the inner table rows using the outer table row
		    List<WebElement> innerLIElementList = outerLIElement.findElements(By.xpath("//div[@class='search-result-sec']/h5"));
		    
		   
		    // iterate through the inner table rows and sysout
		    for (WebElement innerLIElement : innerLIElementList) {
			       String metaTitle= innerLIElement.getText();
		
			  if (metaTitle.isEmpty()) {
		    	   System.out.println("MetaTitle not Present");
		 
		       }
		       else {
		    	  System.out.println("MetaTitle Present");
		       }
		  }
		    
		}

		}

	
public void searchResultVerificationMetaTitle() {
	genericMethods=new GenericMethods();
	xplicitWait=new WebDriverWait(driver, 0);
	
	List<WebElement> outerLIElementList = driver.findElements(By.xpath("//div[@class='search-result-header']"));

//	System.out.println(outerLIElementList.size());
                             
	
	for (WebElement outerLIElement : outerLIElementList) {
		

	    List<WebElement> innerLIElementList1 = outerLIElement.findElements(By.xpath("//div[@class='search-result-sec']/p"));

	    // iterate through the inner table rows and sysout
	    for (WebElement innerLIElement : innerLIElementList1) {
	       String metaDesc= innerLIElement.getText();
	       if (metaDesc.isEmpty()) {
	    	   System.out.println("metaDesc not Present");
	 
	       }
	       else {
	    	  System.out.println("metaDesc Present");
	       }
	    	   
	    }
}
}
	public void searchResultVerificationShowMore() {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		
		List<WebElement> outerLIElementList = driver.findElements(By.xpath("//div[@class='search-result-header']"));
for (WebElement outerLIElement : outerLIElementList) {
	

    List<WebElement> innerLIElementList2 = outerLIElement.findElements(By.xpath("//div[@class='nb-readmore']"));
   
    for (WebElement innerLIElement : innerLIElementList2) {
     String showMore=   innerLIElement.getText();

     if (showMore.isEmpty()) {
  	   System.out.println("Show More link not Present");

     }
     else {
  	  System.out.println("ShowMore link is Present");
     }
  	   
  }
    }
}
}
