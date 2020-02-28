package Bab6.Source;

import java.awt.*;
import javax.swing.*;

class GLayout extends JFrame {
    JButton tombolSave, tombolEdit, tombolDelete, tombolOpen;

    public GLayout() {
        setTitle("Grid Layout");

        tombolOpen = new JButton("Open");
        tombolSave = new JButton("Save");
        tombolEdit = new JButton("Edit");
        tombolDelete = new JButton("Delete");

        setLayout(new GridLayout(2,2));
        add(tombolOpen);
        add(tombolSave);
        add(tombolEdit);
        add(tombolDelete);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class CobaGridLayout {
    public static void main(String[] args) {
        GLayout g = new GLayout();
    }
}
