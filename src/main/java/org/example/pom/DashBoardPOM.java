package org.example.pom;

import org.example.webdriver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPOM {

    public DashBoardPOM()
    {
        PageFactory.initElements(BrowserDriver.driver,this);
    }
    @FindBy(xpath = "//ul[contains(@class,'oxd-main-menu')]/li/a/span")
   public List<WebElement> main_menue;

    @FindBy(xpath = "//i/parent::button[contains(@class,'oxd-button--secondar')]")
    WebElement adduserheading;

    @FindBy(xpath = "//i/parent::button[contains(@class,'oxd-button--secondar')]")
   public WebElement addNewAdminButton;

    @FindBy(xpath = "//div[@role='option']")
    public List<WebElement> userRoleOptions;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeName;

    @FindBy(xpath = "//label[contains(text(),'Status')]/following::div[contains(text(),\"-- Select --\")]")
    public WebElement statusoption;

    @FindBy(xpath = "//label[contains(text(),'Username')]//following::input[contains(@class,'oxd-input--active')][1]")
    public WebElement username;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    public WebElement password;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    public WebElement conformPassword;

    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement save;

}
