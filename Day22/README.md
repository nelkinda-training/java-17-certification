# JDBC


## JDBC vs ORM

If you can use an ORM instead of JDBC, use an ORM.

Benefits of using an ORM instead of JDBC:
- Manages the relationship dependency mismatch between relational databases and object-oriented data models (dependency inversion)
- Trivial and also much non-trivial SQL code will be auto-generated
- More secure (much less prone to SQL-Injection attacks)
- Abstracts the database so that we have less (ideally no) DBMS-coupling
- Easy swap-out of a "slow" DBMS like Postgres with a "fast" in-memory DBMS like H2, for example for fast integrated tests.
- Thread-Safety via connection pooling (for example using Hikari)
- Handles SQLException for us
- Ensures naming consistency between Java and database, sometimes even in configurable ways
- Provides an interface for database migration (for example using Flyway or LiquiBase)
- Manages the database lifecycle (and connects it with database migration)
- Provides declarative instead of imperative transaction management (typically in conjuction with another framework like Spring or Micronaut)

The most popular ORM for Java is probably Hibernate.
Typically, Hibernate is also not used directly, but via a dependency injection framework and inversion of control container like Spring or Micronaut.

```java
public class Customer {
    private final UUID id;
    private String firstname;
    private String lastname;
    public Customer(final UUID id, final String firstname, final String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getter for id, firstname, lastname
    // Setter for firstname, lastname
    public Set<ShippingAddress> getShippingAddresses() { ... }
}

public class ShippingAddress {
    private final UUID id;
    private final String line1;
    private final String line2;
    private final String line3;
    private final String line4;
    private final String zip;
    private final String city;
    private final String country;
    // ...
}
```

```sql
CREATE TABLE Customer(
    id UUID PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL
);

CREATE TABLE ShippingAddress(
    id UUID PRIMARY KEY,
    line1 VARCHAR(255) NOT NULL,
    line2 VARCHAR(255) NOT NULL,
    line3 VARCHAR(255) NOT NULL,
    line4 VARCHAR(255) NOT NULL,
    zip VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    customerId UUID NOT NULL, // Foreign Key to Customer.id
);
```
