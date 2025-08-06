package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BasePage;
import utility.TestUtil;

public class MapCandidatePage extends BasePage{
	
	@FindBy(xpath="//a[text()='Map Candidate']")
	WebElement click_mapCandidateLink;
	
	@FindBy(xpath="//strong[text()='Add Candidate to Demand']/following::input[@placeholder='Search Applications']")
	WebElement enter_candidateAppInSearchBox;
	
	@FindBy(xpath="//strong[text()='Add Candidate to Demand']/following::span[text()='Search']")
	WebElement search_candidateApp;
	
	@FindBy(xpath="//div[contains(@class,'CheckboxGroup---choice_group')]")
	WebElement searched_candidateAppRowChkbox;
	
	@FindBy(xpath="//button[.//span[text()='Next']]")
	WebElement btn_next;
	
	@FindBy(xpath="(//span[text()='Years']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//span[text()])[2]")
	WebElement totalExperience_dropYear;
	
	@FindBy(xpath="(//span[text()='Months']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//span[text()])[4]")
	WebElement totalExperience_dropMonth;
	
	@FindBy(xpath="(//span[text()='Years']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//span[text()])[6]")
	WebElement relevantExperience_dropYear;
	
	@FindBy(xpath="(//span[text()='Months']/ancestor::div[contains(@class,'FieldLayout---field_layout')]//span[text()])[8]")
	WebElement relevantExperience_dropMonth;
	
	@FindBy(xpath="(//strong[text()='Current Salary (Annual Salary)']/following::span[text()])[1]")
	WebElement currentSal_currencyType;
	
	@FindBy(xpath="(//strong[text()='Current Salary (Annual Salary)']/following::input[@value])[1]")
	WebElement currentSal_currency;
	
	@FindBy(xpath="(//strong[text()='Current Salary (Annual Salary)']/following::span[text()])[2]")
	WebElement expectedSal_currencyType;
	
	@FindBy(xpath="(//strong[text()='Current Salary (Annual Salary)']/following::input[@value])[2]")
	WebElement expectedSal_currency;
	
	@FindBy(xpath="//label[text()='Current Location']/following::input[@value][1]")
	WebElement txt_currentLocation;
	
	@FindBy(xpath="//span[text()='Preferred Location']/following::span[text()][1]")
	WebElement drop_preferredLocation;
	
	@FindBy(xpath="//label[contains(text(),'Current Organisation')]/following::input[@value]")
	WebElement txt_currentOrganization;
	
	@FindBy(xpath="//label[contains(text(),'Current Designation')]/following::input[@value]")
	WebElement txt_currentDesignation;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::span[text()='Notice Period']/following::span[text()])[1]")
	WebElement drop_noticePeriod;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::label[text()='Last Working Date (Tentative)']/following::input[@value])[1]")
	WebElement cal_lastWorkingDate;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::span[text()='Current Employment Type']/following::span[text()])[1]")
	WebElement drop_currentEmployeeType;
	
	@FindBy(xpath="//label[text()='Certification']/following::input[@value]")
	WebElement txt_certification;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::span[text()='Source']/following::span[text()])[1]")
	WebElement drop_source;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::span[text()='Job Posting Type']/following::span[text()])[1]")
	WebElement drop_jobPostingType;
	
	@FindBy(xpath="(//div[@class='FieldLayout---label_above']/child::span[text()='Vendor Name']/following::span[text()])[1]")
	WebElement drop_vendorNameType;
	
	@FindBy(xpath="//div[@class='FieldLayout---label_above']/child::span[text()='Referred By']/following::input[@value][1]")
	WebElement picker_referral;
	
	@FindBy(xpath="//label[text()='Profile Received Date']/following::input[@value]")
	WebElement date;
	
	@FindBy(xpath="//span[text()='CV/Resume']/following::span[text()='Upload']")
	WebElement fileUpload_cv;
	
	@FindBy(xpath="(//span[text()='CitizenShip Status']/following::span[text()])[1]")
	WebElement drop_citizenshipStatus;
	
	@FindBy(xpath="//div[text()='Supporting Document']/following::a[text()='Add Document']")
	WebElement link_newDocument;
	
	@FindBy(xpath="//div[text()='Supporting Document']/following::span[text()='Upload']")
	WebElement supportingDoc_fileUpload;
	
	@FindBy(xpath="//div[text()='Supporting Document']/following::input[@type='text']")
	WebElement supportingDoc_comments;
	
	@FindBy(xpath="//div[text()='Supporting Document']/following::a[contains(@class,'LinkedItem---standalone_richtext_link')]")
	WebElement removeDocument;
	
	@FindBy(xpath="//button/following::span[text()='Submit']")
	WebElement btn_submit;
	
	@FindBy(xpath="//button[@type='button']/following::span[text()='Yes']")
	WebElement alertSubmit;
	
	@FindBy(xpath="//strong[text()='Candidate added to the demand successfully!!']")
	WebElement message;
	
	public MapCandidatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void map_CandidateLink() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		click_mapCandidateLink.click();
	}
	
	public void select_CandidateApp(String candidateRefNo) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		enter_candidateAppInSearchBox.sendKeys(candidateRefNo);
		TestUtil.WaitUtil(2000);
		search_candidateApp.click();
		TestUtil.WaitUtil(2000);
		searched_candidateAppRowChkbox.click();
	}
	
	public void select_nextBtn() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		btn_next.click();
	}
	
	public void select_totalExp(String total_year, String total_month) throws InterruptedException {
	    TestUtil.WaitUtil(2000);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_next);
	    totalExperience_dropYear.click();
	    TestUtil.selecteddropdownValue(total_year);
	    TestUtil.WaitUtil(2000);
	    totalExperience_dropMonth.click();
	    TestUtil.selecteddropdownValue(total_month);
	}

	public void select_relevantExp(String relevant_year, String relevant_month) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		relevantExperience_dropYear.click();
		TestUtil.selecteddropdownValue(relevant_year);
		TestUtil.WaitUtil(2000);
		relevantExperience_dropMonth.click();
		TestUtil.selecteddropdownValue(relevant_month);
	}
	
	public void select_currentSalCurrencyDetails(String current_currency, String current_currencyType) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		currentSal_currencyType.click();
		TestUtil.selectdropdownValue(current_currencyType);
		TestUtil.WaitUtil(2000);
		currentSal_currency.click();
		TestUtil.enterTextValue(currentSal_currency, current_currency);
	}
	
	public void select_expectedSalCurrencyDetails(String expected_currency, String expected_currencyType) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		expectedSal_currencyType.click();
		TestUtil.selectdropdownValue(expected_currencyType);
		TestUtil.WaitUtil(2000);
		expectedSal_currency.click();
		TestUtil.enterTextValue(expectedSal_currency, expected_currency);
	}
	
	public void enter_currentLocation(String text) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.enterTextValue(txt_currentLocation, text);
	}
	
	public void select_preferredLocation(String preferredLocation) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.selectMultipleDropdownValues(drop_preferredLocation, preferredLocation);
	}
	
	public void enter_currentOrganization(String CO_text) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.enterTextValue(txt_currentOrganization, CO_text);
	} 
	
	public void enter_currentDesignation(String CD_text) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.enterTextValue(txt_currentDesignation, CD_text);
	} 
	
	public void select_noticePeriod(String noticePeriod) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_noticePeriod.click();
		TestUtil.selectdropdownValue(noticePeriod);
	}
	
	public void select_employeeType(String empType) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_currentEmployeeType.click();
		TestUtil.selectdropdownValue(empType);
	}
	
	public void select_lastWorkingDate(String lastWorkingDate)throws InterruptedException {
		TestUtil.WaitUtil(2000);
		String noticePeriodValue = drop_noticePeriod.getText();
		if(noticePeriodValue.equals("Serving Notice") || noticePeriodValue.equals("Immediate")) {
		cal_lastWorkingDate.click();
		TestUtil.WaitUtil(1000);
		TestUtil.selectAppianDate(lastWorkingDate);
		}else {
			System.out.println("Notice period value is:\n"+noticePeriodValue+"\nhence this field is not applicable");
		}
	}
	
	public void select_noticePeriodNegotiable(String valueFromExcel) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		String noticePeriodVal = drop_noticePeriod.getText();
		if(noticePeriodVal.equals("30 Days") || noticePeriodVal.equals("45 Days") || noticePeriodVal.equals("60 Days") || noticePeriodVal.equals("90 Days")) {
		String xpath = "//span[normalize-space(text())='Notice Period Negotiable ?']" + "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +"//label[normalize-space(text())='" + valueFromExcel.trim() + "']";
		WebElement radioLabel = driver.findElement(By.xpath(xpath));
		radioLabel.click();
		}else {
			System.out.println("Notice period value is:\n"+noticePeriodVal+"\nhence this field is not applicable");
		}
	}
	
	public void enter_txtCertification(String certificationTxtOptional) throws InterruptedException {
		TestUtil.enterTextValue(txt_certification, certificationTxtOptional);
	}
	
	public void select_source(String source) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_submit);
		drop_source.click();
		TestUtil.selecteddropdownValue(source);
	}
	
	public void select_sourceType(String value) throws InterruptedException {
	    TestUtil.WaitUtil(2000);
	    String source = drop_source.getText();

	    if (source.equals("Job Posting")) {
	        drop_jobPostingType.click();
	        TestUtil.selectdropdownValue(value);

	    } else if (source.equals("External")) {
	        drop_vendorNameType.click();
	        TestUtil.selectdropdownValue(value);

	    } else if (source.equals("Referral")) {
	        TestUtil.WaitUtil(2000);
	        if (value != null && !value.trim().isEmpty()) {
	            TestUtil.selectFromAutoSuggestion(picker_referral, value);
	        } else {
	            System.out.println("Referred By value is null or empty.");
	        }

	    } else {
	        System.out.println("Invalid source type: " + source);
	    }
	}

	public void select_authorizationRadioOptions(String valueFromExcel1, String valueFromExcel2, String valueFromExcel3) throws InterruptedException {
	    TestUtil.WaitUtil(2000);
	    
	    String trimmedValue1 = valueFromExcel1.trim();
	    String trimmedValue2 = valueFromExcel2.trim();
	    String trimmedValue3 = valueFromExcel3.trim();

	    String xpath1 = "//span[contains(text(),'Are you currently authorized')]" + 
	                    "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +
	                    "//label[normalize-space(text())='" + trimmedValue1 + "']";

	    WebElement radioLabel1 = driver.findElement(By.xpath(xpath1));
	    radioLabel1.click();

	    if (trimmedValue1.equalsIgnoreCase("yes")) {
	        String xpath2 = "//span[contains(text(),'sponsorships / extensions')]" + 
	                        "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +
	                        "//label[normalize-space(text())='" + trimmedValue2 + "']";

	        String xpath3 = "//span[contains(text(),'Does this authorisation')]" + 
	                        "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +
	                        "//label[normalize-space(text())='" + trimmedValue3 + "']";
	        
	        TestUtil.WaitUtil(2000);
	        WebElement radioLabel2 = driver.findElement(By.xpath(xpath2));
	        radioLabel2.click();
	        TestUtil.WaitUtil(2000);
	        WebElement radioLabel3 = driver.findElement(By.xpath(xpath3));
	        radioLabel3.click();
	    } else {
	        System.out.println("Radio button1 value is: " + trimmedValue1);
	    }
	}

	
	public void cal_profileReceivedDate(String profileDate) throws InterruptedException{
		TestUtil.WaitUtil(2000); 
	    date.click(); 
	    TestUtil.WaitUtil(1000); 
	    TestUtil.selectAppianDate(profileDate);
	}
	
	public void upload_resume(String path) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.fileUploadUsingRobotClass(fileUpload_cv, path);
		TestUtil.WaitUtil(1000);
	}
	
	public void select_openForRelocation(String relocationFromExcel) {
		String xpath_Val = "//span[normalize-space(text())='Open For Relocation ?']" +
		               "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +
		               "//label[normalize-space(text())='" + relocationFromExcel.trim() + "']";

		WebElement radioLabel = driver.findElement(By.xpath(xpath_Val));
		radioLabel.click();
	}
	
	public void select_citizenshipStatus(String status) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_citizenshipStatus.click();
		TestUtil.selecteddropdownValue(status);
	}
	
	
	public void link_addnewDocument() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		link_newDocument.click();
	}
	
	public void upload_supportingDoc(String SD_path) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		TestUtil.fileUploadUsingRobotClass(supportingDoc_fileUpload, SD_path);
		TestUtil.WaitUtil(1000);
	}
	
	public void enter_sdTxt(String docText) throws InterruptedException {
		TestUtil.enterTextValue(supportingDoc_comments, docText);
	}
	
	public void remove_document(String remove) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		if(remove.equalsIgnoreCase("Y")) {
			removeDocument.click();
		}else {
			System.out.println("New doc uploaded");
		}
	}	
	
	public void click_submitButton() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		btn_submit.click();
		TestUtil.WaitUtil(2000);
		alertSubmit.click();
	}
	
	public void verify_candidateMessage() throws InterruptedException {
		TestUtil.WaitUtil(1000);
		Assert.assertTrue(message.isDisplayed(),"Candidate added to the demand successfully!!");
	}
}
