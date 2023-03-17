package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterAndLogInPage;
import pages.WishListPage;

public class WishListTest extends BaseTest{
    WishListPage wishListPage;
    @BeforeMethod
    public void localSetup() {
        wishListPage = new WishListPage(driver);
    }

    @Test
    public void wishListTest(){
        wishListPage.addToWishList();
        Assert.assertTrue(wishListPage.isItemInWishList());
    }
}
