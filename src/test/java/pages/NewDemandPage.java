package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

public class NewDemandPage extends BasePage{
	
	  @FindBy(xpath="//span[text()='Country']//preceding::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	    WebElement WB_department;
	  
	  @FindBy(xpath="//span[text()='Country']//following::div[1]")
		 WebElement drop_country;
	  
	  @FindBy(xpath="//span[text()='Project']//preceding::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'][1]")
	  WebElement drop_Designation;
	  
	  @FindBy(xpath="//input[@class='TextInput---text TextInput---align_start']")
	  WebElement txt_positions;
	  
	  @FindBy(xpath="//span[text()='Job Type']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'][1]")
	  WebElement drop_JobType;
	  
	 @FindBy(xpath="//span[text()='City']//following::div[@class='MultipleDropdownWidget---dropdown_value']")
	 WebElement drop_City;
	 
	 @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---secondary Button---small Button---minimize_width Button---inModalDialogLayout Button---icon_start']")
	 WebElement upload_JD;
	 
	 @FindBy(xpath="//span[text()='Priority']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	 WebElement drop_Priority;
	 
	 @FindBy(xpath="//span[text()='Next']//ancestor::button[@class='Button---btn Button---default_direction Button---secondary appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	 WebElement btn_Next;
	 
	 @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---primary appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	 WebElement btn_Submit;
	 @FindBy(xpath="//textarea[@class='ParagraphWidget---textarea ParagraphWidget---align_start ParagraphWidget---height_medium ParagraphWidget---hasCharacterCount ParagraphWidget---inModalDialogLayout']")
	 WebElement txt_Skills;
	 @FindBy(xpath="//input[@class='DatePickerWidget---text DatePickerWidget---align_start DatePickerWidget---input_width']")
	 WebElement date;
	 
	 @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	 WebElement alertSubmit;
	 
	 @FindBy(xpath="//strong[contains(text(),'Demand created successfully!!')]")
	 WebElement message;
	 
public NewDemandPage() {
	PageFactory.initElements(driver, this);
}

public void select_Department(String dept) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	WB_department.click();
	TestUtil.selectdropdownValue(dept);
}
public void select_Country(String countryOption) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	drop_country.click();
	TestUtil.selectdropdownValue(countryOption);
}

public void select_Designation(String designationOption) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	drop_Designation.click();
	TestUtil.selectdropdownValue(designationOption);
}

public void enter_NoOfPositions(String position) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	txt_positions.sendKeys(position);
}

public void select_JobType(String jobOption) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	drop_JobType.click();
	TestUtil.selectdropdownValue(jobOption);
}
public void select_City(String dropCity) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	TestUtil.clickUsingJavascriptExecutor(drop_City);
	//TestUtil.selectdropdownValue(dropCity);
	 Thread.sleep(2000);
     int flag = 0;
     
     try {
         List<WebElement> allOptions = driver.findElements(By.xpath("//li[@role='option']"));
         for (WebElement dropoption : allOptions) {
             String txtoptions = dropoption.getText();
             System.out.println(txtoptions);
             if (txtoptions.toString().equals(dropCity)) {
            	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            	 wait.until(ExpectedConditions.elementToBeClickable(dropoption));
                 Actions act = new Actions(driver);
                 act.moveToElement(dropoption).click().click().build().perform();
            	
                 flag = 1;// Set to 1 when the required element was found and clicked.
                 break;
             }

         }

     } catch (StaleElementReferenceException e) {
         List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@class,'MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget')]"));
         for (WebElement dropoption : allOptions) {
             String txtoptions = dropoption.getText();
             System.out.println(txtoptions);
             if (txtoptions.toString().equals(dropCity)) {
                 Actions act = new Actions(driver);
                 act.moveToElement(dropoption).click().build().perform();
                 flag = 1;// Set to 1 when the required element was found and clicked.
                 break;
             }

         }
     }

	date.click();
}

public void upload_JobDescription(String path) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	TestUtil.fileUploadUsingRobotClass(upload_JD, path);
	TestUtil.WaitUtil(1000);
}
public void select_Priority(String priorityOption) throws InterruptedException {
	TestUtil.WaitUtil(2000);
	TestUtil.clickUsingJavascriptExecutor(drop_Priority);

	TestUtil.selectdropdownValue(priorityOption);
}
public void click_NextBtn() throws InterruptedException {
	TestUtil.WaitUtil(2000);
	btn_Next.click();
}

public void fillCriteria() throws InterruptedException {
	TestUtil.WaitUtil(2000);
	TestUtil.createDemandForm();
}
public void clickOnSubmitBtn() throws InterruptedException {
	TestUtil.WaitUtil(2000);
	btn_Submit.click();
	TestUtil.WaitUtil(1000);
	alertSubmit.click();
	
	
}

public void verify_demandCreation() throws InterruptedException {
	TestUtil.WaitUtil(2000);
	Assert.assertTrue(message.isDisplayed(),"Success Message is not displyaing");
	
}









}
