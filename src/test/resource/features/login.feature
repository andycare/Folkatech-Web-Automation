Feature: Login Feature

  @SuccessLogin
  Scenario: Successful Login
    Given I am on the login page
    When I enter valid email
    And I enter valid password
    And I click login
    Then I should be redirected to the homepage

  @UnregisteredEmail
    Scenario: Login with unregistered email
    Given I am on the login page
    When I enter unregistered email
    And I enter valid password
    And I click login
    Then I should see warning message 'Login Gagal! Akun tidak ada.'

  @InvalidPassword
    Scenario: Login with unregistered email
    Given I am on the login page
    When I enter valid email
    And I enter invalid password
    And I click login
    Then I should see warning message 'Login Gagal! Kata sandi salah.'