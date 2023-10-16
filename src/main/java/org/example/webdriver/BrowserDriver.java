package org.example.webdriver;

import org.apache.poi.ss.formula.atp.Switch;
import org.example.urls.URLS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

public class BrowserDriver {
    public static Properties properties;
    public static WebDriver  driver;
    public  static void getDriver()  {

        try {
            File file=new File("src\\global.properties");
            FileReader reader =new FileReader (file.getAbsolutePath());
            properties=new Properties();
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      String browser = properties.getProperty("browser");
        switch (browser)
        {
            case "chrome" :
            {
               driver=new ChromeDriver();
               driver.get(URLS.orangeHRM);
                driver.manage().window().maximize();
               break;
            }
        }
    }
}
