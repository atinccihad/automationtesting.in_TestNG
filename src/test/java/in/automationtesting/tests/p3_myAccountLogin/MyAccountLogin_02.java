package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountLogin_02 extends TestBaseRapor {
    //20. Log-in with incorrect username and incorrect password
    HomePage homePage = new HomePage();
    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void myAccountLogin_02() {
        extentTest = extentReports.createTest("myAccountLogin_08","Gecersiz username ve sifre ile giris yapilmamali.");
        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        //4) Enter incorrect username in username textbox
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton is clicked.");
        homePage.emailBox.sendKeys("wrongMail");
        extentTest.info("yanlis mail girildi.");
        //5) Enter incorrect password in password textbox.
        ReusableMethods.clickWithJS(homePage.passwordBox);
        homePage.passwordBox.sendKeys("wrongPassword");
        extentTest.info("yanlis password girildi.");
        //6) Click on login button
        homePage.loginButton.click();
        extentTest.info("Giriş düğmesine tıklandi.");
        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        assert homePage.wrongText.isDisplayed();
        extentTest.info("Hata mesaji goruntulendi.");
        Driver.getDriver().navigate().refresh();
        extentTest.pass("PASS");
    }

    @AfterClass
    public void closeDriver(){Driver.closeDriver();}

}
