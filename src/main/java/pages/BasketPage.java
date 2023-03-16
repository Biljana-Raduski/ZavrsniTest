package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }


    By categoriesDropdown = By.xpath("//a[@data-test='nav-categories']");
    By powerToolsHover = By.xpath("nav-power-tools");
    By drillChechBox = By.xpath("//input[@data-test='category-11']");
    By drills = By.xpath("//div[@class='col-md-9']/div[@data-test='filter_completed']");//Ovo su sve busilice 1/4.....
    By increaseQuantityButton = By.id("btn-increase-quantity");
    By addToCartButton = By.id("btn-add-to-cart");
    By drills2 = By.xpath("//img[@class='card-img-top']");//opet1/3............
    By cartQuantity = By.xpath("//span[@id='lblCartCount']");
    By shopingCartButton = By.xpath("//*[@id=\"lblCartCount\"]");
By firstPrice = By.xpath("//aw-wizard/div/aw-wizard-step[1]/div/table/tbody/tr[1]/td[5]");
    By secondPrice = By.xpath("//aw-wizard-step[1]/div/table/tbody/tr[2]/td[5]");
    By totalPrice = By.xpath("//aw-wizard-step[1]/div/table/tfoot/tr/td[5]");
    By proceedToCheckoutButton = By.xpath("//button[@data-test='proceed-1']");
    By proceedToCheckoutAgain = By.xpath("//button[@data-test='proceed-2']");
    By proceedToCheckoutAndAgain = By.xpath("//button[@data-test='proceed-3']");
    By paymentMethodDropdown = By.id("payment-method");
    By acountNameFeild = By.id("account-name");
    By acountNumberFeild = By.id("account-number");
    By confirmButton = By.xpath("//button[@data-test='finish']");
    By paymentSuccesMasage = By.xpath("//div[@class='help-block']");
    By userMenuText = By.id("user-menu");
    String expectedText = "Payment was successful";
    String userMenu;

    //Treba mi metoda koja ce izvuci tekst iz elementa "userMenuText" i dodeliti je promenljivoj "userMenu" da bih mogao tu promenljivu da koristim pri kraju placanja
    //Treba da nadjem nacin da trimujem tekst iz elemenata za cenu, da im se skine "$" znakic kako bih mogao da obavljam sabiranje i uporedjivanje rezultata
    //Treba mi metoda koja ce izvucene cene da sabere i da ih uporedi sa "totalPrice"
    //Treba mi da nekako napravim @BeforeMetod da odradi registraciju i log in!




}
