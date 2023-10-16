package org.example.explicitwait;

import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementLevelWait {

    public static WebDriverWait setWait()
    {
        WebDriverWait driverWait=new WebDriverWait(BrowserDriver.driver, Duration.ofSeconds(5));
        return driverWait;
    }
}
