package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Products']")
    public WebElement productsTab;

    @FindBy(xpath = "//span[.='Solutions']")
    public WebElement solutionsTab;

    @FindBy(linkText = "Enterprise")
    public WebElement enterpriseTab;

    @FindBy(xpath = "//span[.='Resources']")
    public WebElement resourcesTab;

    @FindBy(linkText = "Pricing")
    public WebElement pricingTab;

    @FindBy(linkText = "Login")
    public WebElement loginTab;

    @FindBy(xpath="//a[@class='blue-box']")
    public WebElement watchDemoTab;

    @FindBy(xpath = "//maker-button[@href='https://www.podium.com/get-started-v2/']")
    public WebElement getStartedButton;

    @FindBy(xpath = "//iframe[@title='Content']")
    public WebElement iFrameHomePage;

    @FindBy(xpath = "//div[@class='Prompt__PromptText']")
    public WebElement widgetMessage;

    @FindBy(id = "podium-prompt")
    public WebElement iFramePrompt;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement widgetInputName;

    @FindBy(xpath = "//input[@id='Mobile Phone']")
    public WebElement widgetInputMobile;

    @FindBy(xpath = "//textarea[@id='Message']")
    public WebElement widgetInputMessage;

    @FindBy(id = "podium-modal")
    public WebElement iFrameWidget;


}
