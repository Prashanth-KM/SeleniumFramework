package Pages.PageActions;

import Generic.CommonFunctions;
import Pages.PageObjects.MyInfoObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.DriverManager;

public class MyInfoActions implements Constants {

    WebDriver driver;
    MyInfoObjects myInfoObjects= new MyInfoObjects();
    CommonFunctions commonFunctions;

    public MyInfoActions(){
        this.driver= DriverManager.getDriver();
        commonFunctions= new CommonFunctions(driver);
        PageFactory.initElements(driver,this);
        PageFactory.initElements(driver,myInfoObjects);

    }

    public  void navigateToMyInfo(){
        commonFunctions.waitAndClick(myInfoObjects.myInfo,"my info tab");
    }
}
