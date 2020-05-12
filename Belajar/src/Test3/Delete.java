package Test3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnim;
    JTextField fnim;
    JButton bDelete, bCancel;

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
            setVisible(false);
            controller.Delete(Integer.parseInt(fnim.getText()));
        }
        if (actionEvent.getSource() == bCancel) {
            setVisible(false);
            new View();
        }
    }
}
