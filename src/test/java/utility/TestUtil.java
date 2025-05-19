package utility;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class TestUtil extends BasePage{
	 public static long PAGE_LOAD_TIMEOUT = 20;
	    public static long IMPLICIT_WAIT = 20;

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

}
