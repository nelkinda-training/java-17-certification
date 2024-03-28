package com.nelkinda.training.java17.jdbc;

import java.sql.*;
import java.util.*;

public class AccessDatabase {
//    private static final String jdbcUrl = "jdbc:h2:~/training";
    //private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/training";
    private static final String jdbcUrl = "jdbc:mariadb://localhost:3306/training";

    public static void main(final String... args) throws SQLException {
        try (final Connection connection = DriverManager.getConnection(jdbcUrl, "root", null)) {
            CustomerRepository customerRepository = new CustomerRepository(connection);
//            customerRepository.createTable();

            // Firstname: John
            // Lastname: "); DROP TABLE Customer;
            CustomerCreationFormData formData = new CustomerCreationFormData() {{ firstname = "Amit"; lastname = "Patil"; }};
            customerRepository.insertCustomer(new Customer(formData.firstname, formData.lastname));

            final Set<Customer> customers = customerRepository.findByFirstname("Amit");
            for (final Customer customer : customers)
                System.out.println(customer);
        }
    }
}

class CustomerRepository {
    private final Connection connection;
    public CustomerRepository(final Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        try (final Statement stmt = connection.createStatement()) {
            boolean result = stmt.execute("CREATE TABLE Customer (id UUID PRIMARY KEY, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL)");
            System.out.println("Table created: " + result);
        }
    }

    public void insertCustomerBadDoNotDoThis(final Customer customer) throws SQLException {
        // DON'T DO THIS! THIS IS PRONE TO SQL INJECTION ATTACKS!!!
        try (final Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO Customer (id, firstname, lastname) VALUES (\"" + customer.id + "\", \"" + customer.firstname + "\", \"" + customer.lastname + "\")");
        }
    }

    public void insertCustomer(final Customer customer) throws SQLException {
        // DO THIS! This is not vulnerable to SQL Injection Attacks.
        try (final PreparedStatement stmt = connection.prepareStatement("INSERT INTO Customer (id, firstname, lastname) VALUES (?, ?, ?)")) {
            stmt.setObject(1, customer.id);
            stmt.setString(2, customer.firstname);
            stmt.setString(3, customer.lastname);
            stmt.executeUpdate();
        }
    }

    public Set<Customer> findByFirstname(final String firstname) throws SQLException {
        try (final PreparedStatement stmt = connection.prepareStatement("SELECT id, firstname, lastname FROM Customer WHERE firstname = ?")) {
            stmt.setString(1, firstname);

            try (final ResultSet result = stmt.executeQuery()) {
                final Set<Customer> customers = new HashSet<Customer>();
                while (result.next())
                    customers.add(new Customer(result.getObject(1, UUID.class), result.getString(2), result.getString(3)));
                return customers;
            }
        }
    }
}

class CustomerCreationFormData {
    public String firstname;
    public String lastname;
}

class Customer {
    public UUID id;
    public String firstname;
    public String lastname;

    public Customer(String firstname, String lastname) {
        this(UUID.randomUUID(), firstname, lastname);
    }

    public Customer(UUID id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
