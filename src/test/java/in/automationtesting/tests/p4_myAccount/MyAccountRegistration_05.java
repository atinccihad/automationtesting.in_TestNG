package in.automationtesting.tests.p4_myAccount;

import in.automationtesting.pages.RegistrationPage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.Test;

public class MyAccountRegistration_05 extends TestBaseRapor {
    //23. Log-in with empty username and empty password
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
    }

}
