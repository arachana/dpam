package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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


public class CommunityListPageHelper {
	
	CommunityListPageObjects communityListObject;
	GenericMethods genericMethods;
	WebDriverWait xplicitWait;
	WebDriver driver;
	
		public CommunityListPageHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void sortVerification() {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		driver.navigate().refresh();
		GenericMethods.Waitformilliseconds(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		genericMethods.click(driver, communityListObject.sort_dropdown, "Sort Dropdown");
		genericMethods.click(driver, communityListObject.sort_Alphabates, "Sort Alpha");
		String Result=genericMethods.getText(driver, "//div[@id='comm-list-view']/ul/li[1]/div[@class='community-list-details']//h2/a");
		genericMethods.assertAndReport("Alphabets Sorting",Result,"Al Khail Gate");
		genericMethods.click(driver, communityListObject.sort_dropdown, "Sort Dropdown");
		genericMethods.click(driver, communityListObject.sort_Price_LTH, "Sort LTH");
		String Result2=genericMethods.getText(driver, "//div[@id='comm-list-view']/ul/li[1]/div[@class='community-list-details']//h2/a");
		genericMethods.assertAndReport("Alphabets Sorting",Result2,"Al Khail Gate");
		genericMethods.click(driver, communityListObject.sort_dropdown, "Sort Dropdown");
		genericMethods.click(driver, communityListObject.sort_Price_HTL, "Sort HTL");
		String Result3=genericMethods.getText(driver, "//div[@id='comm-list-view']/ul/li[1]/div[@class='community-list-details']//h2/a");
		genericMethods.assertAndReport("Alphabets Sorting",Result3,"Layan");
		genericMethods.click(driver, communityListObject.sort_dropdown, "Sort Dropdown");
		genericMethods.click(driver, communityListObject.sort_Relevance, "Sort Relevance");
		String Result4=genericMethods.getText(driver, "//div[@id='comm-list-view']/ul/li[1]/div[@class='community-list-details']//h2/a");
		genericMethods.assertAndReport("Alphabets Sorting",Result4,"Shorooq");
	}
	
	
	public void formRIverification(String communityName) {
	communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
	genericMethods=new GenericMethods();
	xplicitWait=new WebDriverWait(driver, 0);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,60)");
	genericMethods.javascriptClick(driver, "//button[@data-community='"+communityName+"']", "communityName");
	}
	
	public void formRIdataInput(String formLabel,String data) {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		Select unitTypes=new Select(driver.findElement (By.xpath("//form[@id='schedule-a-tour-form']//select[@id='txtUnitType']")));
		Select bedRoom=new Select (driver.findElement(By.xpath("//form[@id='schedule-a-tour-form']//select[@id='txtBedRoom']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,60)");
		
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='"+formLabel+"']")), data, "Feild Name");
		

	}
	
	
	public void formSubmission() {
	communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
	genericMethods=new GenericMethods();
	Select unitTypes=new Select(driver.findElement (By.xpath("//form[@id='schedule-a-tour-form']//select[@id='txtUnitType']")));
	Select bedRoom=new Select (driver.findElement(By.xpath("//form[@id='schedule-a-tour-form']//select[@id='txtBedRoom']")));
	genericMethods.click(driver, communityListObject.moveindate_calender, "moveindate");
	genericMethods.click(driver, communityListObject.moveinDate_value, "24Jan2018");
	unitTypes.selectByValue("0");
	bedRoom.selectByValue("1");
	genericMethods.click(driver, communityListObject.checkbox,"checkbox");
	genericMethods.click(driver, communityListObject.submit_button, "submit");
	String thankyou =genericMethods.getText(driver, communityListObject.thanku_popup);
	genericMethods.assertAndReport("Check Success of Form Submission", "Thank You", thankyou);
}

	public void formRIdataInputwithoutUnitType(String formLabel,String data) {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,60)");
		genericMethods.inputValue(driver, driver.findElement(By.xpath("//input[@id='"+formLabel+"']")), data, "Feild Name");
		
		}
	
		public void formSubmissionwithoutunitType() {
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		
		Select bedRoom=new Select (driver.findElement(By.xpath("//form[@id='schedule-a-tour-form']//select[@id='txtBedRoom']")));
		genericMethods.click(driver, communityListObject.moveindate_calender, "moveindate");
		genericMethods.click(driver, communityListObject.moveinDate_value, "24Jan2018");
		bedRoom.selectByValue("2");
		genericMethods.click(driver, communityListObject.checkbox,"checkbox");
		genericMethods.click(driver, communityListObject.submit_button, "submit");
		String thankyou =genericMethods.getText(driver, communityListObject.thanku_popup);
		genericMethods.assertAndReport("Check Success of Form Submission", "Thank You", thankyou);
	}

	public void errorValidation()
	{
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,60)");
		genericMethods.click(driver, communityListObject.submit_button, "submit");
		String errorText1=genericMethods.getText(driver, communityListObject.FN_Error_text);
		genericMethods.assertAndReport("Check FN Field error", "First Name is a required field", errorText1);
		String errorText2=genericMethods.getText(driver, communityListObject.LN_Error_text);
		genericMethods.assertAndReport("Check LN Field error", "Last Name is a required field", errorText2);
		String errorText3=genericMethods.getText(driver, communityListObject.email_Error_text);
		genericMethods.assertAndReport("Check email Field error", "Email Address is a required field", errorText3);
		genericMethods.assertAndReport("Check email Field error", "Last Name is a required field", errorText2);
		String errorText4=genericMethods.getText(driver, communityListObject.contactNo_error);
		genericMethods.assertAndReport("Check contact no Field error", "Contact No is a required field", errorText4);
		String errorText5=genericMethods.getText(driver, communityListObject.moveindateError);
		genericMethods.assertAndReport("Check email Field error", "Move-in Date is a required field", errorText5);
		String errorText6=genericMethods.getText(driver, communityListObject.unitType_error);
		genericMethods.assertAndReport("Check email Field error", "Property Type is a required field", errorText6);
		String errorText7=genericMethods.getText(driver, communityListObject.bedRoom_error);
		genericMethods.assertAndReport("Check email Field error", "Bedroom is a required field", errorText7);
		String errorText8=genericMethods.getText(driver, communityListObject.checkbox_error);
		genericMethods.assertAndReport("Check email Field error", "Please accept the Terms of Use", errorText8);
	
	}

	public void errorValidationwithoutUnitType()
	{
		communityListObject=PageFactory.initElements(driver, CommunityListPageObjects.class);
		genericMethods=new GenericMethods();
		xplicitWait=new WebDriverWait(driver, 0);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,60)");
		genericMethods.click(driver, communityListObject.submit_button, "submit");
		String errorText1=genericMethods.getText(driver, communityListObject.FN_Error_text);
		genericMethods.assertAndReport("Check FN Field error", "First Name is a required field", errorText1);
		String errorText2=genericMethods.getText(driver, communityListObject.LN_Error_text);
		genericMethods.assertAndReport("Check LN Field error", "Last Name is a required field", errorText2);
		String errorText3=genericMethods.getText(driver, communityListObject.email_Error_text);
		genericMethods.assertAndReport("Check email Field error", "Email Address is a required field", errorText3);
		genericMethods.assertAndReport("Check email Field error", "Last Name is a required field", errorText2);
		String errorText4=genericMethods.getText(driver, communityListObject.contactNo_error);
		genericMethods.assertAndReport("Check contact no Field error", "Contact No is a required field", errorText4);
		String errorText5=genericMethods.getText(driver, communityListObject.moveindateError);
		genericMethods.assertAndReport("Check email Field error", "Move-in Date is a required field", errorText5);
		String errorText7=genericMethods.getText(driver, communityListObject.bedRoom_error);
		genericMethods.assertAndReport("Check email Field error", "Bedroom is a required field", errorText7);
		String errorText8=genericMethods.getText(driver, communityListObject.checkbox_error);
		genericMethods.assertAndReport("Check email Field error", "Please accept the Terms of Use", errorText8);
	
	}
}

