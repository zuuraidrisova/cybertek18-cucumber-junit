@wikiWIP0
Feature: Wiki Title and Search Verifications
  Agile Story:


  Background: User is on the Wiki home page
    Given User is on the Wikipedia home page


  @wikiWIP
  Scenario: Search Functionality title verification
    When  User searches "Steve Jobs" in the wiki search page
    Then  User should see "Steve Jobs" in the wiki title


  @wikiWIP2
  Scenario: Search functionality header verification
    When  User searches "Steve Jobs" in the wiki search page
    Then  User should see "Steve Jobs" in the main header


  @wikiWIP3
  Scenario: Search functionality header verification
    When  User searches "Steve Jobs" in the wiki search page
    Then  User should see "Steve Jobs" in the wiki title
    Then  User should see "Steve Jobs" in the main header
    Then  User should see "Steve Jobs" in the image header


    @wikiScenarioOutline
  Scenario Outline: Search functionality header verification
    When  User searches "<searchValue>" in the wiki search page
    Then  User should see "<expectedTitle>" in the wiki title
    Then  User should see "<expectedHeaderTitle>" in the main header
    Then  User should see "<expectedImageTitle>" in the image header

    Examples: example test data for wikipedia search
      |searchValue  | expectedTitle  | expectedHeaderTitle  | expectedImageTitle |
      | Steve Jobs  |  Steve Jobs    |  Steve Jobs          |    Steve Jobs      |
      | Keanu Reeves| Keanu Reeves   | Keanu Reeves         |  Keanu Reeves      |
      | Dua Lipa    | Dua Lipa       | Dua Lipa             | Dua Lipa           |
      | Bruce Lee   | Bruce Lee      | Bruce Lee            | Bruce Lee          |

