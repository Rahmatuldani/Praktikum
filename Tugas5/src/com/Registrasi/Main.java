package com.Registrasi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginGUI{
    public static void main(String[] args) {
        lGUI g = new lGUI();
    }
}
class lGUI extends JFrame implements ActionListener {
    final JTextField userrname = new JTextField(10);
    JLabel unama = new JLabel(" UserName ");
    final JTextField password = new JPasswordField(10);
    JLabel pass = new JLabel(" Password");
    JButton btnLogin = new JButton("Login");
    JButton btnClose = new JButton("Close");
    public lGUI() {
        setTitle("Registration");
        setDefaultCloseOperation(3);
        setSize(350, 200);

        setLayout(null);
        add(unama);
        add(userrname);
        add(password);
        add(pass);
        add(btnLogin);
        add(btnClose);

        // setBounds(m,n,o,p)
        // m = posisi x; n = posisi n
        // o = panjang komponen; p = tinggi komponen
        unama.setBounds(10, 10, 120, 20);
        userrname.setBounds(130, 10, 150, 20);
        pass.setBounds(10, 40, 120, 20);
        password.setBounds(130, 40, 150, 20);
        btnLogin.setBounds(10, 100, 120, 20);
        btnClose.setBounds(150, 100, 120, 20);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}