package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.LoginPage;
import pages.NewDemandPage;
import utility.BasePage;
import utility.ExcelUtil;

public class BaseTest extends LoginTest{
	 public static LoginPage loginPage;
	  public static HomePage homePage;
	  public static NewDemandPage demand;
	  protected static ExcelUtil testData;
	
	 @BeforeMethod
	    public void init() throws InterruptedException {
		 loginInApplicationTest();
	        homePage = new HomePage();
	        demand = new NewDemandPage();
	    }

}
