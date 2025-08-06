package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class HoldDemandTest extends BaseTest{
	public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\holdAndResumeDemand.xlsx";
	 @Test(priority = 1, description = "Hold existing demand")
	 public void holdExistingDemand() throws Exception {
		 ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
		 String enterReferenceNumber = testData.getExcelAsMap().get(0).get("Demand Reference Number");
		 String comment = testData.getExcelAsMap().get(0).get("Comments");

	     editDemandPage.enter_existingDemand(enterReferenceNumber);
	     editDemandPage.search_existingDemand();
	     editDemandPage.select_existingDemand();
	     holdDemandPage.click_holdDemand();
	     holdDemandPage.enter_textInComments(comment);
	     holdDemandPage.click_holdButton();
 
	 }
}
