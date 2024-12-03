Feature: HomePage functionality

  Scenario: User clicks on Sign In link
    Given User is on the homepage
    When User clicks on the "Sign In" link
    Then User should be redirected to the login page

  Scenario: User clicks on Create Account link
    Given User is on the homepage
    When User clicks on the "Create Account" link
    Then User should be redirected to the sign-up page
