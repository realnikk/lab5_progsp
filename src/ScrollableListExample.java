import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollableListExample extends JFrame {
    private JList<String> myList;
    private DefaultListModel<String> listModel;

    public ScrollableListExample() {
        setTitle("Scrollable List Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        listModel = new DefaultListModel<>();
        myList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(myList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 200, 150); // Установка координат и размеров панели прокрутки
        add(scrollPane);

        JButton addButton = new JButton("Add Item");
        addButton.setBounds(10, 170, 100, 30); // Установка координат и размеров кнопки
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = "Item " + (listModel.size() + 1);
                listModel.addElement(newItem);
            }
        });
        add(addButton);

        setSize(250, 250);
        //setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrollableListExample example = new ScrollableListExample();
            example.setVisible(true);
        });
    }
}