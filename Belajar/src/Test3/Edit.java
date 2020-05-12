package Test3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnama, lkelamin, ljurusan, lalamat, olnim;
    JTextField fnama, ofnim;
    JTextArea falamat;
    JRadioButton fl, fp;
    JComboBox comboBox;
    ButtonGroup buttonGroup;
    JScrollPane scrollPane;
    JButton bSave, bCancel, bCari;

    Object[][] data = new Object[50][8];

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
            data = controller.Find(Integer.parseInt(ofnim.getText()));

            fnama.setText(data[0][1].toString());
            falamat.setText(data[0][2].toString());
            comboBox.setSelectedItem(data[0][3].toString());
            if (fl.getActionCommand().equals(data[0][4].toString())){
                fl.setSelected(true);
            } else {
                fp.setSelected(false);
            }
        }
        if (actionEvent.getSource() == bSave) {
            int nim = Integer.parseInt(ofnim.getText());
            data[0][0] = fnama.getText();
            data[0][1] = falamat.getText();
            data[0][2] = comboBox.getSelectedItem().toString();
            data[0][3] = buttonGroup.getSelection().getActionCommand();
            setVisible(false);

//            JOptionPane.showMessageDialog(null,data,"done",JOptionPane.INFORMATION_MESSAGE);
            controller.Update(data,nim);
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new View();
        }
    }
}
