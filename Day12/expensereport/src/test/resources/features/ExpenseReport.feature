Feature: Characterization of ExpenseReport

  Scenario: Reports meals separately
    Given the following expenses:
      | type       | amount |
      | DINNER     |      1 |
      | BREAKFAST  |      2 |
      | CAR_RENTAL |      4 |
      | LUNCH      |      8 |
    When printing the expense report
    Then the report MUST look like this:
      """
      Expenses Fri Dec 15 10:30:00 CET 2023
      Dinner	1	 
      Breakfast	2	 
      Car Rental	4	 
      Lunch	8	 
      Meal expenses: 11
      Total expenses: 15
      """

  Scenario: Certain expense types have limits.
    Given the following expenses:
      | type       | amount |
      | BREAKFAST  |   1001 |
      | BREAKFAST  |   1000 |
      | DINNER     |   5001 |
      | DINNER     |   5000 |
      | LUNCH      |   2001 |
      | LUNCH      |   2000 |
    When printing the expense report
    Then the report MUST look like this:
      """
      Expenses Fri Dec 15 10:30:00 CET 2023
      Breakfast	1001	X
      Breakfast	1000	 
      Dinner	5001	X
      Dinner	5000	 
      Lunch	2001	X
      Lunch	2000	 
      Meal expenses: 16003
      Total expenses: 16003
      """

  Scenario Template: Other exepense types do not have limits.
    Given the following expenses:
      | type   |       amount |
      | <type> |   2147483647 |
    When printing the expense report
    Then the report MUST look like this:
      """
      Expenses Fri Dec 15 10:30:00 CET 2023
      Car Rental	2147483647	 
      Meal expenses: 0
      Total expenses: 2147483647
      """
    Examples:
      | type       |
      | CAR_RENTAL |
