package test;

import pages.LoginPage;
import utility.BasePage;

public class LoginTest extends BasePage{
	 public static LoginPage loginPage;
	 
	 public void loginInApplicationTest(){
		     initialization();
	       loginPage = new LoginPage();
	        loginPage.enterUsername();
	        loginPage.enterPassword();
	        loginPage.clickOnLogin();
	}
	 
	
	 
}
