package com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class waiting
{
    public  static void staticWait()
    {
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream("src//test//resources//configurationFile.properties");
            prop.load(input);
            Integer waitTime = Integer.parseInt(prop.getProperty("waitTime"));
            Thread.sleep(waitTime);
        }catch (Exception e) {}
    }
}
