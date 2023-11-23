// Stack and Heap
public class DefaultValues {
    // static fields are created during class loading and removed during class garbage collection
    private static byte    classFieldByte;    // (byte) 0
    private static short   classFieldShort;   // (short) 0
    private static int     classFieldInt;     // (int) 0
    private static long    classFieldLong;    // 0L
    private static char    classFieldChar;    // '\0'
    private static float   classFieldFloat;   // 0.0F
    private static double  classFieldDouble;  // 0.0
    private static boolean classFieldBoolean; // false

    // instance fields are created during object creation and removed during object garbage collection
    private byte    instanceFieldByte;
    private short   instanceFieldShort;
    private int     instanceFieldInt;
    private long    instanceFieldLong;
    private char    instanceFieldChar;
    private float   instanceFieldFloat;
    private double  instanceFieldDouble;
    private boolean instanceFieldBoolean;

    public static void main(final String... args) {
        // local variables are created when the block is executed on the stack and removed when the block exits
        byte    localByte;
        short   localShort;
        int     localInt;
        long    localLong;
        char    localChar;
        float   localFloat;
        double  localDouble;
        boolean localBoolean;
        {
            boolean anotherVariable;
            System.out.println(); // Which variables can I access at this point?
                                  // Answer: classField*, local*, anotherVariable
                                  // instanceField* can't be accessed because we're inside a static method.
        }
        System.out.println(); // Which variables can I access at that point?
                              // Answer: classField*, local*
                              // instanceField* can't be accessed because we're inside a static method.
                              // anotherVaraible can't be accessed because it's no longer in scope.
        System.out.println(classFieldInt); // Prints 0
        System.out.println(classFieldFloat); // Prints 0.0
        System.out.println(classFieldBoolean); // Prints false
        //System.out.println(localInt); // Compiler error: localInt might not have been initialized
    }
}
