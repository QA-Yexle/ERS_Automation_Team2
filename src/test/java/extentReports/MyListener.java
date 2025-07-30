package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
public class MyListener implements ITestListener
{
	@Override
    public void onTestStart(ITestResult result) {
       // System.out.println("Test Start");
    }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
	  }
	public void onTestFailure(ITestResult result) {
	    // not implemented
	  }
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	public void onStart(ITestContext context) {
	    // not implemented
	  }
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
	
 
}