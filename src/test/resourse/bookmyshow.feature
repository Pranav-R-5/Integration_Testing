Feature: Integration Testing

  Scenario Outline: user get the movie from the Api endpoint and finding available seats - "<city>"
    Given user get all the movies from API endpoint in city "<city>"
    When user get the movie record which shows only in "<language>" language
    And user get the movie name
    Given user navigate to bookmyshow
    When user search the movie
    And user verify the movie
    And user select the movie from the screen
    And user selects the fast filling show
    And user selects the number of tickets
    Then user prints the seats which has adjacent empty seats
    Examples:
      |city|language|
      |bengaluru|Kannada|
      |Coimbatore|Malayalam|


