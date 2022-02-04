@wikipedia
Feature: Wikipedia Title Verification
  Agile Story: As a user, I should be able to search when I am on Wikipedia search page.


  Background:  User should be on Wikipedia home page
    Given User is on Wikipedia home page


  @tc25
  Scenario: Wikipedia Search Functionality Title Verification
    When User types Steve Jobs in the wiki search box
    And  User clicks wiki search button
    Then User sees Steve Jobs is in the wiki title


  @tc26
  Scenario: Wikipedia Search Functionality Title Verification
     When User types Steve Jobs in the wiki search box
     And  User clicks wiki search button
     Then User sees Steve Jobs is in the main header


  @tc27
  Scenario: Wikipedia Search Functionality Title Verification
    When User types Steve Jobs in the wiki search box
    And  User clicks wiki search button
    Then User sees Steve Jobs is in the image header
