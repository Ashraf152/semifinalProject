Feature: Add new address
  Background:
    Given I navigated to 'https://www.rami-levy.co.il/he/'
    And I click on profile button
    And I enter my email 'ashraf.egbaria@gmail.com'
    And I enter my password 'Ashrafadel152'
    And I click on login Button
    And User added new address to his account

  Scenario: Add new address
    When User navigate to address management page
    Then User see the new address been updated

  Scenario: Validate that we have remove the address
    When I delete that address
    Then The address should be removed