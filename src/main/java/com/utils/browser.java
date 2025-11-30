package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browser
{
     public static  WebDriver openBrowser ( )  {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src//test//resources//configurationFile.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println("My Browser Name is : " + browser);


            if  (browser.equalsIgnoreCase("Chrome")) {
                WebDriver tempDriver  = new ChromeDriver();
                tempDriver.manage().window().maximize();
                return tempDriver;
            }
            if  (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");

                WebDriver tempDriver  = new EdgeDriver(edgeOptions);

                tempDriver.manage().window().maximize();
                return tempDriver;
            }


        }catch (Exception e) {
            System.out.println("ERROR : Either browser doesnot exists or the dependency doesnot exists " + e.toString());
        }
     return null;
    }

    public static void closeBrowser ( WebDriver driverToBeClosed )
    {
        driverToBeClosed.close();
        System.out.println("Browser successfully closed");
    }
}
