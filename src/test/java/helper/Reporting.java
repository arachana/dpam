package helper;





import org.testng.annotations.Test;

import actions.GenericMethods;

public class Reporting {

	@Test(groups = "test2")
	public void sendLatestReport(){
		String resultFolderPath;
		resultFolderPath="excel location needs to be given";
		GenericMethods.Waitformilliseconds(15000);
		EmailReportingHelper.sendreportinMail(resultFolderPath);		
	}
}