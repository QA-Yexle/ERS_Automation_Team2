package test;

import pages.LoginPage;
import utility.BasePage;

public class LoginTest extends BasePage{
	 public static LoginPage login_Page;
	 
	 public void loginInApplicationTest(){
		    initialization();
		    login_Page = new LoginPage();
	        login_Page.enterUsername();
	        login_Page.enterPassword();
	        login_Page.clickOnLogin();
	}
	 
	
	 
}