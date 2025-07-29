package test;

import org.testng.annotations.Test;

import utility.ExcelUtil;

public class MapCandidateTest extends BaseTest {
	 public static String testDataFileLocation= System.getProperty("user.dir")+"\\test-data\\mappingCandidateDetails.xlsx";
	 @Test(priority=1,enabled=true,description="Map candidate for the existing demand")
	 public void MapCandidate() throws Exception {
		 ExcelUtil testData = new ExcelUtil(testDataFileLocation,"Sheet1");
		 String demandRefNo = testData.getExcelAsMap().get(0).get("Demand Reference Number");
		 String candidateRefNo = testData.getExcelAsMap().get(0).get("Candidate Reference Number");
		 String totalExpYear = testData.getExcelAsMap().get(0).get("Total Experience(in years)").trim();
		 String totalExpMonth = testData.getExcelAsMap().get(0).get("Total Experience(in months)");
		 String relevantExpYear = testData.getExcelAsMap().get(0).get("Relevant Experience(in years)");
		 String relevantExpMonth = testData.getExcelAsMap().get(0).get("Relevant Experience(in months)");
		 String currentSalCurrencyType = testData.getExcelAsMap().get(0).get("Current Salary(currency type)");
		 String currentSalCurrency = testData.getExcelAsMap().get(0).get("Current Salary(currency)");
		 String expectedSalCurrencyType = testData.getExcelAsMap().get(0).get("Expected Salary(currency type)");
		 String expectedSalCurrency = testData.getExcelAsMap().get(0).get("Expected Salary(currency)");
		 String currentLoc = testData.getExcelAsMap().get(0).get("Current Location");
		 String preferredLoc = testData.getExcelAsMap().get(0).get("Preferred Location");
		 String currentOrg = testData.getExcelAsMap().get(0).get("Current Organization");
		 String currentDesignation = testData.getExcelAsMap().get(0).get("Current Designation");
		 String noticePeriodDrop = testData.getExcelAsMap().get(0).get("Notice Period");
		 String cal_lastWorkingDate = testData.getExcelAsMap().get(0).get("Last Working Date (Tentative)");
		 String empTypeDrop = testData.getExcelAsMap().get(0).get("Employee Type");
		 String noticePeriodNegotiation = testData.getExcelAsMap().get(0).get("Notice Period Negotiable");
		 String certification = testData.getExcelAsMap().get(0).get("Certification");
		 String sourceType = testData.getExcelAsMap().get(0).get("Source");
		 String jobPostingType = testData.getExcelAsMap().get(0).get("Job Posting Type");
		 String vendorName = testData.getExcelAsMap().get(0).get("Vendor Name");
		 String referredBy = testData.getExcelAsMap().get(0).get("Referred By");
		 String calProfileDate = testData.getExcelAsMap().get(0).get("Profile Received Date");
		 String resumePath = testData.getExcelAsMap().get(0).get("CV/Resume(path)");
		 String relocation = testData.getExcelAsMap().get(0).get("Open for Relocation");
		 String citizenship = testData.getExcelAsMap().get(0).get("Citizenship Status");
		 String radioBtn_One = testData.getExcelAsMap().get(0).get("Are you currently authorized to work in the country?");
		 String radioBtn_Two = testData.getExcelAsMap().get(0).get("In the future, do you need any sponsorships / extensions to your work authorisations");
		 String radioBtn_Three = testData.getExcelAsMap().get(0).get("Does this authorisation enable you to work for Yexle if selected");
		 String supportingDocPath = testData.getExcelAsMap().get(0).get("Supporting Document(path)");
		 String supportingDocComment = testData.getExcelAsMap().get(0).get("Supporing Document Comments");
		 String removeSupportingDoc = testData.getExcelAsMap().get(0).get("Supporting Doc Remove(Y/N)");
		 
		 editDemandPage.enter_existingDemand(demandRefNo);
		 editDemandPage.search_existingDemand();
		 editDemandPage.select_existingDemand();
		 mapCandidatePage.map_CandidateLink();
		 mapCandidatePage.select_CandidateApp(candidateRefNo);
		 mapCandidatePage.select_nextBtn();
		 mapCandidatePage.select_nextBtn();
		 mapCandidatePage.select_totalExp(totalExpYear, totalExpMonth);
		 mapCandidatePage.select_relevantExp(relevantExpYear, relevantExpMonth);
		 mapCandidatePage.select_currentSalCurrencyDetails(currentSalCurrency, currentSalCurrencyType);
		 mapCandidatePage.select_expectedSalCurrencyDetails(expectedSalCurrency, expectedSalCurrencyType);
		 mapCandidatePage.enter_currentLocation(currentLoc);
		 mapCandidatePage.select_preferredLocation(preferredLoc);
		 mapCandidatePage.enter_currentOrganization(currentOrg);
		 mapCandidatePage.enter_currentDesignation(currentDesignation);
		 mapCandidatePage.select_noticePeriod(noticePeriodDrop);
		 mapCandidatePage.select_employeeType(empTypeDrop);
		 mapCandidatePage.select_lastWorkingDate(cal_lastWorkingDate);
		 mapCandidatePage.select_noticePeriodNegotiable(noticePeriodNegotiation);
		 mapCandidatePage.enter_txtCertification(certification);
		 mapCandidatePage.select_nextBtn();
		 mapCandidatePage.select_source(sourceType);
		 mapCandidatePage.select_sourceType(referredBy);
		 mapCandidatePage.cal_profileReceivedDate(calProfileDate);
		 mapCandidatePage.upload_resume(resumePath);
		 mapCandidatePage.select_openForRelocation(relocation);
		 mapCandidatePage.select_citizenshipStatus(citizenship);
		 mapCandidatePage.select_authorizationRadioOptions(radioBtn_One,radioBtn_Two, radioBtn_Three);
		 mapCandidatePage.link_addnewDocument();
		 mapCandidatePage.upload_supportingDoc(supportingDocPath);
		 mapCandidatePage.enter_sdTxt(supportingDocComment);
		 mapCandidatePage.remove_document(removeSupportingDoc);
		 mapCandidatePage.click_submitButton();
		 //mapCandidatePage.verify_candidateMessage();
//		 demandPage.clickOnCloseBtn();
	 }
}
