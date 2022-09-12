Feature: Flight Finder

  @Flight

  Scenario Outline: User search lowest fare on  participating airlines.

    Given The user clicks the flights button.
    Then The user has select option. such as "<Type>""<Passengers>""<Departing From>""<On>""<Day>""<Arriving In>""<Returning>""<Day>""<Service Class>""<Airline>"
    Then The user clicks Continue.
    Then Confirm the user found the seats.




    Examples:
    |Type|Passengers|Departing From|On|Day|Arriving In|Returning|Day|Service Class|Airline|
    |One Way|1|New York|July|12|London|December|12|First class                    |Blue Skies Airlines|