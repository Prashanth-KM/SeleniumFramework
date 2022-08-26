package Pages.PageActions;

import Generic.CommonFunctions;
import Pages.PageObjects.LoginPageObjects;
import Reports.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
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
        generic.sendKeys(loginPageObjects.userName,userName,"Username");
        Reporter.log("Username is entered");
        generic.sendKeys(loginPageObjects.password,password,"Password");
        Reporter.log("password is entered");
        generic.waitAndClick(loginPageObjects.loginBtn,"Login Button");
        Reporter.log("Login button is clicked");

    }

    public void inValidLogin(){
        generic.sendKeys(loginPageObjects.userName,userName,"Username");
        generic.sendKeys(loginPageObjects.password,invalidPassword,"Password");
        generic.waitAndClick(loginPageObjects.loginBtn,"Login Button");
        generic.isElementPresentAssertTrue(loginPageObjects.viewMyDetails);

    }
}
