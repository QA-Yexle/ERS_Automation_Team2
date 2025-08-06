package extentReports;

import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
 
import java.io.File;
import java.io.IOException;
 
import org.openqa.selenium.*;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
public class ExtentReportManager {
 
    ExtentReports extent;
    ExtentSparkReporter reporter;
    WebDriver driver;
 
    @BeforeTest
    public void setupExtentReport() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);
 
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "XYZ");
        extent.setSystemInfo("Browser", "Chrome");
 
        driver = new ChromeDriver();
    }
 
    @Test
    public void username() throws IOException {
        ExtentTest test = extent.createTest("Username Test");
        driver.get("https://yexletest.appiancloud.com/suite/sites/employee-recruitment-system");
 
        WebElement username = driver.findElement(By.xpath("//input[@id='un']"));
        username.sendKeys("recruiter.user@yexle.com");
 
        String screenshotPath = takeScreenshot("username");
        test.addScreenCaptureFromPath(screenshotPath);
    }
 
    @Test(dependsOnMethods = "username")
    public void password() throws IOException {
        ExtentTest test = extent.createTest("Password Test");
        WebElement password = driver.findElement(By.xpath("//input[@id='pw']"));
        password.sendKeys("Appian12");
 
        String screenshotPath = takeScreenshot("password");
        test.addScreenCaptureFromPath(screenshotPath);
    }
 
    @Test(dependsOnMethods = "password")
    public void login() throws IOException {
        ExtentTest test = extent.createTest("Login Test");
        WebElement login = driver.findElement(By.xpath("//input[@id='jsLoginButton']"));
        login.click();
 
        String screenshotPath = takeScreenshot("login");
        test.addScreenCaptureFromPath(screenshotPath);
    }
 
    @AfterTest
    public void tearDown() {
      //  driver.quit();
        extent.flush();
    }
 
    public String takeScreenshot(String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = System.getProperty("user.dir") + "\\reports\\screenshots\\";
        new File(screenshotDir).mkdirs();  // Ensure directory exists
        String destPath = screenshotDir + screenshotName + ".png";
 
        try {
            FileUtils.copyFile(src, new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
}