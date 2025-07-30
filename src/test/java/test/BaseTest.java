package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

public class BaseTest extends BasePage {
	
	

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
