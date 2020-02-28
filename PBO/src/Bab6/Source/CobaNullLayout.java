package Bab6.Source;

import java.awt.*;
import javax.swing.*;

class NLayout extends JFrame {
    JButton tombolSave, tombolEdit, tombolDelete, tombolOpen;

    public NLayout() {
        setTitle("Null Layout");

        tombolOpen = new JButton("Open");
        tombolSave = new JButton("Save");
        tombolEdit = new JButton("Edit");
        tombolDelete = new JButton("Delete");

        setLayout(null);
        add(tombolOpen);
        add(tombolSave);
        add(tombolEdit);
        add(tombolDelete);

        tombolOpen.setBounds(10,10,150,20);
        tombolSave.setBounds(150,15,150,20);
        tombolEdit.setBounds(100,30,150,20);
        tombolDelete.setBounds(40,50,150,20);

        setSize(350,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class CobaNullLayout {
    public static void main(String[] args) {
        NLayout n = new NLayout();
    }
}
