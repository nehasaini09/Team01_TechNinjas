package com.pageObject;

import com.hooks.DriverFactory;
import com.utilities.ReadConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Login extends DriverFactory {


    private WebDriver driver;
    private WebDriverWait wait;
   ReadConfig config = new ReadConfig();
   Actions actions;

    @FindBy(id="username") WebElement username;
    @FindBy(id="password") WebElement password;
    @FindBy(xpath="//button[@id='login']") WebElement loginBtn;
    @FindBy(xpath="//div//mat-card//mat-card-content//form//mat-error") WebElement errorMessageBoth;
    @FindBy(xpath="//mat-form-field[1]/div/div[3]/div/mat-error") WebElement UsernameErrmsg;
    @FindBy(xpath="//mat-form-field[2]/div/div[3]/div/mat-error") WebElement passwordErrmsg;
    String uName=null;
    String pwd = null;
    Map<String, String> result = new HashMap<>();


    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions= new Actions(driver);
        PageFactory.initElements(driver, this);
    }

        public Map<String,String> validLogin(String uName, String pwd) {
             result = new HashMap<>();
            wait.until(ExpectedConditions.visibilityOf(username)).clear();
            username.sendKeys(uName);
            wait.until(ExpectedConditions.visibilityOf(password)).clear();
            password.sendKeys(pwd);
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            result= validateHomepage(uName,pwd);
            return result;
        }
// method validates the url and error messages after trying to login
        public Map<String,String > validateHomepage(String uName, String pwd){
                Map<String, String> output = new HashMap<>();
                String expectedUserName= config.getUSername();
                String expctedPwd=config.getpassword();
            try {
                wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/login")));
                String currentUrl = driver.getCurrentUrl();
                System.out.println("currentUrl :" + currentUrl);
                output.put("current_URL",currentUrl);
            }catch(org.openqa.selenium.TimeoutException e) {
                try {
                    if(uName.isEmpty() && pwd.isEmpty() ) {
                        WebElement errMsg = wait.until(ExpectedConditions.visibilityOf(errorMessageBoth));
                        output.put("error_message", errMsg.getText());
                    }else if(uName.isEmpty()){
                        WebElement UnameERR = wait.until(ExpectedConditions.visibilityOf(UsernameErrmsg));
                        output.put("error_message", UnameERR.getText());
                    }else if(pwd.isEmpty()) {
                        WebElement pwdErr = wait.until(ExpectedConditions.visibilityOf(passwordErrmsg));
                        output.put("error_message", pwdErr.getText());
                    }else if( !(uName.equalsIgnoreCase(expectedUserName) && pwd.equalsIgnoreCase(expctedPwd))){
                        WebElement errMsg = wait.until(ExpectedConditions.visibilityOf(errorMessageBoth));
                        output.put("error_message", errMsg.getText());
                    }
                } catch (NoSuchElementException | org.openqa.selenium.TimeoutException ex) {
                    output.put("error_message","No error message displayed");
                }
            }
           return output;
        }

    public Map<String,String>  loginKeyboard(String uName,String pwd){
        wait.until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        result= validateHomepage(uName,pwd);
        return result;

    }

    public Map<String,String>  loginMouse(String uName,String pwd){
        wait.until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        actions.moveToElement(loginBtn).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String currentUrl= driver.getCurrentUrl();
        System.out.println("currentUrl :"+currentUrl);
        result= validateHomepage(uName,pwd);
        return result;
    }
}
