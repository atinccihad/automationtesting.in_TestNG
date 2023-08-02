package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Shop_01 extends TestBaseRapor {
    //32. Shop-Filter By Price Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void shopFilterByPriceFunctionality() {
        extentTest = extentReports.createTest("Shop_01", "Bos password ile kayit gerceklesmemeli.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
        extentTest.info("Clicked the Shop Menu button.");

        //4) Adjust the filter by price between 150 to 450 rps
        shopPage.adjustPriceBySlider(150, 450);
        ReusableMethods.waitFor(3);
        extentTest.info("The filtered by price between 150 to 450 rps.");

        //5) Now click on Filter button
        ReusableMethods.clickWithJS(shopPage.filterMAVI_button);
        extentTest.info("The Filter button is clicked.");

        //6) User can view books only between 150 to 450 rps price
        assertTrue(Driver.getDriver().getCurrentUrl().contains("min_price=150&max_price=450"));
        extentTest.info("User viewed the books, only between 150 to 450 rps price.");
        extentTest.pass("Shop-Filter By Price Functionality test PASS.");
    }

}
