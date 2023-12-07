import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;

public class Lists {
    public static void main(final String... args) {
        final DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("java.awt");
        listModel.addElement("java.util");
        listModel.addElement("javax.swing");

        listModel.addListDataListener(new ListDataListener() {
            @Override
            public void contentsChanged(final ListDataEvent e) {
                System.out.println("contentsChanged()");
                System.out.println(e);
            }
            @Override
            public void intervalAdded(final ListDataEvent e) {
                System.out.println("intervalAdded()");
                System.out.println(e);
            }
            @Override
            public void intervalRemoved(final ListDataEvent e) {
                System.out.println("intervalRemoved()");
                System.out.println(e);
            }
        });

        for (int i = 0; i < 2; i++) {
            final JFrame jframe = new JFrame("List");
            final JList<String> list = new JList<>(listModel);
            final JButton addButton = new JButton("Add");
            addButton.addActionListener(event -> {
                listModel.addElement("New Entry");
            });
            jframe.add(addButton, BorderLayout.SOUTH);
            jframe.add(new JScrollPane(list));
            jframe.pack();
            jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jframe.setVisible(true);
        }
    }
}
