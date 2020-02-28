package Bab8.Source;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PenampilFileJFileChooser extends JFrame {
    JTextArea ta;
    JButton bSave, bOpen, bNew;
    ActionListener Aksi;
    private JFileChooser fc;
    private String alamat;

    public PenampilFileJFileChooser() {
        setTitle("Data.txt");
        setSize(340,280);

        JPanel pn = new JPanel(new FlowLayout());
        add("North", pn);

        bSave = new JButton("Save");
        bOpen = new JButton("Open");
        bNew = new JButton("New");
        bSave.addActionListener(new Aksi());
        bOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacaFile();
            }
        });

        bNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ta.setText("");
            }
        });
        pn.add(bSave);
        pn.add(bOpen);
        pn.add(bNew);

        JPanel p = new JPanel();
        add("Center", p);
        ScrollPane sp = new ScrollPane();
        sp.setPreferredSize(new Dimension(300,200));
        p.add(sp);

        ta = new JTextArea();
        sp.add(ta);

        setDefaultCloseOperation(3);
        setVisible(true);
    }

    class Aksi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ta.write(new FileWriter(alamat));
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) { }
        }
    }

    public void bacaFile() {
        try {
            fc = new JFileChooser();
            int pilihan = fc.showOpenDialog(null);

//            int pilihan = fc.showSaveDialog(null);
            if (pilihan == JFileChooser.APPROVE_OPTION) {
                alamat = fc.getSelectedFile().getPath();
                ta.read(new FileReader(alamat), null);
                System.out.println(alamat);
            } else {
                return;
            }
        } catch (IOException e) {  }
    }
}

public class CobaPenampilFileJFileChooser {
    public static void main(String[] args) {
        new PenampilFileJFileChooser();
    }
}
