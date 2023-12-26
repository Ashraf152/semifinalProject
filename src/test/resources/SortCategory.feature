Feature: Sugar-reduced products page sorting
  Scenario: sort Sugar-reduced products page

    Given User navigates to Sugar-reduced products page 'https://www.rami-levy.co.il/he/online/market/%D7%90%D7%95%D7%A8%D7%92%D7%A0%D7%99-%D7%95%D7%91%D7%A8%D7%99%D7%90%D7%95%D7%AA'
    When User click on filter button
    And User open sorting dropdown and choose from cheap to expensive
    Then Products have been sorted