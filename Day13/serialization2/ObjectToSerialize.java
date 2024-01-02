import java.io.*;

public class ObjectToSerialize implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int SOME_CONSTANT = 42;

    private String field1;
    private String field2;
    private String field3;

    public ObjectToSerialize(final String field1, final String field2, final String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public void someMethod() {
        System.out.println("Hello");
        somePrivateMethod();
        someStaticMethod();
    }

    public void someOtherMethod() {
        somePrivateMethod();
        someStaticMethod();
    }

    void somePrivateMethod() {
    }

    static void someStaticMethod() {
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (field3 == null) {
            field3 = "Default value for field3";
        }
    }

    @Override
    public String toString() {
        return "ObjectToSerialize[field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }
}
