package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.HomePage;
import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Shop_07 extends TestBaseRapor {
    //38. Shop-Default Sorting Functionality
    ShopPage shopPage = new ShopPage();
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    Exception exception = new Exception();

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_08", "Shop-Varsayılan Sıralama İşlevselliği.");
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
        ReusableMethods.doubleClick(homePage.homeMenuButton);
        Driver.getDriver().navigate().refresh();
        extentTest.info("homeMenuButton tiklandi.");

        //5) Read More option indicates the Out Of Stock.
        //6) Users cannot add the product which has read more options as it was out of stock.
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).perform();
        ReusableMethods.clickWithJS(homePage.ikinciAddToBasketButton);
        extentTest.info("ikinciAddToBasketButton tiklandi.");
        ReusableMethods.waitAndClick(homePage.viewBasket, 4);
        homePage.quantityBox.click();
        homePage.quantityBox.sendKeys("99999");
        actions.sendKeys(Keys.UP).perform();
        actions.click(homePage.quantityBox).perform();
        extentTest.info("quantityBox tiklandi.");
        homePage.updateBasketButton.click();
        extentTest.info("updateBasketButton tiklandi.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("hedef element seviyesine gelindi.");
        ReusableMethods.waitAndClick(homePage.proceedToCheckoutButton, 4);
        extentTest.info("proceedToCheckoutButton tiklandi.");
        assertNotEquals(Driver.getDriver().getCurrentUrl(), ConfigurationReader.getProperty("checkoutUrl"), "url'ler beklenmeyen sekilde ayni!!");
        extentTest.info("url'lerin esit olmadigi dogrulandi.");
        extentTest.fail("FAIL");
        extentTest.pass("PASS");
    }

}
