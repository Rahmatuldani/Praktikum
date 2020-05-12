package Bab11.Tugas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class View extends JFrame implements ActionListener,Listener {
    Controller controller = new Controller();
    Model model = new Model();

    JLabel lid = new JLabel("ID Barang");
    JLabel lnama = new JLabel("Nama Barang");
    JLabel lharga = new JLabel("Harga");
    JLabel ljumlah = new JLabel("Jumlah");

    JTextField fid = new JTextField(100);
    JTextField fnama = new JTextField(100);
    JTextField fharga = new JTextField(100);
    JTextField fjumlah = new JTextField(100);
    JTextField total = new JTextField("0",100);

    JButton bSave = new JButton("Tambah");
    JButton bFind = new JButton("Cari");
    JButton bEdit = new JButton("Edit");
    JButton bDelete = new JButton("Delete");

    Object[][] data;
    JPanel panel = new JPanel();
    JTable table;
    JScrollPane scrollPane;
    String[] column = {"No","ID Barang","Nama Barang","Harga","Jumlah","Total"};

    public View(){
        setTitle("MVC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setLayout(null);

        model.setListener(this);
        controller.setModel(model);
        controller.read();
        data = controller.getData();

        total.setFont(new Font("SansSerif",Font.PLAIN,90));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setEditable(false);

        bSave.addActionListener(this);

        panel.add(lid);
        panel.add(fid);
        panel.add(lnama);
        panel.add(fnama);
        panel.add(lharga);
        panel.add(fharga);
        panel.add(ljumlah);
        panel.add(fjumlah);
        panel.add(total);
        panel.add(bSave);
        panel.add(bFind);
        panel.add(bEdit);
        panel.add(bDelete);

        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.cyan);

        table = new JTable(data,column);
        scrollPane = new JScrollPane(table);
        add(scrollPane);

        panel.setBounds(20,20,1500,200);
        lid.setBounds(10,10,120,20);
        fid.setBounds(140,10,160,20);
        lnama.setBounds(10,40,120,20);
        fnama.setBounds(140,40,160,20);
        lharga.setBounds(10,70,120,20);
        fharga.setBounds(140,70,160,20);
        ljumlah.setBounds(10,100,120,20);
        fjumlah.setBounds(140,100,160,20);
        bSave.setBounds(20,140,80,30);
        bFind.setBounds(110,140,80,30);
        bEdit.setBounds(200,140,80,30);
        bDelete.setBounds(290,140,80,30);
        total.setBounds(430,20,1050,120);
        scrollPane.setBounds(20,230,1500,600);
    }

    public JTextField getFid() {
        return fid;
    }

    public JTextField getFnama() {
        return fnama;
    }

    public JTextField getFharga() {
        return fharga;
    }

    public JTextField getFjumlah() {
        return fjumlah;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bSave){
//            controller.create(this);
            JOptionPane.showMessageDialog(null,"bsave","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onChange(Model model) {

    }

    public static void main(String[] args)
    {
        new View();
    }
}