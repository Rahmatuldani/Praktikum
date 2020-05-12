package Test4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simpan extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnama, lhp, lumur, lemail;
    JTextField fnama, fhp, fumur, femail;
    JButton bSave, bCancel;

    Object[][] data = new Object[50][8];

    public Simpan(){
        lnama = new JLabel("Nama");
        lhp = new JLabel("No HP");
        lumur = new JLabel("Umur");
        lemail = new JLabel("Email");

        fnama = new JTextField(120);
        fhp = new JTextField(120);
        fumur = new JTextField(120);
        femail = new JTextField(120);

        bSave = new JButton("Save");
        bCancel = new JButton("Cancel");

        bSave.addActionListener(this);
        bCancel.addActionListener(this);

        setTitle("Simpan data contact");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(380,250);
        setLayout(null);
        setLocationRelativeTo(null);

        add(lnama);
        add(fnama);
        add(lhp);
        add(fhp);
        add(lumur);
        add(fumur);
        add(lemail);
        add(femail);
        add(bSave);
        add(bCancel);

        lnama.setBounds(20,20,120,20);
        fnama.setBounds(140,20,200,20);
        lhp.setBounds(20,50,120,20);
        fhp.setBounds(140,50,200,20);
        lumur.setBounds(20,80,120,20);
        fumur.setBounds(140,80,200,20);
        femail.setBounds(140,110,200,20);
        lemail.setBounds(20,110,200,20);
        bSave.setBounds(40,160,120,30);
        bCancel.setBounds(200,160,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bSave) {
            data[0][0] = fnama.getText();
            data[0][1] = fhp.getText();
            data[0][2] = fumur.getText();
            data[0][3] = femail.getText();

//            JOptionPane.showMessageDialog(null,data, "Done", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            controller.Create(data);
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new View();
        }
    }
}
