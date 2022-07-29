package challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StrangerListPage extends BasePage{

    @FindBy(id = "inputImage")
    private WebElement inputImage;

    @FindBy(css = "textarea.form-control")
    private WebElement textField;

    @FindBy(css = "button.btn-success")
    private WebElement createItemButton;

    public StrangerListPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("http://immense-hollows-74271.herokuapp.com/");
    }
}
