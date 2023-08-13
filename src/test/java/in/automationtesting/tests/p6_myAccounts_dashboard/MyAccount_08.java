package in.automationtesting.tests.p6_myAccounts_dashboard;

import com.github.javafaker.Faker;
import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import in.automationtesting.utilities.TestBaseRapor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyAccount_08 extends TestBaseRapor {
    //51. My Accounts-Log-Out
    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    @Test
    public void myAccountsAddress() {
        extentTest = extentReports.createTest("MyAccount_06", "My Accounts-Address Functionality.");
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        extentTest.info("Get the url -> http://practice.automationtesting.in/");

        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");

        //4) Enter registered username in username textbox
        homePage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentTest.info("emailBox sendKeys username.");

        //5) Enter password in password textbox
        homePage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentTest.info("emailBox sendKeys password.");

        //6) Click on login button
        homePage.loginButton.click();
        extentTest.info("loginButton clicked.");

        //7) User must successfully login to the web page
        assert homePage.welcomeText.isDisplayed();
        extentTest.info("welcomeText isDisplayed.");

        //8) Click on My account link
        homePage.myAccountButton.click();
        extentTest.info("myAccountButton clicked.");
        String cikisYapilmamaisSepet = homePage.sepetItemFiyatSagUst.getText();
        System.out.println("cikisYapilmamaisSepet.toString() = " + cikisYapilmamaisSepet.toString());

        //9) Click on Logout button
        homePage.logoutButton.click();
        extentTest.info("Logout button clicked.");

        //10) On clicking logout,User successfully comes out from the site
        String cikisYapilmisSepet = homePage.sepetItemFiyatSagUst.getText();
        System.out.println("cikisYapilmisSepet.toString() = " + cikisYapilmisSepet.toString());
        assertNotEquals(cikisYapilmamaisSepet, cikisYapilmisSepet);
        System.out.println("Oturumu kapat tıklandı, Kullanıcı siteden başarıyla çıktı.");

        extentTest.pass("My Accounts-Log-Out test PASS.");
    }

}

