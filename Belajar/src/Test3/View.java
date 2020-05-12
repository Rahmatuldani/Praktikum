package Test3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RescaleOp;
import java.sql.*;

public class View extends JFrame implements ActionListener{
    Controller controller = new Controller();

    JScrollPane scrollPane;
    JTable table;
    JButton bSimpan, bEdit, bDelete, bDeleteall;
    Connection koneksi;
    Statement statement;

    Object[][] data;
    String[] kolom = {"NIM", "Nama", "Jenis Kelamin", "Jurusan", "Alamat"};

    public View(){
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,400);
        setLayout(null);
        setLocationRelativeTo(null);

        data = controller.Data();
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
            setVisible(false);
            new Simpan();
        }
        if (actionEvent.getSource() == bEdit) {
            setVisible(false);
            new Edit();
        }
        if (actionEvent.getSource() == bDelete) {
            setVisible(false);
            new Delete();
        }
        if (actionEvent.getSource() == bDeleteall) {
            int p = JOptionPane.showConfirmDialog(null,"Apa anda yakin ingin menghapus semuanya?","Delete All",JOptionPane.YES_NO_OPTION);

            switch (p) {
                case JOptionPane.YES_OPTION :
                    setVisible(false);
                    controller.DeleteAll();
                    break;

                case JOptionPane.NO_OPTION :
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new View();
    }
}