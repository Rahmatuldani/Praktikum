package Bab7.Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ComboBoxHandling extends JFrame implements ItemListener {
    private String status[] = {"Setuju", "Batal"};
    private JTextField text;
    private JComboBox cbStatus;

    public ComboBoxHandling() {
        super("Coba ComboBox Handling");

        text = new JTextField("Status : None");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        cbStatus = new JComboBox(status);
        cbStatus.addItemListener(this);

        setLayout(new BorderLayout());
        add(text, "North");
        add(cbStatus, "South");

        pack();
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            if (cbStatus.getSelectedIndex() == 0) {
                text.setText("Setuju");
            } else if (cbStatus.getSelectedIndex() == 1) {
                text.setText("Batal");
            }
        }
    }
}

public class EventComboBox {
    public static void main(String[] args) {
        new ComboBoxHandling();
    }
}
