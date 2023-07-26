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

public class HomeArrivals_04 extends TestBaseRapor {
    //11. Home-Arrivals-Add to Basket-Items-Remove book
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
    public void homeArrivals_04() {
        extentTest = extentReports.createTest("HomeArrivals_04", "Home-Arrivals-Add to Basket-Items-Remove book.");
        ///3) Click on Shop Menu
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        homePage.shopMenuButton.click();
        extentTest.info("shopMenuButton is clicked.");

        //4) Now click on Home menu button
        homePage.homeMenuButton.click();
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
        homePage.itemsAndPriceLinkButton.click();
        ReusableMethods.clickWithJS(homePage.proceedToCheckoutButton);
        extentTest.info("navigates to proceed to check out page.");

        //13)Now click on Remove this icon in Check out page which removes that book from the grid.
        ReusableMethods.doubleClick(homePage.sepetItemFiyatSagUst);
        ReusableMethods.clickWithJS(homePage.itemRemoveIconList.get(0));
        extentTest.info("itemRemoveIconList clicked.");

        //14) User has the feasibility to remove the book at the time of check out also
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(5);
        softAssert.assertTrue(homePage.bookRemovedText.isDisplayed(), "Kitap silindi uyarisi gorunmedi!!");
        extentTest.info("bookRemoved.");
        extentTest.pass("bookRemoved test PASS.");
        softAssert.assertAll();
    }

}
