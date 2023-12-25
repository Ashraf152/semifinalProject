Feature: Delete Address
  Scenario: Validate that we have remove the address
      When I delete that address
      Then The address should be removed
