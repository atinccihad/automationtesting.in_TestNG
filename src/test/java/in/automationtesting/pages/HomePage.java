package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/shop/\"]") public WebElement shopMenuButton;
    @FindBy(xpath = "//a[@class='woocommerce-LoopProduct-link']") public List<WebElement> sliders;
    @FindBy(xpath = "//div/nav/a") public WebElement homeMenuButton;
    @FindBy(xpath = "(//img[@loading=\"lazy\"])") public List<WebElement> arrivals;
    @FindBy(xpath = "(//img[@loading=\"lazy\"])[1]") public WebElement firstArrival;
    @FindBy(className = "woocommerce-message") public WebElement hasBeenAddedToYourBasket;
    @FindBy(xpath = "//a[@class='woocommerce-main-image zoom']") public WebElement firstArrivalImage;
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']") public WebElement addToBasketButton;
    @FindBy(xpath = "(//a[text()='Add to basket'])[2]") public WebElement ikinciAddToBasketButton;
    @FindBy(xpath = "//a[@class=\"added_to_cart wc-forward\"]") public WebElement viewBasket;
    @FindBy(xpath = "//div[@id='tab-description']") public WebElement description;
    @FindBy(xpath = "//li[@class='reviews_tab']")  public WebElement reviews;
    @FindBy(xpath = "//h2[@class='woocommerce-Reviews-title']") public WebElement reviewsToReview;
    @FindBy(xpath = "//a[@class=\"button wc-forward\"]")  public WebElement viewBasketButton;
    @FindBy(xpath = "//div[@class=\"cart_totals \"]")  public WebElement basketTotals;
    @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div[2]/div/div/a") public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//input[@class='input-text qty text']") public WebElement quantityBox;
    @FindBy(xpath = "//div[@class=\"images\"]") public WebElement bookImage;
    @FindBy(xpath = "//span[@class=\"woocommerce-Price-amount amount\"]") public WebElement price;
    @FindBy(xpath = "//a[@class='wpmenucart-contents']") public WebElement itemsAndPriceLinkButton;
    @FindBy(css = "#coupon_code") public WebElement couponCodeBox;
    public String couponCode = "krishnasakinala";
    public String ilkIndirimli = "";
    public String ikinciIndirimli = "";
    public String basketTotalsTotal = "";
    @FindBy(xpath = "(//td[@data-title=\"Total\"])[2]") public WebElement indirimliTotal;
    @FindBy(id = "menu-item-50") public WebElement myAccountButton;
    @FindBy(css = "#username") public WebElement emailBox;
    @FindBy(css = "#password") public WebElement passwordBox;
    @FindBy(xpath = "//input[@class='woocommerce-Button button']") public WebElement loginButton;
    @FindBy(xpath = "//a[@title='Remove this item']") public List<WebElement> itemRemoveIconList;
    @FindBy(xpath = "//div[@class='woocommerce-message']") public WebElement bookRemovedText;
    @FindBy(xpath = "//li[@class='wpmenucartli wpmenucart-display-standard menu-item']") public WebElement sepetItemFiyatSagUst;
    @FindBy(xpath = "//td[@class='product-quantity']") public WebElement auantityBox;
    @FindBy(xpath = "(//input[@type=\"submit\"])[2]") public WebElement updateBasketButton;
    @FindBy(xpath = "//strong[@class=\"product-quantity\"]") public WebElement yourOrderUrunMiktarElementi;
    @FindBy(xpath = "(//span[@class=\"woocommerce-Price-amount amount\"])[4]") public WebElement total;
    @FindBy(xpath = "(//span[@class=\"woocommerce-Price-amount amount\"])[2]") public WebElement subtotal;
    @FindBy(xpath = "(//span[@class=\"woocommerce-Price-amount amount\"])[3]") public WebElement tax;
    public String checkoutUrl = "https://practice.automationtesting.in/checkout/";
    @FindBy(css = "#billing_first_name") public WebElement billingdetailsFirstname;
    @FindBy(css = "#billing_last_name") public WebElement billingdetailsLastname;
    @FindBy(css = "#billing_company") public WebElement billingdetailsCompanyname;
    @FindBy(css = "#billing_email") public WebElement billingdetailsEmailaddress;
    @FindBy(css = "#billing_phone") public WebElement billingdetailsPhone;
    @FindBy(id = "s2id_billing_state") public WebElement billingdetailsCountry;
    @FindBy(xpath = "//input[@id='billing_address_1']") public WebElement billingdetailsAddress;
    @FindBy(xpath = "//input[@id='billing_address_2']") public WebElement billingdetailsAddress2;
    @FindBy(xpath = "//input[@id='billing_city']") public WebElement billingdetailsTownCity;
    @FindBy(id = "select2-drop-mask") public WebElement billingdetailsStateCountry;
    @FindBy(xpath = "//input[@id='billing_postcode']") public WebElement billingdetailsPostcodeZIP;
    @FindBy(xpath = "//div[@id=\"payment\"]") public WebElement billingdetailsBanktransferPayments;
    @FindBy(xpath = "//div[@class=\"woocommerce-info\"]") public WebElement billingdetailsHaveACouponElement;
    @FindBy(css = "#place_order") public WebElement billingdetailsPlaceOrderButton;
    @FindBy(xpath = "//table[@class='shop_table order_details']") public WebElement billingdetailsOrderDetails;
    @FindBy(xpath = "//table[@class='shop_table customer_details']") public WebElement billingdetailsCustomerDetails;
    @FindBy(xpath = "//div/address") public WebElement billingdetailsBillingAdress;
    @FindBy(className = "woocommerce-MyAccount-content") public WebElement welcomeText;
    @FindBy(className = "woocommerce-error") public WebElement wrongText;
    @FindBy(xpath = "(//a[@href=\"https://practice.automationtesting.in/my-account/customer-logout/\"])[2]") public WebElement signout;
}
