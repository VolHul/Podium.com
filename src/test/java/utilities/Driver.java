package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver == null){
            switch(ConfigReader.getProperty("browser").toLowerCase()){
                default:
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--window-size=1920,1080");

                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try{
            if(driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
