package com.pageObject;

import com.hooks.DriverFactory;
import com.utilities.ReadConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
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
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Login extends DriverFactory {


    private WebDriver driver;
    private WebDriverWait wait;
   ReadConfig config = new ReadConfig();
   Actions actions;
    Map<String, String> result = new HashMap<>();

    @FindBy(id="username") WebElement username;
    @FindBy(id="password") WebElement password;
    @FindBy(xpath="//button[@id='login']") WebElement loginBtn;
    @FindBy(xpath="//div//mat-card//mat-card-content//form//mat-error") WebElement errorMessageBoth;
    @FindBy(xpath="//mat-form-field[1]/div/div[3]/div/mat-error") WebElement UsernameErrmsg;
    @FindBy(xpath="//mat-form-field[2]/div/div[3]/div/mat-error") WebElement passwordErrmsg;


    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions= new Actions(driver);
        PageFactory.initElements(driver, this);
    }
//method for Login
        public Map<String,String> validLogin(String credentials) {
             result = new HashMap<>();
            String uName = "";
            String pwd = "";
            switch(credentials) {
                case "valid credentials":
                    System.out.println("Enter valid credentials");
                    uName = config.getUSername();
                    pwd = config.getpassword();
                    break;
                case "invalid credentials":
                    System.out.println("Enter invalid credentials");
                    uName = config.getinvalidUSername();
                    pwd = config.getinvalidpassword();
                    break;
                case "password":
                    System.out.println("Enter only the password");
                    pwd = config.getpassword();
                    break;
                case "username":
                    System.out.println("Enter only the username");
                    uName = config.getUSername();
                    break;
            }
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
                String expectedPwd=config.getpassword();
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
                    }else if( !(uName.equalsIgnoreCase(expectedUserName) && pwd.equalsIgnoreCase(expectedPwd))){
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
    // login page details validations

    public String spellcheckerUSer(){
        wait.until(ExpectedConditions.visibilityOf(username));
        return username.getAttribute("ng-reflect-placeholder");

    }
    public String spellcheckerpasswrd(){
        wait.until(ExpectedConditions.visibilityOf(password));
        return    password.getAttribute("ng-reflect-placeholder");
    }
    public String spellcheckLoginbutton(){
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.getText().trim();
    }

    public int LogoValidate(){

        WebElement logo = driver.findElement(By.cssSelector("img[class='images']"));
        Assert.assertTrue(logo.isDisplayed());
        return logo.getLocation().getX();

    }

    public void LmsContentMsg(){
        WebElement LMStext= driver.findElement(By.xpath("//*[text()='Please login to LMS application']"));
        String LMS_MSg= LMStext.getText();
        System.out.println(LMS_MSg);

    }
    public  void Asteriskpassword(){
      WebElement UnameStar=driver.findElement(By.xpath("//*[@id='mat-form-field-label-3']/span[2]"));
       Assert.assertTrue(UnameStar.isDisplayed());
    }
public void asteriskUser(){
    WebElement PwdStar=driver.findElement(By.xpath("//*[@id='mat-form-field-label-1']/span[2]"));
    Assert.assertTrue(PwdStar.isDisplayed());
}
public void loginBtnVisible(){
    Assert.assertTrue(loginBtn.isDisplayed());

}
public void USercolor(){
   String Ucolor= username.getCssValue("color");
   String expectedColor="rgba(0, 0, 0, 0.87)";
   System.out.println("user color is :" +Ucolor);
    Assert.assertTrue(Ucolor.equalsIgnoreCase(expectedColor));
}
public void Passwordcolor(){
   String Pcolor= password.getCssValue("color");
    System.out.println("pwd color is :" +Pcolor);
    String expectedColor="rgba(0, 0, 0, 0.87)";
    Assert.assertTrue(Pcolor.equalsIgnoreCase(expectedColor));
}

public int CountTextFields(){
    List<WebElement> textFields = driver.findElements(By.xpath("//input[@type='password' or @id='username']"));
    return textFields.size();
}

public void FirstTextField(){
    List<WebElement> textFields = driver.findElements(By.xpath("//input[@type='password' or @id='username']"));
    WebElement firstTextField= textFields.get(0);
    System.out.println("FIRST TEXT FIELD :"+firstTextField.getAttribute("ng-reflect-placeholder"));
}
public void SecondTextField(){
    List<WebElement> textFields = driver.findElements(By.xpath("//input[@type='password' or @id='username']"));
    WebElement secondTextField =textFields.get(1);
    System.out.println("SECOND TEXT FIELD :"+secondTextField.getAttribute("ng-reflect-placeholder"));
}

}
