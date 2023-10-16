package org.example.utility;

import org.example.explicitwait.ElementLevelWait;
import org.example.pom.LogOutPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LogOut {

   public static LogOutPOM logOut;
    public static void logout()
    {
        logOut=new LogOutPOM();
        logOut.profilebtn.click();
        ElementLevelWait.setWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='menu']")));
        logOut.logout.click();
    }
}