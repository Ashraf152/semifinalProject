Feature: Add To Cart Rami_Levy
  Background:
    Given I navigated to 'https://www.rami-levy.co.il/he/'
    And I click on profile button
    And I enter my email 'ashraf.egbaria@gmail.com'
    And I enter my password 'Ashrafadel152'
    And I click on login Button
    When Add To Cart Item
      | item   |quantity|
      | 377697 |1.00 |
      | 131770 |2.00 |
      | 3691   |2.00 |

  Scenario: Add to cart Items And Check if is added
  Then Check The quantity

    Scenario: Check if the cart empty
      When Remove all the item in the cart
      Then Check if the cart is empty