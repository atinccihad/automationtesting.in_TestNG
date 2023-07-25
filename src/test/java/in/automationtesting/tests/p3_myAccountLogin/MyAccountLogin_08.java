package in.automationtesting.tests.p3_myAccountLogin;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountLogin_08 {
    HomePage homePage = new HomePage();

    @BeforeClass
    public void getUrl() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void myAccountLogin_08() {
        //3) Click on My Account Menu
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        //4) Enter the case changed username in username textbox
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        homePage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        //5) Enter the case chenged password in the password tetxbox
        ReusableMethods.clickWithJS(homePage.passwordBox);
        homePage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on login button
        homePage.loginButton.click();
        //7) Once your are logged in, sign out of the site
        homePage.signout.click();
        //8) Now press back button
        Driver.getDriver().navigate().back();
        //9) User shouldn’t be signed in to his account rather a general webpage must be visible
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigurationReader.getProperty("myaccountUrl"),"Beklenmedik sekilde oturum acildi!!");
        Driver.getDriver().navigate().refresh();
    }

    @AfterClass
    public void closeDriver() {Driver.closeDriver();}

}




