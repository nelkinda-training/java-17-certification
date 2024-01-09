package com.nelkinda.training.java.modules.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @Test
    void sum_of_nothing_is_zero() {
        assertEquals(sum(), 0);
    }

    @Test
    void sum_of_one_number_is_that_number() {
        assertEquals(sum(42), 42);
    }

    @Test
    void sum_of_two_numbers_is_their_sum() {
        assertEquals(sum(42, 23), 65);
    }

    public static int sum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
