import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import lisneras.ExtentReportListener;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import shared.sharedData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

//import static com.utils.Evidance.takeScreenshot;
@Listeners(ExtentReportListener.class)
public class LoginTest
{
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    // TC_001 - The below test is ttying to check if the URL is opening.
    @Test
    public void anotherTest()
    {
        Reporter.log(("Opening Browser" + sharedData.prop.getProperty("url")));

        sharedData.driver.get(sharedData.prop.getProperty("url"));
        LoginPage loginPage = new LoginPage(sharedData.driver);


        /*try {
           // Reporter.log(LogStatus, "Screenshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(sharedData.driver)).build());
         //   Reporter.

        } catch (IOException e) {
            System.out.println("Error while taking screenshot");
        }*/

        com.utils.waiting.staticWait();
        com.utils.waiting.staticWait();

        loginPage.typeUsername();
        /*try {
            ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(takeScreenshot(sharedData.driver));
        } catch (IOException e) {
            System.out.println("Error while taking screenshot");
        }*/

        loginPage.clickLoginButton();
        /*try {
            ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(takeScreenshot(sharedData.driver));
        } catch (IOException e) {
            System.out.println("Error while taking screenshot");
        }

        try {
            ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(takeScreenshot(sharedData.driver));
        } catch (IOException e) {
            System.out.println("Error while taking screenshot");
        }

        com.utils.waiting.staticWait();
        try {
            ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(takeScreenshot(sharedData.driver));
        } catch (IOException e) {
            System.out.println("Error while taking screenshot");
        }
*/
        //   System.out.println("Now verify captcha text - " +      sharedData.driver.findElement(By.xpath("//p[@class='captcha_missMatch']")).getText());
        String actualErrorMassage = sharedData.driver.findElement(By.xpath("//p[@class='captcha_missMatch']")).getText();
        Assert.assertEquals(sharedData.prop.getProperty("expectedCaptchaMissmatchMassage").trim(),actualErrorMassage.trim()
                ,"= actual is = "+ actualErrorMassage + "     Expected is = " + sharedData.prop.getProperty("expectedCaptchaMissmatchMassage").trim());

        com.utils.waiting.staticWait();
        com.utils.waiting.staticWait();
        com.utils.waiting.staticWait();
        com.utils.waiting.staticWait();

    }
}
