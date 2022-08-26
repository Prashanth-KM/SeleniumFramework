package Tests;

import OrangeHr.BaseClass;
import Pages.PageActions.LoginPageAction;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    public LoginPageAction getLoginPage() {
        return new LoginPageAction();
    }

    @Test
    public void TC_01_Login(){
        getLoginPage().validLogin();

    }

    @Test
    public void TC_02_InValidLogin(){
        getLoginPage().inValidLogin();

    }
}
