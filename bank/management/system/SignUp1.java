package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener {


    long random;
    JTextField fnameTextField, lnameTextField, fathersnameTextField, emailIdTextField, addressTextField, cityTextField, postcodeTextField, countryTextField;
    JButton next;
    JDateChooser dateChooser;

    JRadioButton male,female, married, unmarried, other;



    SignUp1(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formno = new JLabel("Application Form No: " + random);
        formno.setFont(new Font("Arial", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);



        JLabel personalDetails = new JLabel("Page 1 : Personal Details ");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 60, 600, 40);
        add(personalDetails);



        JLabel fname = new JLabel("First Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 15));
        fname.setBounds(80, 160, 200, 30);
        add(fname);


        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 165, 400, 25);
        add(fnameTextField);


        JLabel lname = new JLabel("Last Name: ");
        lname.setFont(new Font("Raleway", Font.BOLD, 15));
        lname.setBounds(80, 190, 200, 30);
        add(lname);


        lnameTextField = new JTextField();
        lnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        lnameTextField.setBounds(300, 195, 400, 25);
        add(lnameTextField);



        JLabel fathersname = new JLabel("Father's Name : ");
        fathersname.setFont(new Font("Raleway", Font.BOLD, 15));
        fathersname.setBounds(80, 220, 200, 30);
        add(fathersname);


        fathersnameTextField = new JTextField();
        fathersnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fathersnameTextField.setBounds(300, 225, 400, 25);
        add(fathersnameTextField);



        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 15));
        dob.setBounds(80, 260, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 265, 400, 25);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);



        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 15));
        gender.setBounds(80, 300, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 305, 60, 25);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 305,120, 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);





        JLabel emailId = new JLabel("Email ID : ");
        emailId.setFont(new Font("Raleway", Font.BOLD, 15));
        emailId.setBounds(80, 350, 200, 30);
        add(emailId);


        emailIdTextField = new JTextField();
        emailIdTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailIdTextField.setBounds(300, 355, 400, 25);
        add(emailIdTextField);



        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 15));
        maritalStatus.setBounds(80, 380, 200, 30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 385, 100, 25);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 385,100, 25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(500, 385,100, 25);
        other.setBackground(Color.WHITE);
        add(other);


        ButtonGroup maritalStatusgroup = new ButtonGroup();
        maritalStatusgroup.add(married);
        maritalStatusgroup.add(unmarried);
        maritalStatusgroup.add(other);



        JLabel address = new JLabel("Address :  ");
        address.setFont(new Font("Raleway", Font.BOLD, 15));
        address.setBounds(80, 410, 200, 30);
        add(address);


        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 415, 400, 25);
        add(addressTextField);

        JLabel city = new JLabel("City :  ");
        city.setFont(new Font("Raleway", Font.BOLD, 15));
        city.setBounds(80, 450, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 455, 400, 25);
        add(cityTextField);




        JLabel postcode = new JLabel("Post Code:  ");
        postcode.setFont(new Font("Raleway", Font.BOLD, 15));
        postcode.setBounds(80, 500, 200, 30);
        add(postcode);


        postcodeTextField = new JTextField();
        postcodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        postcodeTextField.setBounds(300, 505, 400, 25);
        add(postcodeTextField);

        JLabel country = new JLabel("Country : ");
        country.setFont(new Font("Raleway", Font.BOLD, 15));
        country.setBounds(80, 540, 200, 30);
        add(country);

        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        countryTextField.setBounds(300, 545, 400, 25);
        add(countryTextField);


        next = new JButton("Next");
        next.setBounds(500, 600, 200, 25);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        String formno = "" + random; // long
        String fname = fnameTextField.getText();
        String lname = lnameTextField.getText();
        String fathersname = fathersnameTextField.getText();
        String emailid = emailIdTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if((female.isSelected())){
            gender = "female";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String postcode = postcodeTextField.getText();
        String country = countryTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "other";
        }


        try{
            if (fname.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else{
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+"', '"+fname+"', '"+lname+"', '"+fathersname+"', '"+dob+"', '"+emailid+"', '"+gender+"', '"+address+"', '"+city+"', '"+postcode+"', '"+country+"', '"+marital+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }

        }catch (Exception ex){
            System.out.println(ex);
        }

    }



    public static void main(String[] args) {
        new SignUp1();
    }
}
