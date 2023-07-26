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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage_04 extends TestBaseRapor {
    //4. Home page - Arrivals-Images-Description
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void getUrl() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void homePage_04() {
        extentTest = extentReports.createTest("homePage_04", "Home page - Arrivals-Images-Description.");
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
        assertEquals(homePage.arrivals.size(), 3, "Expected value three arrivals, actual value " + homePage.arrivals.size());
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
        assertTrue(homePage.addToBasketButton.isDisplayed(), "homePage.addToBasketButton.is not Displayed !!");
        extentTest.info("Navigate to next page.");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        assertTrue(homePage.firstArrivalImage.isEnabled(), "Image not should be clickable!!");
        extentTest.info("Image should be clickable.");
        ReusableMethods.clickWithJS(homePage.firstArrivalImage);
        extentTest.info("First image is clicked.");
        //assertTrue(homePage.addToBasketButton.isSelected(),"homePage.addToBasketButton.is not Selected!!");
        extentTest.info("Moved to cart page.");
        Driver.getDriver().navigate().refresh();

        //10) Click on Description tab for the book you clicked on.
        ReusableMethods.clickWithJS(homePage.description);
        extentTest.info("Description tab for the book you clicked.");

        //11) There should be a description regarding that book the user clicked on
        assertTrue(homePage.description.isDisplayed(),"description is not Displayed!!");
        extentTest.info("Description is displayed.");
        extentTest.pass("The description test PASS.");
    }
    @AfterClass
    public void closeDriver() {
        Driver.getDriver().close();
    }

}
