package shared;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public   class sharedData {
    public static WebDriver driver = null;
    public static  Properties prop = new Properties();
    public static ExtentReports report;
}
