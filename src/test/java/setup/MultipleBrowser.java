package setup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.galenframework.testng.GalenTestNgTestBase;

import galenHelper.HomeGalenHelper.TestDevice;



public class MultipleBrowser extends GalenTestNgTestBase {
	{
		System.setProperty("atu.reporter.config", "atu.properties");		
	}
	
	public  WebDriver driver;
	private static Dimension resolution = null;
	private static String device = null;
	DesiredCapabilities capabilities;
	
	public void setup(String Browser,String url){

		if(Browser.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "src\\test\\java\\lib\\geckodriver.exe");
			driver= new FirefoxDriver();
		}else if(Browser.equals("CH")){
			String path ="src/test/java/lib/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
	       driver = new ChromeDriver();
		}	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Override
	public WebDriver createDriver(Object[] args) {
	if (args.length > 0) {
	if (args[0] != null && args[0] instanceof TestDevice) {
	TestDevice device = (TestDevice)args[0];
	if (device.getScreenSize() != null) {
	driver.manage().window().setSize(device.getScreenSize());
	}
	}
	}
	return driver;
	}
	/*@BeforeMethod(groups="beforeMethod")
	public void openUrl() {
		driver.get(url);
	}
	*/
	public static class TestDevice {
		private final String name;
		private final Dimension screenSize;
		private final List<String> tags;

		public TestDevice(String name, Dimension screenSize, List<String> tags) {
		this.name = name;
		this.screenSize = screenSize;
		this.tags = tags;
		}

		public String getName() {

		return name;
		}

		public Dimension getScreenSize() {
		resolution = this.screenSize;
		device = this.name;
		return screenSize;
		}

		public List<String> getTags() {
		return tags;
		}

		@Override
		public String toString() {
		return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
		}
		}
}
