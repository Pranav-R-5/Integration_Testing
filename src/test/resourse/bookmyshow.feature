Feature: Integration Testing

  Scenario: user get the movie from the Api endpoint
    Given user get all the movies from API endpoint
    When user get the movie record which shows only in kannada language
    And user get the movie name
    Then I get the response as 200

  Scenario: Print ths seats Which have adjacent empty seats
    Given user navigate to bookmyshow
    When user search the movie
    And user verify the movie
    And user select the movie from the screen
    And user selects the fast filling show
    And user selects the number of tickets
    Then user prints the seats which has adjancent empty seats
