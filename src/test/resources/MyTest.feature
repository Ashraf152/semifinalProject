Feature: Login Validate
  Background:
  Given I navigated to 'https://www.rami-levy.co.il/he/'
      When I click on profile button
      And I enter Email <'MyEmail'>
      And I enter Password <'MyPassword'>
      And I click on <'loginButton'>
      Then The main page of the website is appear and My account has been login




