package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.TestBaseRapor;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MyAccountLogin_06 extends TestBaseRapor {
    HomePage homePage = new HomePage();

    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void myAccountLogin_06() {
        extentTest = extentReports.createTest("myAccountLogin_08", "Gecerli username ve sifre ile giris yapabilmeli.");

        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();

        //4) Enter the password field with some characters.
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        extentTest.info("myAccountButton is clicked.");
        ReusableMethods.clickWithJS(homePage.passwordBox);
        homePage.passwordBox.sendKeys("/*+_$", Keys.ENTER);
        extentTest.info("Kullanıcı adı metin kutusuna  cesitli karakterler iceren kullanıcı adı girildi.");

        //5) The password field should display the characters
        // in asterisks or bullets such that the password is not visible on the screen
        assert homePage.wrongText.isDisplayed();
        extentTest.info("Beklenen karakterler goruntulendi.");
        Driver.getDriver().navigate().refresh();
        extentTest.pass("PASS");
    }

}

