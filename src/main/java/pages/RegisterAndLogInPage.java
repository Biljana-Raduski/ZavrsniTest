package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.Locale;

public class RegisterAndLogInPage extends BasePage {

    private By signIn = By.xpath("//a[@routerlink='/auth/login']");
    private By registerYourAcount = By.xpath("//a[@data-test='register-link']");
    private By firstNameFieild = By.id("first_name");
    private By lastNameFieild = By.id("last_name");
    private By dateOfBirth = By.id("dob");
    private By addressFieild = By.id("address");
    private By postCodeFieild = By.id("postcode");
    private By cityFieild = By.id("city");
    private By stateFieild = By.id("state");
    private By countryDropDown = By.id("country");
    private By phoneFieild = By.id("phone");
    private By eMaillAddresseFieild = By.id("email");
    private By passwordFieild = By.id("password");
    private By registerButton = By.xpath("//button[@data-test='register-submit']");
    private By userEmailFieild = By.id("email");
    private By userPasswordFieild = By.id("password");
    private By loginButton = By.className("btnSubmit");
    private By welcomeScreen = By.xpath("//h1[@data-test='page-title']");

    public RegisterAndLogInPage(WebDriver driver) {
        super(driver);
    }

    private String username;
    private String password;
    private static final Logger log = LogManager.getLogger(RegisterAndLogInPage.class.getName());

    Faker faker = new Faker(new Locale("en", "US"));

    public RegisterAndLogInPage goToRegisterpage() {
        clickOnElement(signIn);
        clickOnElement(registerYourAcount);
        return this;
    }

    public RegisterAndLogInPage registerUser() {
        username = faker.internet().emailAddress();
        password = faker.internet().password();
        log.info("User name is: " + username);
        log.info("Password is: " + password);

        typeIn(firstNameFieild, faker.name().firstName());
        typeIn(lastNameFieild, faker.name().lastName());
        typeIn(dateOfBirth, "01011985");
        typeIn(addressFieild, faker.address().fullAddress());
        typeIn(postCodeFieild, faker.number().digits(5));
        typeIn(cityFieild, faker.address().city());
        typeIn(stateFieild, faker.address().state());
        clickOnElement(countryDropDown);
        Select countryDropdown = new Select(driver.findElement(countryDropDown));
        countryDropdown.selectByVisibleText("United States of America (the)");
        typeIn(phoneFieild, faker.number().digits(10));
        typeIn(eMaillAddresseFieild, username);
        typeIn(passwordFieild, password);
        clickOnElement(registerButton);
        Utils.waitForSeconds(5);
        typeIn(userEmailFieild, username);
        typeIn(userPasswordFieild,password);
        clickOnElement(loginButton);
        return this;

    }


    public boolean isUserRegistered() {
        return matchesExpectetText(welcomeScreen, "My account");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
