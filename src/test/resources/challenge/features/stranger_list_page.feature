@Run
Feature: Stranger List
  Validation of Stranger list home page

  Scenario Outline: Verify item creation
    Given I am in the Stranger List home page
    And I check the number of items
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

  Scenario Outline: Verify delete item
    Given I am in the Stranger List home page
    And I check the number of items
    When I click on the delete button of item "<item text>"
    And I click on the yes, delete it! button
    Then I should see one less item
    And I should not see the item with text "<item text>"
    Examples:
      | item text           |
      | automation new item |

  Scenario Outline: Verify max long in description (valid input)
    Given I am in the Stranger List home page
    When I fill the text field with "<item text>"
    Then I should see the create item button enabled
    Examples:
      | item text                                                                                                                                                                                                                                                                                                    |
      # 300 char long
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |

  Scenario Outline: Verify max long in description (invalid input)
    Given I am in the Stranger List home page
    When I fill the text field with "<item text>"
    Then I should see the create item button disabled
    Examples:
      | item text                                                                                                                                                                                                                                                                                                     |
      # 301 char long
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
