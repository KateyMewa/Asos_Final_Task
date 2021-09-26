Feature: MyProducts
  As a user I want to test bag section
  So that the number of products in bag and total sum were reflected correctly

  Scenario Outline: Check that product was added in bag
    Given User opens '<homePage>' page
    And User clicks MyAccount button
    And User clicks Sign In link
    Then User enters '<email>' into email field
    Then User enters '<password>' into password field
    And User clicks Sign In submitting button
    Then User clicks to Women button
    Then User hovers to Clothes section
    And User goes to Dresses link
    Then User clicks to product One
    Then User chooses '<size>'
    Then User clicks AddToBag button
    Then User checks that MinibagDropdown section is shown up

    Examples:
      | homePage              | email                         | password    | size  |
      | https://www.asos.com/ | kateryna.meleshkova@gmail.com | Myasospass1 | EU 34 |

  Scenario Outline: Check total price in bag
    Given User opens '<homePage>' page
    Then User clicks to Women button
    Then User hovers to Clothes section
    And User goes to Dresses link
    Then User clicks to product One
    Then User chooses '<size>'
    And User adds product price to total sum
    Then User clicks AddToBag button
    And User clicks DressesSection link
    Then User clicks to product Two
    Then User chooses '<size>'
    And User adds product price to total sum
    Then User clicks AddToBag button
    And User hovers to Bag button
    And User clicks to ViewBag button
    And User checks that total price equals the sum of prices for two products

    Examples:
      | homePage              | size  |
      | https://www.asos.com/ | EU 36 |

  Scenario Outline: Check that product is added to wishlist after authorization
    Given User opens '<homePage>' page
    Then User clicks to Women button
    Then User hovers to Clothes section
    And User goes to Dresses link
    Then User clicks to product One
    Then User clicks SaveToWishlist button
    And User clicks Wishlist button
    Then User clicks Sign In button
    Then User enters '<email>' into email field
    Then User enters '<password>' into password field
    And User clicks Sign In submitting button
    Then User checks that the product is saved in wishlist after authorization

    Examples:
      | homePage              | email                         | password    |
      | https://www.asos.com/ | kateryna.meleshkova@gmail.com | Myasospass1 |