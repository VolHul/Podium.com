package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class DemoPage {

    public DemoPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="user-email")
    public WebElement userEmailField;

    @FindBy(id="first-name")
    public WebElement userFirstName;

    @FindBy(id="last-name")
    public WebElement userLastName;

    @FindBy(id="company-name")
    public WebElement userCompanyName;

    @FindBy(id="mobile")
    public WebElement userMobile;

    @FindBy(xpath = "//button[@class='cta-primary']")
    public WebElement watchDemoButton;


    public void fillOutForm(){
        userEmailField.sendKeys(ConfigReader.getProperty("userEmail"));
        userEmailField.sendKeys(Keys.ENTER);
        userFirstName.sendKeys(ConfigReader.getProperty("userName"));
        userLastName.sendKeys(ConfigReader.getProperty("userLastName"));
        userCompanyName.sendKeys(ConfigReader.getProperty("userCompanyName"));
        userMobile.sendKeys(ConfigReader.getProperty("userPhone"));
        watchDemoButton.click();
    }
}
