Feature: Etsy Title Verification
  Agile Story: Agile Story: As a user, I should be able to search when I am on Etsy search page.

  Background: User should be on Etsy search page
    Given User is on etsy page

  @etsy
  Scenario: Etsy Title Verification
    Then  User sees title is as expected.

  @wooden
  Scenario: Etsy Search Functionality Title Verification
    When User types Wooden Spoon in the search box
    And  User clicks search button
    Then User sees Wooden Spoon is in the title

  @parameterized
  Scenario: Etsy Search Functionality Title Verification
      When User types "Wooden spoon" in the search box
      And  User clicks search button
      Then User sees "Wooden spoon" is in the title


