Feature: Example of how to implement data table

  @dataTable
  Scenario: Something happens
    #Given User does something
    Then User should see below words displayed
      | Apple    |
      | Kiwi     |
      | Orange   |
      | Broccoli |
      | Cucumber |

    #command option L will make the pipes straight