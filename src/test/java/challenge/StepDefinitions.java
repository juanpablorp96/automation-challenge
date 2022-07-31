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

    @When("I click on edit button")
    public void iClickOnEditButton() {
        strangerListPage.clickEditButton();
    }

    @Then("I should see the item updated with text {string}")
    public void iShouldSeeTheItemUpdatedWithText(String expectedItemText) {
        Assert.assertEquals(strangerListPage.getItemText(), expectedItemText);
    }

    @When("I click on the delete button of item {string}")
    public void iClickOnDeleteButton(String itemText) throws Exception {
        strangerListPage.clickDeleteButton(itemText);
    }

    @When("I click on the yes, delete it! button")
    public void iClickOnTheYesDeleteItButton() {
        strangerListPage.clickConfirmDeleteButton();
    }

    @Then("^I (should|should not) see the item with text \"([^\"]*)\"$")
    public void iShouldNotSeeTheItemWithText(String present, String itemText){
        if(present.equals("should")){
            Assert.assertTrue(strangerListPage.isItemPresent(itemText));
        }else {
            Assert.assertFalse(strangerListPage.isItemPresent(itemText));
        }
    }

    @Given("I check the number of items")
    public void iCheckTheNumberOfItems() {
        strangerListPage.checkNumberOfItems();
    }

    @Then("^I should see one (more|less) item$")
    public void iShouldSeeOneLessItem(String listState) {
        if(listState.equals("more")){
            strangerListPage.verifyOneMoreItem();
        }else {
            strangerListPage.verifyOneLessItem();
        }
    }

    @Then("^I should see the create item button (enabled|disabled)$")
    public void iShouldSeeTheCreateItemButtonEnabled(String buttonState) {
        if(buttonState.equals("enabled")){
            Assert.assertTrue(strangerListPage.isButtonEnabled());
        }else {
            Assert.assertFalse(strangerListPage.isButtonEnabled());
        }
    }

    @Then("I should see the item with image {string}")
    public void iShouldSeeTheItemWithImage(String fileName) {
        Assert.assertTrue(strangerListPage.isImagePresent(fileName));
    }

}
