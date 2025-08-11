package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{

    JTextField pan, aadharNo;
    JButton button;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, occupation, ed;
    String formno;

    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATON FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(260,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100,30);
        add(name);

        String[] valreligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 150, 30);
        add(fname);

        String[] valCategory = {"General", "OBC", "ST", "SC", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);

        String[] incomeCategory = {"NULL", "< 2,00,000", "< 4,00,000", "< 6,00,000", "< 8,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel Gender = new JLabel("Education");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 150, 30);
        add(Gender);

        JLabel ql = new JLabel("Qualification:");
        ql.setFont(new Font("Raleway", Font.BOLD, 20));
        ql.setBounds(100,315,200,30);
        add(ql);

        String[] eduValue = {"Graduate", "Non-Graduate", "Post-Graduation", "Other"};
        ed = new JComboBox(eduValue);
        ed.setBounds(300, 305, 400, 30);
        ed.setBackground(Color.WHITE);
        add(ed);

        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 370, 150, 30);
        add(marital);

        String[] occupationValue = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 370, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 150, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 250, 30);
        add(aadhar);

        aadharNo = new JTextField();
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharNo.setBounds(300, 490, 400, 30);
        add(aadharNo);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 150, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);


        JLabel pinCode = new JLabel("Existing Account: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 250, 30);
        add(pinCode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup ExistingAGroup = new ButtonGroup();
        ExistingAGroup.add(eyes);
        ExistingAGroup.add(eno);

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
        String formno = "";
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String sed = (String)ed.getSelectedItem();
        String socc = (String)occupation.getSelectedItem();

        String seniorCitizen = null;
        if(syes.isSelected()) {
            seniorCitizen = "Yes";
        }else if(sno.isSelected()) {
            seniorCitizen = "NO";
        }

        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()) {
            existingAccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadharNo.getText();

        try {
                Conn c = new Conn();
                String qry = "insert into signupTwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+sed+"', '"+socc+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(qry);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);

        } catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
