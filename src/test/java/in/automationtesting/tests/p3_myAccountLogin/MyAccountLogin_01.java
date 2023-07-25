package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyAccountLogin_01 {
    //19. Log-in with valid username and password
    HomePage homePage = new HomePage();

    @BeforeClass
    public void getUrl_login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        //3) Click on My Account Menu
        //4) Enter registered username in username textbox
        //5) Enter password in password textbox
        //6) Click on login button
        ReusableMethods.login();
    }

    @Test
    public void myAccountLogin_01() {
        //7) User must successfully login to the web page
        assert homePage.welcomeText.isDisplayed();
    }

    @AfterClass
    public void closeDriver() {Driver.getDriver().close();}

}
