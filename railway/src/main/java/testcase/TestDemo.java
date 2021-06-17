package testcase;

import common.common.Check;
import constant.Constant;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TestDemo extends BaseTest {
    @Test
    public void testBayBa(){
        BasePage.goToTab(BasePage.getLoginTab());
        LoginPage loginPage = new LoginPage();
        loginPage.login("asdasdsd", Constant.PASSWORD);
        Check.isCheckLogin("asdasdsd");
        boolean check = Check.isCheckLogin("asdasdsd");
        System.out.println(check);
    }
}
