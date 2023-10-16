package org.example.utility;

import org.example.explicitwait.ElementLevelWait;
import org.example.pom.LoginPageModel;
import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login {

    public static String loginURL(String name,String password)
    {
        LoginPageModel loginPageModel=new LoginPageModel();
           loginPageModel.loginPage(name,password);
        ElementLevelWait.setWait().until(ExpectedConditions.titleContains("OrangeHRM"));
      return   BrowserDriver.driver.getTitle();
    }
}
