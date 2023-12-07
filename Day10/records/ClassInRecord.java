class Class {
    private int x;
    public Class(int x) {
        this.x = x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
}

// This record is mutable via a "backdoor". That is dangerous.
// Recommendation: Only use record fields that are the following:
// - Primitives (boolean, byte, short, int, long, char, float, double)
// - Wrappers (Boolean, Byte, Short, Integer, Long, Character, Float, Double)
// - Strings (String)
// - Enum constants
// - Other records
record Record(Class c) {
}
