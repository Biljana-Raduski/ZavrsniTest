package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.RegisterAndLogInPage;

public class BasketTest extends BaseTest{

    BasketPage basketPage;


    @BeforeMethod
    public void localSetup(){
        basketPage = new BasketPage(driver);
    }



    @Test
    public void basketTest(){
        basketPage.addToBasket();
        Assert.assertTrue(basketPage.daLiJeKorpaPuna());
    }



}
