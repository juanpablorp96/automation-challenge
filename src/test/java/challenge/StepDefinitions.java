package challenge;

import challenge.pages.StrangerListPage;
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

    @When("I select an image")
    public void iSelectAnImage() {
        strangerListPage.selectImage();
    }

    @When("I fill the text field with {string}")
    public void iFillTheTextFieldWith(String itemText) {
        strangerListPage.fillTextField(itemText);
    }

    @When("I click on the create item button")
    public void iClickOnTheCreateItemButton() {
        strangerListPage.clickCreateItem();
    }

    @Then("I should see the item created with text {string}")
    public void iShouldSeeTheItemCreatedWithText(String itemText) {
        Assert.assertTrue("Item does not exist", strangerListPage.isNewItemPresent(itemText));
    }

}
