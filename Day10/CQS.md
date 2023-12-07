# CQS

Command Query Separation

Good functions or methods are either
- commands, that is, they have side-effects but no return values, that is, they are void
or
- queries, that is, they do not have side-effects, but they do return values.

```
class Customer {
    private final UUID id;
    private String firstname;
    private String lastname;

    public Customer(final UUID uuid, final String firstname, final String lastname) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }
}
```

```
class Dimension {
    private int width;
    private int height;
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}

class Button {
    private Dimension size = new Dimension(50, 50);
    public Dimension getSize() {
        return size; // No defensive cloning, button can break
        return new Dimension(size.getWidth(), size.getHeight()); // Defensive cloning
    }
}

class SomeProgram {
    public static void main(final String... args) {
        Button b1 = new Button("Cancel");
        Button b2 = new Button("Ok");
        Dimension size = b1.getSize();
        size.setHeight(100); // b1 protected itself against this unwanted change using defensive cloning
        b2.setSize(size);
    }
}
```

```
class Dimension {
    private final int width;
    private final int height;
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

class Button {
    private Dimension size = new Dimension(50, 50);
    public Dimension getSize() {
        return size;
    }
    public void setSize() {
        this.size = size;
    }
}

class SomeProgram {
    public static void main(final String... args) {
        Button b1 = new Button("Cancel");
        Button b2 = new Button("Ok");
        Dimension size = b1.getSize();
        size = new Dimension(size.getWidth(), 100);
        b2.setSize(size);
    }
}
```

```
record Dimension(int width, int height) {}

class Button {
    private Dimension size = new Dimension(50, 50);
    public Dimension getSize() {
        return size;
    }
    public void setSize() {
        this.size = size;
    }
}

class SomeProgram {
    public static void main(final String... args) {
        Button b1 = new Button("Cancel");
        Button b2 = new Button("Ok");
        Dimension size = b1.getSize();
        size = new Dimension(size.width(), 100);
        b2.setSize(size);
    }
}
```
