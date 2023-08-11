package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.HomePage;
import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Shop_09 extends TestBaseRapor {
    //40. Shop-Sale Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());
    HomePage homepage = new HomePage();

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_10", "Mağaza-Satış İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));

        //3) Click on Shop Menu
        homepage.shopBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopBtn, 3);
        extentTest.info("shopButton tiklandi.");

        //4) Click on Sale written product in home page]
        homepage.saleBtn.click();
        extentTest.info("saleBtn tiklandi.");

        //5) User can clearly view the actual price with old price stricken for the sale written products
        assertTrue(homepage.actualPrice.isDisplayed() && homepage.oldPrice.isDisplayed());
        extentTest.info("actualPrice assertion.");

        extentTest.pass("Shop-Sale Functionality test PASS.");
    }

}
