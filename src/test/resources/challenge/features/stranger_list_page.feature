@Run
Feature: Stranger List
  Validation of Stranger list home page

  Scenario Outline: Verify item creation
    Given I am in the Stranger List home page
    When I select the image "<item image>"
    And I fill the text field with "<item text>"
    And I click on the create item button
    Then I should see the item created with text "<item text>" and image "<item image>"
    Examples:
      | item text           | item image                     |
      | automation new item | stranger-things-will-byers.jpg |

  Scenario Outline: Verify edit item
    Given I am in the Stranger List home page
    When I click on edit button
    And I fill the text field with "<item text>"
    And I click on the update item button
    Then I should see the item updated with text "<item text>"
    Examples:
      | item text   |
      | Edited text |
