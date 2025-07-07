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
	@FindBy(xpath="//span[text()='Vendors']")
	WebElement vendorBtn;

	@FindBy(xpath = "//input[@placeholder=\'Search Vendors\']")
	WebElement searchField;

	@FindBy(xpath = "//span[text()=\'Search\']/ancestor::button")
	WebElement searchBtn;

	@FindBy(xpath = "//i[@class='TextInput---fa-times-circle-svg']")
	WebElement closeBtn;
	 
	 public HomePage(){
	        PageFactory.initElements(driver, this);
	    }

	 public void Validation_HomePage() throws InterruptedException {
		 TestUtil.WaitUtil(3);
		 Assert.assertTrue(btn_CreateDemand.isDisplayed());
	 }
	 public void Verify_VendorPage() throws InterruptedException{
		 TestUtil.WaitUtil(2);
		 Assert.assertTrue(vendorBtn.isDisplayed());
		 vendorBtn.click();
		 searchField.sendKeys("000000007");
		 searchBtn.click();
		 TestUtil.WaitUtil(2);
		 closeBtn.click();
	 }

}
