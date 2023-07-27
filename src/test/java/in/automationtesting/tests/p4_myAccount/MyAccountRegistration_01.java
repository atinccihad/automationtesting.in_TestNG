package in.automationtesting.tests.p4_myAccount;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MyAccountRegistration_01 extends TestBaseRapor {
    //27. Registration-Sign-in
    RegistrationPage registrationPage = new RegistrationPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void registration_SignIn() {
        extentTest = extentReports.createTest("MyAccountRegistration_01", "Gecerli veriler ile kayit gerceklesmeli.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");
        //3) Click on My Account Menu
        ReusableMethods.waitAndClick(registrationPage.myAccountButton, 3);
        extentTest.info("myAccountButton clicked.");

        //4) Enter registered Email Address in Email-Address textbox
        Driver.getDriver().navigate().refresh();
        registrationPage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentTest.info("Email-Address textbox sendKeys email.");

        //5) Enter your own password in password textbox
        registrationPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("Password textbox sendKeys password.");

        //6) Click on Register button
        ReusableMethods.clickWithJS(registrationPage.registerButton);
        extentTest.info("Clicked on Register button.");

        //7) User will be registered successfully and will be navigated to the Home page
        assert registrationPage.helloUser.isDisplayed();
        extentTest.info("Hello {username} (not {username}? Sign out), text assertion.");

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigurationReader.getProperty("base_url");
        assertEquals("Navigated to the Home page FAIL !!", expectedUrl, actualUrl);
        extentTest.info("Navigated to the Home page.");
        extentTest.pass("Registration-Sign-in test PASS.");
    }
}
