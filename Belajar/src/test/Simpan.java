package test;

import javax.swing.*;
import java.awt.event.*;

public class Simpan extends JFrame implements ActionListener {

    public Simpan(String nama, String nim, String kelamin, String alamat, String fakultas){
        JOptionPane.showMessageDialog(null,nim + ",\n" + nama + ",\n " + kelamin + ",\n " + alamat + ",\n " + fakultas, "Hasil", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
