package in.automationtesting.tests.p4_myAccount_registration;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyAccountRegistration_04 extends TestBaseRapor {
    //30. Registration with empty password
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

        //4) Enter valid Email Address in Email-Address textbox
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        registrationPage.emailBox.sendKeys(ConfigurationReader.getProperty("username"), Keys.ENTER);
        extentTest.info("Entered username in username textbox.");

        //5) Enter empty password in password textbox
        registrationPage.passwordBox.sendKeys("");
        extentTest.info("The empty password has been entered in the password text box.");

        //6) Click on Register button
        registrationPage.registerButton.click();
        extentTest.info("The registerButton clicked.");

        //7) Registration must fail with a warning message(ie please enter an account password)
        assertTrue(registrationPage.errorMessage.isDisplayed(), "errorMessage -> 'Error: Username is required.' is not displayed!!");
        extentTest.info("'Error: Password is required.' is displayed.");

        extentTest.pass("Log-in with valid username and empty password test PASS.");
    }

}
