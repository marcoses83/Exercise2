Feature: Booking
  So I can rest in a comfortable place
  As a Spotahome user
  I want to be able to book a home

  Scenario: Display search results
    Given I am in home page
    When I select a city and date
    Then I should be at "Rooms" page

  Scenario: Book with random dates
    Given I am in home page
    When I select a city and date
    And I select a room
    And I select a date and book
    Then I should be at "Booking" page