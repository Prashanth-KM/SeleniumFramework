package Pages.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    @FindBy(id = "txtUsername")
    public WebElement userName;

    @FindBy(id = "txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement viewMyDetails;
}
