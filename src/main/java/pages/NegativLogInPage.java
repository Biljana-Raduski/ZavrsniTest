package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    List<String> greska = new LinkedList<String>();

    {
        greska.add("Invalid email or password");
        greska.add(" E-mail is required. ");
        greska.add(" Password is required. ");
        greska.add(" E-mail format is invalid. ");
    }

    List<By> listalokatora = new ArrayList<>();

//    {
//        if (eMailMessage != null)
//            listalokatora.add(eMailMessage);
//        if (passwordMessage != null)
//            listalokatora.add(passwordMessage);
//        if (eMailFormatMessage != null)
//            listalokatora.add(eMailFormatMessage);
//        if (invalidEmailOrPasswor != null)
//            listalokatora.add(invalidEmailOrPasswor);
//
//    }


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





    public boolean isErrorPresent(int i) {
//        WebElement element = getElement(eMailMessage);
//
//            if (greska.contains(element.getText()))
//                return true;
//        return false;
        //listalokatora.add(passwordMessage);
        // if (!listalokatora.isEmpty()) {
        if( i == 0)
        if (matchesExpectetText(passwordMessage, "Password is required.")) {
            //listalokatora.remove(passwordFieild);
            return true;
        }
        // } else {
        // listalokatora.add(eMailMessage);
        // if (!listalokatora.isEmpty()) {
        if(i == 1)
        if (matchesExpectetText(eMailMessage, "E-mail is required.")) {
           // listalokatora.remove(eMailFieild);
            return true;
        }
        //} else {
        // listalokatora.add(eMailFormatMessage);
        //if (!listalokatora.isEmpty()) {
        if(i == 2)
        if (matchesExpectetText(eMailFormatMessage, "E-mail format is invalid.")) {
           // listalokatora.remove(eMailFormatMessage);
            return true;
        }
        //  } else {
        // listalokatora.add(invalidEmailOrPasswor);
        //if (!listalokatora.isEmpty()) {
        if(i == 3)
        if (matchesExpectetText(invalidEmailOrPasswor, "Invalid email or password")) {
           // listalokatora.remove(invalidEmailOrPasswor);
            return true;
        }


        return false;

    }


}
