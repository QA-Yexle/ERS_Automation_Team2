package test;

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

}
