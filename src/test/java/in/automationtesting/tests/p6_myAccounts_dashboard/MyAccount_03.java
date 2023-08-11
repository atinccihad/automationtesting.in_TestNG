package in.automationtesting.tests.p6_myAccounts_dashboard;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MyAccount_03 extends TestBaseRapor {
    //46. My Accounts - Orders
    HomePage homePage = new HomePage();

    @Test
    public void myAccountsOrders() {
        extentTest = extentReports.createTest("MyAccount_02", "My Accounts - Orders Functionality.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");

        //4) Enter registered username in username textbox
        homePage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentTest.info("emailBox sendKeys username.");

        //5) Enter password in password textbox
        homePage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("emailBox sendKeys password.");

        //6) Click on login button
        homePage.loginButton.click();
        extentTest.info("loginButton clicked.");

        //7) User must successfully login to the web page
        assert homePage.welcomeText.isDisplayed();
        extentTest.info("welcomeText isDisplayed.");

        //8) Click on My account link
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");

        //9) Click on Orders link
        homePage.ordersButton.click();
        extentTest.info("Orders clicked.");

        //10) Click view button
        //ReusableMethods.clickWithJS(homePage.viewsList.get(5));
        homePage.firstViewButton.click();
        extentTest.info("Ilk view buttona tiklandi.");

        //11) User must view his Order details,customer details and billing details on clicking view button
        assertTrue("orderDetailsAllPage is not Displayed!", homePage.orderDetailsAllPage.isDisplayed());
        extentTest.info("orderDetailsAllPage assertion.");
        ReusableMethods.jsExecutorScrool(homePage.billingAddressDetailsAllPage);
        assertTrue("billingAddressDetailsAllPage is not Displayed!", homePage.billingAddressDetailsAllPage.isDisplayed());
        extentTest.info("billingAddressDetailsAllPage assertion.");
        ReusableMethods.jsExecutorScrool(homePage.customerDetailsAllPage);
        assertTrue("customerDetailsAllPage is not Displayed!", homePage.customerDetailsAllPage.isDisplayed());
        extentTest.info("customerDetailsAllPage assertion.");
        extentTest.pass("My Accounts - Orders test PASS.");
    }
}
