package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NegativLogInPage;
import pages.RegisterAndLogInPage;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class NegativLogInTest extends BaseTest {

    NegativLogInPage negativLogInPage;


    @BeforeMethod
    public void localSetup() {
        negativLogInPage = new NegativLogInPage(driver);
    }


    @Test(dataProvider = "dpLogInTest", dataProviderClass = Utils.class)
    public void registerAndLogInTest(String username, String password) {

        negativLogInPage.goToRegisterpage().logInUser(username, password);
        Assert.assertTrue(negativLogInPage.isErrorPresent());

    }

}

