package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;
import utility.TestUtil;

public class NewCandidatePage extends BasePage{
	//candidate tab
	@FindBy (xpath="//span[normalize-space()='Candidates']")
	WebElement candidate;
	//create candidate action
	@FindBy (xpath="//span[normalize-space()='Create Candidate - Click to create a new candidate']//preceding::span[contains(text(),'Create Candidate')]")
	WebElement createCandidate;
	//Candidate
	@FindBy(xpath="//input[@placeholder='Enter Candidate name']/..//input[@placeholder='Enter Candidate name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Enter candidate surname']/..//input[@placeholder='Enter candidate surname']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']/..//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	WebElement drop_Country;
	
	@FindBy(xpath="//body/div[2]//following::div[contains(text(),'India')]")
	WebElement country_India;
	
	@FindBy(xpath="//body/div[2]//preceding::input[@placeholder='Aadhar Card Number']")
	WebElement aadhar_Number;  
	
	
	@FindBy(xpath="//input[@placeholder='Enter Personal Email ']/..//input[@placeholder='Enter Personal Email ']")
	WebElement email_ID;
	
	@FindBy(xpath="(//input[@placeholder='ex:94XXXXXX83']/..//input[@placeholder='ex:94XXXXXX83'])[1]")
	WebElement primary_MobileNum;
	
	@FindBy(xpath="(//*[@class='DropdownWidget---dropdown_caret'])[4]") 		//click
	WebElement drop_sceMob;
	
	@FindBy(xpath="(//li[@class='MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget'])[1]")    
	WebElement drop_select;
	
	@FindBy(xpath="(//input[@placeholder='ex:94XXXXXX83'])[2]"  )//sendkeys"
	WebElement secondary_MobileNum;
	
	@FindBy(xpath="//input[@placeholder='https://www.linkedin.com/in/XXXXX/']")
	WebElement linkedIn;

	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---outline appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']/..//button[@class='Button---btn Button---default_direction Button---outline appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement nxt_button;
	
	//Education Details
	@FindBy(xpath="//label[normalize-space()='Highest Degree']//following::input[@placeholder='Enter Highest Degree You Hold']")
	WebElement highestDegree;
	
	@FindBy(xpath="//label[normalize-space()='College']//following::input[@placeholder='Enter College Name']")
	WebElement clgName;
	
	@FindBy(xpath="//label[normalize-space()='University']//following::input[@placeholder='Enter University Name']")
	WebElement universityName;
	
	@FindBy(xpath="//label[normalize-space()='Graduation Year/ Year of Passing']//following::input[@placeholder='Enter Graduation Year']")
	WebElement yearofPassing;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---outline appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement edu_nxtButton;
	
	//Professional details 
	@FindBy(xpath="(//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[1]")
	WebElement drop_Department;
	
	@FindBy(xpath="//div[normalize-space()='QA']")
	WebElement app_Department;
	
	@FindBy(xpath="(//div[@class='MultipleDropdownWidget---dropdown_value'])[1]")
	WebElement drop_Type;
	
	@FindBy(xpath="//span[normalize-space()='Manual']")
	WebElement select_Type;
	
	@FindBy(xpath="(//strong[normalize-space()='Total Experience']/../../../../..//div[@role='combobox'])[1]")
	WebElement drop_Exp_Year;
	
	@FindBy(xpath="//div[@class='TetherComponent---sailcontents appian-context-browser-chrome appian-context-os-windows MenuLayout---button_menu tether-enabled tether-out-of-bounds tether-out-of-bounds-bottom tether-out-of-bounds-right tether-element-attached-bottom tether-element-attached-left tether-target-attached-top tether-target-attached-left']//following::div[normalize-space()='3']")
	WebElement expYear;
	
	@FindBy(xpath="(//span[@class='FieldLayout---field_label']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---inSideBySideItem'])[2]")
	WebElement drop_Exp_Month;
	
	@FindBy(xpath="//input[@placeholder='Search']//following::div[normalize-space()='7']")
	WebElement exp_Month;
	
	//Relevant Experience
	@FindBy(xpath="//strong[normalize-space()='Relevant Experience']//following::span[contains(text(),'---Select no of years---')]")
	WebElement drop_Relevant_ExpYear;
	
	@FindBy(xpath="//input[@placeholder='Search']//following::div[normalize-space()='2']")
	WebElement relavant_Exp_Year;
	
	@FindBy(xpath="(//span[@class='FieldLayout---field_label']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---inSideBySideItem'])[4]")
	WebElement drop_Relevant_ExpMonth;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---inSideBySideItem']//following::div[normalize-space()='3']")
	WebElement relevant_Exp_Month;
	
	//Current Salary
	@FindBy(xpath="//strong[normalize-space()='Current Salary (Annual Salary)']/../../../../..//span[contains(text(),'--- Currency Type---')]")
	WebElement drop_Current_Sal;
	
	@FindBy(xpath="//strong[normalize-space()='Current Salary (Annual Salary)']//following::div[normalize-space()='INR']")
	WebElement select_currentSalary;
	
	@FindBy(xpath="//strong[normalize-space()='Current Salary (Annual Salary)']/../../../../..//input[@placeholder='Enter Current Annual Salary of Candidate']")
	WebElement enter_CurrentSalary;
	
	@FindBy(xpath="//strong[contains(text(),'Expected Salary')]//following::span[contains(text(),'--- Currency Type---')]")
	WebElement drop_ExpectedSal;
	
	@FindBy(xpath="//strong[contains(text(),'Expected Salary')]//following::div[normalize-space()='INR']")
	WebElement select_expectedSal;
	
	@FindBy(xpath="//strong[contains(text(),'Expected Salary')]//following::input[@placeholder='Enter Current Annual Salary of Candidate']")
	WebElement enter_expectedSal;
	
	@FindBy(xpath="//label[normalize-space()='Current Location']//following::input[@placeholder='Current Working location of Candidate']")
	WebElement current_Location;
	
	//Preferred Location
	@FindBy(xpath="//span[@data-placeholder='select Location']/..//span[@class='MultipleDropdownWidget---value_display']")
	WebElement drop_Location;
	
	@FindBy(xpath="//span[normalize-space()='Hyderabad']")
	WebElement preffered_Location;
	
	@FindBy(xpath="(//label[normalize-space()='Current Organisation']//following::input[@class='TextInput---text TextInput---align_start'])[1]")
	WebElement current_Organisation;
	
	@FindBy(xpath="//label[normalize-space()='Current Designation']//following::input[@placeholder='Ex : senior Consultant']")
	WebElement current_Designation;
	
	@FindBy(xpath="(//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[1]")
	WebElement drop_NoticePeriod;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder appian-context-ux-mouse-focus']//following::div[normalize-space()='90 Days']")
	WebElement notice_Period;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/appian-action-dialog[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement drop_CurrentEmploymentType;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder appian-context-ux-mouse-focus']//following::div[normalize-space()='Regular']")
	WebElement current_EmploymentType;
	
	@FindBy(xpath="//span[@class='FieldLayout---field_label']//following::label[normalize-space()='Yes']")
	WebElement radiobut_NoticePeriod;
	
	@FindBy(xpath="//label[normalize-space()='Certification']//following::input[@placeholder='ex : Appian L3 Certification']")
	WebElement certification;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---outline appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement professional_nxtbutton;
	
	@FindBy(xpath="(//span[@class='FieldLayout---field_label']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[1]")
	WebElement drop_Source;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder appian-context-ux-mouse-focus']//following::div[normalize-space()='Job Posting']")
	WebElement source_Select;
	
	@FindBy(xpath="//span[@class='FieldLayout---field_label']//following::div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']")
	WebElement drop_jobposting_Type;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder appian-context-ux-mouse-focus']//following::div[normalize-space()='LinkedIn']")
	WebElement select_jobpostingtype;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement file_upload;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement submit_button;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement conf_button;
	
	public NewCandidatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void click_CandidateTab() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        candidate.click();
    }
	
	public void click_CreateCandidate() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        createCandidate.click();
    }
	
	public void enter_Firstname(String fname) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		firstName.sendKeys(fname);
		}
	
	public void enter_Lastname(String lname) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		lastname.sendKeys(lname);
		}
	public void select_CountryIndia() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        drop_Country.click();
        TestUtil.WaitUtil(5000);
        country_India.click();
        }
	public void enter_Aadhar(String aadhar) throws InterruptedException {
        TestUtil.WaitUtil(2000);
        aadhar_Number.sendKeys(aadhar);
	}
	public void enter_Email(String email) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		email_ID.sendKeys(email);
	}
	public void enter_PrimaryMobile(String num) throws InterruptedException {
        TestUtil.WaitUtil(2000);
        primary_MobileNum.sendKeys(num);
    }
	public void select_SecondaryMobileType() throws InterruptedException {
        TestUtil.WaitUtil(2000);
        drop_sceMob.click();
        TestUtil.WaitUtil(2000);
        drop_select.click();
    }
	public void enter_SecondaryMobile(String num) throws InterruptedException {
        TestUtil.WaitUtil(2000);
        secondary_MobileNum.sendKeys(num);
    }
	
	public void enter_LinkedIn(String url) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		linkedIn.sendKeys(url);
	}
	
	public void click_NextButton() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		nxt_button.click();
	}
	
	public void enter_HighestDegree(String degree) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		highestDegree.sendKeys(degree);
	}
	
	public void enter_CollegeName(String college) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		clgName.sendKeys(college);
	}
	
	public void enter_UniversityName(String university) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		universityName.sendKeys(university);
	}
	
	public void enter_YearOfPassing(String year) throws InterruptedException {
	    TestUtil.WaitUtil(2000);
	    
	    if (year != null && !year.trim().isEmpty()) {
	        System.out.println("Year of Passing from Excel: " + year);
	        yearofPassing.sendKeys(year);
	    } else {
	        System.err.println("Provided year is null or empty! Check Excel file or test data.");
	    }
	}

	
	public void click_EducationNxt() throws InterruptedException{
		TestUtil.WaitUtil(2000);
		edu_nxtButton.click();
	}
	
	public void select_Department() throws InterruptedException{
		TestUtil.WaitUtil(2000);
		drop_Department.click();
		TestUtil.WaitUtil(2000);
		app_Department.click();
	}
	
	public void select_Type() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Type.click();
		TestUtil.WaitUtil(2000);
		select_Type.click();
	}
	public void select_Experience(String year, String month) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Exp_Year.click();
		TestUtil.WaitUtil(1000);
		expYear.click();
		TestUtil.WaitUtil(2000);
		drop_Exp_Month.click();
		TestUtil.WaitUtil(1000);
		exp_Month.click();
	}
	public void select_RelevantExperience(String year, String month) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Relevant_ExpYear.click();
		TestUtil.WaitUtil(1000);
		relavant_Exp_Year.click();
		TestUtil.WaitUtil(2000);
		drop_Relevant_ExpMonth.click();
		TestUtil.WaitUtil(1000);
		relevant_Exp_Month.click();
	}
	public void enter_CurrentSalary(String salary) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Current_Sal.click();
		TestUtil.WaitUtil(2000);
		select_currentSalary.click();
		TestUtil.WaitUtil(2000);
		enter_CurrentSalary.sendKeys(salary);
	}
	public void enter_ExceptedSalary(String salary) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		drop_ExpectedSal.click();
		TestUtil.WaitUtil(2000);
		select_expectedSal.click();
		TestUtil.WaitUtil(2000);
		enter_expectedSal.sendKeys(salary);
			
	}
	
	public void enter_CurrentLocation(String location) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		current_Location.sendKeys(location);
	}

	public void select_PreferredLocation() throws InterruptedException{
		TestUtil.WaitUtil(2000);
		drop_Location.click();
		TestUtil.WaitUtil(1000);
		preffered_Location.click();
	}

	public void enter_CurrentOrganisation(String organisation) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		current_Organisation.sendKeys(organisation);
	}
	
	public void enter_CurrentDesignation(String designation) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		current_Designation.sendKeys(designation);
	}
	
	public void select_NoticePeriod() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_NoticePeriod.click();
		TestUtil.WaitUtil(2000);
		notice_Period.click();
	}
	
	public void select_EmploymentType() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_CurrentEmploymentType.click();
		TestUtil.WaitUtil(2000);
		current_EmploymentType.click();
	}
	
	public void select_NoticePeriodOption() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		radiobut_NoticePeriod.click();
	}
	
	public void enter_Certification(String cert) throws InterruptedException{
		TestUtil.WaitUtil(2000);
		certification.sendKeys(cert);
	}

	public void click_ProfessionalNxt()throws InterruptedException{
		TestUtil.WaitUtil(2000);
		professional_nxtbutton.click();
	}

	public void select_Source() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_Source.click();
		TestUtil.WaitUtil(2000);
		source_Select.click();
	}
	
	public void select_JobPostingType() throws InterruptedException {
		TestUtil.WaitUtil(2000);
		drop_jobposting_Type.click();
		TestUtil.WaitUtil(2000);
		select_jobpostingtype.click();
	}
	
	public void upload_File(String filePath) throws InterruptedException {
		TestUtil.WaitUtil(2000);
		file_upload.sendKeys(filePath); 
	}

	public void click_Submit()throws InterruptedException{
		TestUtil.WaitUtil(2000);
		submit_button.click();
	}
	
	public void click_Conf()throws InterruptedException{
		TestUtil.WaitUtil(2000);
		conf_button.click();
	}

}
