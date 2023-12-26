Feature: Searching for product

  Scenario: Searching for <"חלב">
    Given I am navigated to 'https://www.rami-levy.co.il/he/'
    When I search for 'חלב'
    And I click enter
    Then I got sub page with relevant results