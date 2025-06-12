package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import utility.BasePage;
import utility.TestUtil;


public class HomePage extends BasePage{
	 @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---primary Button---small appian-context-first-in-list appian-context-last-in-list Button---icon_start']")
	    WebElement btn_CreateDemand;
	 
	
	 
	 public HomePage(){
	        PageFactory.initElements(driver, this);
	    }

	 public void Validation_HomePage() throws InterruptedException {
		 TestUtil.WaitUtil(3);
		 Assert.assertTrue(btn_CreateDemand.isDisplayed());
	 }
	 public void clickOnCreateDemandAction() throws InterruptedException {
		 TestUtil.WaitUtil(3);
		 Assert.assertTrue(btn_CreateDemand.isDisplayed());
		 btn_CreateDemand.click();
	 }
}
