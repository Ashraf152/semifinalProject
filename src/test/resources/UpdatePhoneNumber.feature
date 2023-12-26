Feature: Update user information
  Scenario: update phone number

    Given User in his private area 'https://www.rami-levy.co.il/he/dashboard'
    When User update his phone number
    Then New phone number shown to the user