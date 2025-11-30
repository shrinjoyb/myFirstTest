package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.sharedData;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage {
    WebElement userID = null;
    WebElement password = null;
    WebElement loginButton = null;
    public WebElement captchaMismatchMessage = null;
    Properties prop = new Properties();
    WebDriver browser ;
    public  LoginPage(WebDriver browser) {
        this.userID= browser.findElement(By.xpath("//input[@placeholder='User ID']"));
        this.password= browser.findElement(By.xpath("//input[@placeholder='Password']"));
        this.loginButton= browser.findElement(By.xpath("//button[normalize-space()='Login']"));
        this.browser=browser;
        try {
            InputStream input = new FileInputStream("src//test//resources//configurationFile.properties");
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void typeUsername() {
        userID.sendKeys((prop.getProperty("username")));
    }
    public void typepassword() {
        password.sendKeys((prop.getProperty("password")));
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void getCaptchaMismatchMessage() {
     //   this.captchaMismatchMessage = browser.findElement(By.xpath("//p[@class='captcha_missMatch']"));

    }
}
