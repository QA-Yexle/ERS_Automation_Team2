package testClasses;

import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	
	@Test
	void homeNavigation() throws InterruptedException {
		homePage.Validation_HomePage();
	}

}
