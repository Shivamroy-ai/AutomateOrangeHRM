package org.example.utility;

import org.example.pom.DashBoardPOM;
import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM {

  public static   DashBoardPOM dashBoardPOM;
    public  static void orangeHRMOperationMethod(String oper)
    {
         dashBoardPOM=new DashBoardPOM();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        List<WebElement> operationList = BrowserDriver.driver.findElements(By.xpath("//ul[contains(@class,'oxd-main-menu')]/li/a/span"));
        List<WebElement> operationList=dashBoardPOM.main_menue;
        System.out.println(operationList.size());
        for (WebElement operationitem: operationList)
         {
             System.out.println("Text = "+operationitem.getText());
             if(operationitem.getText().equalsIgnoreCase(oper))
             {
//                 operationitem.click();

                 switchToFun(operationitem,oper);
                  break;
             }
         }
    }

    private static void switchToFun(WebElement optEle,String oper) {
        switch (oper)
        {
            case "Admin" :
            {
                adminOperation(optEle);
                break;
            }
            default:
            {
                System.out.println("Default value = ");
            }
        }
    }

    private static void adminOperation(WebElement optEle)
    {
        optEle.click();
        CustomeWebDriverWait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i/parent::button[contains(@class,'oxd-button--secondar')]")));
        dashBoardPOM.addNewAdminButton.click();
        createNewUser();
    }

    private static WebDriverWait CustomeWebDriverWait(int i)
    {
      return new WebDriverWait(BrowserDriver.driver, Duration.ofSeconds(60));

    }

    private static void createNewUser() {

        CustomeWebDriverWait(60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Add User']")));
        BrowserDriver.driver.findElement
                (By.xpath("//div/label[contains(text(),'User Role')]/following::div[contains(text(),'Select')][1]")).click();

       List<WebElement> userName= dashBoardPOM.userRoleOptions;
        for (WebElement element:userName)
        {
            if(element.getText().equalsIgnoreCase("Admin"))
            {
                element.click();
                break;
            }
        }
        employeName();
    }

    private static void employeName() {
        Actions actions=new Actions(BrowserDriver.driver);
        dashBoardPOM.employeName.sendKeys("S");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        dashBoardPOM.statusoption.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        dashBoardPOM.username.sendKeys("ShivamPalSingh1");
        dashBoardPOM.password.sendKeys("Shivam1234@@");
        dashBoardPOM.conformPassword.sendKeys("Shivam1234@@");
        dashBoardPOM.save.click();

    }


}
