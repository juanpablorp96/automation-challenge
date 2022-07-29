package challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        this.webDriver.manage().window().maximize();
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }
}
