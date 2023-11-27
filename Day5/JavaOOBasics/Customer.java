class MySuperClassForStuff {
    public String formattedLogString() {
        return "";
    }
}

public class Customer extends MySuperClassForStuff {
    private final String id;
    private final String name;

    public Customer(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer(id=" + id + ", name=" + name + ")";
    }

    @Override
    public String formattedLogString() {
        return "Customer(id=" + id + ", name=" + name + ")";
    }
}

class Store {
}


class Main {
    public static void main(final String... args) {
        Customer customer = new Customer("13516957", "Amit Patil");
        System.err.println(customer.toString());
        System.err.println(customer);
    }
}
