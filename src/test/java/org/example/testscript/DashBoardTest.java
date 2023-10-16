package org.example.testscript;

import org.example.utility.LogOut;
import org.example.utility.OrangeHRM;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DashBoardTest {
    @Test
    @Parameters({"operation"})
    public void hrmOperationTest(String oper)
    {
        System.out.println("HRM Operation");
        OrangeHRM.orangeHRMOperationMethod(oper);
    }
    @Test(dependsOnMethods = "hrmOperationTest")
    public void logout()
    {
        LogOut.logout();
    }
}
