package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NegativLogInPage extends BasePage {
    public NegativLogInPage(WebDriver driver) {
        super(driver);
    }

    private By signInButton = By.xpath("//a[@routerlink='/auth/login']");
    private By eMailFieild = By.id("email");
    private By passwordFieild = By.id("password");
    private By logInButton = By.xpath("//input[@value='Login']");
    private By eMailMessage = By.xpath("//div[text()=\" E-mail is required. \"]");
    private By passwordMessage = By.xpath("//div[text()=\" Password is required. \"]");
    private By eMailFormatMessage = By.xpath("//div[text()=\" E-mail format is invalid. \"]");
    private By invalidEmailOrPasswor = By.xpath("//div[text()=\"Invalid email or password\"]");

//List<String> greska = new LinkedList<String>(){{ add("Invalid email or password"); add(" E-mail is required. "); add(" Password is required. "); add(" E-mail format is invalid. ");}};

    public NegativLogInPage goToRegisterpage() {
        clickOnElement(signInButton);
        return this;
    }
    public NegativLogInPage logInUser(String username, String password) {
        typeIn(eMailFieild, username);
        typeIn(passwordFieild, password);
        clickOnElement(logInButton);
        return this;
    }

    public boolean isErrorPresent() {
        if (matchesExpectetText(eMailMessage, "E-mail is required."))
            return true;
        if (matchesExpectetText(passwordMessage, "Password is required."))
            return true;
        if (matchesExpectetText(eMailFormatMessage, "E-mail format is invalid."))
            return true;

        if (matchesExpectetText(invalidEmailOrPasswor, "Invalid email or password"))
            return true;

        return false;

    }




}
