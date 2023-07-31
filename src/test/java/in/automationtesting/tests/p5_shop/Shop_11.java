package in.automationtesting.tests.p5_shop;

import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Shop_11 extends TestBaseRapor {
    //41. Shop-Add to Basket-View Basket Functionality
    ShopPage shopPage = new ShopPage();
    Actions actions = new Actions(Driver.getDriver());

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
        //5) User can view that Book in the Menu item with price .
        //6) Now click on View Basket link which navigates to proceed to check out page.
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        //8) The total always < subtotal because taxes are added in the subtotal
        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        //12) Now click on Place Order button to complete process
        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        extentTest.pass("");
    }

}
