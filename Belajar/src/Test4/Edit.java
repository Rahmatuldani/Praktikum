package Test4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnama, lhp, lumur, lemail;
    JTextField fnama, fhp, fumur, femail;
    JButton bSave, bCancel, bCari;

    Object[][] data = new Object[50][8];

    public Edit(){
        lnama = new JLabel("Masukan nama");
        lhp = new JLabel("No HP");
        lumur = new JLabel("Umur");
        lemail = new JLabel("Email");

        fnama = new JTextField(120);
        fhp = new JTextField(120);
        fumur = new JTextField(120);
        femail = new JTextField(120);

        bSave = new JButton("Save");
        bCancel = new JButton("Cancel");
        bCari = new JButton("Cari");

        bSave.addActionListener(this);
        bCari.addActionListener(this);
        bCancel.addActionListener(this);

        setTitle("Edit data contact");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(380,330);
        setLayout(null);
        setLocationRelativeTo(null);

        add(lnama);
        add(fnama);
        add(bCari);
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
        bCari.setBounds(190,60,120,30);
        lhp.setBounds(20,140,120,20);
        fhp.setBounds(140,140,200,20);
        lumur.setBounds(20,170,120,20);
        fumur.setBounds(140,170,200,20);
        femail.setBounds(140,200,200,20);
        lemail.setBounds(20,200,200,20);
        bSave.setBounds(40,240,120,30);
        bCancel.setBounds(200,240,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bCari) {
            data = controller.Find(fnama.getText());

//            JOptionPane.showMessageDialog(null,data[0][1],"done",JOptionPane.INFORMATION_MESSAGE);
            fhp.setText(data[0][1].toString());
            fumur.setText(data[0][2].toString());
            femail.setText(data[0][3].toString());
        }
        if (actionEvent.getSource() == bSave) {
            String nama = fnama.getText();
            data[0][0] = fnama.getText();
            data[0][1] = fhp.getText();
            data[0][2] = fumur.getText();
            data[0][3] = femail.getText();
            setVisible(false);

//            JOptionPane.showMessageDialog(null,data,"done",JOptionPane.INFORMATION_MESSAGE);
            controller.Update(data,nama);
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new View();
        }
    }
}
