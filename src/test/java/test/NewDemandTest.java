package test;

import java.io.IOException;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class NewDemandTest extends BaseTest{
	 public static String testDataFileLocation= System.getProperty("user.dir")+"\\TestData\\NewDemand.xlsx";
	
	 @Test
	 public void CreateNewDemand_HR() throws IOException, InterruptedException {
		testData = new ExcelUtil(testDataFileLocation,"Sheet1");
	      String dropDepartment = testData.getExcelAsMap().get(0).get("department");
	      String dropDesignation = testData.getExcelAsMap().get(0).get("designation");
	      String  countPosition = testData.getExcelAsMap().get(0).get("positions");
	      String  dropJobType = testData.getExcelAsMap().get(0).get("jobtype");
	      String  dropCountry = testData.getExcelAsMap().get(0).get("country");
	      String  dropCity = testData.getExcelAsMap().get(0).get("city");
	      String   description = testData.getExcelAsMap().get(0).get("jobDiscription");
	      String dropPriority =testData.getExcelAsMap().get(0).get("priority");
	      
	      
	      homePage.clickOnCreateDemandAction();    
	      demand.select_Department(dropDepartment);
	      demand.select_Designation(dropDesignation);
	      demand.enter_NoOfPositions(countPosition);
	      demand.select_JobType(dropJobType);
	      demand.select_Country(dropCountry);
	      demand.upload_JobDescription(description);
	      demand.select_Priority(dropPriority);
	      demand.select_City(dropCity);
	      demand.click_NextBtn();
	      demand.fillCriteria();
	      demand.clickOnSubmitBtn();
	      
	      
	      
	      
	}
	
	
	
	
	
	
	

}
