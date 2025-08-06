package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

<<<<<<< HEAD
public class HomePage extends BasePage{
	 @FindBy(xpath="//button[@type=\"button\" and @class=\"Button---btn Button---default_direction Button---primary Button---small appian-context-first-in-list appian-context-last-in-list Button---icon_start\"]")
	    WebElement btn_CreateDemand;
	 
	
	 
	 public HomePage(){
	        PageFactory.initElements(driver, this);
	    }

	 public void validation_HomePage() throws InterruptedException {
		TestUtil.WaitUtil(3000);
		Assert.assertTrue(btn_CreateDemand.isDisplayed());
		System.out.println("Create demand button displayed successfully");
	 }
	 
	 public void clickOnCreateDemand() throws InterruptedException {
		 TestUtil.WaitUtil(3000);
		 Assert.assertTrue(btn_CreateDemand.isDisplayed());
		 btn_CreateDemand.click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("document.body.style.zoom='70%'");
	 }
	 public void clickOnCreateDemandAction() throws InterruptedException {
		 TestUtil.WaitUtil(3);
		 Assert.assertTrue(btn_CreateDemand.isDisplayed());
		 btn_CreateDemand.click();
	 }
=======
public class HomePage extends BasePage {

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
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // Validate that the home page loaded by checking the Create Demand button
    public void Validation_HomePage() throws InterruptedException {
        TestUtil.WaitUtil(3);
        Assert.assertTrue(btn_CreateDemand.isDisplayed(), "Create Demand button is not displayed.");
    }

    // Click Create Demand button
    public void clickOnCreateDemandAction() throws InterruptedException {
        TestUtil.WaitUtil(3);
        Assert.assertTrue(btn_CreateDemand.isDisplayed(), "Create Demand button is not displayed.");
        btn_CreateDemand.click();
    }

    // Click on the Candidates tab
    public void clickOnCandidateTab() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        Assert.assertTrue(candidate.isDisplayed(), "Candidate Tab is not visible.");
        candidate.click();
    }

    // Click on the Create Candidate button
    public void clickOnCreateCandidate() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        Assert.assertTrue(createCandidate.isDisplayed(), "Create Candidate button is not visible.");
        createCandidate.click();
    }
>>>>>>> Haseena_Team2
}
