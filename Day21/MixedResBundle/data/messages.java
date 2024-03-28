package data;

import java.util.ListResourceBundle;

public class messages extends ListResourceBundle {
    public Object[][] getContents() {
        return new Object[][] {
            { "message", "Class messages: Hello, world!" },
            { "m2", "Class messages: m2" },
        };
    }
}
