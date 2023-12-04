public class Literals {
    public static void main(final String... args) {
        final String simpleString = "foobar";
        final char simpleChar = 'f';
        final String commentString = "// comment";
        final String key = "foobar";
        final String multilineString = """
            { // This looks like a comment but is part of the text block\s
                ${key}: "value\n",
                key2: "value2"
            }
            """;
        final String regularStringWithMultipleLines = "{\n    key: \"value\",\n    key2: \"value2\"\n}\n";
        final String multilineString2 = """
            {
                key: "value",
                key2: "value2"
            }
            """;
        System.out.println(multilineString2.equals(regularStringWithMultipleLines)); // true
        System.out.println(multilineString2 == regularStringWithMultipleLines); // true
        System.out.println(multilineString.charAt(2));
        System.out.println("<" + multilineString + ">");
        System.out.println("""
            <!DOCTYPE html>
            <html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml">
                <head>
                    <title>Some HTML</title>
                </head>
                <body>
                    <h1>Some HTML</h1>
                </body>
            </html>
            """);
    }
}
