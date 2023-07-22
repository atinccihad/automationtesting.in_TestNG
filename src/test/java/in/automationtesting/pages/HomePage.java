package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//li[@id='menu-item-40']") public WebElement shopMenuButton;
    @FindBy(xpath = "//a[@class='woocommerce-LoopProduct-link']") public List<WebElement> sliders;
    @FindBy(xpath = "(//a[@href=\"https://practice.automationtesting.in\"])[2]") public WebElement homeMenuButton;
    @FindBy(xpath = "(//img[@loading=\"lazy\"])") public List<WebElement> arrivals;
    @FindBy(xpath = "(//img[@loading=\"lazy\"])[1]") public WebElement firstArrival;
    @FindBy(className = "woocommerce-message") public WebElement hasBeenAddedToYourBasket;
    @FindBy(xpath = "//a[@class='woocommerce-main-image zoom']") public WebElement firstArrivalImage;
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']") public WebElement addToBasketButton;
    @FindBy(xpath = "//div[@id='tab-description']") public WebElement description;
    @FindBy(xpath = "//li[@class='reviews_tab']")  public WebElement reviews;
    @FindBy(xpath = "//h2[@class='woocommerce-Reviews-title']") public WebElement reviewsToReview;
    @FindBy(xpath = "//a[@class=\"button wc-forward\"]")  public WebElement viewBasketButton;
    @FindBy(xpath = "//div[@class=\"cart_totals \"]")  public WebElement basketTotals;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']") public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//input[@class='input-text qty text']") public WebElement quantityBox;
    @FindBy(xpath = "//input[@class=\"input-text qty text\"]") public WebElement addToBasketYanindakiBox;
    @FindBy(xpath = "//div[@class=\"images\"]") public WebElement bookImage;
    @FindBy(xpath = "//span[@class=\"woocommerce-Price-amount amount\"]") public WebElement price;
    @FindBy(xpath = "//a[@class='wpmenucart-contents']") public WebElement itemsAndPriceLinkButton;
    @FindBy(css = "#coupon_code") public WebElement couponCodeBox;
    public String couponCode = "krishnasakinala";
    public String ilkIndirimli = "";
    public String ikinciIndirimli = "";
    public String basketTotalsTotal = "";
    @FindBy(xpath = "(//td[@data-title=\"Total\"])[2]") public WebElement indirimliTotal;

}
