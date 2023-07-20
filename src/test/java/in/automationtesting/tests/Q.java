package in.automationtesting.tests;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import org.testng.annotations.Test;

public class Q {
    HomePage homePage = new HomePage();
    String url1 = "https://amazon.com";
    String url2 = "https://trendyol.com";
    String url3 = "https://bestbuy.com";
    String url4 = "https://github.com";
    @Test
    public void test04() {
        Driver.getDriver().get(url4);
    }
    @Test
    public void test01() {
        Driver.getDriver().get(url1);
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        homePage.shopMenuButton.click();

    }

    @Test
    public void test02() {
        Driver.getDriver().get(url2);
    }

    @Test
    public void test03() {
        Driver.getDriver().get(url3);
    }
}
