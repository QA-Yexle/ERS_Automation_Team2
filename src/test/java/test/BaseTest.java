package test;

<<<<<<< HEAD
import org.testng.annotations.*;

import pages.CloseDemandPage;
import pages.CreateDemandPage;
import pages.EditDemandPage;
import pages.HoldDemandPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MapCandidatePage;
import pages.ResumeDemandPage;

public class BaseTest extends LoginTest{
	 public static LoginPage loginPage;
	 public static HomePage homePage;
	 public static CreateDemandPage demandPage;
	 public static EditDemandPage editDemandPage;
	 public static HoldDemandPage holdDemandPage;
	 public static ResumeDemandPage resumeDemandPage;
	 public static CloseDemandPage closeDemandPage;
	 public static MapCandidatePage mapCandidatePage;
	 
	 @BeforeMethod
	    public void init() throws InterruptedException {
		 loginInApplicationTest();
	        homePage = new HomePage();
	        demandPage = new CreateDemandPage();
	        editDemandPage = new EditDemandPage();
	        holdDemandPage = new HoldDemandPage();
	        resumeDemandPage = new ResumeDemandPage();
	        closeDemandPage = new CloseDemandPage();
	        mapCandidatePage = new MapCandidatePage();
	    }
	 
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
=======
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

public class BaseTest extends BasePage {
	
	
>>>>>>> Haseena_Team2

    // Create Demand Button
    @FindBy(xpath = "//button[@class='Button---btn Button---default_direction Button---primary Button---small appian-context-first-in-list appian-context-last-in-list Button---icon_start']")
    WebElement btn_CreateDemand;

    // Candidate Tab
    @FindBy(xpath = "//span[normalize-space()='Candidates']")
    WebElement candidate;

    // Create Candidate Action
    @FindBy(xpath = "//span[normalize-space()='Create Candidate - Click to create a new candidate']//preceding::span[contains(text(),'Create Candidate')]")
    WebElement createCandidate;

    // Constructor
    public BaseTest() {
        PageFactory.initElements(driver, this);
    }

    // Validates Home Page by checking if Create Demand button is displayed
    public void Validation_HomePage() throws InterruptedException {
        TestUtil.WaitUtil(3);
        Assert.assertTrue(btn_CreateDemand.isDisplayed(), "Create Demand button is not displayed.");
    }

    // Click on Create Demand Button
    public void clickOnCreateDemandAction() throws InterruptedException {
        TestUtil.WaitUtil(3);
        Assert.assertTrue(btn_CreateDemand.isDisplayed(), "Create Demand button is not displayed.");
        btn_CreateDemand.click();
    }

    // Click on Candidates tab
    public void clickOnCandidateTab() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        Assert.assertTrue(candidate.isDisplayed(), "Candidate Tab is not visible.");
        candidate.click();
    }

    // Click on Create Candidate button
    public void clickOnCreateCandidate() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        Assert.assertTrue(createCandidate.isDisplayed(), "Create Candidate button is not visible.");
        createCandidate.click();
    }
}
