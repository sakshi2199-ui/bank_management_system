package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pinTF, repinTF;
    JButton change, back;
    String pinNo;

    PinChange(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pinTF = new JPasswordField();
        pinTF.setFont(new Font("Raleway",Font.BOLD,16));
        pinTF.setBounds(330,320,180,25);
        image.add(pinTF);

        JLabel reEnterpin = new JLabel("Re-Enter PIN:");
        reEnterpin.setForeground(Color.WHITE);
        reEnterpin.setFont(new Font("Raleway",Font.BOLD,16));
        reEnterpin.setBounds(165,360,180,25);
        image.add(reEnterpin);

        repinTF = new JPasswordField();
        repinTF.setFont(new Font("Raleway",Font.BOLD,16));
        repinTF.setBounds(330,360,180,25);
        image.add(repinTF);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change) {
            try {
                String npin = pinTF.getText();
                String rpin = repinTF.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNo+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNo+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinNo+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
