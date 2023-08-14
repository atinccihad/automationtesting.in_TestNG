package in.automationtesting.tests.p1_homePage;

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

public class HomePage_06 extends TestBaseRapor {
    //6. Home page - Arrivals-Images-Add to Basket
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
    public void test06() {
        extentTest = extentReports.createTest("homePage_06", "Arrivals-Images-Add to Basket.");
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();

        //3) Click on Shop Menu
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        homePage.shopMenuButton.click();
        extentTest.info("shopMenuButton is clicked.");

        //4) Now click on Home menu button
        homePage.homeMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        extentTest.info("homeMenuButton is clicked.");

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertEquals(homePage.arrivals.size(), 3, "Expected value three arrivals, actual value " + homePage.arrivals.size());
        extentTest.info("The Home page must contains only three Arrivals.");

        //7) Now click the image in the Arrivals
        for (int i = 0; i < homePage.arrivals.size(); i++) {
            ReusableMethods.clickWithJS(homePage.arrivals.get(i));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().back();
        }
        extentTest.info("Clicked image in the Arrivals.");

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        ReusableMethods.clickWithJS(homePage.arrivals.get(1));
        softAssert.assertTrue(homePage.addToBasketButton.isDisplayed(), "homePage.addToBasketButton.is not Displayed !!");
        extentTest.info("Navigate to next page.");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        softAssert.assertTrue(homePage.firstArrivalImage.isEnabled(), "Image not should be clickable!!");
        extentTest.info("Image should be clickable.");
        ReusableMethods.clickWithJS(homePage.firstArrivalImage);
        softAssert.assertTrue(homePage.addToBasketButton.isEnabled(), "homePage.addToBasketButton.is not Selected!!");
        extentTest.info("Moved to cart page.");
        Driver.getDriver().navigate().refresh();

        //10) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(homePage.addToBasketButton);
        extentTest.info("addToBasketButton clicked.");

        //11) User can view that Book in the Menu item with price.
        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        ReusableMethods.clickWithJS(homePage.viewBasketButton);
        extentTest.info("viewBasketButton clicked.");
        Driver.getDriver().navigate().refresh();
        softAssert.assertTrue(homePage.basketTotals.isDisplayed());
        extentTest.info("basketTotals is displayed.");
        extentTest.pass("Arrivals-Images-Add to Basket test PASS.");
        softAssert.assertAll();

    }

}
