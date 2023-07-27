package in.automationtesting.tests.p4_myAccount;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyAccountRegistration_04 extends TestBaseRapor {
    //22. Log-in with empty username and valid password
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void myAccountRegistration_04() {
        extentTest = extentReports.createTest("MyAccountRegistration_04", "Bos password ile kayit gerceklesmemeli.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        extentTest.info("myAccountButton clicked.");

        //4) Enter empty username in username textbox
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        registrationPage.emailBox.sendKeys("", Keys.ENTER);
        extentTest.info("Entered empty username in username textbox.");

        //5) Now enter valid password in the password textbox
        registrationPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("The password has been entered in the password text box.");

        //6) Click on login button.
        registrationPage.loginButton.click();
        extentTest.info("The loginButton clicked.");

        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        assertTrue(registrationPage.errorMessage.isDisplayed(), "errorMessage -> 'Error: Username is required.' is not displayed!!");
        extentTest.info("'Error: Username is required.' is displayed.");
        extentTest.pass("Log-in with empty username and valid password test PASS.");
    }

}
