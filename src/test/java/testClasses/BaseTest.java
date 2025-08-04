package testClasses;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.LoginPage;
import pages.NewDemandPage;
import utility.BasePage;
import utility.ExcelUtil;



@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest extends LoginTest{
	 public static LoginPage loginPage;
	  public static HomePage homePage;
	  public static NewDemandPage demand;
	  protected static ExcelUtil testData;
	
	 @BeforeMethod
	 @Description("Login test using correct username and password")
	
	    @Severity(SeverityLevel.CRITICAL)
	    public void init() throws InterruptedException {
		 loginInApplicationTest();
	        homePage = new HomePage();
	        demand = new NewDemandPage();
	    }
	 @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            takeScreenshot("Test Failure Screenshot");
	        }
	        driver.quit();
	    }

	    @Attachment(value = "{0}", type = "image/png")
	    public byte[] takeScreenshot(String name) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
}
