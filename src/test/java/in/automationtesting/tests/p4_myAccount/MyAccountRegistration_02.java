package in.automationtesting.tests.p4_myAccount;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyAccountRegistration_02 extends TestBaseRapor {
    //28. Registration with invalid Email-id
    RegistrationPage registrationPage = new RegistrationPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void registrationWithInvalidEmailId() {
        extentTest = extentReports.createTest("MyAccountRegistration_02", "Gecersiz email-id ile kayit gerceklesmemeli.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");
        //3) Click on My Account Menu
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        extentTest.info("myAccountButton clicked.");

        //4) Enter invalid Email Address in Email-Address textbox
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(registrationPage.myAccountButton);
        registrationPage.emailBox.sendKeys(ConfigurationReader.getProperty("invalidUsername"));
        extentTest.info("Enter the invalid Email Address.");

        //5) Enter your own password in password textbox
        registrationPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("The password has been entered in the password text box.");

        //6) Click on Register button
        registrationPage.registerButton.click();
        extentTest.info("The registerButton clicked.");

        //7) Registration must fail with a warning message(ie You must enter a valid email address)
        System.out.println(registrationPage.emailWarningMessage.getText());
        assertTrue(registrationPage.emailWarningMessage.getText().contains("Error: Please provide a valid email address."), "The password you entered for the username invalidMail is incorrect. Lost your password? mesaji goruntulenmedi!");
        extentTest.info("invalidMail  assertion.");
        extentTest.pass("Registration with invalid email id test PASS.");
    }

}
