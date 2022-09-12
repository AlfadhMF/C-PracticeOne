Feature: Registration


  Scenario: The user is filling in information.


    When The user start is fill the contact information.
    Then The user filling mailing information.
    Then The user filling user information.
    When The user click Submit.
    Then The user have been registered.

