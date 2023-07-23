package in.automationtesting.tests.p2_homeArrivals;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeArrivals_03 {
    //9. Home-Arrivals-Add to Basket-Items-Coupon
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void getUrl() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void homeArrivals_03() {

        ///3) Click on Shop Menu
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        homePage.shopMenuButton.click();

        //4) Now click on Home menu button
        homePage.homeMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertEquals(homePage.arrivals.size(), 3, "Expected value three arrivals, actual value " + homePage.arrivals.size());

        //7) Now click the image in the Arrivals
        for (int i = 0; i < homePage.arrivals.size(); i++) {
            ReusableMethods.clickWithJS(homePage.arrivals.get(i));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().back();
        }
        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        ReusableMethods.clickWithJS(homePage.arrivals.get(0));
        softAssert.assertTrue(homePage.addToBasketButton.isDisplayed(), "homePage.addToBasketButton.is not Displayed !!");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        softAssert.assertTrue(homePage.firstArrivalImage.isEnabled(), "Image not should be clickable!!");
        ReusableMethods.clickWithJS(homePage.firstArrivalImage);
        softAssert.assertTrue(homePage.addToBasketButton.isEnabled(), "homePage.addToBasketButton.is not Selected!!");
        Driver.getDriver().navigate().refresh();

        //10) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(homePage.addToBasketButton);

        //11) User can view that Book in the Menu item with price.
        softAssert.assertTrue(homePage.bookImage.isDisplayed(), "homePage.bookImage.is not Displayed!!");
        softAssert.assertTrue(homePage.price.isDisplayed(), "homePage.price.is not Displayed!!");

        //12) Now click on Item link which navigates to proceed to check out page.
        homePage.itemsAndPriceLinkButton.click();

        //13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
        softAssert.assertTrue(homePage.proceedToCheckoutButton.isEnabled(), "proceedToCheckoutButton is not Selected!!");

        //14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
        homePage.couponCodeBox.sendKeys(homePage.couponCode, Keys.ENTER);

        //15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
        softAssert.assertNotEquals(homePage.indirimliTotal.getText(), homePage.price.getText(), "Indirim uygulanmamasi!!");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver() {
        Driver.getDriver().close();
    }

}
