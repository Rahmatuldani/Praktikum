package Test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Edit extends JFrame implements ActionListener {
//        public static void main(String[] args) {
//        new Edit();
//    }
    JLabel lnama, lkelamin, ljurusan, lalamat, olnim;
    JTextField fnama, ofnim;
    JTextArea falamat;
    JRadioButton fl, fp;
    JComboBox comboBox;
    ButtonGroup buttonGroup;
    JScrollPane scrollPane;
    JButton bSave, bCancel, bCari;

    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    String[] data = new String[5];
    String[] kolom = {"NIM", "Nama", "Jenis Kelamin", "Jurusan", "Alamat"};

    public Edit(){
        olnim = new JLabel("Masukan NIM");
        lnama = new JLabel("Nama");
        lkelamin = new JLabel("Jenis Kelamin");
        ljurusan = new JLabel("Fakultas");
        lalamat = new JLabel("Alamat");

        ofnim = new JTextField(120);
        fnama = new JTextField(120);
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
        bCari = new JButton("Cari");

        bSave.addActionListener(this);
        bCari.addActionListener(this);
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

        setTitle("Edit data mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(380,470);
        setLayout(null);
        setLocationRelativeTo(null);

        add(olnim);
        add(ofnim);
        add(bCari);
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

        olnim.setBounds(20,20,120,20);
        ofnim.setBounds(140,20,200,20);
        bCari.setBounds(190,50,120,30);
        lnama.setBounds(20,140,120,20);
        fnama.setBounds(140,140,200,20);
        lkelamin.setBounds(20,170,120,20);
        fl.setBounds(140,170,200,20);
        fp.setBounds(140,200,200,20);
        ljurusan.setBounds(20,230,200,20);
        comboBox.setBounds(140,230,200,20);
        lalamat.setBounds(20,260,200,20);
        scrollPane.setBounds(140,260,200,80);
        bSave.setBounds(40,380,120,30);
        bCancel.setBounds(200,380,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bCari) {
            String cari = ofnim.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
                statement = koneksi.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM mahasiswa WHERE nim = '"+ cari +"'");
                while (resultSet.next()){
                    data[0] = resultSet.getString("nim");
                    data[1] = resultSet.getString("nama");
                    data[2] = resultSet.getString("kelamin");
                    data[3] = resultSet.getString("jurusan");
                    data[4] = resultSet.getString("alamat");
                }
                statement.close();
                koneksi.close();

                if (data == null){
                    JOptionPane.showConfirmDialog(null, "Data tidak ditemukan", "Database", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    fnama.setText(data[1]);
                    if (fl.getActionCommand().equals(data[2])){
                        fl.setSelected(true);
                    } else {
                        fp.setSelected(false);
                    }
                    comboBox.setSelectedItem(data[3]);
                    falamat.setText(data[4]);
                }
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,"Driver tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (actionEvent.getSource() == bSave) {
            String nama = fnama.getText();
            String nim = data[0];
            String alamat = falamat.getText();
            String kelamin = buttonGroup.getSelection().getActionCommand();
            String jurusan = comboBox.getSelectedItem().toString();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
                statement = koneksi.createStatement();
                statement.executeUpdate("UPDATE mahasiswa SET nama = '"+ nama +"', alamat = '"+ alamat +"', jurusan = '"+ jurusan +"', kelamin = '"+ kelamin +"' WHERE nim = '"+ nim +"'");
                JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate", "Done", JOptionPane.INFORMATION_MESSAGE);
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
