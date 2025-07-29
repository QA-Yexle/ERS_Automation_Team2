package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class EditDemandTest extends BaseTest{
	 public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\editDemand.xlsx";
	 @Test(priority = 1, description = "Edit existing demand")
	 public void editExistingDemand() throws Exception {
		 ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
		 String enterReferenceNumber = testData.getExcelAsMap().get(0).get("Demand Reference Number");
	     String updateNoOfPositions = testData.getExcelAsMap().get(0).get("No of Positions");
	     String updateProject = testData.getExcelAsMap().get(0).get("Project");
	     String updateHiringEndDate = testData.getExcelAsMap().get(0).get("Hiring End Date");
	     String updatePriority = testData.getExcelAsMap().get(0).get("Priority");

	     editDemandPage.enter_existingDemand(enterReferenceNumber);
	     editDemandPage.search_existingDemand();
	     editDemandPage.select_existingDemand();
	     editDemandPage.click_editDemand();
	     editDemandPage.enter_NoOfPositions(updateNoOfPositions);
	     editDemandPage.select_Project(updateProject);
	     editDemandPage.select_hiringEndDate(updateHiringEndDate);
	     editDemandPage.select_Priority(updatePriority);
	     demandPage.click_NextBtn();
	     demandPage.clickOnSubmitBtn();
	     demandPage.clickOnCloseBtn();
	 }

}
