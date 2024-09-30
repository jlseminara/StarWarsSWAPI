Feature: Test the one and lonely endpoint around here

  Scenario Outline: I specified part of the name and I get the right person
    Given I'm online
    When I specify the name "<name>"
    Then I get the full name "<result>"
    And the gender is "<gender>"


    Examples:
      | name                    | result              | gender        |
      | Luke                    | Luke Skywalker      | male          |
      | Han                     | Han Solo            | male          |
      | leia                    | Leia Organa         | female        |
      | luke                    | Luke Skywalker      | male          |
      | r2                      | R2-D2               | n/a           |
      | vader                   | Darth Vader         | male          |
      | Luke                    | Luke Skywalker      | male          |
      | Anakin skywalker        | Anakin Skywalker    | male          |


  Scenario Outline: I specify wrong and odd names and I get errors
    Given I'm online
    When I specify the name "<name>"
    Then I get an error Not Found


    Examples:
      | name            |
      | leonardo        |
      | DreamTheater    |
      | Nightwish       |
      | Metallica       |
      | Garcia Marquez  |
