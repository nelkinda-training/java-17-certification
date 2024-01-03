package com.nelkinda.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.nelkinda.training.CsvLoader.loadExpenseTypes;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toUnmodifiableMap;

class CsvLoader {
    static <T> Map<String, T> loadExpenseTypes(final Class<T> tClass, final Function<String[], T> mapper) {
        try (final var in = new BufferedReader(new InputStreamReader(requireNonNull(tClass.getResourceAsStream(tClass.getSimpleName() + ".csv"))))) {
            return in
                    .lines()
                    .skip(1)
                    .map(it -> it.split(","))
                    .collect(toUnmodifiableMap(a -> a[0], mapper));
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

class ExpenseType {
    private static final Map<String, ExpenseType> expenseTypes = loadExpenseTypes(ExpenseType.class, ExpenseType::new);

    final String name;
    final boolean isMeal;
    final int limit;

    ExpenseType(final String name, final boolean isMeal, final int limit) {
        this.name = name;
        this.isMeal = isMeal;
        this.limit = limit;
    }
    private ExpenseType(final String... a) {
        this(a[1], parseBoolean(a[2]), "NULL".equals(a[3]) ? MAX_VALUE : parseInt(a[3]));
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

class ExpenseReport {
    @SuppressWarnings("unused")
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
                .mapToInt(Expense::amount)
                .sum();
    }
}
