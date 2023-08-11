package in.automationtesting.tests.p4_myAccount_registration;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MyAccountRegistration_03 extends TestBaseRapor {
    //29. Registration with empty Email-id
    RegistrationPage registrationPage = new RegistrationPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void myAccountRegistration_03() {
        extentTest = extentReports.createTest("MyAccountRegistration_03", "Bos e-posta ile kayit gerceklesmemeli.");
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
        extentTest.info("myAccountButton clicked.");
        registrationPage.emailBox.sendKeys("", Keys.ENTER);
        extentTest.info("An empty email has been entered in the Email text box..");

        //5) Enter your own password in password textbox
        registrationPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("The password has been entered in the password text box.");

        //6) Click on Register button
        registrationPage.registerButton.click();
        extentTest.info("The registerButton clicked.");

        //7) Registration must fail with a warning message(ie please provide valid email address)
        assertTrue("Uyari mesaji goruntulenmedi!!", registrationPage.usernameIsRequired.isDisplayed());
        extentTest.info("Uyari mesaji dogrulandi.");
        extentTest.pass("Registration with empty email test PASS.");
    }

}
