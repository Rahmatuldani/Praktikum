package Bab5.Tugas;

import javax.swing.*;

public class MultiLayout {
    public static void main(String[] args) {
        Tampil t = new Tampil();
    }
}

class Tampil extends JFrame {
    JButton no0 = new JButton("0");
    JButton no1 = new JButton("1");
    JButton no2 = new JButton("2");
    JButton no3 = new JButton("3");
    JButton no4 = new JButton("4");
    JButton no5 = new JButton("5");
    JButton no6 = new JButton("6");
    JButton no7 = new JButton("7");
    JButton no8 = new JButton("8");
    JButton no9 = new JButton("9");
    JButton no10 = new JButton("10");
    JButton no11 = new JButton("11");

    public Tampil() {
        setTitle("Multi Layout");
        setDefaultCloseOperation(3);
        setSize(540,140);

        setLayout(null);
        add(no0);
        add(no1);
        add(no2);
        add(no3);
        add(no4);
        add(no5);
        add(no6);
        add(no7);
        add(no8);
        add(no9);
        add(no10);
        add(no11);

        no0.setBounds(10, 10, 50, 20);
        no1.setBounds(70, 10, 50, 20);
        no2.setBounds(130, 10, 50, 20);
        no3.setBounds(190, 10, 50, 20);
        no4.setBounds(270, 10, 70, 20);
        no5.setBounds(270, 30, 70, 20);
        no6.setBounds(270, 50, 70, 20);
        no7.setBounds(270, 70, 70, 20);
        no8.setBounds(370, 10, 70, 40);
        no9.setBounds(440, 10, 70, 40);
        no10.setBounds(370,50,70,40);
        no11.setBounds(440,50,70,40);
        setVisible(true);
    }
}
