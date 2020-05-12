package Test4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnama;
    JTextField fnama;
    JButton bDelete, bCancel;

    public Delete(){
        setTitle("Hapus data contact");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(350,150);
        setLayout(null);
        setLocationRelativeTo(null);

        lnama = new JLabel("Nama");
        fnama = new JTextField(10);
        bDelete = new JButton("Delete");
        bCancel = new JButton("Cancel");

        bDelete.addActionListener(this);
        bCancel.addActionListener(this);

        add(lnama);
        add(fnama);
        add(bDelete);
        add(bCancel);

        lnama.setBounds(20,20,120,20);
        fnama.setBounds(140,20,180,20);
        bDelete.setBounds(30,60,120,30);
        bCancel.setBounds(180,60,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bDelete) {
            setVisible(false);
            controller.Delete(fnama.getText());
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new View();
        }
    }
}
