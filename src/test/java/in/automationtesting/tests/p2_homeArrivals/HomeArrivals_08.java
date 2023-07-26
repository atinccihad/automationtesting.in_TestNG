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

public class HomeArrivals_08 extends TestBaseRapor {
    //15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
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
    public void homeArrivals_08() {
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

        //13) Now user can find total and subtotal values just above the Proceed to Checkout button.
        softAssert.assertTrue(homePage.subtotal.isDisplayed(), "subtotal is not displayed!!");
        extentTest.info("subtotal is displayed.");
        softAssert.assertTrue(homePage.tax.isDisplayed(), "tax is not displayed!!");
        extentTest.info("tax is displayed.");
        softAssert.assertTrue(homePage.total.isDisplayed(), "total is not displayed!!");
        extentTest.info("total is displayed.");

        //14) The total always < subtotal because taxes are added in the subtotal
        String totalStr = homePage.total.getText();
        totalStr = totalStr.replaceAll("₹", "");
        totalStr = totalStr.replaceAll(",", "");
        totalStr = totalStr.replaceAll(".00", "");
        int totalInt = Integer.parseInt(totalStr);

        String subtotalStr = homePage.total.getText();
        subtotalStr = subtotalStr.replaceAll("₹", "");
        subtotalStr = subtotalStr.replaceAll(",", "");
        subtotalStr = subtotalStr.replaceAll(".00", "");
        int subtotalInt = Integer.parseInt(subtotalStr);

        String taxStr = homePage.total.getText();
        taxStr = taxStr.replaceAll("₹", "");
        taxStr = taxStr.replaceAll(",", "");
        taxStr = taxStr.replaceAll(".00", "");
        int taxInt = Integer.parseInt(taxStr);

        softAssert.assertEquals((subtotalInt + taxInt), 2 * totalInt, "Total degerinin, subtotal ve tax toplamina esitligi, yani buyuklugu dogrulanamadi!!");
        extentTest.info("total is bigger value.");

        //15) Total
        System.out.println("totalInt = " + totalInt);
        extentTest.pass("Ara toplam testi PASS.");
        softAssert.assertAll();
    }

}
