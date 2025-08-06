package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;
import utility.TestUtil;

public class HoldDemandPage extends BasePage{
	
	@FindBy(xpath="//a[text()='Hold Demand']")
	  WebElement click_HoldDemand;
	
	@FindBy(xpath="//label[text()='Comments']/following::textarea")
	  WebElement enter_comments;
	
	@FindBy(xpath="//button[.//span[text()='Hold Demand']]")
	  WebElement click_holdBtn;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	  WebElement alertSubmit;
	
	 public HoldDemandPage() {
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void click_holdDemand() throws InterruptedException {
		 TestUtil.WaitUtil(2000);
		 click_HoldDemand.click();
	 }
	 
	 public void enter_textInComments(String comments) throws InterruptedException {
		 TestUtil.WaitUtil(2000);
		 enter_comments.sendKeys(comments);
	 }
	 
	 public void click_holdButton() throws InterruptedException {
		 click_holdBtn.click();
		 TestUtil.WaitUtil(2000);
		 alertSubmit.click();
		 TestUtil.refresh_window();
	 }
}
