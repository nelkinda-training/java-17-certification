class MySuperClassForStuff {
    public String formattedLogString() {
        return "";
    }
}

public class Customer extends MySuperClassForStuff {
    private final String id;
    private String firstname;
    private String lastname;
    private boolean isEmailVerified;

    public Customer(final String id, final String firstname, final String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer(id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ")";
    }

    @Override
    public String formattedLogString() {
        return "Customer(id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ")";
    }
}

class Store {
}


class Main {
    public static void main(final String... args) {
        Customer customer = new Customer("13516957", "Amit", "Patil");
        System.err.println(customer.toString());
        System.err.println(customer);
        System.err.println("Customer id: " + customer.getId());
        System.err.println("Customer name: " + customer.getName());
        System.err.println("Correcting customer name...");
        customer.setFirstname("Anil");
        System.err.println("Customer name: " + customer.getName());
        if (customer.isEmailVerified()) {
            System.err.println("Email is verified");
        } else {
            System.err.println("Email is not verified");
        }
    }
}
