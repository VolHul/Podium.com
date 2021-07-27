package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "emailOrPhoneInput")
    public WebElement emailOrPhoneInputField;

    @FindBy(id = "passwordInput")
    public WebElement passwordField;

    @FindBy(xpath = "//div[contains(text(),'Incorrect email')]")
    public WebElement errorMessage;
}
