package challenge;

import challenge.pages.StrangerListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class StepDefinitions {

    private StrangerListPage strangerListPage;

    @Given("I am in the Stranger List home page")
    public void iAmInTheStrangerListHomePage() {
        strangerListPage = new StrangerListPage(BaseTest.getDriver().getWebDriver());
    }

    @When("I select the image {string}")
    public void iSelectAnImage(String fileName) {
        strangerListPage.selectImage(fileName);
    }

    @When("I fill the text field with {string}")
    public void iFillTheTextFieldWith(String itemText) {
        strangerListPage.fillTextField(itemText);
    }


    @When("^I click on the (create|update) item button$")
    public void iClickOnTheCreateUpdateItemButton(String buttonType) {
        if(buttonType.equals("create")){
            strangerListPage.clickCreateItem();
        }else {
            strangerListPage.clickUpdateItemButton();
        }
    }

    @Then("I should see the item created with text {string} and image {string}")
    public void iShouldSeeTheItemCreatedWithTextAndImage(String itemText, String itemImage) {
        Assert.assertTrue("Item does not exist", strangerListPage.isNewItemPresent(itemText, itemImage));
    }

    @When("I click on edit button")
    public void iClickOnEditButton() {
        strangerListPage.clickEditButton();
    }

    @Then("I should see the item updated with text {string}")
    public void iShouldSeeTheItemUpdatedWithText(String expectedItemText) {
        Assert.assertEquals(strangerListPage.getItemText(), expectedItemText);
    }

}
