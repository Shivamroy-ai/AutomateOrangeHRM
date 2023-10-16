package org.example.pom;

import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageModel {

    public LoginPageModel()
    {

        PageFactory.initElements(BrowserDriver.driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
   public WebElement name;
    @FindBy(xpath = "//input[@placeholder='Password']")
   public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
   public WebElement submitbtn;
    public void   loginPage(String name,String password)
    {
       this.name.sendKeys(name);
       this.password.sendKeys(password);
       this.submitbtn.click();

    }
}
