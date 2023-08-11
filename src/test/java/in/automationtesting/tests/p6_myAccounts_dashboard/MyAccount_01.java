package in.automationtesting.tests.p6_myAccounts_dashboard;

import in.automationtesting.pages.HomePage;
import in.automationtesting.pages.ShopPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class MyAccount_01 extends TestBaseRapor {
    //44. My Accounts - Dashboard
    HomePage homePage = new HomePage();
    ShopPage shopPage = new ShopPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void myAccountsDashboard() {
        extentTest = extentReports.createTest("MyAccount_01", "My Accounts - Dashboard Functionality.");
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

        //8) Click on Myaccount link which leads to Dashboard
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");
        homePage.dashboardBtn.click();
        extentTest.info("dashboardBtn clicked.");

        //9) User must view Dashboard of the site
        String expectedDashboardUrl = Driver.getDriver().getCurrentUrl();
        String actualDashboardUrl = "https://practice.automationtesting.in/my-account/";
        assertEquals(expectedDashboardUrl, actualDashboardUrl);
        extentTest.info("expectedDashboardUrl equalTo(actualDashboardUrl)");
        extentTest.pass("My Accounts - Dashboard test PASS");
    }
}
