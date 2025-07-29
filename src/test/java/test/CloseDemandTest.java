package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class CloseDemandTest extends BaseTest {
	public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\closeDemand.xlsx";
	 @Test(priority = 1, description = "Close existing demand")
	 public void closeExistingDemand() throws Exception {
		 ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
		 String demandRefNumber = testData.getExcelAsMap().get(0).get("Demand Reference Number");
		 String demandComments = testData.getExcelAsMap().get(0).get("Close Comments");
		 String closeDemandOption = testData.getExcelAsMap().get(0).get("Close Demand(Y/N)");
		 if(closeDemandOption != null && closeDemandOption.equalsIgnoreCase("Y")) {
			 editDemandPage.enter_existingDemand(demandRefNumber);
		     editDemandPage.search_existingDemand();
		     editDemandPage.select_existingDemand();
		     closeDemandPage.click_closeDemand();
		     closeDemandPage.enter_comments(demandComments);
		     closeDemandPage.click_closeDemandBtn();
		 }

	 }
}