package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterPage extends BasePage {
    public FilterPage(WebDriver driver) {
        super(driver);
    }

    private By categoriesMenu = By.xpath("//a[@data-test='nav-categories']");
    private By powerToolsButton = By.xpath("//a[@data-test='nav-power-tools']");
    private By elementsOnPage = By.xpath("//img[@class='card-img-top']");
    private By drillCheckBox = By.xpath("//input[@data-test='category-11']");
    private By elementsOnDrillPage = By.xpath("//img[@class='card-img-top']");
int numberOfElementsPT;
int numberOfElementsDR;
    public FilterPage filterDrills() {
        Utils.waitForSeconds(2);
        clickOnElement(categoriesMenu);
        Utils.waitForSeconds(2);
        clickOnElement(powerToolsButton);
        Utils.waitForSeconds(2);
        numberOfElementsPT = driver.findElements(elementsOnPage).size();
        clickOnElement(drillCheckBox);
        Utils.waitForSeconds(2);
        numberOfElementsDR = driver.findElements(elementsOnDrillPage).size();
        return this;
    }
    public boolean areListsEqual() {
        if (numberOfElementsPT > numberOfElementsDR) {
            log.info("PASSED - Number of elements on pages are different");
        }else {
            log.info("FAILED");
        }
        return true;
    }
}
