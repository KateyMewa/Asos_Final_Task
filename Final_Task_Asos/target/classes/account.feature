Feature: Account
  As a user I want to test sign in option and personal information section
  So that in case of misprint I will be notified of the mistake

  Scenario Outline: Check signing in function upon entering correct email and password
    Given User opens '<homePage>' page
    And User clicks MyAccount button
    And User clicks Sign In link
    Then User enters '<email>' into email field
    Then User enters '<password>' into password field
    And User clicks Sign In submitting button
    And User clicks MyAccount button
    And User clicks MyAccount link
    And User checks that MyAccountPage has in its url '<url-keyword>'

    Examples:
      | homePage              | email                         | password    | url-keyword |
      | https://www.asos.com/ | kateryna.meleshkova@gmail.com | Myasospass1 | my-account  |

  Scenario Outline: Check signing in function upon entering incorrect email and password
    Given User opens '<homePage>' page
    And User clicks MyAccount button
    And User clicks Sign In link
    Then User enters '<wrongEmail>' into email field
    Then User enters '<wrongPassword>' into password field
    And User clicks Sign In submitting button
    And User checks that loginErrorMessage is shown

    Examples:
      | homePage              | wrongEmail                    | wrongPassword |
      | https://www.asos.com/ | ivanna.meleshkova@gmail.com | Myasospass    |

  Scenario Outline: Check error messages on condition of clearing email and entering wrong into e-mail feld in MyAccount page
    Given User opens '<homePage>' page
    And User clicks MyAccount button
    And User clicks MyAccount link
    Then User enters '<email>' into email field
    Then User enters '<password>' into password field
    And User clicks Sign In submitting button
    And User clicks MyAccount details button
    Then User clears Email filed
    Then User clicks Submit changes button
    Then User checks that message with '<clearFieldKeyword>' is shown
    Then User enters '<incorrectEmail>'
    Then User clicks Submit changes button
    Then User checks that message with '<wrongFieldKeyword>' is shown

    Examples:
      | homePage              | email                         | incorrectEmail                        | password    | clearFieldKeyword                | wrongFieldKeyword                       |
      | https://www.asos.com/ | kateryna.meleshkova@gmail.com | kateryna.meleshkovagmail.com | Myasospass1 | You need to type your email here | look like an email address |