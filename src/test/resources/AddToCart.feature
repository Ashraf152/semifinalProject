Feature: Add To Cart Rami_Levy
  Scenario: Add to cart Items And Check if is added
  When Add To Cart Item
    | item   |quantity|
    | 354095 |1.00 |
    | 131770 |2.00 |
    | 3691   |2.00 |
  Then Check The quantity