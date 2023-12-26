Feature: Add new address
  Background:
    Given User added new address to his account


  Scenario: Add new address
    When User click on address management
    Then User see the new address been updated

  Scenario: Validate that we have remove the address
    When I delete that address
    Then The address should be removed