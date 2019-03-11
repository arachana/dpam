package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	
	/*Header***********************************/	
	@FindBy(xpath=" //a[@title='OUR COMMUNITIES']")
	public WebElement Header_Communities_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement topNavBannerPageHeader;
	
	@FindBy(xpath="//li[@class='nav dropdown']/a[@title='Staff Accommodation']")
	public WebElement Header_staffAccommodation_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement StaffAccommodation_page_text;
	
	@FindBy(xpath="//li[@class='nav']/a[@href='/en/about-us']")
	public WebElement Header_aboutUs_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement aboutUs_page_text;
	
	@FindBy(xpath="//a[@title='ABOUT DUBAI HOLDING']")
	public WebElement Header_ADH_link;
	
	@FindBy(xpath="//a[contains (text(),'E-Services')] ")
	public WebElement Header_Eservice_link;
	
	@FindBy(xpath="//div[@class='dropdown-content corporate-dropdown']/ul/li/a[@href='/en/brokers']")
	public WebElement Header_brokers_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement brokers_page_text;
	
	@FindBy(xpath="//div[@class='dropdown-content corporate-dropdown']/ul/li/a[@href='/en/procurement']")
	public WebElement Header_procurement_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement procurement_page_text;
	
 /*
  * **************************logo**************/	
 	@FindBy(xpath="//div[@class='header-container']//a[@href='/']")
 	public WebElement header_logo_img;

	/* 
	 * *********************HomeHeroSlider********************** /
	 */

 	@FindBy(xpath="//button[@aria-label='1 of 4']")
	public WebElement dotInd_01_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement Hero_slider1_text;
	
	@FindBy(xpath="//button[@aria-label='2 of 4']")
	public WebElement dotInd_02_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h2")
	public WebElement Hero_text;
	
	@FindBy(xpath="//button[@aria-label='3 of 4']")
	public WebElement dotInd_03_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement Hero_slider3_text;
	
	@FindBy(xpath="//button[@aria-label='4 of 4']")
	public WebElement dotInd_04_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement Hero_slider4_text;
	
	/* *********** HomeSliderArrow ***************/

	@FindBy(xpath=" //div[@class='main-slide slick-initialized slick-slider slick-dotted']//button[@class='slick-prev slick-arrow'])")
	public WebElement HomeSliderPrevArrow_link;
	
	@FindBy(xpath="//div[@class='main-slide slick-initialized slick-slider slick-dotted']//button[@class='slick-next slick-arrow'] ")
	public WebElement HomeSliderNextArrow_link;
	
	/* *********** All Communities Filter ***************/
	@FindBy (xpath="//div[@class='input-categories']/span[contains(text(),'All communities')]")
	public WebElement AllCommunities_filter;
	
	@FindBy(xpath=" //div[@id='dropdown-community']//li[@data-value='all'] ")
	public WebElement AllCommunities_dropDown0_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='1']")
	public WebElement communities_dropDown1_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='2']")
	public WebElement communities_dropDown2_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='3']")
	public WebElement communities_dropDown3_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='4']")
	public WebElement communities_dropDown4_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='5']")
	public WebElement communities_dropDown5_value;
	
	@FindBy (xpath="//div[@id='dropdown-community']//li[@data-attr='6']")
	public WebElement communities_dropDown6_value;
	
	/* *********** All Unit Type Filter ***************/
	
	@FindBy (xpath="//div[contains(@class,'search-input unit-type')]/div/span[contains(@class,'icon')]")
	public WebElement AllUnitTypes_filter;
	
	@FindBy(xpath="//span[contains(text(),'All unit types')] ")
	public WebElement AllUnitTypes_value;
	
	@FindBy (xpath="//div[@id='dropdown-unit-type']//li[@data-attr='1']")
	public WebElement Apartment_value;
	
	@FindBy (xpath="//div[@id='dropdown-unit-type']//li[@data-attr='2']")
	public WebElement Villa_value;
	
/* *********** Any Size Filter ***************/
	
	@FindBy (xpath="//div[contains(@class,'search-input community-size')]/div/span[contains(@class,'icon')]")
	public WebElement AnySizeBed_filter;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='0'] ")
	public WebElement Any_dropDown1_value;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='1'] ")
	public WebElement Studio_dropDown2_value;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='2'] ")
	public WebElement Bed1_dropDown2_value;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='3'] ")
	public WebElement Bed2_dropDown2_value;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='4'] ")
	public WebElement Bed3_dropDown3_value;
	
	@FindBy (xpath="//div[@id='bedroom-count']//li[@data-attr='5'] ")
	public WebElement Bed4_dropDown4_value;
	
	@FindBy(xpath="//button[@id='comm-search-btn']")
	public WebElement search_btn;
	
	@FindBy(xpath="//div[@class='comm-details-count']")
	public WebElement SearchResult_text;
	
	//HomeCaraousel//
	
	@FindBy (xpath="//div[@class='community-sec-toggle hidden-xs']//a[@href='#comm-list-view']")
	public WebElement Home_listView;
	
	@FindBy (xpath="//li[@class='map-icon active']//a[@href='#comm-map-view']")
	public WebElement Home_mapView;
	
	@FindBy (xpath="//div[@class='community-sec-list-view']//h2")
	public WebElement caraousel_text;
	
	//Live the Difference//
	
	@FindBy (xpath="//div[@class='live-the-diff-wrapper']//h2")
	public WebElement liveThe_text;
	
	@FindBy (xpath="//a[contains (text(),'Enriched Living')]")
	public WebElement enriched_link;
	
	@FindBy (xpath="//a[contains (text(),'Convenience')]")
	public WebElement convenience_link;
	
	@FindBy (xpath="//a[contains (text(),'Added value')]")
	public WebElement Added_link;
	
	@FindBy (xpath="//a[contains (text(),'Peace of Mind')]")
	public WebElement peachOfMind_link;
	
	//Ready to find//
	
	@FindBy (xpath="//div[@class='find-home-details']//h2")
	public WebElement findHome_text;
	
	@FindBy (xpath="//div[@class='button']/a[@href='/en/our-communities']")
	public WebElement ViewAllCommunities_link;
	
	//Know Us Better//
	@FindBy (xpath=" //div[@class='homepage-know-us-content']//h2")
	public WebElement knowUs_text;
	
	@FindBy (xpath="//a[@href='#who-are-we']")
	public WebElement whoAreWe_heading;
	
	@FindBy ( xpath=" //li[@id='who-are-we']//h3")
	public WebElement whoAreWe_shortDesc;
	
	@FindBy (xpath="//a[@href='/en/about-us#who-we-are']")
	public WebElement kM_whoAreWe_link;

	
	@FindBy (xpath="//a[@href='#our-leadership']")
	public WebElement Leadership_heading;
	
	@FindBy ( xpath=" //li[@id='our-leadership']//h3")
	public WebElement leadership_shortDesc;
	
	@FindBy (xpath="//a[@href='/en/about-us#leadership']")
	public WebElement kM_leadership_link;
	
	@FindBy (xpath="//a[@href='#about-dubai-holding']")
	public WebElement ADH_heading;
	
	@FindBy ( xpath=" //li[@id='about-dubai-holding']//h3")
	public WebElement ADH_shortDesc;
	
	@FindBy (xpath="//a[@href='/en/about-us#about-dubai-holding']")
	public WebElement kM_ADH_link;
	
	@FindBy (xpath="//div[@class='staff-acc-container']//h2")
	public WebElement staff_CTA_heading;
	
	@FindBy(xpath="//div[@class='button hidden-xs']/a[@href='/en/staff-accommodation']")
	public WebElement staff_LearnMore_link;
	
	@FindBy (xpath="//div[@id='social-feed']//h2")
	public WebElement homeStacka_text;
	
/* *********** Footer link ***************/
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/our-communities']")
	public WebElement footer_communities_link;
	
	@FindBy(xpath="//div[@class='links']//a[@href='/en/brokers']")
	public WebElement footer_brokers_link;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/media-center']")
	public WebElement footer_mediaCenter_link;
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement mediaCenter_page_text;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/staff-accommodation']")
	public WebElement footer_staffAccommodation_link;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/procurement']")
	public WebElement footer_procurment_link;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/faqs']")
	public WebElement footer_faqs_link;
	
	@FindBy(xpath="//div[@class='banner-content']/h1")
	public WebElement FAQs_page_text;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/about-us']")
	public WebElement footer_aboutUs_link;
	
	@FindBy (xpath="//div[@class='links']//a[@href='/en/about-us#work-with-us']")
	public WebElement footer_career_link;
	
	@FindBy (xpath="//div[@class='copyright-text']")
	public WebElement copyright_text;
	
	@FindBy (xpath="//div[@class='disclaimer-links']//a[@href='/en/privacy-and-cookies-policy']")
	public WebElement footer_privacyCookies_link;
	
	@FindBy (xpath="//div[@class='disclaimer-links']//a[@href='/en/terms-and-conditions']")
	public WebElement footer_TC_link;
	
	@FindBy (xpath="//a[@href='/en/contact-us']")
	public WebElement Enquire_link;


}

