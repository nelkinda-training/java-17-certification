package com.nelkinda.training.java.modules.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdTest {
    @Test
    void product_of_nothing_is_one() {
        assertEquals(product(), 1);
    }

    @Test
    void product_of_one_number_is_that_number() {
        assertEquals(product(42), 42);
    }

    @Test
    void product_of_two_numbers_is_their_product() {
        assertEquals(product(42, 23), 966);
    }

    public static int product(final int... numbers) {
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }
}
