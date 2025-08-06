package test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewCandidatePage;
import utility.BasePage;
import utility.ExcelUtil;

public class NewCandidateTest extends BaseTest {

    ExcelUtil testData;
    NewCandidatePage newCandidatePage;

    public static String testDataFileLocation =
        "C:\\Users\\haseena.shaik\\OneDrive - Yexle Digital Services India Private Limited\\Documents\\GitHub\\ERS_Automation_Team2\\TestData\\New Candidate.xlsx";

    @BeforeClass
    public void setup() throws InterruptedException {
        // Launch browser and navigate to app
        BasePage.initialization();

        // Perform login FIRST
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLogin();

        // Initialize page objects after login
        newCandidatePage = PageFactory.initElements(driver, NewCandidatePage.class);
    }

    @Test(priority = 1, description = "Create new candidate profile")
    public void createNewCandidate() throws IOException, InterruptedException {

        testData = new ExcelUtil(testDataFileLocation, "Sheet1");

        // Read test data
        String firstName = testData.getExcelAsMap().get(0).get("firstName");
        String lastName = testData.getExcelAsMap().get(0).get("lastName");
        String aadhar = testData.getExcelAsMap().get(0).get("aadhar");
        String email = testData.getExcelAsMap().get(0).get("email");
        String primaryMobile = testData.getExcelAsMap().get(0).get("primaryMobile");
        String secondaryMobile = testData.getExcelAsMap().get(0).get("secondaryMobile");
        String linkedIn = testData.getExcelAsMap().get(0).get("linkedIn");
        String highestDegree = testData.getExcelAsMap().get(0).get("highestDegree");
        String college = testData.getExcelAsMap().get(0).get("college");
        String university = testData.getExcelAsMap().get(0).get("university");
        String yearOfPassing = testData.getExcelAsMap().get(0).get("yearOfPassing");
        String totalExpYear = testData.getExcelAsMap().get(0).get("totalExpYear");
        String totalExpMonth = testData.getExcelAsMap().get(0).get("totalExpMonth");
        String relevantExpYear = testData.getExcelAsMap().get(0).get("relevantExpYear");
        String relevantExpMonth = testData.getExcelAsMap().get(0).get("relevantExpMonth");
        String currentSalary = testData.getExcelAsMap().get(0).get("currentSalary");
        String expectedSalary = testData.getExcelAsMap().get(0).get("expectedSalary");
        String currentLocation = testData.getExcelAsMap().get(0).get("currentLocation");
        String organisation = testData.getExcelAsMap().get(0).get("organisation");
        String designation = testData.getExcelAsMap().get(0).get("designation");
        String certification = testData.getExcelAsMap().get(0).get("certification");
        String resumePath = testData.getExcelAsMap().get(0).get("resumePath");

        // Fill candidate details
        newCandidatePage.click_CandidateTab();
        newCandidatePage.click_CreateCandidate();
        newCandidatePage.enter_Firstname(firstName);
        newCandidatePage.enter_Lastname(lastName);
        newCandidatePage.select_CountryIndia();
        newCandidatePage.enter_Aadhar(aadhar);
        newCandidatePage.enter_Email(email);
        newCandidatePage.enter_PrimaryMobile(primaryMobile);
        newCandidatePage.select_SecondaryMobileType();
        newCandidatePage.enter_SecondaryMobile(secondaryMobile);
        newCandidatePage.enter_LinkedIn(linkedIn);
        newCandidatePage.click_NextButton();

        // Education
        newCandidatePage.enter_HighestDegree(highestDegree);
        newCandidatePage.enter_CollegeName(college);
        newCandidatePage.enter_UniversityName(university);
        newCandidatePage.enter_YearOfPassing(yearOfPassing);
        newCandidatePage.click_EducationNxt();

        // Professional
        newCandidatePage.select_Department();
        newCandidatePage.select_Type();
        newCandidatePage.select_Experience(totalExpYear, totalExpMonth);
        newCandidatePage.select_RelevantExperience(relevantExpYear, relevantExpMonth);
        newCandidatePage.enter_CurrentSalary(currentSalary);
        newCandidatePage.enter_ExceptedSalary(expectedSalary);
        newCandidatePage.enter_CurrentLocation(currentLocation);
        newCandidatePage.select_PreferredLocation();
        newCandidatePage.enter_CurrentOrganisation(organisation);
        newCandidatePage.enter_CurrentDesignation(designation);
        newCandidatePage.select_NoticePeriod();
        newCandidatePage.select_EmploymentType();
        newCandidatePage.select_NoticePeriodOption();
        newCandidatePage.enter_Certification(certification);
        newCandidatePage.click_ProfessionalNxt();

        // Final
        newCandidatePage.select_Source();
        newCandidatePage.select_JobPostingType();
        newCandidatePage.upload_File(resumePath);
        newCandidatePage.click_Submit();
        newCandidatePage.click_Conf();
    }
}
