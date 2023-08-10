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
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[2]/a[2]") public WebElement ikinciElementAddToBasketButton;
    @FindBy(xpath = "//a[@class=\"wpmenucart-contents\"]") public WebElement sepetIconVeSepetTutari;
    @FindBy(xpath = "(//a/span)[2]") public WebElement itemMiktariSagUst;
    @FindBy(xpath = "(//a/span)[3]") public WebElement itemTutariSagUst;
    @FindBy(xpath = "(//tr/td)[2]") public WebElement urunIcon;
    @FindBy(xpath = "(//tr/td)[3]") public WebElement urunIsim;
    @FindBy(xpath = "(//tr/td)[4]") public WebElement urunPrice;
    @FindBy(xpath = "(//tr/td)[5]") public WebElement urunQuantity;
    @FindBy(xpath = "(//tr/td)[6]") public WebElement urunTotal;
    @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span") public WebElement subtotalMiktari;
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[4]") public WebElement taxMiktari;
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[5]") public WebElement totalMiktari;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/checkout/\"]") public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "(//ul[@class=\"wc_payment_methods payment_methods methods\"] /li)[1]") public WebElement directBankTransfer;
    @FindBy(xpath = "(//ul[@class=\"wc_payment_methods payment_methods methods\"] /li)[2]") public WebElement checkPayments;
    @FindBy(xpath = "(//ul[@class=\"wc_payment_methods payment_methods methods\"] /li)[3]") public WebElement cashOnDelivery;
    @FindBy(xpath = "(//ul[@class=\"wc_payment_methods payment_methods methods\"] /li)[4]") public WebElement paypalExpressCheckout;
    @FindBy(xpath = "//input[@id='place_order']") public WebElement checkoutPagePlaceholderButton;
    @FindBy(xpath = "//span[@id='select2-chosen-2']") public WebElement statecountryKapali;
    @FindBy(xpath = "//input[@id=\"billing_postcode\"]") public WebElement postcodeZIP;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/p[1]") public WebElement thanksMessage;
    @FindBy(xpath = "//span[@style='left: 100%;']") public WebElement adjustRightBtn;
    @FindBy(xpath = "//span[@style='left: 85.7143%;']") public WebElement adjustLeft450;
    @FindBy(xpath = "//button[.='Filter']") public WebElement filterBtn;
    @FindBy(xpath = "//ul[@class='product-categories']/li") public List<WebElement> productList;
    @FindBy(xpath = "//a[.='Android']") public WebElement androidBtn;
    @FindBy(xpath = "//nav[@class='woocommerce-breadcrumb']/a") public WebElement productPage;
    @FindBy(tagName = "h3") public List<WebElement> productTitle;
    @FindBy(xpath = "//select[@name='orderby']") public WebElement sortDropdown;
    @FindBy(xpath = "//a[@data-product_id='160']") public WebElement shopPageAddToBasketBtn;
    @FindBy(xpath = "//*[.='View Basket']") public WebElement viewBasketBtn;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']") public WebElement checkoutBtn;
    @FindBy(id = "s2id_billing_country") public WebElement billingCountryDropdown;
    @FindBy(id = "s2id_autogen1_search") public WebElement billingCountryInputBox;
    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-in-tax-1']/td") public WebElement taxForIndia;
    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-roaming-tax-1']/td") public WebElement taxForOtherCountries;
    @FindBy(xpath = "//td[@class='product-total']/span") public WebElement totalAtLastPage;

}
