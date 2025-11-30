import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import shared.sharedData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestInitialization
{
    @BeforeSuite
    public void beforeSuite() {
        try {
            InputStream input = new FileInputStream("src//test//resources//configurationFile.properties");
            sharedData.prop.load(input);
        } catch (IOException e) {
           e.printStackTrace();
        }

        Reporter.log("Before Suite");

        sharedData.driver =
                com.utils.browser.openBrowser();
    }
    @AfterSuite
    public void afterSuite() {
        Reporter.log("After Suite");
        com.utils.browser.closeBrowser(sharedData.driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) throws IOException {
        // The ITestResult is a mandatory parameter
        //ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(iTestResult,com.utils.Evidance.takeScreenshot(sharedData.driver));
    }

}
