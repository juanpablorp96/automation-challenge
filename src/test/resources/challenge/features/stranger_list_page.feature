@Run
Feature: Stranger List
  Validation of Stranger list home page

  Scenario Outline: Verify item creation
    Given I am in the Stranger List home page
    And I check the number of items
    When I select the image "<item image>"
    And I fill the text field with "<item text>"
    And I click on the create item button
    Then I should see one more item
    And I should see the item with text "<item text>"
    And I should see the item with image "<item image>"
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

  Scenario Outline: Verify item exist
    Given I am in the Stranger List home page
    Then I should see the item with text "<item text>"
    Examples:
      | item text                                                                                                                                                                                                                                                                                                     |
      | Creators: Matt Duffer, Ross Duffer |

  # Bug 1
  Scenario Outline: Verify image can be edited
    Given I am in the Stranger List home page
    When I click on edit button
    And I select the image "<item image>"
    And I click on the update item button
    Then I should see the item with image "<item image>"
    Examples:
      | item image          |
      | stranger-things.jpg |

  # Bug 2
  Scenario Outline: Verify image input is clear after item creation
    Given I am in the Stranger List home page
    And I check the number of items
    And I select the image "<item image>"
    And I fill the text field with "<item text>"
    And I click on the create item button
    And I should see one more item
    When I fill the text field with "<item text>"
    And I click on the create item button
    Then I should see an alert with the message "<alert message>"
    Examples:
      | item text           | item image                     | alert message               |
      | automation new item | stranger-things-will-byers.jpg | You must to select an image |

  # Bug 3
  Scenario Outline: Verify edit/delete button are visible with long description
    Given I am in the Stranger List home page
    And I check the number of items
    When I select the image "<item image>"
    And I fill the text field with "<item text>"
    And I click on the create item button
    And I should see one more item
    And I should see the item with text "<item text>"
    Then I should see the Edit button in the item "<item text>"
    And I should see the Delete button in the item "<item text>"
    Examples:
      | item image                     | item text                                                                                                                                                                                                                                                                                                     |
                                         # 300 char long
      | stranger-things-will-byers.jpg | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
