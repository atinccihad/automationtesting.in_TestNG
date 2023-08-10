package in.automationtesting.tests.p5_shop;

import com.github.javafaker.Faker;
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
import org.testng.asserts.SoftAssert;

public class Shop_11 extends TestBaseRapor {
    //41. Shop-Add to Basket-View Basket Functionality
    ShopPage shopPage = new ShopPage();
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();

    @Test
    public void shopDefaultSortingFunctionality() {
        extentTest = extentReports.createTest("Shop_11", "Alışveriş-Sepete Ekle-Sepete Bak İşlevselliği.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();
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

        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitAndClick(shopPage.proceedToCheckoutButton, 3);
        extentTest.info("proceedToCheckoutButton clicked.");

        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        homePage.billingdetailsFirstname.sendKeys(faker.name().firstName());
        assert homePage.billingdetailsFirstname.isDisplayed();
        extentTest.info("billingdetailsFirstname isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsLastname);
        homePage.billingdetailsLastname.sendKeys(faker.name().lastName());
        assert homePage.billingdetailsLastname.isDisplayed();
        extentTest.info("billingdetailsLastname isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsCompanyname);
        homePage.billingdetailsCompanyname.sendKeys(faker.company().name());
        assert homePage.billingdetailsCompanyname.isDisplayed();
        extentTest.info("billingdetailsCompanyname isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsEmailaddress);
        homePage.billingdetailsEmailaddress.sendKeys(faker.internet().emailAddress());
        assert homePage.billingdetailsEmailaddress.isDisplayed();
        extentTest.info("billingdetailsEmailaddress isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsPhone);
        homePage.billingdetailsPhone.sendKeys(faker.phoneNumber().cellPhone());
        assert homePage.billingdetailsPhone.isDisplayed();
        extentTest.info("billingdetailsPhone isDisplayed.");
        ReusableMethods.waitFor(1);
        assert homePage.billingdetailsCountry.isDisplayed();
        extentTest.info("billingdetailsCountry isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsAddress);
        homePage.billingdetailsAddress.sendKeys(faker.address().fullAddress());
        assert homePage.billingdetailsAddress.isDisplayed();
        extentTest.info("billingdetailsAddress isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsAddress2);
        homePage.billingdetailsAddress2.sendKeys(faker.address().fullAddress());
        assert homePage.billingdetailsAddress2.isDisplayed();
        extentTest.info("billingdetailsAddress2 isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsTownCity);
        homePage.billingdetailsTownCity.sendKeys(faker.address().city());
        assert homePage.billingdetailsTownCity.isDisplayed();
        extentTest.info("billingdetailsTownCity isDisplayed.");
        ReusableMethods.waitFor(1);
        shopPage.postcodeZIP.sendKeys("35430");
        assert shopPage.postcodeZIP.isDisplayed();
        extentTest.info("postcodeZIP isDisplayed.");
        ReusableMethods.jsExecutorScrool(homePage.billingdetailsPlaceOrderButton);
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).perform();
        assert homePage.total.isDisplayed();
        extentTest.info("total isDisplayed.");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(homePage.subtotal);
        assert homePage.subtotal.isDisplayed();
        extentTest.info("subtotal isDisplayed.");
        assert homePage.tax.isDisplayed();
        extentTest.info("tax isDisplayed.");
        assert homePage.billingdetailsBanktransferPayments.isDisplayed();
        extentTest.info("billingdetailsBanktransferPayments isDisplayed.");
        ReusableMethods.waitFor(1);

        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        ReusableMethods.jsExecutorScrool(shopPage.directBankTransfer);
        assert shopPage.directBankTransfer.isDisplayed();
        extentTest.info("directBankTransfer isDisplayed.");
        assert shopPage.checkPayments.isDisplayed();
        extentTest.info("checkPayments isDisplayed.");
        assert shopPage.cashOnDelivery.isDisplayed();
        extentTest.info("cashOnDelivery isDisplayed.");
        assert shopPage.paypalExpressCheckout.isDisplayed();
        extentTest.info("paypalExpressCheckout isDisplayed.");

        //12) Now click on Place Order button to complete process
        ReusableMethods.jsExecutorScrool(shopPage.checkoutPagePlaceholderButton);
        ReusableMethods.clickWithJS(shopPage.checkoutPagePlaceholderButton);
        extentTest.info("checkoutPagePlaceholderButton clicked.");

        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(shopPage.thanksMessage.isDisplayed(), "Tesekkur mesahi gorulmedi!!");
        extentTest.info("ourBankDetails isDisplayed.");
        softAssert.assertAll();
        extentTest.pass("Alışveriş-Sepete Ekle-Sepete Bak İşlevselliği testi PASS.");

    }

}
