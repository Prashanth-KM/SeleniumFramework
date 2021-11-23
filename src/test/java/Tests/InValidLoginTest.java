package Tests;

import OrangeHr.BaseClass;
import Pages.PageActions.LoginPageAction;
import org.testng.annotations.Test;

public class InValidLoginTest extends BaseClass {
    public LoginPageAction getLoginPage() {
        return new LoginPageAction();
    }

    @Test
    public void InValidLogin(){
        getLoginPage().inValidLogin();

    }
}
