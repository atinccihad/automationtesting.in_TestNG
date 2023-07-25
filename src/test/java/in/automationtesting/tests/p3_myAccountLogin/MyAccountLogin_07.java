package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.Report;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountLogin_07 extends Report {
    //25. Login-Handles case sensitive
    HomePage homePage = new HomePage();

    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void myAccountLogin_07() {
        extentTest = extentReports.createTest("myAccountLogin_07","Gecerli username ve sifre ile giris yapabilmeli.");
        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        //4) Enter the case changed username in username textbox
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton is clicked.");
        homePage.emailBox.sendKeys("wrong", Keys.ENTER);
        extentTest.info("Kullanıcı adı metin kutusuna durum değiştirmeyen kullanıcı adı girildi.");
        //5) Enter the case chenged password in the password tetxbox
        ReusableMethods.clickWithJS(homePage.passwordBox);
        homePage.passwordBox.sendKeys("wrong", Keys.ENTER);
        extentTest.info("Parola metin kutusuna durum değiştirilen parola girildi.");
        //6) Click on login button
        homePage.loginButton.click();
        extentTest.info("login button tiklandi.");
        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        assert homePage.wrongText.isDisplayed();
        Driver.getDriver().navigate().refresh();
    }

    @AfterClass
    public void closeDriver() {Driver.closeDriver();}

}


