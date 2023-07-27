package in.automationtesting.tests.p4_myAccount;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyAccountRegistration_05 extends TestBaseRapor {
    //31. Registration with empty Email-id & password
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void myAccountRegistration_05() {
        extentTest = extentReports.createTest("MyAccountRegistration_05", "Bos kullanici adi, bos password ile kayit gerceklesmemeli.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        extentTest.info("myAccountButton clicked.");

        //4) Enter empty Email Address in Email-Address textbox
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        registrationPage.emailBox.sendKeys("", Keys.ENTER);
        extentTest.info("Entered empty Email Address in Email-Address textbox.");

        //5) Enter empty password in password textbox
        registrationPage.passwordBox.sendKeys("");
        extentTest.info("The empty password has been entered in the password text box.");

        //6) Click on Register button
        registrationPage.registerButton.click();
        extentTest.info("RegisterButton clicked.");

        //7) Registration must fail with a warning message(ie please provide valid email address)
        assertTrue(registrationPage.errorMessage.isDisplayed(), "Warning message is not displayed.");
        extentTest.info("Registration is fail with a warning message.");
        extentTest.pass("Bos kullanici adi, bos password ile kayit gerceklesmedi.");
    }

}
