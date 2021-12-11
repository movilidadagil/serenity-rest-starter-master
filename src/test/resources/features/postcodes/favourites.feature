Feature: List favorites


  Background:
    Given x-api-key is already acquired.


  @favs
  Scenario: Listing for all favorites dogs
    When Tester makes "favourites" request
    Then Tester should see information about dog
