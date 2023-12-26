Feature: Logout Feature
  Background:
    Given I navigated to 'https://www.rami-levy.co.il/he/'
    And I click on profile button
    And I enter my email 'ashraf.egbaria@gmail.com'
    And I enter my password 'Ashrafadel152'
    And I click on login Button

  Scenario: Check The The LogOut Feature
    When I Click On LogOut
    Then Check LogOut Feature