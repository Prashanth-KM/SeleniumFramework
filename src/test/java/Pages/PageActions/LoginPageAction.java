package Pages.PageActions;

import Generic.CommonFunctions;
import Pages.PageObjects.LoginPageObjects;
import Reports.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.DriverManager;


public class LoginPageAction implements Constants {
    WebDriver driver;
    CommonFunctions generic;
    LoginPageObjects loginPageObjects=  new LoginPageObjects();

    public LoginPageAction(){
        this.driver = DriverManager.getDriver();
        generic= new CommonFunctions(driver);

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, loginPageObjects);
    }

    public void validLogin(){
        try{
            generic.sendKeys(loginPageObjects.userName,userName,"Username");
            generic.sendKeys(loginPageObjects.password,password,"Password");
            generic.waitAndClick(loginPageObjects.loginBtn,"Login Button");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inValidLogin(){
        try{
            generic.sendKeys(loginPageObjects.userName,userName,"Username");
            generic.sendKeys(loginPageObjects.password,invalidPassword,"Password");
            generic.waitAndClick(loginPageObjects.loginBtn,"Login Button");
            generic.isElementPresentAssertTrue(loginPageObjects.viewMyDetails);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
