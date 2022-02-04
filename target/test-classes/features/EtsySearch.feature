@etsy
Feature: Etsy Search feature
  Agile Story: User should be able to enter search terms and see relevant
  results in the page and in the title.

  Background: User is on the etsy home page
    Given   User is on the etsy home page

  @etsyWIP
  Scenario: Title verification
    Then   User should see title is as expected

    #expected:  Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
  @etsyWIP2
  Scenario: Title Verification after search term
    When  User searches "Wooden spoon" in the search box
    And   User clicks to search button
    Then  User should see "Wooden spoon"in the etsy title





