package in.automationtesting.tests.p2_homeArrivals;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeArrivals_07 extends TestBaseRapor {
    //14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        ReusableMethods.login();
    }

    @Test
    public void homeArrivals_07() {
        extentTest = extentReports.createTest("HomeArrivals_07", "Home-Arrivals-Add to Basket-Items-Check-out-Update Basket.");
        ///3) Click on Shop Menu
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        homePage.shopMenuButton.click();
        extentTest.info("shopMenuButton is clicked.");

        //4) Now click on Home menu button
        ReusableMethods.clickWithJS(homePage.homeMenuButton);
        extentTest.info("homeMenuButton is clicked.");
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertEquals(homePage.arrivals.size(), 3, "Expected value three arrivals, actual value " + homePage.arrivals.size());
        extentTest.info("The Home page must contains only three arrivals.");

        //7) Now click the image in the Arrivals
        for (int i = 0; i < homePage.arrivals.size(); i++) {
            ReusableMethods.clickWithJS(homePage.arrivals.get(i));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().back();
        }
        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        ReusableMethods.clickWithJS(homePage.arrivals.get(0));
        Driver.getDriver().navigate().refresh();
        softAssert.assertTrue(homePage.addToBasketButton.isDisplayed(), "homePage.addToBasketButton.is not Displayed !!");
        extentTest.info("addToBasketButton.is Displayed.");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        softAssert.assertTrue(homePage.firstArrivalImage.isEnabled(), "Image not should be clickable!!");
        extentTest.info("firstArrivalImage is should be clickable.");
        ReusableMethods.clickWithJS(homePage.firstArrivalImage);
        softAssert.assertTrue(homePage.addToBasketButton.isEnabled(), "homePage.addToBasketButton.is not Selected!!");
        extentTest.info("addToBasketButton is should be Selected.");
        Driver.getDriver().navigate().refresh();

        //10) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(homePage.addToBasketButton);
        extentTest.info("addToBasketButton clicked.");

        //11) User can view that Book in the Menu item with price.
        softAssert.assertTrue(homePage.bookImage.isDisplayed(), "homePage.bookImage.is not Displayed!!");
        extentTest.info("bookImage is Displayed.");
        softAssert.assertTrue(homePage.price.isDisplayed(), "homePage.price.is not Displayed!!");
        extentTest.info("price is Displayed.");

        //12) Now click on Item link which navigates to proceed to check out page.
        ReusableMethods.clickWithJS(homePage.viewBasketButton);
        extentTest.info("viewBasketButton is clicked.");

        //13) Click on textbox value under quantity in Check out page to add or subtract books.
        homePage.quantityBox.click();
        extentTest.info("quantityBox is clicked.");

        //14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
        softAssert.assertTrue(homePage.updateBasketButton.isSelected(), "Quantity box sadece tiklandiginda, updateBasket button tiklanamiyor!!");
        extentTest.info("updateBasketButton is Selected.");

        //15) Now click on Update Basket to reflect those changes
        homePage.updateBasketButton.click();
        extentTest.info("updateBasketButton is clicked.");

        //16) User has the feasibility to Update Basket at the time of check out
        ReusableMethods.clickWithJS(homePage.proceedToCheckoutButton);
        extentTest.info("proceedToCheckoutButton is clicked.");
        ReusableMethods.jsExecutorScrool(homePage.yourOrderUrunMiktarElementi);
        softAssert.assertTrue(homePage.yourOrderUrunMiktarElementi.isSelected(), "Urun miktari odeme sayfasinda degistirilemedi!!");
        extentTest.info("proceedToCheckoutButton is clicked.");
        extentTest.pass("Ana Sayfa-Gelenler-Sepete Ekle-Ürünler-Çıkış-Sepeti Güncellendi.");
        softAssert.assertAll();
    }

}
