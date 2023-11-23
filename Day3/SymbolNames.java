class SymbolNames {
    public static void main(final String... args) {
        // Compiler-Rules:
        // - Cannot use keyword (but can use contextual keyword)
        var var = 10;
        var ॐ  = 42; // works
        var 噸 = 4242; // works, too
        System.out.println(var);
        System.out.println(ॐ);
        System.out.println(噸);
        var $1 = 42;
        System.out.println($1);

        // Convention Rules
        // lowerCamelCase for variable and method names
        // UpperCamelCase for type names (classes, enums, interfaces, annotations, records)
        // CAPS_WITH_UNDERSCORE for compile-time-resolvable constants (primitive constants, enum constants)
    }
}
