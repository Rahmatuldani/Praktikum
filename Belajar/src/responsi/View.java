package responsi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame{
    JFrame jFrame;

    JButton bpenumpang = new JButton("Daftar Tiket");
    JButton bkereta = new JButton("Daftar Kereta");

//    *Start Bagian Tiket
    JButton btambah_tiket = new JButton("Tambah");
    JButton bbatal_tiket = new JButton("Batal");

    JLabel nama_tiket = new JLabel("Nama");
    JLabel jk_tiket = new JLabel("Jenis kelamin");
    JLabel tujuan_tiket = new JLabel("Stasiun Tujuan");
    JLabel kereta_tiket = new JLabel("Kereta");

    JTextField fnama_tiket = new JTextField(120);
    String[] jk = {"Laki-laki","Perempuan"};
    JComboBox fjk_tiket = new JComboBox(jk);
    String[] tujuan = {};
    JComboBox ftujuan_tiket = new JComboBox(tujuan);
    String[] kereta = {};
    JComboBox fkereta_tiket = new JComboBox(kereta);

    String[] column_tiket = {"Nama","Jenis Kelamin","Stasiun","Kereta"};
    DefaultTableModel table_tiket;
    JTable jTable_tiket;
    JScrollPane jScrollPane_tiket;
//    *End Bagian Tiket

//    *Start Bagian Kereta
    JButton btambah_kereta = new JButton("Tambah");
    JButton bedit_kereta = new JButton("Edit");
    JButton bhapus_kereta = new JButton("Hapus");
    JButton bbatal_kereta = new JButton("Batal");

    JLabel nama_kereta = new JLabel("Nama");
    JLabel kelas_kereta = new JLabel("Kelas");
    JLabel tujuan_kereta = new JLabel("Tujuan");

    JTextField fnama_kereta = new JTextField(120);
    String[] kelas = {"Ekonomi","Bisnis","Eksklusif"};
    JComboBox fkelas_kereta = new JComboBox(kelas);
    JTextField ftujuan_kereta = new JTextField(120);

    String[] column_kereta = {"ID Kereta","Nama Kereta","Kelas","Tujuan"};
    DefaultTableModel table_kereta;
    JTable jTable_kereta;
    JScrollPane jScrollPane_kereta;
//    *End Bagian Kereta

    View(){
        table_tiket = new DefaultTableModel(column_tiket,0);
        jTable_tiket = new JTable(table_tiket);
        jScrollPane_tiket = new JScrollPane(jTable_tiket);
        table_kereta = new DefaultTableModel(column_kereta,0);
        jTable_kereta = new JTable(table_kereta);
        jScrollPane_kereta = new JScrollPane(jTable_kereta);
        MainView();
    }

    public JFrame MainView(){
        setTitle("Kereta Api");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setSize(500,380);
        setVisible(true);
        setLayout(null);

        JLabel judul = new JLabel("Tiket Kereta Api");
        judul.setFont(new Font("Verdana",Font.PLAIN,30));
        add(judul).setBounds(120,60,300,50);
        add(bpenumpang).setBounds(180,130,130,40);
        add(bkereta).setBounds(180,200,130,40);

        return jFrame;
    }

    public JFrame Penumpang(){
        setTitle("Kereta Api");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setSize(600,550);
        setVisible(true);
        setLayout(null);

        add(nama_tiket).setBounds(20,20,120,25);
        add(fnama_tiket).setBounds(120,20,140,25);
        add(jk_tiket).setBounds(20,55,120,25);
        add(fjk_tiket).setBounds(120,55,140,25);
        add(tujuan_tiket).setBounds(20,90,120,25);
        add(ftujuan_tiket).setBounds(120,90,140,25);
        add(kereta_tiket).setBounds(20,120,120,25);
        add(fkereta_tiket).setBounds(120,120,140,25);
        add(btambah_tiket).setBounds(280,20,120,25);
        add(bbatal_tiket).setBounds(280,55,120,25);
        add(jScrollPane_tiket).setBounds(20,180,540,300);
        return jFrame;
    }

    public JFrame Kereta(){
        setTitle("Kereta Api");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setSize(600,550);
        setVisible(true);
        setLayout(null);

        add(nama_kereta).setBounds(20,20,120,30);
        add(fnama_kereta).setBounds(120,20,140,30);
        add(kelas_kereta).setBounds(20,55,120,30);
        add(fkelas_kereta).setBounds(120,55,140,30);
        add(tujuan_kereta).setBounds(20,90,120,30);
        add(ftujuan_kereta).setBounds(120,90,140,30);
        add(btambah_kereta).setBounds(280,20,120,30);
        add(bedit_kereta).setBounds(280,55,120,30);
        add(bhapus_kereta).setBounds(280,90,120,30);
        add(bbatal_kereta).setBounds(280,130,120,30);
        add(jScrollPane_kereta).setBounds(20,180,540,300);

        return jFrame;
    }
}