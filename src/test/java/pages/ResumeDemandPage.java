package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;
import utility.TestUtil;

public class ResumeDemandPage extends BasePage{
	
	@FindBy(xpath="//a[text()='Resume Demand']")
	WebElement click_resumeDemand;
	
	@FindBy(xpath="//span[text()='Resume Demand']/ancestor::button")
	WebElement click_resumeDemandButton;
	
	public ResumeDemandPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void click_resumeDemand() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		click_resumeDemand.click();
	}
	
	public void click_resumeDemandButton() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		click_resumeDemandButton.click();
		HoldDemandPage holdPage = new HoldDemandPage();
		holdPage.alertSubmit.click();
		TestUtil.refresh_window();
	}
}
