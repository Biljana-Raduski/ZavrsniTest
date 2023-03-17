package pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.util.Locale;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
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
    private By categoriesDropdown = By.xpath("//a[@data-test='nav-categories']");
    private By powerToolsHover = By.xpath("//div[@id='navbarSupportedContent']//a[@data-test='nav-power-tools']");
    private By drillChechBox = By.xpath("//input[@data-test='category-11']");
    private By drills = By.xpath("//h5[contains(text(),'Cordless Drill')]");//Ovo su sve busilice 1/4.....
    private By increaseQuantityButton = By.id("btn-increase-quantity");
    private By addToCartButton = By.id("btn-add-to-cart");


    private By randomTools = By.xpath("//img[@class='card-img-top']");
    //By drills2 = By.xpath("//div[@class='col']");
    //By drills2 = By.xpath("//div[@class='col']//img[@class='card-img-top']");//opet1/3............


    private By cartQuantity = By.xpath("//span[@id='lblCartCount']");
    private By shopingCartButton = By.xpath("//*[@id=\"lblCartCount\"]");
    private By firstPrice = By.xpath("//aw-wizard/div/aw-wizard-step[1]/div/table/tbody/tr[1]/td[5]");
    private By secondPrice = By.xpath("//aw-wizard-step[1]/div/table/tbody/tr[2]/td[5]");
    private By totalPrice = By.xpath("//aw-wizard-step[1]/div/table/tfoot/tr/td[5]");
    private By proceedToCheckoutButton = By.xpath("//button[@data-test='proceed-1']");
    private By proceedToCheckoutAgain = By.xpath("//button[@data-test='proceed-2']");
    private By proceedToCheckoutAndAgain = By.xpath("//button[@data-test='proceed-3']");
    private By paymentMethodDropdown = By.id("payment-method");
    private By cassOnDelivery = By.xpath("//*[@id=\"payment-method\"]/option[3]");
    private By acountNameFeild = By.id("account-name");
    private By acountNumberFeild = By.id("account-number");
    private By confirmButton = By.xpath("//button[@data-test='finish']");
    private By paymentSuccesMasage = By.xpath("//div[@class='help-block']");
    private By userMenuText = By.id("user-menu");
    private By hammers = By.xpath("//input[@data-test='category-3']");
    private By randomHammer = By.xpath("//img[@class='card-img-top']");

    private By userName = By.id("user-menu");
    private By outOfStock = By.xpath("//p[@class='text-danger mt-3']");
    private By secondRandomTool = By.xpath("//img[@class='card-img-top']");

    String expectedText = "Payment was successful";
    private String username;
    private String password;

    private static final Logger log = LogManager.getLogger(RegisterAndLogInPage.class.getName());
    Faker faker = new Faker(new Locale("en", "US"));
    Actions actions = new Actions(driver);

    private double getTextAsDouble(By locator) {
        String text = getTextFromElement(locator).replaceFirst("\\D", "");
        double digitsOnly = Double.parseDouble(text);
        return digitsOnly;
    }

    private String kolicinaUKorpi = "3";
    double cenaPrvogProizvoda;
    double cenaDrugogProizvoda;
    double ukupnaCena;
    String acoNumber = "123";

    SoftAssert softAssert;

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

    public BasketPage addToBasket() {
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

        clickOnRandomElement(randomHammer);
        clickOnElement(addToCartButton);
        clickOnElement(categoriesDropdown);
        hoverAndClick(powerToolsHover);
        clickOnElement(drillChechBox);
        Utils.waitForSeconds(2);
        clickOnRandomElement(drills);
        clickOnElement(increaseQuantityButton);
        clickOnElement(addToCartButton);
        clickOnElement(shopingCartButton);
        cenaPrvogProizvoda = getTextAsDouble(firstPrice);
        cenaDrugogProizvoda = getTextAsDouble(secondPrice);
        ukupnaCena = getTextAsDouble(totalPrice);
        Utils.waitForSeconds(2);
        clickOnElement(proceedToCheckoutButton);
        Utils.waitForSeconds(2);
        clickOnElement(proceedToCheckoutAgain);
        Utils.waitForSeconds(2);
        clickOnElement(proceedToCheckoutAndAgain);
        Utils.waitForSeconds(2);
        clickOnElement(paymentMethodDropdown);
        Utils.waitForSeconds(2);
        Select paymentMethod = new Select(driver.findElement(paymentMethodDropdown));
        paymentMethod.selectByVisibleText("Cash on Delivery");
        String imeKorisnika = getTextFromElement(userName);
        typeIn(acountNameFeild, imeKorisnika);
        typeIn(acountNumberFeild, acoNumber);
        clickOnElement(confirmButton);
        return this;
    }

    public boolean daLiJeKorpaPuna() {

        if (cenaPrvogProizvoda + cenaDrugogProizvoda == ukupnaCena) {
            log.info("TEST PASED");
        } else {
            log.info("TEST FAILD");
        }
        return matchesExpectetText(cartQuantity, kolicinaUKorpi) && matchesExpectetText(paymentSuccesMasage, expectedText);
    }
}
