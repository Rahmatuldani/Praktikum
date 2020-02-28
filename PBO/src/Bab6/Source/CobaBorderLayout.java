package Bab6.Source;

import java.awt.*;
import javax.swing.*;

class BLayout extends JFrame {
    JButton tombolSave, tombolEdit, tombolDelete, tombolOpen;
    JLabel labelGambar;

    public BLayout() {
        setTitle("Border Layout");

        tombolOpen = new JButton("Open");
        tombolSave = new JButton("Save");
        tombolEdit = new JButton("Edit");
        tombolDelete = new JButton("Delete");

        labelGambar = new JLabel(new ImageIcon(getClass().getResource("image/Gambar.jpg")));

        setLayout(new BorderLayout());
        add(tombolOpen, "North");
        add(tombolSave, "West");
        add(labelGambar, "Center");
        add(tombolEdit, "East");
        add(tombolDelete, "South");

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class CobaBorderLayout {
    public static void main(String[] args) {
        BLayout b = new BLayout();
    }
}
