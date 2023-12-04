public enum ExpenseType {
    DINNER("Dinner"),
    BREAKFAST("Breakfast"),
    CAR_RENTAL("Car Rental"),
    ;

    private final String name;

    ExpenseType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ExpenseType {
    public static final ExpenseType DINNER = new ExpenseType("Dinner");
    public static final ExpenseType BREAKFAST = new ExpenseType("Breakfast");
    public static final ExpenseType CAR_RENTAL = new ExpenseType("Car Rental");

    private final String name;

    private ExpenseType(final String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
