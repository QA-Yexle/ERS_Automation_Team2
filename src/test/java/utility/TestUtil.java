package utility;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
<<<<<<< HEAD
import org.openqa.selenium.support.locators.RelativeLocator;
=======
>>>>>>> SaiPrathyusha_Team2
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
import java.time.Duration;
=======
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
>>>>>>> SaiPrathyusha_Team2
import java.util.List;
import java.util.Locale;


public class TestUtil extends BasePage{
	 public static long PAGE_LOAD_TIMEOUT = 20;
	    public static long IMPLICIT_WAIT = 20;
	    public static WebDriverWait wait ;
<<<<<<< HEAD

=======
>>>>>>> SaiPrathyusha_Team2
	    public static String TESTDATA_SHEET_PATH = "/Users/naveenkhunteta/Documents/workspace"
	            + "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	    static Workbook book;
	    static Sheet sheet;
	    static JavascriptExecutor js;

	    public void switchToFrame() {
	        driver.switchTo().frame("mainpanel");
	    }
	    
	    public static Object[][] getTestData(String sheetName) {
	        FileInputStream file = null;
	        try {
	            file = new FileInputStream(TESTDATA_SHEET_PATH);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            book = WorkbookFactory.create(file);
	        } catch (InvalidFormatException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        sheet = book.getSheet(sheetName);
	        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	        // System.out.println(sheet.getLastRowNum() + "--------" +
	        // sheet.getRow(0).getLastCellNum());
	        for (int i = 0; i < sheet.getLastRowNum(); i++) {
	            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	                // System.out.println(data[i][k]);
	            }
	        }
	        return data;
	    }
	    
	    public static void takeScreenshotAtEndOfTest() throws IOException {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String currentDir = System.getProperty("user.dir");
	        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	    }
	   
	    public static void WaitUtil(int time) throws InterruptedException {
	        Thread.sleep(time);
	    }
	    
	    public static void clickUsingJavascriptExecutor(WebElement element){
	        js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();",element);
	    }
	    
	    public static boolean isElementVisible(final By by)
	            throws InterruptedException {
	        boolean value = false;

	        if (driver.findElements(by).size() > 0) {
	            value = true;
	        }
	        return value;
	    }
	    
	    public static void selectdropdownValue(String option) throws InterruptedException {
	        Thread.sleep(3000);
	        int flag = 0;	        
	        try {
	            List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@class,'MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget')]"));
	            for (WebElement dropoption : allOptions) {
	                String txtoptions = dropoption.getText();
	                System.out.println(txtoptions);
	                if (txtoptions.toString().equals(option)) {
	                    Actions act = new Actions(driver);
	                    act.moveToElement(dropoption).click().build().perform();
	                    flag = 1;// Set to 1 when the required element was found and clicked.
	                    System.out.println(flag);
	                    break;
	                }
	            }
	        } catch (StaleElementReferenceException e) {
	            List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@class,'MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget')]"));
	            for (WebElement dropoption : allOptions) {
	                String txtoptions = dropoption.getText();
	                System.out.println(txtoptions);
	                if (txtoptions.toString().equals(option)) {
	                    Actions act = new Actions(driver);
	                    act.moveToElement(dropoption).click().build().perform();
	                    flag = 1;// Set to 1 when the required element was found and clicked.
	                    break;
	                }
	            }
	        }
	    }
		
	    public static void enterTextValue(WebElement element, String text) throws InterruptedException {
	        Thread.sleep(1000);
	        String value = text.split("\\.")[0]; 
	        element.clear();
	        element.sendKeys(value);
	        System.out.println("Entered text: " + value);
	    }
	    
	    public static void selectMultipleDropdownValues(WebElement dropdown, String valuesToSelect) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Step 1: Open the dropdown
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
	        dropdown.click();
	        TestUtil.WaitUtil(1000);

	        // Step 2: Clear previously selected values using the "Clear" link
	        try {
	            List<WebElement> clearLinks = driver.findElements(By.xpath("//a[@aria-label='Clear value']"));
	            for (WebElement clear : clearLinks) {
	                if (clear.isDisplayed()) {
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clear);
	                    TestUtil.WaitUtil(500);
	                }
	            }
	            System.out.println("Cleared previous values.");
	        } catch (Exception e) {
	            System.out.println("No clear link found: " + e.getMessage());
	        }

	        // Step 3: Select new values
	        String[] values = valuesToSelect.split(",");
	        for (String value : values) {
	            value = value.trim();
	            String optionXPath = "//*[contains(@class,'MultipleDropdownWidget')]//*[normalize-space(text())='" + value + "']";
	            try {
	                List<WebElement> options = driver.findElements(By.xpath(optionXPath));
	                for (WebElement opt : options) {
	                    if (opt.isDisplayed()) {
	                        wait.until(ExpectedConditions.elementToBeClickable(opt));
	                        opt.click();
	                        System.out.println("Selected: " + value);
	                        break;
	                    }
	                }
	            } catch (Exception e) {
	                System.out.println("Could not select: " + value + " - " + e.getMessage());
	            }
	        }
	    }

<<<<<<< HEAD
public static void createDemandForm() throws InterruptedException {
	wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
	 String[][] criteriaData = {
	            {"Total Experience", "4 Year", "Desirable", "Candidate should have strong leadership skills."},
	            {"Minimum Relevant Experience", "3 Year", "Desirable", "Experience in Spring Boot is a must."},
	            {"Minimum Certification Requirement", "PMP", "Desirable", "Scrum Master certification preferred."},
	            {"Mode of Work", "Remote", "Essential", "Fully remote work allowed."},
	            {"Visit Client Location", "Yes", "Desirable", "Requires occasional travel."},
	            {"Annual Salary( in INR )", "1500000", "Desirable", "Negotiable based on experience."}
	        };
	 
	 for (String[] rowData : criteriaData) {
        String parameterName = rowData[0];
        String criteriaValue = rowData[1];
        String essentialDesirable = rowData[2];
        String comments = rowData[3];
        
        WebElement parameterLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='" + parameterName + "']") // Adjust if text is inside a span/div within td
            ));
            System.out.println("\nProcessing parameter: " + parameterName);
            
            if(parameterName.equals("Total Experience")||parameterName.equals("Minimum Relevant Experience")) {
            	WebElement criteriaDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[1]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout DropdownWidget---placeholder']")));
                criteriaDropdown.click();
                Thread.sleep(1000);
                selectdropdownValue(criteriaValue);
                Thread.sleep(1000);
                WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
                essentialDesirableDropdown.click();
                Thread.sleep(1000);
                selectdropdownValue(essentialDesirable);
                Thread.sleep(2000);
                WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
                commentsField.sendKeys(comments);
            }else if(parameterName.equals("Minimum Certification Requirement")) {
            	WebElement textcertification =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Minimum Certification Requirement']//following::input[1]")));
           	 textcertification.sendKeys(criteriaValue);
           	Thread.sleep(1000);
            WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
            essentialDesirableDropdown.click();
            Thread.sleep(1000);
            selectdropdownValue(essentialDesirable);
            Thread.sleep(2000);
            WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
            commentsField.sendKeys(comments);
            }else if(parameterName.equals("Mode of Work")) {
            	WebElement workModeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[1]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout DropdownWidget---placeholder']")));
            	workModeDropdown.click();
                Thread.sleep(1000);
                String mode = "Remote";
                selectdropdownValue(mode);
                Thread.sleep(1000);
                WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
                essentialDesirableDropdown.click();
                Thread.sleep(1000);
                selectdropdownValue(essentialDesirable);
                Thread.sleep(2000);
                WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
                commentsField.sendKeys(comments);
            }else if(parameterName.equals("Visit Client Location")) {
            	 WebElement radioButtonToSelect;
                 if (criteriaValue.equalsIgnoreCase("Yes")) {
                	// radioButtonToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='Yes']")));
                	 radioButtonToSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='Yes']")));
                	 clickUsingJavascriptExecutor(radioButtonToSelect);
                 } else {
                     radioButtonToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='No']")));
                         // Specific xpath for the 'No' radio button
                 }
                 if (!radioButtonToSelect.isSelected()) {
                     radioButtonToSelect.click();
                     System.out.println("Selected radio button: " + criteriaValue);
                 }
                 Thread.sleep(1000);
                 WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
                 essentialDesirableDropdown.click();
                 Thread.sleep(1000);
                 selectdropdownValue(essentialDesirable);
                 Thread.sleep(2000);
                 WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                         By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
                 commentsField.sendKeys(comments);
            }else if (parameterName.equals("Annual Salary( in INR )")) {
                     WebElement salaryInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='"+parameterName+"']//following::input")));
                     salaryInputField.clear();
                     salaryInputField.sendKeys(criteriaValue);
                     System.out.println("Entered salary: " + criteriaValue);
                     WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
                     essentialDesirableDropdown.click();
                     Thread.sleep(1000);
                     selectdropdownValue(essentialDesirable);
                     Thread.sleep(2000);
                     WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                             By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
                     commentsField.sendKeys(comments);
                         
        }
            }
            
            
            
        
	 }



public static void fileUploadUsingRobotClass(WebElement element,String filepath)  {
	try {
		element.click();
		 Thread.sleep(2000);
	  Robot robot = new Robot();
	  StringSelection stringSelection = new StringSelection(filepath);
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
      System.out.println("File path copied to clipboard: " + filepath);

      // Simulate pressing Ctrl+V (to paste the file path)
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      System.out.println("Pasted file path.");

      // Simulate pressing Enter (to confirm the file selection)
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
      System.out.println("Pressed Enter to confirm file selection.");

      // Give a small pause to allow the file to be processed/uploaded
      Thread.sleep(3000); 

      // 4. (Optional) Verify the upload if there's an indication on the page.
      // For example, if a file name appears next to the input, or a success message.
      // This part is highly dependent on your application's UI.
      // Example: Assuming a div with ID "fileNameDisplay" shows the uploaded file name
      // WebElement uploadedFileNameDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileNameDisplay")));
      // System.out.println("Uploaded file name displayed: " + uploadedFileNameDisplay.getText());
	}catch (AWTException e) {
        System.err.println("Robot class error: " + e.getMessage());
        e.printStackTrace();
    } catch (InterruptedException e) {
        System.err.println("Thread interrupted: " + e.getMessage());
        Thread.currentThread().interrupt(); // Restore the interrupted status
    } catch (Exception e) {
        System.err.println("Selenium or other error: " + e.getMessage());
        e.printStackTrace();
    } 
}


}
=======
	    public static void selecteddropdownValue(String option) throws InterruptedException {
	        Thread.sleep(3000);
	        int flag = 0;

	        // Normalize input: convert "2.0" to "2"
	        if (option.endsWith(".0")) {
	            option = option.substring(0, option.length() - 2);
	        }

	        try {
	            List<WebElement> allOptions = driver.findElements(
	                By.xpath("//*[contains(@class,'MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget')]"));

	            for (WebElement dropoption : allOptions) {
	                String txt = dropoption.getText().trim();

	                // Normalize dropdown value: convert "2.0" to "2" if needed
	                if (txt.endsWith(".0")) {
	                    txt = txt.substring(0, txt.length() - 2);
	                }

	                if (txt.equalsIgnoreCase(option.trim())) {
	                    new Actions(driver).moveToElement(dropoption).click().build().perform();
	                    System.out.println("Selected option: " + txt);
	                    flag = 1;
	                    break;
	                }
	            }

	            if (flag == 0) {
	                System.out.println("Dropdown value '" + option + "' not found.");
	            }

	        } catch (StaleElementReferenceException e) {
	            // Retry on stale element
	            selectdropdownValue(option);
	        }
	    }
	    
	    public static void selectFromAutoSuggestion(WebElement inputField, String partialText) {
	        try {
	            if (partialText == null || partialText.trim().isEmpty()) {
	                System.out.println("No partial text provided for auto-suggestion.");
	                return;
	            }

	            inputField.click();
	            inputField.clear();
	            inputField.sendKeys(partialText);
	            Thread.sleep(1500); // wait for suggestions

	            Actions actions = new Actions(driver);
	            actions.sendKeys(inputField, Keys.ARROW_DOWN)
	                   .sendKeys(Keys.ENTER)
	                   .perform();

	            System.out.println("Selected suggestion for: " + partialText);
	        } catch (Exception e) {
	            System.out.println("Failed to select auto-suggestion for: " + partialText);
	            e.printStackTrace();
	        }
	    }
	    
	    public void selectRadioOptionByQuestion(String questionLabel, String optionValue) {
	    	String xpath = "//span[normalize-space(text())='" + questionLabel.trim() + "']" +
	    	               "/ancestor::div[contains(@class,'FieldLayout---field_layout')]" +
	    	               "//label[normalize-space(text())='" + optionValue.trim() + "']";

	    	WebElement radioLabel = driver.findElement(By.xpath(xpath));
	    	radioLabel.click();
	    }
	    
	    public static void createDemandForm() throws InterruptedException {
			wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			 String[][] criteriaData = {
			            {"Total Experience", "4 Year", "Desirable", "Candidate should have strong leadership skills."},
			            {"Minimum Relevant Experience", "3 Year", "Desirable", "Experience in Spring Boot is a must."},
			            {"Minimum Certification Requirement", "PMP", "Desirable", "Scrum Master certification preferred."},
			            {"Mode of Work", "Remote", "Essential", "Fully remote work allowed."},
			            {"Visit Client Location", "Yes", "Desirable", "Requires occasional travel."},
			            {"Annual Salary( in INR )", "1500000", "Desirable", "Negotiable based on experience."}
			        };
			 
			 for (String[] rowData : criteriaData) {
		        String parameterName = rowData[0];
		        String criteriaValue = rowData[1];
		        String essentialDesirable = rowData[2];
		        String comments = rowData[3];
		        
		        WebElement parameterLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//p[text()='" + parameterName + "']") // Adjust if text is inside a span/div within td
		            ));
		            System.out.println("\n Processing parameter: " + parameterName);
		            
		            if(parameterName.equals("Total Experience")||parameterName.equals("Minimum Relevant Experience")) {
		            	WebElement criteriaDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[1]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout DropdownWidget---placeholder']")));
		                criteriaDropdown.click();
		                Thread.sleep(1000);
		                selectdropdownValue(criteriaValue);
		                Thread.sleep(1000);
		                WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
		                essentialDesirableDropdown.click();
		                Thread.sleep(1000);
		                selectdropdownValue(essentialDesirable);
		                Thread.sleep(2000);
		                WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                        By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
		                commentsField.sendKeys(comments);
		            }else if(parameterName.equals("Minimum Certification Requirement")) {
		            	WebElement textcertification =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Minimum Certification Requirement']//following::input[1]")));
		           	 textcertification.sendKeys(criteriaValue);
		           	Thread.sleep(1000);
		            WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
		            essentialDesirableDropdown.click();
		            Thread.sleep(1000);
		            selectdropdownValue(essentialDesirable);
		            Thread.sleep(2000);
		            WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
		            commentsField.sendKeys(comments);
		            }else if(parameterName.equals("Mode of Work")) {
		            	WebElement workModeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[1]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout DropdownWidget---placeholder']")));
		            	workModeDropdown.click();
		                Thread.sleep(1000);
		                String mode = "Remote";
		                selectdropdownValue(mode);
		                Thread.sleep(1000);
		                WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
		                essentialDesirableDropdown.click();
		                Thread.sleep(1000);
		                selectdropdownValue(essentialDesirable);
		                Thread.sleep(2000);
		                WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                        By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
		                commentsField.sendKeys(comments);
		            }else if(parameterName.equals("Visit Client Location")) {
		            	 WebElement radioButtonToSelect;
		                 if (criteriaValue.equalsIgnoreCase("Yes")) {
		                	// radioButtonToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='Yes']")));
		                	 radioButtonToSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='Yes']")));
		                	 clickUsingJavascriptExecutor(radioButtonToSelect);
		                 } else {
		                     radioButtonToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::input[@value='No']")));
		                         // Specific xpath for the 'No' radio button
		                 }
		                 if (!radioButtonToSelect.isSelected()) {
		                     radioButtonToSelect.click();
		                     System.out.println("Selected radio button: " + criteriaValue);
		                 }
		                 Thread.sleep(1000);
		                 WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
		                 essentialDesirableDropdown.click();
		                 Thread.sleep(1000);
		                 selectdropdownValue(essentialDesirable);
		                 Thread.sleep(2000);
		                 WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                         By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
		                 commentsField.sendKeys(comments);
		                 js.executeScript("(document.evaluate(\"//span[text()='Submit']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).scrollIntoView()");
		            }else if (parameterName.equals("Annual Salary( in INR )")) {
		                     WebElement salaryInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='"+parameterName+"']//following::input")));
		                     salaryInputField.clear();
		                     salaryInputField.sendKeys(criteriaValue);
		                     System.out.println("Entered salary: " + criteriaValue);
		                     WebElement essentialDesirableDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+parameterName+"']//following::td[2]//div[@class='DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout']")));
		                     essentialDesirableDropdown.click();
		                     Thread.sleep(1000);
		                     selectdropdownValue(essentialDesirable);
		                     Thread.sleep(2000);
		                     WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                             By.xpath("//p[text()='" + parameterName + "']//following::td[3]//textarea")));
		                     commentsField.sendKeys(comments);  
		        }
		            }  
		}
		
		public static void fileUploadUsingRobotClass(WebElement element,String filepath)  {
			try {
				element.click();
				 Thread.sleep(2000);
			  Robot robot = new Robot();
			  StringSelection stringSelection = new StringSelection(filepath);
		      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		      System.out.println("\n File path copied to clipboard: " + filepath);
		
		      // Simulate pressing Ctrl+V (to paste the file path)
		      robot.keyPress(KeyEvent.VK_CONTROL);
		      robot.keyPress(KeyEvent.VK_V);
		      robot.keyRelease(KeyEvent.VK_V);
		      robot.keyRelease(KeyEvent.VK_CONTROL);
		      System.out.println("Pasted file path.");
		
		      // Simulate pressing Enter (to confirm the file selection)
		      robot.keyPress(KeyEvent.VK_ENTER);
		      robot.keyRelease(KeyEvent.VK_ENTER);
		      System.out.println("Pressed Enter to confirm file selection. \n");
		
		      // Give a small pause to allow the file to be processed/uploaded
		      Thread.sleep(3000); 
		
		      // 4. (Optional) Verify the upload if there's an indication on the page.
		      // For example, if a file name appears next to the input, or a success message.
		      // This part is highly dependent on your application's UI.
		      // Example: Assuming a div with ID "fileNameDisplay" shows the uploaded file name
		      // WebElement uploadedFileNameDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileNameDisplay")));
		      // System.out.println("Uploaded file name displayed: " + uploadedFileNameDisplay.getText());
			}catch (AWTException e) {
		        System.err.println("Robot class error: " + e.getMessage());
		        e.printStackTrace();
		    } catch (InterruptedException e) {
		        System.err.println("Thread interrupted: " + e.getMessage());
		        Thread.currentThread().interrupt(); // Restore the interrupted status
		    } catch (Exception e) {
		        System.err.println("Selenium or other error: " + e.getMessage());
		        e.printStackTrace();
		    } 
		}
		
		public static void selectAppianDate(String dateStr) {
		    try {
		        LocalDate date;
		        //parsing with both formats
		        try {
		            DateTimeFormatter fullYearFormat = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH);
		            date = LocalDate.parse(dateStr, fullYearFormat);
		        } catch (DateTimeParseException e) {
		            DateTimeFormatter shortYearFormat = DateTimeFormatter.ofPattern("d-MMM-yy", Locale.ENGLISH);
		            date = LocalDate.parse(dateStr, shortYearFormat);
		        }
		        // Formatting the appian input box
		        DateTimeFormatter appianFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String formattedDate = date.format(appianFormat); // example: "04/07/2025"
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(
		        By.cssSelector("input[data-testid='DatePickerWidget-textInput']"))); 
		        dateInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		        dateInput.sendKeys(Keys.DELETE);
		        dateInput.sendKeys(formattedDate);
		        System.out.println(" Successfully entered date: " + formattedDate);
		    } catch (Exception e) {
		        System.out.println(" Failed to enter date: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
		
		public static void switchToNewWindow() {
		    String originalWindow = driver.getWindowHandle();
		    for (String windowHandle : driver.getWindowHandles()) {
		        if (!windowHandle.equals(originalWindow)) {
		            driver.switchTo().window(windowHandle);
		            break;
		        }
		    }
		}

		public static String takeScreenshotAtEndOfTest(String testName) throws IOException {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
		    FileUtils.copyFile(srcFile, new File(screenshotPath));
		    return screenshotPath;
		}
		
		public static void refresh_window() {
			driver.navigate().refresh();
		}
	}

>>>>>>> SaiPrathyusha_Team2
