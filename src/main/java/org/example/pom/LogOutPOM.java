package org.example.pom;

import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPOM {

    public LogOutPOM()
    {
        PageFactory.initElements(BrowserDriver.driver,this);
    }

    @FindBy(xpath = "//img[@alt='profile picture']")
    public WebElement profilebtn;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;
}
