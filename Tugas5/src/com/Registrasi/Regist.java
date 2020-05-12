package com.Registrasi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Register {
    public static void main(String[] args) {
        RGui g = new RGui();
    }
}
class RGui extends JFrame{
    final JTextField Fname = new JTextField(10);
    JLabel FirstN = new JLabel(" First Name ");
    final JTextField Lname = new JTextField(10);
    JLabel LastN = new JLabel(" Last Name ");
    final JTextField userrname = new JTextField(10);
    JLabel unama = new JLabel(" UserName ");
    final JTextField password = new JPasswordField(10);
    JLabel pass = new JLabel(" Password");
    JButton btnOK = new JButton("OK");
    JButton btnClose = new JButton("Close");
    public RGui() {
        setTitle("Registration");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(350, 200);

//        jangan lupa kasih setVisible diawal
        setVisible(true);

        setLayout(null);
        add(unama);
        add(userrname);
        add(Fname);
        add(FirstN);
        add(Lname);
        add(LastN);
        add(password);
        add(pass);
        add(btnOK);
        add(btnClose);

        // setBounds(m,n,o,p)
        // m = posisi x; n = posisi n
        // o = panjang komponen; p = tinggi komponen
        FirstN.setBounds(10, 10, 120, 20);
        Fname.setBounds(130, 10, 150, 20);
        LastN.setBounds(10, 35, 120, 20);
        Lname.setBounds(130, 35, 150, 20);
        unama.setBounds(10, 60, 120, 20);
        userrname.setBounds(130, 60, 150, 20);
        pass.setBounds(10, 85, 120, 20);
        password.setBounds(130, 85, 150, 20);
        btnOK.setBounds(10, 120, 120, 20);

        btnOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ini untuk apa?
//                btnOK.setEnabled(false);
                
//                kasih setVisible untuk pindah frame
                setVisible(false);
                new lGUI();
//                new LoginGUI();
            }
        });

        btnClose.setBounds(150, 120, 120, 20);

        btnClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //setVisible(true);
    }
}