package challenge.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class StrangerListPage extends BasePage{

    @FindBy(id = "inputImage")
    private WebElement inputImage;
    @FindBy(css = "textarea.form-control")
    private WebElement textField;
    @FindBy(css = "button.btn-success")
    private WebElement createItemButton;
    @FindBy(xpath = "//button[text()='Edit']")
    private WebElement editButton;
    @FindBy(xpath = "//button[text()='Update Item']")
    private WebElement updateItemButton;
    @FindBy(css = "p.story")
    private WebElement itemText;
    @FindBy(css = "li.media")
    private List<WebElement> itemContainer;
    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//button[text()='Yes, delete it!']")
    private WebElement confirmDeleteButton;
    private int itemsNumber;

    public StrangerListPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("http://immense-hollows-74271.herokuapp.com/");
    }

    public void selectImage(String fileName){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputImage));
        File file = new File(fileName);
        String absolutePath = file.getAbsolutePath();
        inputImage.sendKeys(absolutePath);
    }

    public void fillTextField(String itemText){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(itemText);
    }

    public void clickCreateItem(){
        clickElement(createItemButton);
    }

    public boolean isNewItemPresent(String itemText, String fileName){
        int newItemIndex = itemsNumber + 1;
        try {
            getWebDriverWait().until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("li.media"), newItemIndex));
            getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format("(//p)[%s]", newItemIndex)), itemText));
            getWebDriverWait().until(ExpectedConditions.attributeContains(By.xpath(String.format("(//figure/img)[%s]", newItemIndex)), "src", fileName));
            return true;
        }catch(TimeoutException timeoutException){
            return false;
        }
    }

    public void clickEditButton(){
        clickElement(editButton);
    }

    public void clickUpdateItemButton(){
        clickElement(updateItemButton);
    }

    public String getItemText(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(itemText));
        return itemText.getText();
    }

    public void clickDeleteButton(String itemText) throws Exception {
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(itemContainer));
        for(WebElement item : itemContainer) {
            if (item.findElement(By.cssSelector("p.story")).getText().equals(itemText)) {
                List<WebElement> buttons = getWebDriver().findElements(By.xpath("//button[text()='Delete']"));
                buttons.get(itemContainer.indexOf(item)).click();
                break;
            } else if (itemContainer.indexOf(item) == itemContainer.size() - 1) {
                throw new Exception("Could not find the desired item");
            }
        }
    }

    public void clickConfirmDeleteButton(){
        clickElement(confirmDeleteButton);
    }

    public boolean isItemPresent(String itemText){
        for(WebElement item : itemContainer) {
            if (item.findElement(By.cssSelector("p.story")).getText().equals(itemText)) {
                return true;
            }
        }
        return false;
    }

    public void checkNumberOfItems(){
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(itemContainer));
        itemsNumber = itemContainer.size();
    }

    public void verifyOneLessItem(){
        getWebDriverWait().until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("li.media"), itemsNumber - 1));
    }

    public boolean isButtonEnabled(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(createItemButton));
        System.out.println(createItemButton.isEnabled());
        return createItemButton.isEnabled();
    }
}
