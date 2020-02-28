package Bab8.Source;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PenampilFile extends JFrame {
    JTextArea ta;
    JButton bSave;
    ActionListener Aksi;

    public PenampilFile(){
        setTitle("Data.txt");
        setSize(340, 280);

        JPanel pn = new JPanel();
        add("North", pn);

        bSave = new JButton("Save");
        bSave.addActionListener(new Aksi());
        pn.add(bSave);

        JPanel p = new JPanel();
        add("Center", p);

        ScrollPane sp = new ScrollPane();
        sp.setPreferredSize(new Dimension(300, 200));
        p.add(sp);

        ta = new JTextArea();
        sp.add(ta);

        setDefaultCloseOperation(3);
        setVisible(true);
        bacaFile();
    }

    class Aksi implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            try {
                //karakter
                ta.write(new FileWriter("data.txt"));
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan", "Hasil", JOptionPane.INFORMATION_MESSAGE);

                //byte :
                //ta.write(new OutputStreamWriter(new FileOutputStream("data.txt")));
            } catch (IOException e) { };
        }
    }

    public void bacaFile() {
        try {
            //karakter
            ta.read(new FileReader("data.txt"), null);

            //byte :
            //ta.write(new OutputStreamReader(new FileOutputStream("data.txt")));
        } catch (IOException e) { };
    }
}

public class CobaPenampilFile {
    public static void main(String[] args) {
        new PenampilFile();
    }
}
