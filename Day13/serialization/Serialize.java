import java.io.*;
import java.lang.reflect.*;
import java.util.UUID;
import java.time.*;

record Customer(UUID id, String name) implements Serializable {
}

// {
//   'id': '9ed0d3f5-62a5-4429-a3f0-0c08ad6b506f',
//   'name': 'Amit Patil'
// }

// {
//   'id': {
//     'leastSigBits': -6633789019707977617,
//     'mostSigBits': -7002864369685674967
//   },
//   'name': 'Amit Patil'
// }

// Example for custom serialization of a specific field.
class ObjectWithTimestamp implements Serializable {
    private String name;
    private transient Instant timestamp;
    public ObjectWithTimestamp(final String name) {
        this.name = name;
        timestamp = Instant.now();
    }

    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(timestamp.toString());
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        timestamp = Instant.parse(in.readUTF());
    }

    @Override
    public String toString() {
        return "ObjectWithTimestamp[name=" + name + ", timestamp=" + timestamp + "]";
    }
}

class ObjectWithFieldToExclude implements Serializable {
    private String partOfState;
    private transient Object lock = new Object();
    public ObjectWithFieldToExclude(final String partOfState) {
        this.partOfState = partOfState;
    }

    //private void writeObject(final ObjectOutputStream out) throws IOException {
    //    out.defaultWriteObject();
    //}

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        lock = new Object();
    }

    @Override
    public String toString() {
        return "ObjectWithFieldToExclude[partOfState=" + partOfState + ", lock=" + lock + "]";
    }
}

class ObjectWithFieldsThatShouldNotBeSerialized implements Serializable {
    private String fieldToSerialize;
    private transient String fieldToExcludeFromSerialization;
    public ObjectWithFieldsThatShouldNotBeSerialized(final String fieldToSerialize, final String fieldToExcludeFromSerialization) {
        this.fieldToSerialize = fieldToSerialize;
        this.fieldToExcludeFromSerialization = fieldToExcludeFromSerialization;
    }

    @Override
    public String toString() {
        return "ObjectWithFieldsThatShouldNotBeSerialized[fieldToSerialize=" + fieldToSerialize + ", fieldToExcludeFromSerialization=" + fieldToExcludeFromSerialization + "]";
    }
}

class Reflect {
    public static void main(final String... args) throws Throwable {
        final Class c = Class.forName(args[0]);
        for (final Field f : c.getDeclaredFields()) {
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + " " + f.getName());
        }
    }
}

class WriteCustomer {
    public static void main(final String... args) throws IOException {
        final Customer customer = new Customer(UUID.randomUUID(), args[0]);
        final ObjectWithFieldsThatShouldNotBeSerialized o = new ObjectWithFieldsThatShouldNotBeSerialized("foo", "bar");
        final ObjectWithFieldToExclude o2 = new ObjectWithFieldToExclude("foo");
        final ObjectWithTimestamp o3 = new ObjectWithTimestamp("foo");
        try (final ObjectOutputStream out = new ObjectOutputStream(System.out)) {
            out.writeObject(customer);
            out.writeObject(o);
            System.err.println("Wrote " + o);
            out.writeObject(o2);
            System.err.println("Wrote " + o2);
            out.writeObject(o3);
            System.err.println("Wrote " + o3);
        }
    }
}

class ReadCustomer {
    public static void main(final String... args) throws IOException, ClassNotFoundException {
        try (final ObjectInputStream in = new ObjectInputStream(System.in)) {
            System.out.println(in.readObject()); // customer
            System.out.println(in.readObject()); // ObjectWithFieldsThatShouldNotBeSerialized
            System.out.println(in.readObject()); // ObjectWithFieldToExclude
            System.out.println(in.readObject()); // Should be ObjectWithTimestamp
        }
    }
}
