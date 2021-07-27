package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateAccountPage {
    public CreateAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "first-name")
    public WebElement firstnameField;

    @FindBy(id = "last-name")
    public WebElement lastnameField;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id='mobile']")
    public WebElement mobileField;

    @FindBy(id = "company-search")
    public WebElement companySearchField;

    @FindBy(id = "Password")
    public WebElement passwordField;

}
