package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

	public class CreateDemandPage extends BasePage{
	  
	  @FindBy(xpath="//span[text()='Country']//preceding::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	  WebElement WB_department;
	  
	  @FindBy(xpath="//span[text()='Project']//preceding::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'][1]")
	  WebElement drop_Designation;
	  
	  @FindBy(xpath="//input[@class='TextInput---text TextInput---align_start']")
	  WebElement txt_positions;
	  
	  @FindBy(xpath="//span[text()='Hiring Plan']//following::div[1]")
	  WebElement drop_projectHire;
	  
	  @FindBy(xpath="//span[text()='Project']/following::div[4]")
	  WebElement drop_Project;
	  
	  @FindBy(xpath="//span[text()='Job Type']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'][1]")
	  WebElement drop_JobType;
	  
	  @FindBy(xpath="//span[text()='Country']//following::div[1]")
	  WebElement drop_country;
	    
	  @FindBy(xpath="//span[text()='City']/ancestor::div[contains(@class,'FieldLayout---label_above')]/following-sibling::div//div[contains(@class,'DropdownWidget---dropdown_value')]")
	  WebElement drop_City;
	  
	  @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---secondary Button---small Button---minimize_width Button---inModalDialogLayout Button---icon_start']")
	  WebElement upload_JD;
	   
	  @FindBy(xpath="//label[text()='Mandatory/Preferred Skills']/following::textarea")
	  WebElement txt_Skills;
	  
	  @FindBy(xpath="//button[@class='DatePickerWidget---calendar_btn']")
	  WebElement cal_hiringStartDate;
	  
	  @FindBy(xpath="//span[contains(text(),'90 Days')]")
	  WebElement drop_hiringEndDate;
	  
	  @FindBy(xpath="//span[text()='Priority']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	  WebElement drop_Priority;
	 
	  @FindBy(xpath="//span[text()='Next']//ancestor::button[@class='Button---btn Button---default_direction Button---secondary appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	  WebElement btn_Next;
	 
	  @FindBy(xpath="//button[@type='button']/following::span[text()='Submit']")
	  WebElement btn_Submit;
	 
	  @FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	  WebElement alertSubmit;
	 
	  @FindBy(xpath="//strong[contains(text(),'Demand created successfully!!')]")
	  WebElement message;
	  
	  @FindBy(xpath="//span[text()='Close']")
	  WebElement btn_close;
	  
	  @FindBy(xpath="//strong[text()='Demand created successfully!!']/following::span[contains(text(),'DMN')]")
	  WebElement referenceNumber;
	 
	public CreateDemandPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void select_Department(String dept) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		WB_department.click();
		TestUtil.selectdropdownValue(dept);
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
	
	public void select_hiringType(String dropHiringType) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_projectHire.click();
		TestUtil.selectdropdownValue(dropHiringType);
	}
	
	public void select_Project(String projectOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Project.click();
		TestUtil.selectdropdownValue(projectOption);
	}
	
	public void select_JobType(String jobOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_JobType.click();
		TestUtil.selectdropdownValue(jobOption);
	}
	
	public void select_Country(String countryOption) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_country.click();
		TestUtil.selectdropdownValue(countryOption);
	}
	
	public void select_City(String cityDataFromExcel) throws InterruptedException {
		int flag = 0;
	    String[] dropCities = cityDataFromExcel.split(",");
	
	    TestUtil.WaitUtil(2000);
	    System.out.println("\n Total cities: " + dropCities.length);
	
	    drop_City.click();
	    TestUtil.WaitUtil(1000);
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	    for (String city : dropCities) {
	        city = city.trim();
	        System.out.println("Select city: " + city);
	        String optionXPath = "//*[normalize-space(text())='" + city + "']";
	
	        try {
	            List<WebElement> allOptions = driver.findElements(By.xpath(optionXPath));
	            for (WebElement dropoption : allOptions) {
	                String txt = dropoption.getText().trim();
	                if (txt.equalsIgnoreCase(city)) {
	                    wait.until(ExpectedConditions.elementToBeClickable(dropoption));
	                    dropoption.click();
	                    flag = 1;
	                    System.out.println(flag);
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to select city: " + city + " " + e.getMessage());
	        }
	    }
	
	    drop_City.click();
	}
	
	public void upload_JobDescription(String path) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.fileUploadUsingRobotClass(upload_JD, path);
		TestUtil.WaitUtil(1000);
	}
	
	public void text_Skills(String text) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		txt_Skills.sendKeys(text);
	}
	
	public void select_hiringStartDate(String startDateOption) throws InterruptedException {
	    TestUtil.WaitUtil(2000); 
	    cal_hiringStartDate.click(); 
	    TestUtil.WaitUtil(1000); 
	    TestUtil.selectAppianDate(startDateOption); // Format: "04-Jul-2025"
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
	
	public void clickOnCloseBtn() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		btn_close.click();
		System.out.println("Clicked close button");
	}
	
	public String display_referenceNumber() throws InterruptedException {
//		System.out.println("Demand Reference Number:"+referenceNumber.getText());
		return referenceNumber.getText();
	}
	
	public void clickOnReferenceFromGrid() {
	    try {
	        String demandRefNo = display_referenceNumber();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        String xpath = "//td//span[normalize-space(text())='"+ demandRefNo +"']";
	        WebElement refElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", refElement);
	        refElement.click();

	        System.out.println("Clicked on Demand Reference: " + demandRefNo);
	    } catch (Exception e) {
	        System.err.println("Failed to click reference number from grid");
	        e.printStackTrace();
	    }
	}
	
	}