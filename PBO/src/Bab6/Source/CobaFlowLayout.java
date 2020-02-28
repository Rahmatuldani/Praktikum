package Bab6.Source;

import java.awt.*;
import javax.swing.*;

class FLayout extends JFrame {
    JButton tombolSave, tombolEdit, tombolDelete, tombolOpen;

    public FLayout() {
        setTitle("Flow Layout");

        tombolOpen = new JButton("Open");
        tombolSave = new JButton("Save");
        tombolEdit = new JButton("Edit");
        tombolDelete = new JButton("Delete");

        setLayout(new FlowLayout());
        add(tombolOpen);
        add(tombolSave);
        add(tombolEdit);
        add(tombolDelete);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class CobaFlowLayout {
    public static void main(String[] args) {
        FLayout f = new FLayout();
    }
}
