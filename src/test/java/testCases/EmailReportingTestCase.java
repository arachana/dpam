package testCases;


import org.testng.annotations.Test;

import actions.GenericMethods;
import helper.EmailReportingHelper;

public class EmailReportingTestCase {



@Test(groups = "test",priority=39)
public void sendLatestReport(){
String resultFolderPath;

resultFolderPath="D:/Brasseler Demo New file/ATU_Reporter/Results/";

//test Machine Path
//resultFolderPath="C:/BrasselerRepo/ATU_Reporter/Results/";
//GenericMethods.Waitformilliseconds(15000);
//EmailReportingHelper.sendreportinMail(resultFolderPath);	
}
}