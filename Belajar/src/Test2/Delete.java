package Test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame implements ActionListener {
//    public static void main(String[] args) {
//        new Delete();
//    }
    JLabel lnim;
    JTextField fnim;
    JButton bDelete, bCancel;

    Connection koneksi;
    Statement statement;

    public Delete(){
        setTitle("Hapus data mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(350,150);
        setLayout(null);
        setLocationRelativeTo(null);

        lnim = new JLabel("NIM");
        fnim = new JTextField(10);
        bDelete = new JButton("Delete");
        bCancel = new JButton("Cancel");

        bDelete.addActionListener(this);
        bCancel.addActionListener(this);

        add(lnim);
        add(fnim);
        add(bDelete);
        add(bCancel);

        lnim.setBounds(20,20,120,20);
        fnim.setBounds(140,20,180,20);
        bDelete.setBounds(30,60,120,30);
        bCancel.setBounds(180,60,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bDelete) {
            String nim = fnim.getText();
            int pilih = JOptionPane.showConfirmDialog(null,"Anda yakin ingin menghapus data ini?","Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            switch (pilih) {
                case JOptionPane.YES_OPTION:
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
                        statement = koneksi.createStatement();
                        statement.executeUpdate("DELETE FROM mahasiswa WHERE nim = '"+ nim +"'");
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
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new TAwal();
        }
    }
}
