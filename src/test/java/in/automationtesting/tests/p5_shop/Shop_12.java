package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.HomePage;
import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class Shop_12 extends TestBaseRapor {
    HomePage homepage = new HomePage();
    ShopPage shopPage = new ShopPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ShopAdd() {
        extentTest = extentReports.createTest("Shop_12", "Shop-Add to Basket-View Basket-Tax Functionality.");
        //43. Shop-Add to Basket-View Basket-Tax Functionality
        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        homepage.shopBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopBtn, 3);
        extentTest.info("shopButton tiklandi.");

        //4) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.jsExecutorScrool(shopPage.ikinciElementAddToBasketButton);
        ReusableMethods.clickWithJS(shopPage.ikinciElementAddToBasketButton);
        extentTest.info("ikinciElementAddToBasketButton tiklandi.");

        //5) User can view that Book in the Menu item with price .
        softAssert.assertTrue(shopPage.itemMiktariSagUst.isDisplayed(), "itemMiktariSagUst is not Displayed!!");
        extentTest.info("itemMiktariSagUst goruntulendi.");

        //6) Now click on View Basket link which navigates to proceed to check out page.
        ReusableMethods.waitAndClick(shopPage.sepetIconVeSepetTutari, 3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(shopPage.sepetIconVeSepetTutari, 3);
        extentTest.info("sepeti goruntule tiklandi.");

        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        softAssert.assertTrue(shopPage.urunIsim.isDisplayed(), "urunIsim is not Displayed!!");
        softAssert.assertTrue(shopPage.urunPrice.isDisplayed(), "urunPrice is not Displayed!!");
        softAssert.assertTrue(shopPage.urunQuantity.isDisplayed(), "urunQuantity is not Displayed!!");
        softAssert.assertTrue(shopPage.subtotalMiktari.isDisplayed(), "subtotalMiktari is not Displayed!!");
        softAssert.assertTrue(shopPage.taxMiktari.isDisplayed(), "taxMiktari is not Displayed!!");
        softAssert.assertTrue(shopPage.totalMiktari.isDisplayed(), "totalMiktari is not Displayed!!");
        extentTest.info("toplam ve toplam degerleri goruntulendi.");

        //8) The total always < subtotal because taxes are added in the subtotal
        String subtotalMiktariStr = shopPage.subtotalMiktari.getText().replaceAll("[\\D]", "");
        int subtotalMiktariInt = Integer.parseInt(subtotalMiktariStr);
        subtotalMiktariInt /= 100;
        extentTest.info("subtotalMiktariInt=> " + subtotalMiktariInt);
        String totalMiktariStr = shopPage.totalMiktari.getText().replaceAll("[\\D]", "");
        int totalMiktariInt = Integer.parseInt(totalMiktariStr);
        totalMiktariInt /= 100;
        extentTest.info("totalMiktariInt=> " + totalMiktariInt);
        softAssert.assertTrue(totalMiktariInt > subtotalMiktariInt, "totalMiktari < subtotalMiktari !!");
        extentTest.info("The total always < subtotal.");

        //9) The tax rate variers for India compared to other countries
        ReusableMethods.clickWithJS(shopPage.checkoutBtn);
        extentTest.info("checkoutBtn clicked.");
        double taxForIndia = Double.parseDouble(shopPage.taxForIndia.getText().substring(1));
        double totalAtLastPage = Double.parseDouble(shopPage.totalAtLastPage.getText().substring(1));

        assertEquals((totalAtLastPage * 2) / 100, taxForIndia);
        extentTest.info("vergi orani farkliligi dogrulandi.");

        //10) Tax rate for indian should be 2% and for abroad it should be 5%
        ReusableMethods.waitAndClickElement(shopPage.billingCountryDropdown, 3);
        extentTest.info("billingCountryDropdown clicked.");
        ReusableMethods.jsExecutorScrool(shopPage.billingCountryInputBox);
        shopPage.billingCountryInputBox.sendKeys("Turkey");
        extentTest.info("billingCountryInputBox send the keys.");
        shopPage.billingCountryInputBox.sendKeys(Keys.ENTER);
        extentTest.info("billingCountryInputBox clicked.");

        ReusableMethods.wait(10);
        double taxForotherCountries = Double.parseDouble(shopPage.taxForOtherCountries.getText().substring(1));
        assertEquals((totalAtLastPage * 5) / 100, taxForotherCountries);
        extentTest.info("vergi oranlari dogrulandi.");
        extentTest.pass("Shop-Add to Basket-View Basket-Tax Functionality test PASS.");

    }
}
