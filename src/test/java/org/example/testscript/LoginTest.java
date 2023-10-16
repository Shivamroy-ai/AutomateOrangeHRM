package org.example.testscript;

import org.example.ddt.DataDrivenTesting;
import org.example.utility.Login;
import org.example.utility.OrangeHRM;
import org.example.webdriver.BrowserDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class LoginTest
{
    @BeforeSuite
    public  void runDriver()
    {
        BrowserDriver.getDriver();
    }
    @Test(dataProvider = "data_provider",testName = "LoginScreenTest")
    public void loginTest(String username,String password)
    {
        if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("admin123"))
        {
            // Here loginURL return Title of the Dashboard
            Assert.assertEquals("OrangeHRM", Login.loginURL(username,password));
        }
    }



    @DataProvider(name="data_provider")
    public Object[][]  loginDataProvider() throws IOException {
      String[][] loginData=  DataDrivenTesting.readExcel();
      return  loginData;
    }
}
