package Test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RescaleOp;
import java.sql.*;

public class Awal {
    public static void main(String[] args) {
        new TAwal();
    }
}

class TAwal extends JFrame implements ActionListener {
    JScrollPane scrollPane;
    JTable table;
    JButton bSimpan, bEdit, bDelete, bDeleteall;
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    String[][] data = new String[50][5];
    String[] kolom = {"NIM", "Nama", "Jenis Kelamin", "Jurusan", "Alamat"};

    public TAwal(){
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,400);
        setLayout(null);
        setLocationRelativeTo(null);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mahasiswa");
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("kelamin");
                data[p][3] = resultSet.getString("jurusan");
                data[p][4] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Driver tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table = new JTable(data,kolom);
        scrollPane = new JScrollPane(table);

        bSimpan = new JButton("Insert");
        bEdit = new JButton("Edit");
        bDelete = new JButton("Delete");
        bDeleteall = new JButton("Delete All");

        bSimpan.addActionListener(this);
        bEdit.addActionListener(this);
        bDeleteall.addActionListener(this);
        bDelete.addActionListener(this);

        add(scrollPane);
        add(bSimpan);
        add(bEdit);
        add(bDelete);
        add(bDeleteall);

        scrollPane.setBounds(20,20,600,320);
        bSimpan.setBounds(640,40,120,50);
        bEdit.setBounds(640,100,120,50);
        bDelete.setBounds(640,160,120,50);
        bDeleteall.setBounds(640,220,120,50);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bSimpan) {
//            JOptionPane.showMessageDialog(null,"Button Simpan", "Action", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Simpan();
        }
        if (actionEvent.getSource() == bEdit) {
//            JOptionPane.showMessageDialog(null,"Button Edit", "Action", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Edit();
        }
        if (actionEvent.getSource() == bDelete) {
//            JOptionPane.showMessageDialog(null,"Button Delete", "Action", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Delete();
        }
        if (actionEvent.getSource() == bDeleteall) {
            int p = JOptionPane.showConfirmDialog(this,"Anda yakin ingin mengapus semua data?", "Delete All Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            switch (p) {
                case JOptionPane.YES_OPTION:
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
                        statement = koneksi.createStatement();
                        statement.executeUpdate("DELETE FROM mahasiswa");
                        JOptionPane.showMessageDialog(null,"Data Berhasil Hapus", "Done", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                        koneksi.close();
                        setVisible(false);
                        new TAwal();
                    } catch (SQLException e){
                        JOptionPane.showMessageDialog(null,"Data Gagal Disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null,"Driver tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }
}