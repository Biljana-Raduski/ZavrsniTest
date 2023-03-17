package pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.Locale;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

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
    private By homeSrcreen = By.xpath("//a[@class='nav-link active']");
    private By hammers = By.xpath("//input[@data-test='category-3']");
    private By hammerType = By.xpath("//div[3]/div[2]/div[1]/a[4]/div[1]/img");
    private By favouritesButton = By.id("btn-add-to-favorites");
    By userMenu = By.id("user-menu");
    By myFavourites = By.xpath("//a[text()=\"My favorites\"]");
    By itemName = By.xpath("//h5[text()=\"Thor Hammer\"]");


    private String username;
    private String password;

    private static final Logger log = LogManager.getLogger(RegisterAndLogInPage.class.getName());
    Faker faker = new Faker(new Locale("en", "US"));

    private String dob() {
        if (driver instanceof ChromeDriver) {
            return "01011985";
        } else if (driver instanceof FirefoxDriver) {
            actions.sendKeys(getElement(dateOfBirth), "01011985").build().perform();
        } else if (driver instanceof EdgeDriver) {
            return "01011985";
        }
        return null;
    }

    public WishListPage addToWishList(){
        clickOnElement(signIn);
        clickOnElement(registerYourAcount);
        username = faker.internet().emailAddress();
        password = faker.internet().password();
        log.info("User name is: " + username);
        log.info("Password is: " + password);
        typeIn(firstNameFieild, faker.name().firstName());
        typeIn(lastNameFieild, faker.name().lastName());
        typeIn(dateOfBirth, dob());
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
        Utils.waitForSeconds(2);
        typeIn(userEmailFieild, username);
        typeIn(userPasswordFieild, password);
        clickOnElement(loginButton);
        Utils.waitForSeconds(2);
        clickOnElement(homeSrcreen);
        Utils.waitForSeconds(2);

        clickOnElement(hammers);
        Utils.waitForSeconds(2);
        clickOnElement(hammerType);
        Utils.waitForSeconds(2);

        clickOnElement(favouritesButton);
        clickOnElement(userMenu);
        Utils.waitForSeconds(2);
        clickOnElement(myFavourites);




        return this;
    }
    public boolean isItemInWishList() {
        return matchesExpectetText(itemName, "Thor Hammer");
    }
}
