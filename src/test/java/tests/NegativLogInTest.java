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
        if (username.equals(""))
            Assert.assertTrue(negativLogInPage.isErrorPresent(1));
        else
        if (password.equals("") && !username.isEmpty())
            Assert.assertTrue(negativLogInPage.isErrorPresent(0));
        else
        if(!username.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
            //if(username.equals("admin"))
            Assert.assertTrue(negativLogInPage.isErrorPresent(2));
        else
            Assert.assertTrue(negativLogInPage.isErrorPresent(3));




    }

}

