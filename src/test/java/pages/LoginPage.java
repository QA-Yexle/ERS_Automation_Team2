package pages;

import utility.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='un']")
    WebElement username;

    @FindBy(xpath = "//input[@id='pw']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Sign In']")
    WebElement btn_Login;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(){
        String name = property.getProperty("username_recruiter");
        username.sendKeys(name);
    }

    public void enterPassword(){
        String pwd = property.getProperty("recruiter_pwd");
        password.sendKeys(pwd);
    }

    public void clickOnLogin(){
        btn_Login.click();
    }
}
