Feature: Booking
  So I can rest in a comfortable place
  As a Spotahome user
  I want to be able to book a home

  Scenario: Display search results
    Given I am in home page
    When I select a random city and date
    Then I should be at "Rooms" page

  Scenario: Book with random dates
    Given I am in home page
    When I select city "Dubai" and date from "2019-03-22" to "2022-02-01"
    And I select a random room
    And I select a random date and book
    Then I should be at "Booking" page