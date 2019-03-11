package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityListPageObjects {
	
	@FindBy(xpath=" //a[@title='OUR COMMUNITIES']")
	public WebElement Header_Communities_link;
	
	/* *********** Sort ***************/
	
	@FindBy(xpath="//li[@class='sort']//span[@class='icon fa fa-angle-down']")
	public WebElement sort_dropdown;
	
	@FindBy(xpath="//a[contains(text(),' Relevance')]")
	public WebElement sort_Relevance;
	
	@FindBy(xpath="//a[contains(text(),' Alphabetical (A-Z)')]")
	public WebElement sort_Alphabates;
	
	@FindBy(xpath="//a[contains(text(),'Price Low to High')]")
	public WebElement sort_Price_LTH;
	
	@FindBy(xpath="//a[contains(text(),' Price High to Low')]")
	public WebElement sort_Price_HTL;
	
//	******************* RegisterIntrestform ****************
	
	@FindBy(xpath="//button[@data-community='Shorooq']")
	public WebElement CL_shorroqRI_Button;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//input[@name='firstname']")
	public WebElement FirstName_intext;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//label[@id='txtFirstName-error']")
	public WebElement FN_Error_text;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//input[@name='lastname']")
	public WebElement lastName_intext;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//label[@id='txtLastName-error']")
	public WebElement LN_Error_text;
	
	@FindBy (xpath="//form[@id='schedule-a-tour-form']//input[@name='email']")
	public WebElement Email_intext;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//label[@id='txtEmail-error']")
	public WebElement email_Error_text;
	
	@FindBy (xpath="//form[@id='schedule-a-tour-form']//input[@name='contact']")
	public WebElement contactNo_intext;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//label[@id='txtPhoneNumber-error']")
	public WebElement contactNo_error;
	
	@FindBy (xpath="//input[@id='sat-moveindate']")
	public WebElement moveindate_calender;
	
	@FindBy (xpath="//form[@id='schedule-a-tour-form']//label[@id='sat-moveindate-error']")
	public WebElement moveindateError;
	
	@FindBy (xpath="//a[contains(text(),'24')]")
	public WebElement moveinDate_value;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public WebElement calenderNextArrow;
	
	@FindBy(xpath="//label[@id='txtUnitType-error']")
	public WebElement UnitTypeError_text;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//select[@id='txtUnitType']")
	public WebElement unitType_dropdown;
	
	@FindBy (xpath="//div[@class='input-unitType']//option[@value='0']")
	public WebElement unitType_Apartment;
	
	@FindBy (xpath="//div[@class='input-unitType']//option[@value='1']")
	public WebElement unitType_villas;
	
	@FindBy (xpath="//label[@id='txtUnitType-error']")
	public WebElement unitType_error;
	
	@FindBy (xpath="//form[@id='schedule-a-tour-form']//select[@id='txtBedRoom']")
	public WebElement bedRomm_dropdown;
	
	@FindBy (xpath="//label[@id='txtBedRoom-error']")
	public WebElement bedRoom_error;
	
	@FindBy(xpath="//textarea[@id='txtComments']")
	public WebElement comment_textbox;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//input[@id='Policycheckbox']")
	public WebElement checkbox;
	
	@FindBy (xpath="//label[@id='checkbox-error']")
	public WebElement checkbox_error;
	
	@FindBy(xpath="//form[@id='schedule-a-tour-form']//button[@class='btn-link btn-small cancel-btn']")
	public WebElement cancel_button;
	
	@FindBy (xpath="//button[@id='Schedule-tour-submit-button']")
	public WebElement submit_button;
	
	@FindBy(xpath="//div[@id='schedule-a-tour']//div[@class='thank-you-slider-heading']")
	public WebElement thanku_popup;
	
	
	
	
}

