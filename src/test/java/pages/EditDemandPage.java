package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BasePage;
import utility.TestUtil;

public class EditDemandPage extends BasePage {
	
	@FindBy(xpath="//input[@placeholder='Search Demands']")
	  WebElement enter_referenceNumber;
	
	@FindBy(xpath="//span[text()='Search']")
	  WebElement search_referenceNumber;
	
	@FindBy(xpath="//span[contains(text(),'DMN')]")
	  WebElement select_referenceNumber;
	
	@FindBy(xpath="//a[text()='Edit Demand']")
	  WebElement click_EditDemand;
	
	@FindBy(xpath="//input[@class='TextInput---text TextInput---align_start']")
	  WebElement txt_positions;
	
	@FindBy(xpath="//span[text()='Project']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//div[contains(@class,'DropdownWidget---dropdown_value')]")
	  WebElement drop_Project;
	
	@FindBy(xpath="//span[contains(text(),'Days') or contains(text(),'Immediate') or contains(text(),'Custom')]")
	  WebElement drop_hiringEndDate;
	 
	@FindBy(xpath="//span[text()='Priority']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//div[contains(@class,'DropdownWidget---dropdown_value')]")
	  WebElement drop_Priority;
	
    public EditDemandPage() {
        PageFactory.initElements(driver, this);
    }
    
    public void enter_existingDemand(String demand) throws InterruptedException {
        TestUtil.WaitUtil(2000);
        enter_referenceNumber.sendKeys(demand);
    }
    
    public void search_existingDemand() throws InterruptedException {
        TestUtil.WaitUtil(2000);
    	search_referenceNumber.click();
    }
    
    public void select_existingDemand() throws InterruptedException {
        TestUtil.WaitUtil(2000);
    	select_referenceNumber.click();
    	TestUtil.WaitUtil(2000);  
    	TestUtil.switchToNewWindow();
    }
    
    public void click_editDemand() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        click_EditDemand.click();
    }

    public void enter_NoOfPositions(String position) throws InterruptedException {
        TestUtil.WaitUtil(2000);
        txt_positions.clear();

        if (position != null && position.endsWith(".0")) {
            position = position.replace(".0", "");
        }

        txt_positions.sendKeys(position);
    }
    
    public void select_Project(String projectOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Project.click();
		TestUtil.selectdropdownValue(projectOption);
		((JavascriptExecutor) driver).executeScript("(document.evaluate(\"//span[text()='Next']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).scrollIntoView()");
	}
    
    public void select_hiringEndDate(String endDateOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_hiringEndDate.click();
		TestUtil.selectdropdownValue(endDateOption);
	}
    
    public void select_Priority(String priorityOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.clickUsingJavascriptExecutor(drop_Priority);
		TestUtil.selectdropdownValue(priorityOption);
	}

}
