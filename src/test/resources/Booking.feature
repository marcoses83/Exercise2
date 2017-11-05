Feature: Booking
  So
  As
  I

  Scenario: Book
    Given I am in home page
    When I select a city and date
    And I select a room
    And I select a date and book
    Then I should be at "Booking" page