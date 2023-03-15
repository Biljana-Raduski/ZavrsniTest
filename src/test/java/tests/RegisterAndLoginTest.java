package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegisterAndLogInPage;

public class RegisterAndLoginTest extends BaseTest {

    RegisterAndLogInPage registerAndLogInPage;
@BeforeMethod
    public void localSetup() {
        registerAndLogInPage = new RegisterAndLogInPage(driver);
    }
@Test
public void registerAndLogInTest(){
registerAndLogInPage.goToRegisterpage()
        .registerUser();
    Assert.assertTrue(registerAndLogInPage.isUserRegistered());

}

}
