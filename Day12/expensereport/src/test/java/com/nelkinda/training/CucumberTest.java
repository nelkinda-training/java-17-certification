package com.nelkinda.training;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.DataTableType;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@SuppressWarnings("java:S2187")
public class CucumberTest {
    private List<Expense> expenses;
    private String actualOutput;

    @DataTableType
    public Expense expense(final Map<String, String> entry) {
        return new Expense(ExpenseType.valueOf(entry.get("type")), Integer.parseInt(entry.get("amount")));
    }

    @Given("an empty list of expenses")
    public void givenAnEmptyListOfExpenses() {
        expenses = List.of();
    }

    @Given("the following expenses:")
    public void givenExpenses(final List<Expense> expenses) {
        this.expenses = expenses;
    }

    @When("printing the expense report")
    public void printTheExpenseReport() {
        actualOutput = new ExpenseReport().generateReport(expenses, new Date(123, 11, 15, 10, 30, 00));
    }

    @Then("the report MUST look like this:")
    public void theReportMustLookLike(final String expectedOutput) {
        assertEquals(expectedOutput.translateEscapes() + "\n", actualOutput);
    }
}
