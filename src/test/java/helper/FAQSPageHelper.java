package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import actions.GenericMethods;

public class FAQSPageHelper {
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver; 

	public FAQSPageHelper (WebDriver driver) {
		this.driver= driver;
	}

	public void FAQsCategory (String catID,String verificationText) {
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		genericMethods.javascriptClick(driver, "//a[@href='"+catID+"']", "Category");
		String categoryText= genericMethods.getText(driver, "//a[@href='"+catID+"']");
		genericMethods.assertAndReport("Check FAQS Category", verificationText, categoryText);
	}

	public void que(String outerElementID,String outerElement1ID,String innerElementID,int verificationCount) {
		genericMethods=new GenericMethods();
		List<WebElement> outerLIElementList = driver.findElements(By.xpath("//div[@id='"+outerElementID+"']"));
		int queCount=outerLIElementList.size();
		System.out.println(outerLIElementList.size() );
		genericMethods.assertAndReport("Check Count of Que", verificationCount, queCount);	
		List<WebElement> outerLIElementList1 = driver.findElements(By.xpath("//div[@id='"+outerElement1ID+"']"));
		
//		WebElement plusButton =driver.findElement(By.xpath("//*[@id='Moving-In']//following-sibling::span[@class='icon plus']"));
	
		
		for (WebElement outerLIElement : outerLIElementList1) {

		    // find the inner table rows using the outer table row
		    List<WebElement> innerLIElementList = outerLIElement.findElements(By.xpath("//div[@id='"+innerElementID+"']"));
		    
		  
		    // iterate through the inner table rows and sysout
		    
		    GenericMethods.Waitformilliseconds(1000);
		    for (WebElement innerLIElement : innerLIElementList) {
			       String que= innerLIElement.getText();
		
			  if (que.isEmpty()) {
		    	   System.out.println("Question not Present");
		 
		       }
		       else {
		    	  System.out.println("Question Present");
		       }
		  }
	}

	}
	

public void Answer(String outerElementID,String outerElement1ID,String innerElementID,String plusButton) {
	genericMethods=new GenericMethods();
	List<WebElement> outerLIElementList = driver.findElements(By.xpath("//div[@id='"+outerElementID+"']"));

	System.out.println(outerLIElementList.size() );
	String ans1=genericMethods.getText(driver, "//div[@class='answer short-desc']/ul");
	System.out.println(ans1);
	
	List<WebElement> outerLIElementList1 = driver.findElements(By.xpath("//div[@id='"+outerElement1ID+"']"));
//	List<WebElement> plusButtons = driver.findElements(By.xpath("(//*[@class='icon plus'])[position()<19]"));
	
	
	for (WebElement outerLIElement : outerLIElementList1) {

	    // find the inner table rows using the outer table row
	    List<WebElement> innerLIElementList = outerLIElement.findElements(By.xpath("//div[@id='"+innerElementID+""));
	 
		genericMethods.javascriptClick(driver, "//div[@id='"+plusButton+"']", "PlusButton");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	
		
	
	    // iterate through the inner table rows and sysout
	    for (WebElement innerLIElement : innerLIElementList) {
	    
		      String Ans= innerLIElement.getText();
	System.out.println(Ans);
		      
//		  if (Ans.isEmpty()) {
//	    	   System.out.println("Answer not Present");
//	 
//	       }
//	       else {
//	    	  System.out.println("Answer Present");
//	       }
//	
	    }
	   
}
}
}
