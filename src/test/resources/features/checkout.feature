Feature: Registered user checkout
  Scenario: Registered user places an order
    Given user is logged in with email "testuser@example.com" and password "Password123!"
    When user searches for "Apple MacBook Pro" and adds to cart
    And user proceeds to checkout and confirms order
    Then order should be placed successfully
