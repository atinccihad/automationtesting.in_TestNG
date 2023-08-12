package in.automationtesting.tests.p6_myAccounts_dashboard;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MyAccount_05 extends TestBaseRapor {
    //48. My Accounts-Address Functionality
    HomePage homePage = new HomePage();
    @Test
    public void myAccountsOrders() {
        extentTest = extentReports.createTest("MyAccount_05", "My Accounts-Address Functionality.");
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

        //8) Click on My account link which leads to Dashboard
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");

        //9) Click on Address link
        homePage.addresses.click();
        Driver.getDriver().navigate().refresh();
        homePage.addresses.click();
        extentTest.info("addresses clicked.");

        //10) User must view billing address and ship address
        assertTrue(homePage.billingAddress.isDisplayed());
        extentTest.info("billingAddress isDisplayed.");
        assertTrue(homePage.shippingAddress.isDisplayed());
        extentTest.info("shippingAddress isDisplayed.");
        extentTest.pass("My Accounts-Address Functionality test PASS.");
    }
}
