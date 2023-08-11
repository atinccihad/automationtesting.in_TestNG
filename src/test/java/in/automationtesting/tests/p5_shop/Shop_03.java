package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Shop_03 extends TestBaseRapor {
    //34. Shop-Default Sorting Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_03", "Shop-Varsayılan Sıralama İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
        extentTest.info("shopButton tiklandi.");

        //4) Click on Sort by Popularity item in Default sorting dropdown
        Select select = new Select(shopPage.sortingSecenekleri);
        select.selectByIndex(1);
        //System.out.println(select.getFirstSelectedOption().getText());
        extentTest.info("1.index 'Sort by Popularity' secildi.");

        //5) Now user can view the popular products on
        select.selectByVisibleText("Sort by popularity");
        extentTest.info("'Sort by popularity' secildi.");
        //System.out.println(shopPage.seleniumElementleri.get(0).getText());
        assertEquals(shopPage.seleniumElementleri.get(0), shopPage.seleniumFirstElement, "Siralama secenegine gore bekledigimiz siralama olusmadi!");
        extentTest.info("Siralama secenegine gore beklenilen siralama olustu.");

        extentTest.pass("Shop-Default Sorting Functionality test PASS.");
    }

}
