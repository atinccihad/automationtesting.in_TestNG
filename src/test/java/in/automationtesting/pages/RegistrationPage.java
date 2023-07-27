package in.automationtesting.pages;

import in.automationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public RegistrationPage(){ PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(xpath = "//a[text()='My Account']") public WebElement myAccountButton;
    @FindBy(css = "#username") public WebElement emailBox;
    @FindBy(css = "#password") public WebElement passwordBox;
    @FindBy(xpath = "//input[@class='woocommerce-Button button']") public WebElement registerButton;
    @FindBy(xpath = "(//div/p)[1]") public WebElement helloUser;
    @FindBy(xpath = "//li[*='invalidMail']") public WebElement emailWarningMessage;
    @FindBy(xpath = "//ul[@class=\"woocommerce-error\"]") public WebElement usernameIsRequired;
}
