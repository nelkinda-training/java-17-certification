import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {
    public static void main(final String... args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        final Class<?> c = Class.forName(args[0]);
        for (final Method method : c.getMethods()) {
            System.out.println(method);
            if (method.getName().equals("toString")) {
                method.invoke(null);
                ((Object) null).toString();
            }
        }
    }
}
