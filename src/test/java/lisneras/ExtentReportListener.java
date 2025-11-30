package lisneras;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import shared.sharedData;


public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize ExtentReports before the test suite starts
    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/target/ExtentReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // You can add system information here
        extent.setSystemInfo("Host Name", "Local at 3000");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Shrinjoy");
    }

    // Create a new test in the report for each TestNG test method
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    // Log test status (PASS, FAIL, SKIP) to the report
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");

        extentTest.get().log(Status.PASS, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(com.utils.Evidance.takeScreenshot(sharedData.driver)).build());
        //extentTest.get().
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        extentTest.get().log(Status.FAIL, com.utils.Evidance.takeScreenshot(sharedData.driver));

        // Optionally, add screenshots on failure
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        extentTest.get().log(Status.SKIP, com.utils.Evidance.takeScreenshot(sharedData.driver));

    }

    // Flush the report after the test suite finishes
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}