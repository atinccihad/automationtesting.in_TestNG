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

public class HomePage_01 extends TestBaseRapor {
    //1. Home Page with three Sliders only
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void getUrl() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void homePage_01() throws InterruptedException {
        extentTest = extentReports.createTest("homePage_01", "Home Page contains with three Sliders.");
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

        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contains only three sliders
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        assertEquals(homePage.sliders.size(), 3, "Expected value three sliders, actual value " + homePage.sliders.size());
        extentTest.info("The Home page contains three sliders.");
        extentTest.pass("The homepage contains only three sliders.");
    }

}
