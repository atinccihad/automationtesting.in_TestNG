package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.HomePage;
import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Shop_10 extends TestBaseRapor {
    //41. Shop-Add to Basket-View Basket Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());
    HomePage homepage = new HomePage();

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_10", "Alışveriş-Sepete Ekle-Sepete Bak İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        homepage.shopBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopBtn, 3);
        extentTest.info("Clicked Shop Menu");

        //4) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(shopPage.shopPageAddToBasketBtn);
        extentTest.info("Clicked shopPageAddToBasketBtn");

        //5) User can view that Book in the Menu item with price .
        String itemText = homepage.itemText.getText();
        assertEquals(itemText, "1 Item");
        extentTest.info("1 Item  assertion");
        String priceText = homepage.priceText.getText();
        assertEquals(priceText, "₹500.00");
        extentTest.info("priceText  assertion");

        //6) Now click on Item link which navigates to proceed to check out page.
        ReusableMethods.clickWithJS(homepage.viewBasketButton);
        extentTest.info("clicked viewBasketButton");

        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Driver.getDriver().navigate().refresh();
        assertTrue(homepage.subtotalValue.isDisplayed() && homepage.finalTotalPrice.isDisplayed());
        extentTest.info("subtotalValue isDisplayed");

        //8) The total always < subtotal because taxes are added in the subtotal
        double subtotal = Double.parseDouble(homepage.subtotalValue.getText().substring(1));
        double totalPrice = Double.parseDouble(homepage.finalTotalPrice.getText().substring(1));
        assertTrue(totalPrice > subtotal);
        extentTest.info("totalPrice > subtotal");

        //9) The tax rate variers for India compared to other countries
        ReusableMethods.clickWithJS(shopPage.checkoutBtn);
        extentTest.info("checkoutBtn clicked");
        double taxForIndia = Double.parseDouble(shopPage.taxForIndia.getText().substring(1));
        double totalAtLastPage = Double.parseDouble(shopPage.totalAtLastPage.getText().substring(1));
        assertEquals((totalAtLastPage * 2) / 100, taxForIndia);
        extentTest.info("totalAtLastPage * 2) / 100, taxForIndia -> EQUAL");

        //10) Tax rate for indian should be 2% and for abroad it should be 5%
        shopPage.billingCountryDropdown.click();
        shopPage.billingCountryInputBox.sendKeys("Turkey");
        shopPage.billingCountryInputBox.sendKeys(Keys.ENTER);
        ReusableMethods.wait(10);
        double taxForotherCountries = Double.parseDouble(shopPage.taxForOtherCountries.getText().substring(1));
        assertEquals((totalAtLastPage * 5) / 100, taxForotherCountries);
        extentTest.info("totalAtLastPage * 5) / 100, taxForotherCountries -> EQUAL");
        extentTest.pass("Shop-Add to Basket-View Basket Functionality test PASS.");
    }

}
