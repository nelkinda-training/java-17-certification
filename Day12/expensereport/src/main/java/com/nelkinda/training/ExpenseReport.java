package com.nelkinda.training;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.stream.Collectors;

enum ExpenseType {
    DINNER    ("Dinner",     true,  5000),
    BREAKFAST ("Breakfast",  true,  1000),
    CAR_RENTAL("Car Rental", false, Integer.MAX_VALUE),
    LUNCH     ("Lunch",      true,  2000),
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

record Expense(ExpenseType type, int amount) {
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
    public void printReport(final List<Expense> expenses) {
        printReport(expenses, new Date());
    }

    public void printReport(final List<Expense> expenses, final Date timestamp) {
        System.out.print(generateReport(expenses, timestamp));
    }

    public String generateReport(final List<Expense> expenses, final Date timestamp) {
        return reportHeader(timestamp) + reportBody(expenses) + reportSummary(expenses);
    }

    public static String reportHeader(final Date timestamp) {
        return "Expenses " + timestamp + "\n";
    }

    public static String reportBody(final List<Expense> expenses) {
        return expenses.stream().map(ExpenseReport::expenseDetail).collect(Collectors.joining());
    }

    public static String expenseDetail(final Expense expense) {
        return expense.getName() + "\t" + expense.amount() + "\t" + expenseOverLimitMarker(expense) + "\n";
    }

    public static String expenseOverLimitMarker(final Expense expense) {
        return expense.isOverLimit() ? "X" : " ";
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
            .mapToInt(Expense::amount)
            .sum();
    }
}