package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public static void highlightElement(WebElement element) throws InterruptedException{
        String style = "border: 4px dashed red";
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, style);
        Thread.sleep(200);
    }

    public static void waitForElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isDisplayedWithHighlight(WebElement element) throws InterruptedException {
        waitForElementToBeDisplayed(element);
        boolean isDisp = element.isDisplayed();
        highlightElement(element);
        return isDisp;
    }

    public static void switchToIframe(WebElement element, WebDriver driver){
        waitForElementToBeDisplayed(element);
        driver.switchTo().frame(element);
    }

    public static void highlightElement(WebElement element,int timeOut) throws InterruptedException {
        String style = "border: 4px dashed red";
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, style);
        Thread.sleep(timeOut);
    }
}
