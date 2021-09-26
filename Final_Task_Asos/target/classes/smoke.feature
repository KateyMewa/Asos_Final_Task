Feature: Smoke
  As a user I want to test main general functionality
  So that I can be sure that the main functions I need are on the website and operate correctly

  Scenario Outline: Check visibility of main elements on the home page
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search panel visibility
    And User checks main widgets visibility
    And User checks social media links visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check that search results are reflected on page after entering correct text
    Given User opens '<homePage>' page
    And User checks search panel visibility
    Then User enters '<keyword>' into search input
    Then User clicks search button
    And User checks that search results are reflected

    Examples:
      | homePage              | keyword |
      | https://www.asos.com/ | dress   |

  Scenario Outline: Check message saying that no results is shown on page after entering incorrect text
    Given User opens '<homePage>' page
    And User checks search panel visibility
    Then User enters '<keyword>' into search input
    Then User clicks search button
    And User checks that message saying that no results is shown

    Examples:
      | homePage              | keyword  |
      | https://www.asos.com/ | fydimsky |

  Scenario Outline: Check that after changing currency prices are given in this currency
    Given User opens '<homePage>' page
    And User clicks Country button
    And User select the '<currency>'
    And User clicks UpdatePreferences button
    Then User clicks to Women button
    Then User hovers to Clothes section
    And User goes to Dresses link
    Then User checks that random product price contains '<currencySymbol>'

    Examples:
      | homePage              | currency | currencySymbol |
      | https://www.asos.com/ | € EUR    | €              |