package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
public class Login extends JFrame implements ActionListener {


    JButton login, clear, signUp;
    JTextField cardTextField;

    JPasswordField pinTextField;
    Login(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg")); //imported icon
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No. : ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 21));
        cardno.setBounds(100, 150, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);


        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 21));
        pin.setBounds(120, 220, 250, 40);
        add(pin);


        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);



        clear = new JButton("Reset");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);


        signUp = new JButton("Sign Up");
        signUp.setBounds(300, 350, 230, 30);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.white);

        setTitle("Automated Teller Machine");
        setSize(800, 480);
        setVisible(true); // If stated true then the frame will be visible.

    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear ){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber =  pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = Conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incrrect Card Number or Pin");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else if (e.getSource() == signUp){
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }



    public static void main(String[] args) {
        new Login();              // create a new object for the class called
    }
}
