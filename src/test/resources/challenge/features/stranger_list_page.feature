@Run
Feature: Stranger List
  Validation of Stranger list home page

  Scenario Outline: Verify item creation
    Given I am in the Stranger List home page
    When I select an image
    And I fill the text field with "<item text>"
    And I click on the create item button
    Then I should see the item created with text "<item text>"
    Examples:
      | item text           |
      | automation new item |
