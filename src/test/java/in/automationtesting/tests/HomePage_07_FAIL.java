package in.automationtesting.tests;

import in.automationtesting.pages.HomePage;
import in.automationtesting.utilities.ConfigurationReader;
import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePage_07_FAIL {
    //7. Home page - Arrivals-Add to Basket with more books
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void getUrl() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Test
    public void test07() {

        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();

        //3) Click on Shop Menu
        homePage.shopMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        homePage.shopMenuButton.click();

        //4) Now click on Home menu button
        homePage.homeMenuButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertEquals(homePage.arrivals.size(), 3, "Expected value three arrivals, actual value " + homePage.arrivals.size());

        //7) Now click the image in the Arrivals
        for (int i = 0; i < homePage.arrivals.size(); i++) {
            ReusableMethods.clickWithJS(homePage.arrivals.get(i));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().back();
        }

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        ReusableMethods.clickWithJS(homePage.arrivals.get(0));
        softAssert.assertTrue(homePage.addToBasketButton.isDisplayed(), "homePage.addToBasketButton.is not Displayed !!");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        softAssert.assertTrue(homePage.firstArrivalImage.isEnabled(), "Image not should be clickable!!");
        ReusableMethods.clickWithJS(homePage.firstArrivalImage);
        softAssert.assertTrue(homePage.addToBasketButton.isEnabled(), "homePage.addToBasketButton.is not Selected!!");
        Driver.getDriver().navigate().refresh();

        //10) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(homePage.addToBasketButton);

        //11) User can view that Book in the Menu item with price.
        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        ReusableMethods.clickWithJS(homePage.viewBasketButton);
        Driver.getDriver().navigate().refresh();
        softAssert.assertTrue(homePage.basketTotals.isDisplayed());

        //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        Driver.getDriver().navigate().back();
        int stock = 20;
        actions.sendKeys(homePage.quantityBox,"21",Keys.ENTER);

        //14) Click the add to basket button
        ReusableMethods.clickWithJS(homePage.addToBasketButton);

        //15) Now it throws an error prompt like you must enter a value between 1 and 20
        String expectedErrorPrompt = "prompt like you must enter a value between 1 and 20";
        String actualErrorPrompt = "";
        try {
            actualErrorPrompt = Driver.getDriver().switchTo().alert().getText();
        }catch (NoAlertPresentException e){
            System.out.println("NoAlertPresentException");
        }
        softAssert.assertEquals(actualErrorPrompt,expectedErrorPrompt,"hata mesaji beklenenden farkli!!");
        softAssert.assertAll();
    }
}
