package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Test {
    public static void main(String[] args) {
        new Database();
    }
}

class Database extends JFrame implements ActionListener{
    JLabel lnama = new JLabel("Nama");
    JLabel lnim = new JLabel("NIM");
    JLabel lalamat = new JLabel("Alamat");
    JLabel lumur = new JLabel("Umur");
    JLabel lfakultas = new JLabel("Fakultas");
    JLabel lkelamin = new JLabel("Jenis Kelamin");

    JTextField fnama = new JTextField(20);
    JTextField fnim = new JTextField(20);
    JTextArea falamat = new JTextArea(5,20);
    JTextField fumur = new JTextField(20);

    String[] fakultas = {
            "-- Pilih Fakultas --",
            "Fakultas Industri",
            "Fakultas Fisip",
            "Fakultas Pertambangan",
            "Fakultas Perminyakan",
            "Fakultas Pertanian",
    };
    JComboBox comboBox = new JComboBox(fakultas);

    JRadioButton fp = new JRadioButton("Perempuan");
    JRadioButton fl = new JRadioButton("Laki-Laki");
    ButtonGroup buttonGroup = new ButtonGroup();

    JButton bSave = new JButton("Simpan");
    JButton bClear = new JButton("Clear");

    Statement statement;
    Connection koneksi;

    String[][] data = new String[500][5];
    String[] kolom = {"Nim", "Nama", "Jenis Kelamin", "Fakultas", "Alamat"};
    JTable table;
    JScrollPane scrollPane;
    ResultSet resultSet;

    public Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Connection", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Connection", JOptionPane.ERROR_MESSAGE);
        }

        try {
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mahasiswa");
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("kelamin");
                data[p][3] = resultSet.getString("jurusan");
                data[p][4] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dibaca!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table = new JTable(data,kolom);
        scrollPane = new JScrollPane(table);

        buttonGroup.add(fl);
        buttonGroup.add(fp);
        bSave.addActionListener(this);
        bClear.addActionListener(this);
        fl.setActionCommand("Laki-Laki");
        fp.setActionCommand("Perempuan");


        setTitle("Java Stream File dan Database");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,340);
        setVisible(true);
        setLayout(null);

        add(lnama);
        add(fnama);
        add(lnim);
        add(fnim);
        add(lkelamin);
        add(fl);
        add(fp);
        add(lfakultas);
        add(comboBox);
        add(lalamat);
        add(falamat);
        add(bSave);
        add(bClear);
        add(scrollPane);

        lnama.setBounds(10,10,100,20);
        fnama.setBounds(140,10,180,20);
        lnim.setBounds(10,40,100,20);
        fnim.setBounds(140,40,180,20);
        lkelamin.setBounds(10,70,100,20);
        fl.setBounds(140,70,120,20);
        fp.setBounds(140,100,120,20);
        lfakultas.setBounds(10,130,100,20);
        comboBox.setBounds(140,130,180,20);
        lalamat.setBounds(10,160,100,20);
        falamat.setBounds(140,160,180,80);
        bSave.setBounds(30,260,120,20);
        bClear.setBounds(190,260,120,20);
        scrollPane.setBounds(340,10,620,280);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bSave){
            int jawab = JOptionPane.showConfirmDialog(this,
                    "Apakah data yang akan anda simpan sudah benar?\n" +
                            "Nama  :  " + fnama.getText() +
                            "\nNIM  :  " + fnim.getText() +
                            "\nJenis Kelamin  : " + buttonGroup.getSelection().getActionCommand() +
                            "\nAlamat  :  " + falamat.getText() +
                            "\nFakultas  :  " + comboBox.getSelectedItem().toString());

            switch (jawab) {
                case JOptionPane.YES_OPTION:
                    String nama = fnama.getText();
                    String nim = fnim.getText();
                    String kelamin = buttonGroup.getSelection().getActionCommand();
                    String alamat = falamat.getText();
                    String fakultas = comboBox.getSelectedItem().toString();
                    try {
                        statement = koneksi.createStatement();
                        statement.executeQuery("INSERT INTO mahasiswa VALUES("+ nim +","+ nama +","+ alamat +","+ fakultas +","+ kelamin +")");
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Save", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case JOptionPane.NO_OPTION:
                    break;

                case JOptionPane.CANCEL_OPTION:
                    break;
            }
        }
        if (actionEvent.getSource() == bClear){
            fnama.setText("");
            fnim.setText("");
            falamat.setText("");
            buttonGroup.clearSelection();
            comboBox.setSelectedIndex(0);
        }
    }
}
