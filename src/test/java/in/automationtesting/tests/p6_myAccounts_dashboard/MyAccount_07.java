package in.automationtesting.tests.p6_myAccounts_dashboard;

import com.github.javafaker.Faker;
import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class MyAccount_07 extends TestBaseRapor {
    //50. My Accounts-Account Details
    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    @Test
    public void myAccountsAddress() {
        extentTest = extentReports.createTest("MyAccount_06", "My Accounts-Address Functionality.");
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

        //9) Click on Account details
        ReusableMethods.clickWithJS(homePage.accountDetails);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.accountDetails);
        Driver.getDriver().navigate().refresh();
        extentTest.info("accountDetails clicked.");

        //10) User can view account details where he can change his password also.
        assertTrue("passwordChangeText is not Displayed!!", homePage.passwordChangeText.isDisplayed());
        extentTest.info("passwordChangeText is Displayed.");

        extentTest.pass("My Accounts-Address Functionality test PASS.");
    }

}

