package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import in.automationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage {
    public ShopPage(){ PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(id = "menu-item-40") public WebElement shopButton;
    @FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/div") public WebElement filterPriceHedef;
    @FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[1]") public WebElement filterByPriceSOL;
    @FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]") public WebElement filterByPriceSAG;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/aside/div[2]/form/div/div[1]/span[2]") public WebElement filterByPriceSAG2;
    @FindBy(xpath = "//button[@type=\"submit\"]") public WebElement filterMAVI_button;
    @FindBy(xpath = "//span[@class=\"price\"]") public List<WebElement> priceList;
    @FindBy(xpath = "//span/ins/span") public WebElement priceIndirimliList;
    @FindBy(xpath = "//ul[@class='product-categories']//li") public List<WebElement> productCategories;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/product/android-quick-start-guide/\"]") public WebElement androidButton;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/wp-content/uploads/2017/01/Android-Quick-Start-Guide.png\"]") public WebElement androidUrun;
    @FindBy(xpath = "//select[@class=\"orderby\"]") public WebElement sortingSecenekleri;
    @FindBy(className = "woocommerce-LoopProduct-link") public List<WebElement> seleniumElementleri;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/product/selenium-ruby/\"]") public WebElement seleniumFirstElement;
    @FindBy(xpath = "//span[@tabindex='0'][2]")
    public WebElement leftSliderHandleIcon;
    @FindBy(css = "span.to") public WebElement priceRangeTo;
    @FindBy(css = "span.from") public WebElement priceRangeFrom;
    public void adjustPriceBySlider(int startPrice, int endPrice) {
        Actions move = new Actions(Driver.getDriver());
        move.click(leftSliderHandleIcon).build().perform();
        ReusableMethods.wait(2);
        int i = 0;
        while (i >= 0) {
            if (priceRangeTo.getText().contains(String.valueOf(endPrice)) && priceRangeFrom.getText().contains(String.valueOf(startPrice))) {
                break;
            } else {
                move.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            i++;
        }
    }

}
