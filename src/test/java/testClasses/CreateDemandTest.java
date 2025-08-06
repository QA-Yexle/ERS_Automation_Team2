package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class CreateDemandTest extends BaseTest{
	 public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\demand.xlsx";
	 @Test(priority=1,enabled=true,description="create new demand for Appian Department")
	 public void CreateNewDemand_Appian() throws Exception {
		ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
	      String dropDepartment = testData.getExcelAsMap().get(0).get("Department");
	      String dropDesignation = testData.getExcelAsMap().get(0).get("Designation");
	      String countPosition = testData.getExcelAsMap().get(0).get("No of positions");
	      String dropProjectHire= testData.getExcelAsMap().get(0).get("Hiring Plan");
	      String dropProject = testData.getExcelAsMap().get(0).get("Project");
	      String dropJobType = testData.getExcelAsMap().get(0).get("Job Type");
	      String dropCountry = testData.getExcelAsMap().get(0).get("Country");
	      String dropCity = testData.getExcelAsMap().get(0).get("City");
	      String description = testData.getExcelAsMap().get(0).get("Job Description");
	      String skills = testData.getExcelAsMap().get(0).get("Skills");
	      String calStartDate = testData.getExcelAsMap().get(0).get("Hiring Start Date");
	      String dropEndDate = testData.getExcelAsMap().get(0).get("Hiring End Date");
	      String dropPriority =testData.getExcelAsMap().get(0).get("Priority");
	      
	      homePage.clickOnCreateDemand();   
	      demandPage.select_Department(dropDepartment);
	      demandPage.select_Designation(dropDesignation);
	      demandPage.enter_NoOfPositions(countPosition);
	      demandPage.select_hiringType(dropProjectHire);
	      demandPage.select_Project(dropProject);
	      demandPage.select_JobType(dropJobType);
	      demandPage.select_Country(dropCountry);
	      demandPage.select_City(dropCity);
	      demandPage.upload_JobDescription(description);
	      demandPage.text_Skills(skills);
	      demandPage.select_hiringStartDate(calStartDate);
	      demandPage.select_hiringEndDate(dropEndDate);
	      demandPage.select_Priority(dropPriority);
	      demandPage.click_NextBtn();
	      demandPage.fillCriteria();
	      demandPage.clickOnSubmitBtn();
	      demandPage.verify_demandCreation(); 
	      demandPage.display_referenceNumber();
	      demandPage.clickOnCloseBtn();
	      demandPage.clickOnReferenceFromGrid();
	}
}
