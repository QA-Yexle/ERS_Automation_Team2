package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.LoginPage;
import utility.BasePage;

public class BaseTest extends LoginTest{
	 public static LoginPage loginPage;
	  public static HomePage homePage;
	
	 @BeforeMethod
	    public void init() throws InterruptedException {
		 loginInApplicationTest();
	        homePage = new HomePage();
	        
	    }

}
