Feature: List favorites


  Background:
    Given x-api-key is already acquired.


  @favs
  Scenario: Listing for all favorites dogs
    When Tester makes "favourites" request
    Then Tester should see information about dog



  @favs-list
  Scenario: Validation favourites dogs
    When Tester makes favourites api "sub_id" request
    Then Tester should see information about dog

  @emrefavs
  Scenario: Validation favourites dogs
    When Tester makes favourites api "sub_id" request
    Then Tester should see all favourites dogs by "sub_id"

  @emrefavsoutline
  Scenario Outline: User listing for all fav dogs user
    When I make request with "<sub_id>" parameter
    Then User should see its "<image_id>" favourite
    Examples:
    |sub_id         |  image_id    |
    |my-user-1234   |  VOmeXxwUp   |
    |your-user-1234 |  9ccXTANkb   |
