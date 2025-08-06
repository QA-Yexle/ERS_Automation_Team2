package utility;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports report;

    // Using ThreadLocal to ensure thread-safety for parallel test execution
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Adding timestamp to report file name for uniqueness
        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/AutomationReport_" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(sparkReporter);

        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String os = System.getProperty("os.name");
            String username = System.getProperty("user.name");
            String browser = BasePage.property.getProperty("browser");
            String app_URL = BasePage.property.getProperty("application_URL");

            report.setSystemInfo("Computer Name", hostname);
            report.setSystemInfo("Environment", "QA");
            report.setSystemInfo("Application URL", app_URL);
            report.setSystemInfo("Tester Name", username);
            report.setSystemInfo("OS", os);
            report.setSystemInfo("Browser Name", browser);
        } catch (UnknownHostException e) {
            System.err.println("Failed to get system information: " + e.getMessage());
        }
    }

    // Initializing the ExtentTest before each test begins
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = report.createTest(result.getMethod().getMethodName());
        extentTest.set(test); // ✅ Store it in ThreadLocal for thread safety
        extentTest.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName()); // ✅ Optional info log
    }

    // Using thread-safe ExtentTest reference
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    // Logging failure and attach screenshot
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Reason: " + result.getThrowable());

        try {
            // Take screenshot with test method name
            String screenshotPath = TestUtil.takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath); // ✅ Attach screenshot to report
        } catch (IOException e) {
            // Handle screenshot failure gracefully
            extentTest.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    // Use thread-safe logging for skipped tests
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    // Keep flush at the end to ensure report is written
    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
