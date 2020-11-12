Feature: SmartBear order process
  Agile Story: As a user, I should be able to log into SmartBear and enter all order information and verify.


  @smartBearWIP
  Scenario: SmartBear order process
    Given User is logged into SmartBear Tester account and on Order page
    When  User selects FamilyAlbum from product dropdown
    And   User enters "4" to quantity
    And   User enters John Wick to costumer name
    And   User enters Kinzie Ave to street
    And   User enters Chicago to city
    And   User enters IL to state
    And   User enters "60056"
    And   User selects Visa as card type
    And   User enters "1111222233334444" to card number
    And   User enters "12/22" to expiration date
    And   User clicks process button
    Then  User verifies John Wick is in the list


  @smartBearWithParameterization
  Scenario: SmartBear order process
    Given User logs into SmartBear Tester account and on Order page
    When  User should select FamilyAlbum from product dropdown
    And   User enters "4" quantity
    And   User enters "John Wick" to costumer name
    And   User enters "Kinzie Ave" to street
    And   User enters "Chicago" to city
    And   User enters "IL" to state
    And   User should enter "60056"
    And   User selects Visa as card
    And   User enters "1111222233334444" card number
    And   User enters "12/22" expiration date
    And   User clicks process Button
    Then  User verifies "John Wick" is in the list