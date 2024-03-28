package data;

import java.util.ListResourceBundle;

public class messages extends ListResourceBundle {
    public Object[][] getContents() {
        return new Object[][] {
            { "message", "Hello, world!" }
        };
    }
}
