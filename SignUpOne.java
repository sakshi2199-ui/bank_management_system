package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, EaddTf, addTf, cityTf, stateTf, pincodeTf;
    JButton button;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;

    SignUpOne(){
        setLayout(null);

        Random rd = new Random();
        random = Math.abs((rd.nextLong() % 9000L) + 1000l);

        JLabel formno = new JLabel("Application Form No: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(145,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(260,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 150, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel Gender = new JLabel("Gender: ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 150, 30);
        add(Gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel Eaddress = new JLabel("Email Address: ");
        Eaddress.setFont(new Font("Raleway", Font.BOLD, 20));
        Eaddress.setBounds(100, 340, 150, 30);
        add(Eaddress);

        EaddTf = new JTextField();
        EaddTf.setFont(new Font("Raleway", Font.BOLD, 14));
        EaddTf.setBounds(300, 340, 400, 30);
        add(EaddTf);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 150, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 150, 30);
        add(address);

        addTf = new JTextField();
        addTf.setFont(new Font("Raleway", Font.BOLD, 14));
        addTf.setBounds(300, 440, 400, 30);
        add(addTf);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 150, 30);
        add(city);

        cityTf = new JTextField();
        cityTf.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTf.setBounds(300, 490, 400, 30);
        add(cityTf);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 150, 30);
        add(state);

        stateTf = new JTextField();
        stateTf.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTf.setBounds(300, 540, 400, 30);
        add(stateTf);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 150, 30);
        add(pinCode);

        pincodeTf = new JTextField();
        pincodeTf.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTf.setBounds(300, 590, 400, 30);
        add(pincodeTf);

        button = new JButton("Next");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Rale way", Font.BOLD, 14));
        button.setBounds(620,660,80,30);
        button.addActionListener(this);
        add(button);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        }else if(female.isSelected()) {
            gender = "Female";
        }
        String Eaddress = EaddTf.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }

        String address = addTf.getText();
        String city = cityTf.getText();
        String state = stateTf.getText();
        String pin = pincodeTf.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+Eaddress+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new SignUpOne();
    }
}
