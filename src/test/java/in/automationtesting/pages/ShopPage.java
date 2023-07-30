package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
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



}
