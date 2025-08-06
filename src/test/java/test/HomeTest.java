package test;

import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    HomePage homePage;

    @Test
    public void homeNavigation() throws InterruptedException {
        homePage = new HomePage();  // ✅ initialize the page object
        homePage.Validation_HomePage();
    }
}
