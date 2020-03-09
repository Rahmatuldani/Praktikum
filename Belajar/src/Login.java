import javax.swing.*;

public class Login {
    public static void main(String[] args) {
        TampilLogin login = new TampilLogin();
    }
}

class TampilLogin extends JFrame {
    JTextField fuser = new JTextField(20);
//    JTextField fpass = new JTextField(20);
    JPasswordField fpass = new JPasswordField(20);

    JLabel luser = new JLabel("Username");
    JLabel lpass = new JLabel("Password");

    JButton bLogin = new JButton("Login");
    JButton bCancel = new JButton("Cancel");

   public TampilLogin(){
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320,180);

        setLayout(null);
        add(luser);
        add(fuser);
        add(lpass);
        add(fpass);
        add(bLogin);
        add(bCancel);

        luser.setBounds(10,10,120,20);
        fuser.setBounds(140,10,120,20);
        lpass.setBounds(10,40,120,20);
        fpass.setBounds(140,40,120,20);
        bLogin.setBounds(10,70,120,20);
        bCancel.setBounds(140,70,120,20);

        setVisible(true);
   }
}