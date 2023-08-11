package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Shop_02 extends TestBaseRapor {
    //33. Shop-Product Categories Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void shopProductCategoriesFunctionality() {
        extentTest = extentReports.createTest("Shop_02", "Mağaza-Ürün Kategorileri İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
        extentTest.info("shopButton tiklandi.");

        //4) Click any of the product links available in the product category
        ReusableMethods.clickWithJS(shopPage.androidButton);
        extentTest.info("productCategories teki androidButton secenek tiklandi.");
        Driver.getDriver().navigate().refresh();

        //5) Now user can view only that particular product
        assertTrue(shopPage.androidUrun.isDisplayed(), "androidUrun gorunmuyor!");
        extentTest.info("androidUrun gorundugu dogrulandi.");

        extentTest.pass("Shop-Product Categories Functionality test PASS.");
    }

}
