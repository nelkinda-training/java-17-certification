enum ExpenseType {
    BREAKFAST, DINNER, CAR_RENTAL
}

public class SwitchExample {
    public static void main(final String... args) {
        final ExpenseType expenseType = ExpenseType.valueOf(args[0]);
        System.out.println(getName(expenseType));
    }
    public static String getName(final ExpenseType expenseType) {
        //return switch (expenseType) {
        //        case BREAKFAST:  yield "Breakfast";
        //        case DINNER:     yield "Dinner";
        //        case CAR_RENTAL: yield "Car Rental";
        //    };
        return switch (expenseType) {
                case BREAKFAST  -> { System.out.println("yum!"); yield "Breakfast"; }
                case DINNER     -> { yield "Dinner"; }
                case CAR_RENTAL -> "Car Rental";
            };
    }
}
