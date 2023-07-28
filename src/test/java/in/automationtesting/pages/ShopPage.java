package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    public ShopPage(){ PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(id = "menu-item-40") public WebElement shopButton;
    @FindBy(xpath = "//form/div/div/span[@style=\"left: 85.7143%;\"]") public WebElement filterPriceHedef;
    @FindBy(xpath = "//span[@style='left: 0%;']") public WebElement filterByPriceSOL;
    @FindBy(xpath = "//span[@style='left: 100%;']") public WebElement filterByPriceSAG;
    @FindBy(xpath = "//button[@type=\"submit\"]") public WebElement filterMAVI_button;
    @FindBy(xpath = "//span[@class=\"price\"]") public WebElement priceList;
    @FindBy(xpath = "//span/ins/span") public WebElement priceIndirimliList;
    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[1]") public WebElement t1;
    @FindBy(xpath = "(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[2]") public WebElement t2;

}
