import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InputDataMahasiswa extends JFrame{

    JLabel lNim, lNama, lAlamat;
    JTextField tfNim, tfNama, tfAlamat;
    JButton bSimpan;
    JPanel panelForm, panelTombol;
    String DBurl = "jdbc:mysql://localhost:3306/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public InputDataMahasiswa() {
        setTitle("Coba Database!");
        setSize(400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        lNim = new JLabel("NIM");
        lNama = new JLabel("Nama");
        lAlamat = new JLabel("Alamat");
        tfNim = new JTextField(9);
        tfNama= new JTextField(50);
        tfAlamat = new JTextField(50);
        bSimpan = new JButton("Save");
        panelForm = new JPanel(new GridLayout(4,4));
        panelTombol = new JPanel(new FlowLayout());

        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(lNim);
        panelForm.add(tfNim);
        panelForm.add(lNama);
        panelForm.add(tfNama);
        panelForm.add(lAlamat);
        panelForm.add(tfAlamat);
        add(panelTombol, BorderLayout.SOUTH);
        panelForm.add(bSimpan);

        bSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                masukkanData();
            }
        });
    }

    public void masukkanData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("INSERT INTO mahasiswa VALUES(" + tfNim.getText() + "," + tfNama.getText() + "," + tfAlamat.getText() + ")");
            JOptionPane.showMessageDialog(null, "Data berhasil Disimpan", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new InputDataMahasiswa();
    }
}
