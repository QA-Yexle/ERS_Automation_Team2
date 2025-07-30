package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class ExtentManager {
	WebDriver driver;
	@Test
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://yexletest.appiancloud.com/suite/sites/employee-recruitment-system");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

 
}