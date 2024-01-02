package com.nelkinda.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toUnmodifiableMap;

class ExpenseType {
    private static final Map<String, ExpenseType> expenseTypes = loadExpenseTypes();

    final String name;
    final boolean isMeal;
    final int limit;

    ExpenseType(final String name, final boolean isMeal, final int limit) {
        this.name = name;
        this.isMeal = isMeal;
        this.limit = limit;
    }

    private static Map<String, ExpenseType> loadExpenseTypes() {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(ExpenseType.class.getResourceAsStream("ExpenseType.csv")))) {
            return in
                .lines()
                .skip(1)
                .map(it -> it.split(","))
                .collect(toUnmodifiableMap(a -> a[0], a -> fromArray(a)));
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static ExpenseType fromArray(final String[] a) {
        return new ExpenseType(a[1], Boolean.valueOf(a[2]), "NULL".equals(a[3]) ? Integer.MAX_VALUE : Integer.valueOf(a[3]));
    }

    public static ExpenseType valueOf(final String type) {
        return expenseTypes.get(type);
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
        return header(timestamp) + body(expenses) + summary(expenses);
    }

    public static String header(final Date timestamp) {
        return "Expenses " + timestamp + "\n";
    }

    public static String body(final List<Expense> expenses) {
        return expenses.stream().map(ExpenseReport::expenseDetail).collect(joining());
    }

    public static String expenseDetail(final Expense expense) {
        return expense.getName() + "\t" + expense.amount() + "\t" + expenseOverLimitMarker(expense) + "\n";
    }

    public static String expenseOverLimitMarker(final Expense expense) {
        return expense.isOverLimit() ? "X" : " ";
    }

    public static String summary(final List<Expense> expenses) {
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
            .collect(summingInt(Expense::amount));
    }
}
