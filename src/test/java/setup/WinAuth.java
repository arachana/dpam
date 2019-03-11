package setup;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.security.UserAndPassword;

import actions.GenericMethods;

public class WinAuth {
	GenericMethods genericMethods;

	public static void AuthAlertHandling(WebDriver driver,String user_name, String password){
//		Alert alert = driver.switchTo().alert() ;
//		alert.authenticateUsing(new UserAndPassword(user_name,password));
		driver.switchTo().defaultContent() ; 
	}
	
	public static void aitoIT_AuthHandling(WebDriver driver,String user_name, String password){
		try {
			//GenericMethods.waitForPageLoaded(driver);
			GenericMethods.Waitformilliseconds(4000);
			Runtime.getRuntime().exec("src/test/java/lib/Authentication1.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
