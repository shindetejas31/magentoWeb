Feature: User Sign-In

  Scenario Outline: User successfully logs in with valid credentials
    Given User is testing sign-in with "<scenario>" scenario
    When User enters sign-in details
    Then Sign-in should show appropriate result

    Examples:
      | scenario    |
      | validLogin  |

  Scenario Outline: User tries to sign in with invalid email
    Given User is testing sign-in with "<scenario>" scenario
    When User enters sign-in details
    Then Sign-in should show appropriate result

    Examples:
      | scenario      |
      | invalidEmail  |

  Scenario Outline: User tries to sign in with incorrect password
    Given User is testing sign-in with "<scenario>" scenario
    When User enters sign-in details
    Then Sign-in should show appropriate result

    Examples:
      | scenario        |
      | incorrectPassword |

  Scenario Outline: User tries to sign in with empty fields
    Given User is testing sign-in with "<scenario>" scenario
    When User enters sign-in details
    Then Sign-in should show appropriate result

    Examples:
      | scenario    |
      | emptyFields |
