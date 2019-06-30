Feature: Tickets reservation

  Background:
    Given now is "2019-05-01 15:00"

  Scenario: The one when the customer reserves a single seat
    Given cinema "LublinPlaza" is defined
    And movie "Smoleńsk" is defined
    And show "Smoleńsk" is played in cinema "LublinPlaza" on "2019-05-01 20:00" ticket cost 25
    When I select cinema "Plaza" in "Lublin"
    And I select movie "Smoleńsk"
    And I select show at "2019-05-01 20:00"
    And I select 1 ticket
    And I select seat 0 in row 0
    Then the cost of reservation is 25 PLN
    When I make a reservation
    Then the selected seats are reserved for me

  Scenario: The one when the customer reserves a single seat
    Given cinema "LublinPlaza" is defined
    And movie "Smoleńsk" is defined
    And show "Smoleńsk" is played in cinema "LublinPlaza" on "2019-05-01 20:00" ticket cost 25
    When I select cinema "Plaza" in "Lublin"
    And I select movie "Smoleńsk"
    And I select show at "2019-05-01 20:00"
    And I select 1 ticket
    And I select seat 10 in row 5
    Then the cost of reservation is 25 PLN
    When I make a reservation
    Then the selected seats are reserved for me

  Scenario: The one when the customer reserves 2 seats
    Given cinema "LublinPlaza" is defined
    And movie "Smoleńsk" is defined
    And show "Smoleńsk" is played in cinema "LublinPlaza" on "2019-05-01 20:00" ticket cost 25
    When I select cinema "Plaza" in "Lublin"
    And I select movie "Smoleńsk"
    And I select show at "2019-05-01 20:00"
    And I select seat 10 in row 5
    And I select seat 11 in row 5
    Then the cost of reservation is 50 PLN
    When I make a reservation
    Then the selected seats are reserved for me

  Scenario: The one when customer sees occupied seats
    Given cinema "LublinPlaza" is defined
    And movie "Smoleńsk" is defined
    And show "Smoleńsk" is played in cinema "LublinPlaza" on "2019-05-01 20:00" ticket cost 25
    And seat 10 in row 5 is reserved for "Smoleńsk" in cinema "Plaza" in "Lublin" on "2019-05-01 20:00"
    When I select cinema "Plaza" in "Lublin"
    And I select movie "Smoleńsk"
    And I select show at "2019-05-01 20:00"
    Then I see that seat 10 in row 5 is already reserved