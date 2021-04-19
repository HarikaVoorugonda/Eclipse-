Feature: Adactin Login feature

  Scenario: Login
    Given User present in Adactin Login page
    When User Enter Username
    And User Enter Password
    And User Click on Login Button
    Then Get Title of the Page
    
    And Select Location
    And Select Hotel
    And Select Room Type
    And No Of Rooms
    And Check-In 
    And Check-out
    And Adults Per Room
    And User clickon Search Button
    Then Hotel Availabilty
    Then Close

