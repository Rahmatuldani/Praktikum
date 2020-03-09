import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;

public class Register {
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}

class GUI extends JFrame {
    JLabel luser = new JLabel("Username");
    JLabel lpass = new JLabel("Password");
    JLabel lfakultas = new JLabel("Fakultas");
    JLabel lagama = new JLabel("Agama");
    JTextField fuser = new JTextField(10);
    JPasswordField fpass = new JPasswordField(10);
    JButton regis = new JButton("Registrasi");
    String[] fakultas = {
            "Fakultas Industri",
            "Fakultas Fisip",
            "Fakultas Pertambangan",
            "Fakultas Perminyakan",
            "Fakultas Pertanian",
    };
    String[] agama = {
            "Islam",
            "Kristen",
            "Hindu",
            "Budha",
    };
    JComboBox comboBox = new JComboBox(fakultas);
    JRadioButton agama1 = new JRadioButton(agama[0]);
    JRadioButton agama2 = new JRadioButton(agama[1]);
    JRadioButton agama3 = new JRadioButton(agama[2]);
    JRadioButton agama4 = new JRadioButton(agama[3]);

    public GUI(){
        setTitle("Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(320,290);
        setLayout(null);

        add(luser);
        add(fuser);
        add(fpass);
        add(lpass);
        add(lagama);
        add(agama1);
        add(agama2);
        add(agama3);
        add(agama4);
        add(lfakultas);
        add(comboBox);
        add(regis);

        luser.setBounds(15,15,140,20);
        fuser.setBounds(145,15,140,20);
        fpass.setBounds(145,45,140,20);
        lpass.setBounds(15,45,140,20);
        lagama.setBounds(15,75,140,20);
        agama1.setBounds(145,75,140,20);
        agama2.setBounds(145,95,140,20);
        agama3.setBounds(145,115,140,20);
        agama4.setBounds(145,135,140,20);
        lfakultas.setBounds(15,165,140,20);
        comboBox.setBounds(145,165,140,20);
        regis.setBounds(145,205,140,20);
    }
}
