Feature: Characterization of ExpenseReport

  Scenario: Empty report
    Given the following expenses:
      | type       | amount |
    When printing the expense report
    Then the report MUST look like this:
      """
      Expenses Fri Dec 15 10:30:00 CET 2023
      Meal expenses: 0
      Total expenses: 0
      """

  Rule: Meals are reported separately.
    Scenario Outline: Meals are included in the meal expenses.
      Given the following expenses:
        | type       | amount |
        | <type>     |      1 |
      When printing the expense report
      Then the report MUST look like this:
        """
        Expenses Fri Dec 15 10:30:00 CET 2023
        <name>	1	 
        Meal expenses: 1
        Total expenses: 1
        """
      Examples:
        | type      | name      |
        | DINNER    | Dinner    |
        | BREAKFAST | Breakfast |
        | LUNCH     | Lunch     |

    Scenario Outline: Non-meals are excluded from the meal expenses.
      Given the following expenses:
        | type       | amount |
        | <type>     |      1 |
      When printing the expense report
      Then the report MUST look like this:
        """
        Expenses Fri Dec 15 10:30:00 CET 2023
        Car Rental	1	 
        Meal expenses: 0
        Total expenses: 1
        """
      Examples:
        | type       | name       |
        | CAR_RENTAL | Car Rental |

  Rule: Certain expense types have limits.
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
        <name>	2147483647	 
        Meal expenses: 0
        Total expenses: 2147483647
        """
      Examples:
        | type       | name       |
        | CAR_RENTAL | Car Rental |
