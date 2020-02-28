package Bab7.Source;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RadioHandling extends JFrame implements ItemListener {
    private JTextField text;
    private JPanel panel;
    private JRadioButton rbtn1;
    private JRadioButton rbtn2;

    public RadioHandling() {
        setTitle("Coba RadioButton Handling");
        text = new JTextField("Jenis Kelamin : PILIHAN");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel = new JPanel(new FlowLayout());
        rbtn1 = new JRadioButton("Pria");
        rbtn2 = new JRadioButton("Wanita");

        ButtonGroup group = new ButtonGroup();
        group.add(rbtn1);
        group.add(rbtn2);
        rbtn1.addItemListener(this);
        rbtn2.addItemListener(this);

        setLayout(new BorderLayout());
        add(text,"North");
        add(panel,"West");
        panel.add(rbtn1);
        panel.add(rbtn2);

        pack();
        setVisible(true);
        setLocation(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent event) {
        if (event.getSource() == rbtn1) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                text.setText("Jenis Kelamin : Pria");
            }
        }
        if (event.getSource() == rbtn2) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                text.setText("Jenis Kelamin : Wanita");
            }
        }
    }
}

public class EventRadio {
    public static void main(String[] args) {
        new RadioHandling();
    }
}
