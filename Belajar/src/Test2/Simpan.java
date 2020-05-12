package Test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Simpan extends JFrame implements ActionListener {
//    public static void main(String[] args) {
//        new Simpan();
//    }
    JLabel lnama, lnim, lkelamin, ljurusan, lalamat;
    JTextField fnama, fnim;
    JTextArea falamat;
    JRadioButton fl, fp;
    JComboBox comboBox;
    ButtonGroup buttonGroup;
    JScrollPane scrollPane;
    JButton bSave, bCancel;

    Connection koneksi;
    Statement statement;

    public Simpan(){
        lnama = new JLabel("Nama");
        lnim = new JLabel("NIM");
        lkelamin = new JLabel("Jenis Kelamin");
        ljurusan = new JLabel("Fakultas");
        lalamat = new JLabel("Alamat");

        fnama = new JTextField(120);
        fnim = new JTextField(120);
        falamat = new JTextArea(3,10);
        scrollPane = new JScrollPane(falamat);

        buttonGroup = new ButtonGroup();
        fl = new JRadioButton("Laki-laki");
        fl.setActionCommand("Laki-Laki");
        fp = new JRadioButton("Perempuan");
        fp.setActionCommand("Perempuan");
        buttonGroup.add(fl);
        buttonGroup.add(fp);

        bSave = new JButton("Save");
        bCancel = new JButton("Cancel");

        bSave.addActionListener(this);
        bCancel.addActionListener(this);

        String[] fakultas = {
                "-- Pilih Fakultas --",
                "Fakultas Industri",
                "Fakultas Fisip",
                "Fakultas Pertambangan",
                "Fakultas Perminyakan",
                "Fakultas Pertanian",
        };
        comboBox = new JComboBox(fakultas);

        setTitle("Simpan data mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(380,360);
        setLayout(null);
        setLocationRelativeTo(null);

        add(lnim);
        add(fnim);
        add(lnama);
        add(fnama);
        add(lkelamin);
        add(fl);
        add(fp);
        add(ljurusan);
        add(comboBox);
        add(lalamat);
        add(scrollPane);
        add(bSave);
        add(bCancel);

        lnim.setBounds(20,20,120,20);
        fnim.setBounds(140,20,200,20);
        lnama.setBounds(20,50,120,20);
        fnama.setBounds(140,50,200,20);
        lkelamin.setBounds(20,80,120,20);
        fl.setBounds(140,80,200,20);
        fp.setBounds(140,110,200,20);
        ljurusan.setBounds(20,140,200,20);
        comboBox.setBounds(140,140,200,20);
        lalamat.setBounds(20,170,200,20);
        scrollPane.setBounds(140,170,200,80);
        bSave.setBounds(40,270,120,30);
        bCancel.setBounds(200,270,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bSave) {
            String nama = fnama.getText();
            String nim = fnim.getText();
            String alamat = falamat.getText();
            String kelamin = buttonGroup.getSelection().getActionCommand();
            String jurusan = comboBox.getSelectedItem().toString();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
                statement = koneksi.createStatement();
                statement.executeUpdate("INSERT INTO mahasiswa VALUES('"+ nim +"','"+ nama +"','"+ alamat +"','"+ jurusan +"','"+ kelamin +"') ");
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Done", JOptionPane.INFORMATION_MESSAGE);
                statement.close();
                koneksi.close();
                setVisible(false);
                new TAwal();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,"Driver tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new TAwal();
        }
    }
}
