package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Shop_04 extends TestBaseRapor {
    //35. Shop-Default Sorting Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_04", "Shop-Varsayılan Sıralama İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
        extentTest.info("shopButton tiklandi.");

        //4) Click on Sort by Average ratings in Default sorting dropdown
        Select select = new Select(shopPage.sortingSecenekleri);
        select.selectByIndex(0);
        extentTest.info("Default sort tiklandi.");
        List<WebElement> selectedObjects = select.getOptions();
        assertEquals(selectedObjects.get(0).toString(), selectedObjects.get(2).toString(), "Default sort is not Average ratings.");
        extentTest.info("Default sort ile Average ratings ayni sonuclari veriyor.");

        //5) Now user can view the popular products only
        select.selectByIndex(1);
        extentTest.info("Populer urunlere gore sirala secenegi tiklandi.");

        extentTest.pass("Shop-Default Sorting Functionality test PASS.");

    }

}
