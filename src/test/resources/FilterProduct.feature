Feature: Filter product

  Scenario: Filter products
    Given I am navigate to 'https://www.rami-levy.co.il/he/online/market/קטניות-ודגנים'
    When Click on the “Filter” button.
    And Click on Slim delis brand
    Then I got relevant results