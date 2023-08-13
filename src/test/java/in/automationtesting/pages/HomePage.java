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
    @FindBy(linkText = "Shop") public WebElement shopButton;
    @FindBy(xpath = "//img[@loading='lazy']") public List<WebElement> threeArrivals;
    @FindBy(xpath = "//a[.='Home']") public WebElement homePageButton;
    @FindBy(xpath = "//img[@alt='Arrow']") public List<WebElement> threeSliders;
    @FindBy(xpath = "//div[@style='width: 1160px; height: 652px;']") public WebElement threeslide;
    @FindBy(xpath = "//img[@title='Selenium Ruby']") public WebElement firstArrivals;
    @FindBy(xpath = "//img[@title='Mastering JavaScript']") public WebElement thirdArrivals;
    @FindBy(xpath = "//a[.='Description']") public WebElement descriptionTab;
    @FindBy(xpath = "//h2[.='Product Description']") public WebElement descriptionText;
    @FindBy(xpath = "//a[.='Reviews (0)']") public WebElement reviewsTab;
    @FindBy(xpath = "//h2[.='Reviews']") public WebElement reviewsText;
    @FindBy(xpath = "//button[.='Add to basket']") public WebElement addToBasketBtn;
    @FindBy(xpath = "//span[.='1 item']") public WebElement itemText;
    @FindBy(xpath = "//span[@class='amount']") public WebElement priceText;
    @FindBy(xpath = "(//a[@href='https://practice.automationtesting.in/basket/'])[1]") public WebElement checkoutPageButton;
    @FindBy(id = "coupon_code") public WebElement couponCodeInputBox;
    @FindBy(name = "apply_coupon") public WebElement applyCouponButton;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li") public WebElement errorMessage;
    @FindBy(xpath = "//a[@title='Remove this item']") public WebElement removeThisButton;
    @FindBy(xpath = "//input[@inputmode='numeric']") public WebElement quantityInputBox;
    @FindBy(xpath = "//div[.='Basket updated.']") public WebElement basketUpdatedText;
    @FindBy(xpath = "//td[@data-title='Subtotal']") public WebElement subtotalValue;
    @FindBy(xpath = "(//td[@data-title='Total'])[2]/strong/span") public WebElement finalTotalPrice;
    @FindBy(css = "a[class='checkout-button button alt wc-forward']") public WebElement proceedToCheckout;
    @FindBy(css = "div[class='woocommerce-billing-fields']") public WebElement billingDetails;
    @FindBy(css = "div[class='woocommerce-shipping-fields']") public WebElement additionalInformation;
    @FindBy(css = "table[class='shop_table woocommerce-checkout-review-order-table']") public WebElement orderDetails;
    @FindBy(css = "div[class='woocommerce-checkout-payment']") public WebElement paymentGateway;
    @FindBy(css = "input[id='billing_first_name']") public WebElement inputFirstName;
    @FindBy(css = "input[id='billing_last_name']") public WebElement inputLastName;
    @FindBy(css = "input[id='billing_email']") public WebElement inputEmailAddress;
    @FindBy(css = "input[id='billing_phone']") public WebElement inputPhoneNumber;
    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]") public WebElement inputCountry;
    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]") public WebElement inputProvince;
    @FindBy(xpath = "//td[@data-title='Coupon: krishnasakinala']/span") public WebElement freeCouponAmount;
    @FindBy(xpath = "//a[.='×']") public WebElement removeButton;
    @FindBy(xpath = "//a[@class='button wc-backward']") public WebElement returnToShopButton;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li") public WebElement couponErrorMessage;
    @FindBy(css = "a[class='pp_close']") public WebElement closeButton;
    @FindBy(xpath = "(//td[@data-title='Total'])[1]/span") public WebElement totalPriceOfSelectedBook;
    @FindBy(xpath = "//input[@id='s2id_autogen1_search']") public WebElement searchCountryBox;
    @FindBy(xpath = "//input[@id='s2id_autogen2_search']") public WebElement searchProvinceBox;
    @FindBy(xpath = "//*[@id='billing_country']") public WebElement dropdownCountry;
    @FindBy(css = "input[id='billing_address_1']") public WebElement inputAddress;
    @FindBy(css = "input[id='billing_postcode']") public WebElement inputPostCode;
    @FindBy(css = "input[id='billing_city']") public WebElement inputTown;
    @FindBy(xpath = "//select[@id='billing_state']") public WebElement dropdownProvince;
    @FindBy(css = "input[id='payment_method_bacs']") public WebElement directBankRadioBtn;
    @FindBy(css = "input[id='payment_method_cod']") public WebElement cashOnDeliveryRadioBtn;
    @FindBy(css = "input[id='payment_method_cheque']") public WebElement checkRadioBtn;
    @FindBy(css = "input[id='payment_method_ppec_paypal']") public WebElement payPalRadioBtn;
    @FindBy(id = "place_order") public WebElement placeOrderButton;
    @FindBy(className = "showcoupon") public WebElement addACouponLink;
    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div") public List<WebElement> threeArrivalOnly;
    @FindBy(id = "billing_state") public WebElement dropdown;
    @FindBy(xpath = "//li[@role='presentation']") public WebElement provinceOptions;
    @FindBy(xpath = "//a[.='My Account']") public WebElement myAccountBtn;
    @FindBy(xpath = "//a[.='Shop']") public WebElement shopBtn;
    @FindBy(id = "reg_email") public WebElement registerEmailBox;
    @FindBy(id = "reg_password") public WebElement registerPassBox;
    @FindBy(id = "username") public WebElement emailInputBox;
    @FindBy(id = "password") public WebElement passInputBox;
    @FindBy(xpath = "//input[@value='Login']") public WebElement loginBtn;
    @FindBy(xpath = "//a[.='Dashboard']") public WebElement dashboardBtn;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li") public WebElement loginErrorMessage;
    @FindBy(xpath = "//label[@for='password']/span") public WebElement astrixInPasswordField;
    @FindBy(xpath = "//a[.='Sign out']") public WebElement signOutBtn;
    @FindBy(xpath = "//h2[.='Login']") public WebElement loginPage;
    @FindBy(xpath = "//a[.='Home']") public WebElement homeButton;
    @FindBy(xpath = "//div[@data-slide-duration='0']") public List<WebElement> threeSlidersOnly;
    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//img") public WebElement image1;
    @FindBy(xpath = "//div[@class='woocommerce-message']") public WebElement messageText;
    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//h3") public WebElement itemInImage1;
    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[3]//h3") public WebElement itemInImage3;
    @FindBy(xpath = "//img[@title='Mastering JavaScript']") public WebElement image3LessThan450;
    @FindBy(css = "li[class='description_tab active']") public WebElement descriptionButton;
    @FindBy(xpath = "//span[@class='posted_in']/a") public WebElement categoryOfBook;
    @FindBy(xpath = "//li[@class='reviews_tab']") public  WebElement reviewsButton;
    @FindBy(xpath = "//div[@id='comments']//p") public WebElement reviewText;
    @FindBy(xpath = "//a[.='Selenium Ruby']") public WebElement productNameImage1;
    @FindBy(xpath = "//td[@data-title='Product']/a") public WebElement productName;
    @FindBy(xpath = "//td[@class='product-price']/span") public WebElement productPrice;
    @FindBy(css = "input[title='Qty']") public WebElement quantityOfBook;
    @FindBy(className = "cartcontents") public WebElement itemLink;
    @FindBy(id = "coupon_code") public WebElement inputCouponCode;
    @FindBy(xpath = "//span[.='Sale!']") public WebElement saleBtn;
    @FindBy(xpath = "//p[@class='price']/del/span") public WebElement oldPrice;
    @FindBy(xpath = "//p[@class='price']//ins/span") public WebElement actualPrice;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/my-account/orders/\"]") public WebElement ordersButton;
    @FindBy(xpath = "//tbody/tr") public List<WebElement> ordersList;
    @FindBy(xpath = "//tbody/tr/td[@class=\"order-actions\"]") public List<WebElement> viewsList;
    @FindBy(xpath = "(//td[@class=\"order-actions\"])[1]") public WebElement firstViewButton;
    @FindBy(xpath = "//table[@class=\"shop_table order_details\"]") public WebElement orderDetailsAllPage;
    @FindBy(xpath = "//table[@class=\"shop_table customer_details\"]") public WebElement customerDetailsAllPage;
    @FindBy(xpath = "//div/address") public WebElement billingAddressDetailsAllPage;
    @FindBy(className = "order-number") public WebElement siparisNumarasi;
    @FindBy(className = "order-date") public WebElement siparisTarihi;
    @FindBy(className = "order-status") public WebElement siparisDurumu;
    @FindBy(xpath = "(//a[@href=\"https://practice.automationtesting.in/my-account/edit-address/\"])[1]") public WebElement addresses;
    @FindBy(xpath = "//div[@class='u-column1 col-1 woocommerce-Address']") public WebElement billingAddress;
    @FindBy(xpath = "//div[@class='u-column2 col-2 woocommerce-Address']") public WebElement shippingAddress;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/my-account/edit-address/shipping\"]") public WebElement shippingAddressEdit;
    @FindBy(xpath = "//a[@href=\"https://practice.automationtesting.in/my-account/edit-address/shipping\"]") public WebElement billingAddressEdit;
    @FindBy(xpath = "//input[@id=\"shipping_address_1\"]") public WebElement streetAddressBox;
    @FindBy(xpath = "(//input[@type=\"submit\"])[1]") public WebElement saveAddressButton;
    @FindBy(xpath = "(//a[@href=\"https://practice.automationtesting.in/my-account/edit-account/\"])[1]") public WebElement accountDetails;
    @FindBy(xpath = "//input[@id='account_email']") public WebElement emailAdressBox;
    @FindBy(xpath = "//input[@id='password_current']") public WebElement password_current;
    @FindBy(xpath = "//input[@id='password_current']") public WebElement passwordChangeText;
    @FindBy(xpath = "(//a[@href=\"https://practice.automationtesting.in/my-account/customer-logout/\"])[1]") public WebElement logoutButton;
}
