package testClasses;

//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(utility.MyListener.class) -- This is not the best way 

public class HomeTest extends BaseTest{
	
	@Test
	void homeNavigation() throws InterruptedException {
		homePage.validation_HomePage();
	}

}
