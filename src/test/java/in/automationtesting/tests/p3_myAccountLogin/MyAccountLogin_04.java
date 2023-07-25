package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountLogin_04 extends TestBaseRapor {
    //22. Log-in with empty username and valid password
    HomePage homePage = new HomePage();

    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void myAccountLogin_04() {
        extentTest = extentReports.createTest("myAccountLogin_08","Gecerli username ve sifre ile giris yapabilmeli.");
        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        //4) Enter empty username in username textbox
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton is clicked.");
        homePage.emailBox.sendKeys("", Keys.ENTER);
        extentTest.info("Kullanıcı adı metin kutusuna  ''  kullanıcı adı girildi.");
        //5) Now enter valid password in the password textbox
        ReusableMethods.clickWithJS(homePage.passwordBox);
        homePage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("Parola metin kutusuna durum değiştirilen parola girildi.");
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
    public void closeDriver() {Driver.closeDriver();}

}

