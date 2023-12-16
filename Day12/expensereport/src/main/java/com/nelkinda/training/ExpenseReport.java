package com.nelkinda.training;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.Optional;

enum ExpenseType {
    DINNER("Dinner", true, 5000),
    BREAKFAST("Breakfast", true, 1000),
    CAR_RENTAL("Car Rental", false, Integer.MAX_VALUE),
    LUNCH("Lunch", true, 2000),
    ;

    final String name;
    final boolean isMeal;
    final int limit;

    ExpenseType(final String name, final boolean isMeal, final int limit) {
        this.name = name;
        this.isMeal = isMeal;
        this.limit = limit;
    }
}

class Expense {
    final ExpenseType type;
    final int amount;

    public Expense(final ExpenseType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }

    public boolean isMeal() {
        return type.isMeal;
    }

    public String getName() {
        return type.name;
    }

    public boolean isOverLimit() {
        return amount > type.limit;
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        printReport(expenses, new Date());
    }

    public void printReport(List<Expense> expenses, Date timestamp) {
        System.out.print(generateReport(expenses, timestamp));
    }

    public String generateReport(List<Expense> expenses, Date timestamp) {
        return reportHeader(timestamp) + reportBody(expenses) + reportSummary(expenses);
    }

    public static String reportHeader(final Date timestamp) {
        return "Expenses " + timestamp + "\n";
    }

    public static String reportBody(final List<Expense> expenses) {
        final StringBuilder sb = new StringBuilder();
        for (Expense expense : expenses) {
            sb.append(expenseDetail(expense));
        }
        return sb.toString();
    }

    public static String expenseDetail(final Expense expense) {
        final String expenseName = expense.getName();
        final String mealOverExpensesMarker = expense.isOverLimit() ? "X" : " ";
        return expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker + "\n";
    }

    public static String reportSummary(final List<Expense> expenses) {
        return "Meal expenses: " + sumMeals(expenses) + "\n" +
            "Total expenses: " + sumTotal(expenses) + "\n";
    }

    public static int sumMeals(final List<Expense> expenses) {
        return sum(expenses, Expense::isMeal);
    }

    public static int sumTotal(final List<Expense> expenses) {
        return sum(expenses, it -> true);
    }

    public static int sum(final List<Expense> expenses, final Predicate<Expense> filter) {
        return expenses
            .stream()
            .filter(filter)
            .mapToInt(expense -> expense.amount)
            .sum();
    }
}
