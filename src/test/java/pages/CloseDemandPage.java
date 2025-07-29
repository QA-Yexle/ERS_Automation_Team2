package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;
import utility.TestUtil;

public class CloseDemandPage extends BasePage {
	
	@FindBy(xpath="//a[text()='Close Demand']")
	WebElement click_closeDemandLink;
	
	@FindBy(xpath="//label[text()='Comments']/following::textarea")
	WebElement comments;
	
	@FindBy(xpath="//span[text()='Close Demand']/ancestor::button")
	WebElement click_closeDemandButton;
	
	public CloseDemandPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void click_closeDemand() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		click_closeDemandLink.click();
	}
	
	public void enter_comments(String txt_comments)throws InterruptedException {
		TestUtil.WaitUtil(2000);
		comments.sendKeys(txt_comments);
		System.out.println(txt_comments);
	}
	
	public void click_closeDemandBtn() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		click_closeDemandButton.click();
		HoldDemandPage alert = new HoldDemandPage();
		alert.alertSubmit.click();
		TestUtil.refresh_window();
	}
}