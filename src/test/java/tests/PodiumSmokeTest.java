package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Helper;
import java.util.ArrayList;


public class PodiumSmokeTest {

    WebDriver driver;
    HomePage homePage;
    DemoPage demoPage;
    DemoVideoPage demoVideoPage;
    CreateAccountPage createAccountPage;
    LoginPage loginPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        driver.navigate().to("https://www.podium.com/v8/");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void verifyAllTabsPresent() throws InterruptedException {
        homePage = new HomePage();
        Helper.waitForElementToBeDisplayed(homePage.productsTab);
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.productsTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.solutionsTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.enterpriseTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.resourcesTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.pricingTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.loginTab));
        Assert.assertTrue("Element not present", Helper.isDisplayedCustom(homePage.watchDemoTab));

    }

    @Test
    public void validateLoginErrorTest() throws InterruptedException {
        homePage = new HomePage();
        homePage.loginTab.click();
        loginPage = new LoginPage();
        Helper.waitForElementToBeDisplayed(loginPage.emailOrPhoneInputField);
        loginPage.emailOrPhoneInputField.sendKeys(ConfigReader.getProperty("userEmail"));
        loginPage.emailOrPhoneInputField.sendKeys(Keys.ENTER);
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("password"));
        loginPage.passwordField.sendKeys(Keys.ENTER);
        Helper.waitForElementToBeDisplayed(loginPage.errorMessage);
        Helper.longHighlightElement(loginPage.errorMessage);
        Assert.assertEquals("Incorrect email or password. Please try again."
                ,loginPage.errorMessage.getText());
    }

    @Test
    public void createAccountTest() throws InterruptedException {
        homePage = new HomePage();
        driver.switchTo().frame(homePage.iFrameHomePage);
        homePage.getStartedButton.click();
        createAccountPage = new CreateAccountPage();

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.firstnameField));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.lastnameField));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.emailField));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.mobileField));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.companySearchField));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(createAccountPage.passwordField));
    }

    @Test
    public void widgetButtonTest () throws InterruptedException {
        homePage = new HomePage();
        Helper.waitForElementToBeDisplayed(homePage.iFramePrompt);
        driver.switchTo().frame(homePage.iFramePrompt);
        Assert.assertEquals("Hi there, have a question? Text us here.",homePage.widgetMessage.getText());
        Helper.longHighlightElement(homePage.widgetMessage);
        homePage.widgetMessage.click();
        driver.switchTo().frame(homePage.iFrameWidget);
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(homePage.widgetInputName));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(homePage.widgetInputMobile));
        Assert.assertTrue("Element not present",Helper.isDisplayedCustom(homePage.widgetInputMessage));
    }

    @Test
    public void watchDemoTest() throws InterruptedException {
        homePage = new HomePage();
        demoPage = new DemoPage();
        demoVideoPage = new DemoVideoPage();
        homePage.watchDemoTab.click();
        Helper.waitForElementToBeDisplayed(demoPage.userEmailField);
        demoPage.fillOutForm();
        Helper.waitForElementToBeDisplayed(demoVideoPage.thankYouMessage);
        Helper.longHighlightElement(demoVideoPage.thankYouMessage);
        Assert.assertEquals("Thanks for watching! We'll be in touch.",
                demoVideoPage.thankYouMessage.getText());
    }
}
