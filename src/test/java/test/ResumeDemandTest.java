package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class ResumeDemandTest extends BaseTest{
	public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\holdAndResumeDemand.xlsx";
	 @Test(priority = 1, description = "Resume existing demand which is in on-hold")
	 public void resumeExistingDemand() throws Exception {
		 ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
		 String enterReferenceNumber = testData.getExcelAsMap().get(0).get("Demand Reference Number");
		 String resumeDemand = testData.getExcelAsMap().get(0).get("Resume Demand(Y/N)");
		 if (resumeDemand != null && resumeDemand.equalsIgnoreCase("Y")) {
			 editDemandPage.enter_existingDemand(enterReferenceNumber);
		     editDemandPage.search_existingDemand();
		     editDemandPage.select_existingDemand();
		     resumeDemandPage.click_resumeDemand();
		     resumeDemandPage.click_resumeDemandButton();
		 }
 
	 }
}