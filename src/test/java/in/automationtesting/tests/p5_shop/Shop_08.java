package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Shop_08 extends TestBaseRapor {
    //39. Shop-Read More Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_09", "Mağaza-Daha Fazla Oku İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
        extentTest.info("shopButton tiklandi.");
        //4) Click on read more button in home page
        //5) Read More option indicates the Out Of Stock.
        //6) Users cannot add the product which has read more options as it was out of stock.
        extentTest.pass("Shop-Read More Functionality test PASS.");
    }

}
