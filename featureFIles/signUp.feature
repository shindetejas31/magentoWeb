Feature: User Sign-Up

  Scenario Outline: User successfully signs up with valid details
    Given User is testing sign-up with "<scenario>" scenario
    When User enters sign-up details
    Then Sign-up should show appropriate result

    Examples:
      | scenario      |
      | validData     |

  Scenario Outline: User tries to sign up with invalid email
    Given User is testing sign-up with "<scenario>" scenario
    When User enters sign-up details
    Then Sign-up should show appropriate result

    Examples:
      | scenario      |
      | invalidEmail  |

  Scenario Outline: User tries to sign up with mismatched passwords
    Given User is testing sign-up with "<scenario>" scenario
    When User enters sign-up details
    Then Sign-up should show appropriate result

    Examples:
      | scenario          |
      | passwordMismatch  |

  Scenario Outline: User tries to sign up with empty fields
    Given User is testing sign-up with "<scenario>" scenario
    When User enters sign-up details
    Then Sign-up should show appropriate result

    Examples:
      | scenario    |
      | emptyFields |
