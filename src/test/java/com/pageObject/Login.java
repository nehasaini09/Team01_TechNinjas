package com.pageObject;

import com.hooks.DriverFactory;
import com.utilities.ReadConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Login extends DriverFactory {


    private WebDriver driver;
    private WebDriverWait wait;
   ReadConfig config = new ReadConfig();

    @FindBy(id="username") WebElement username;
    @FindBy(id="password") WebElement password;
    @FindBy(xpath="//button[@id='login']") WebElement loginBtn;
    @FindBy(xpath="//*[@id='errormessage']") WebElement errorMessageBoth;
    String uName=null;
    String pwd = null;
    String actualName = config.getUSername();
   String  actualpwd = config.getpassword();


    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public String validLogin(String uName,String pwd){

            wait.until(ExpectedConditions.visibilityOf(username)).clear();
            wait.until(ExpectedConditions.visibilityOf(password)).clear();
            username.sendKeys(uName);
            password.sendKeys(pwd);
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           try{
               WebElement errMsg= wait.until(ExpectedConditions.visibilityOf(errorMessageBoth));
               return errMsg.getText();
           }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e){
             return "No error message displayed";
           }

        }

    public void loginKeyboard(String uName,String pwd){
        wait.until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).sendKeys(Keys.ENTER);

    }

    public void loginMouse(String uName,String pwd){
        wait.until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

    }
}
