package challenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private WebDriver webDriver;

    public Driver(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "chromeMobile":
                WebDriverManager.chromedriver().setup();
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPhone 12 Pro");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
                webDriver = new ChromeDriver(options);
                break;
        }
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

}
