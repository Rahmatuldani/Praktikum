package Bab5.Tugas;

import javax.swing.*;

public class Login {
    public static void main(String[] args) {
        TampilLogin t = new TampilLogin();
    }
}

class TampilLogin extends JFrame {
    final JTextField fuser = new JTextField(20);
    final JTextField fpass = new JTextField(20);

    JLabel luser = new JLabel("Username ");
    JLabel lpass = new JLabel("Password ");

    JButton btnLogin = new JButton("Login");
    JButton btnCancel = new JButton("Cancel");

    public TampilLogin(){
        setTitle("Login");
        setDefaultCloseOperation(3);
        setSize(350,180);

        setLayout(null);
        add(luser);
        add(fuser);
        add(lpass);
        add(fpass);
        add(btnLogin);
        add(btnCancel);

        luser.setBounds(20, 15, 120, 25);
        fuser.setBounds(130, 15, 190, 25);
        lpass.setBounds(20, 45, 120, 25);
        fpass.setBounds(130, 45, 190, 25);
        btnLogin.setBounds(30, 100, 120, 25);
        btnCancel.setBounds(190, 100, 120, 25);
        setVisible(true);
    }
}
