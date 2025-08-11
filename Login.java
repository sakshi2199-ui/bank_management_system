package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signUp;
    JTextField CardTextField;
    JPasswordField pinTextField;

    // constructor
    Login() {
        setLayout(null);

        setTitle("Automated Teller Machine");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card NO : ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);

        CardTextField = new JTextField();
        CardTextField.setBounds(300, 150, 240, 30);
        CardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(CardTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 240, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == clear){
                 CardTextField.setText("");
                 pinTextField.setText("");
            }else if(ae.getSource() == login){
                Conn conn = new Conn();
                String cardNo= CardTextField.getText();
                String pinNo = pinTextField.getText();
                String query = "select * from login where cardNo = '"+cardNo+"' and pin = '"+pinNo+"'";
                try {
                     ResultSet rs = conn.s.executeQuery(query);
                     if(rs.next()) {
                         setVisible(false);
                         new Transactions(pinNo).setVisible(true);
                     } else {
                         JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                     }
                } catch(Exception e){
                    System.out.println(e);
                }
            }else if(ae.getSource() == signUp){
                setVisible(false);
                new SignUpOne().setVisible(true);
            }

    }

    public static void main(String[] args) {

        new Login();   // object

    }
}