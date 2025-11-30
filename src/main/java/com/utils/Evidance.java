package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import shared.sharedData;

import java.io.File;
import java.io.IOException;

import static shared.sharedData.driver;

public class Evidance {
    public static String takeScreenshot (WebDriver driver)
    {

        TakesScreenshot  ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path and save the screenshot
        File destination = new File("screenshots/visible_screenshot"+System.currentTimeMillis()+".jpg");
        try {
            FileUtils.copyFile(source, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Screenshot of visible area saved at: " + destination.getAbsolutePath());

    return destination.getAbsolutePath();


        }

       /*public static void embeddedScreenshotINtoReport ()
       {
           try {
               ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(takeScreenshot(sharedData.driver));
           } catch (IOException e) {
               System.out.println("Error while taking screenshot");
           }

       }*/
}
