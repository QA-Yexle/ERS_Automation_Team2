package utility;

import java.io.FileInputStream;
<<<<<<< HEAD
=======
import org.openqa.selenium.WebDriver;
>>>>>>> Haseena_Team2

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public static WebDriver driver;
	public static Properties property;
	
	public BasePage(){
		try {
			property = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/Config/config.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			System.err.println("Configuration file not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Configuration file not found: " + e.getMessage());
		}
		}
	
	
	public static void initialization(){
		String browserName = property.getProperty("browser");
		
		if(browserName.equals("chrome")){
			driver = new ChromeDriver(); 
		}
		else {
			System.out.println("Driver not found");
		}	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
		driver.get(property.getProperty("application_URL"));
		}
	}