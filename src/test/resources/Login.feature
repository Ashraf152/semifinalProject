Feature: Login Validate
  Background:
    Given I navigated to 'https://www.rami-levy.co.il/he/'
  Scenario: login to rami-levi
    When I click on profile button
    And I enter my email 'waseem-abusobe@hotmail.com'
    And I enter my password 'Waseem123123'
    And I click on login Button
    Then The main page of the website is appear and My account has been login