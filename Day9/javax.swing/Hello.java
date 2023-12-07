import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello {
    private static final JFrame frame = new JFrame("Hello");
    private static final ActionListener ok = e -> frame.dispose();

    public static void main(final String... args) {
        final JLabel hello = new JLabel("Hello, world!");
        frame.add(hello);
        final JButton ok = new JButton("OK");

        ok.addActionListener(Hello::ok);

        frame.add(ok, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    static void ok(ActionEvent e) {
        System.err.println("OK clicked");
        frame.dispose();
    }
}
