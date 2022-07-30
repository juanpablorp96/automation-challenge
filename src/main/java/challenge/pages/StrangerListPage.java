package challenge.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class StrangerListPage extends BasePage{

    @FindBy(id = "inputImage")
    private WebElement inputImage;

    @FindBy(css = "textarea.form-control")
    private WebElement textField;

    @FindBy(css = "button.btn-success")
    private WebElement createItemButton;

    private final String fileName = "stranger-things-will-byers.jpg";
    private int itemsNumber;

    public StrangerListPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("http://immense-hollows-74271.herokuapp.com/");
    }

    public void selectImage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputImage));
        File file = new File(fileName);
        String absolutePath = file.getAbsolutePath();
        inputImage.sendKeys(absolutePath);
    }

    public void fillTextField(String itemText){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(itemText);
    }

    public void clickCreateItem(){
        itemsNumber = getWebDriver().findElements(By.cssSelector("p.story")).toArray().length;
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createItemButton));
        createItemButton.click();
    }

    public boolean isNewItemPresent(String itemText){
        int newItemIndex = itemsNumber + 1;
        try {
            getWebDriverWait().until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("p.story"), newItemIndex));
            getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format("(//p)[%s]", newItemIndex)), itemText));
            getWebDriverWait().until(ExpectedConditions.attributeContains(By.xpath(String.format("(//figure/img)[%s]", newItemIndex)), "src", fileName));
            return true;
        }catch(TimeoutException timeoutException){
            return false;
        }
    }
}
