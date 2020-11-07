Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search page.

  Background: User should be on google search page
    Given User is on the google search page

  Scenario: Google default title verification
    Then  User should see title is Google


  Scenario: Google title verification after search
    When  User searches apple
    Then  User should see apple in the title

    # shortcut for mac:  option + enter allows u to generate step definitions

  Scenario: Google title verification after search
    When  User searches "bob marley"
    Then  User should see "bob marley" in the title

  @wip #wip means work in progress
  Scenario: Google search page -About- link title
    Then  User should see About link
    And   User clicks to About link
    Then  User should see title Google - About Google, Our Culture & Company News

  @googleTable
  Scenario: Verify that on the google search page footer contains 6 links
    Then  User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search works |
      | Privacy          |
      | Terms            |
      | Settings         |


    # command + D will auto-generate repeated steps
    # command + option + L will give pipes space


