class Expense {
    int amount;
    String type;
}

@Test
public void test() {
    Expense e1 = new Expense();
    e1.amount = 1000;
    e1.type = "Breakfast";

    Expense e2 = new Expense();
    e2.amount = 2000;
    e2.type = "Dinner";

    Expense e1 = new Expense() {{ amount = 1000; type = "Breakfast"; }};
    Expense e2 = new Expense() {{ amount = 2000; type = "Dinner";    }};
}
