package galenHelper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.galenframework.api.Galen;
import com.galenframework.support.LayoutValidationException;
import com.galenframework.testng.GalenTestNgTestBase;

import actions.GenericMethods;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;

public class HomeGalenHelper extends GalenTestNgTestBase{

	GenericMethods genericMethods;
	WebDriver driver;
	private static Dimension resolution = null;
	private static String device = null;
	
        public HomeGalenHelper(WebDriver driver) {
		this.driver=driver;
		}
        
	public  void setDesktopResolution() {
		
		genericMethods = new GenericMethods();
		
		Dimension d = new Dimension(1366, 768);
		driver.manage().window().setSize(d);
		
		
	}

	public  void setMobileResolution() {
		Dimension d = new Dimension(450, 800);
		driver.manage().window().setSize(d);
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
	
	public  boolean executeGalenSpec(String specFilePath, String device) throws IOException {
		try {
			if (device.toLowerCase().contains("mobile")) {
				setMobileResolution();
				
				Galen.checkLayout(driver, specFilePath, Arrays.asList("mobile"));
				
			} else if (device.toLowerCase().contains("desktop")) {
				setDesktopResolution();
				Galen.checkLayout(driver, specFilePath, Arrays.asList("desktop"));
			}
			return true;

		} catch (LayoutValidationException lx) {
			ATUReports.add("Issues found in what we do page grid listing Sectionn "+ specFilePath,"","-","-",false,LogAs.FAILED);
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			ATUReports.add("Issues found in what we do page grid listing Sectionn "+ specFilePath,"","-","-",false,LogAs.FAILED);
			return false;
		}

	}

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