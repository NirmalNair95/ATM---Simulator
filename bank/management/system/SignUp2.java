package bank.management.system;


import com.mysql.cj.protocol.x.SyncMessageSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUp2 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1,c2,c3,c4,c5,c,c7;

    JButton submit, cancel;

    String formno;

    SignUp2(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 2: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);


        JLabel l2 = new JLabel("Account Type");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 100, 200, 30);
        add(l2);


        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 12));
        r1.setBackground(Color.white);
        r1.setBounds(100, 150, 150, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 12));
        r2.setBackground(Color.white);
        r2.setBounds(350, 150, 150, 20);
        add(r2);


        r3 = new JRadioButton("Student Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 12));
        r3.setBackground(Color.white);
        r3.setBounds(100, 190, 150, 20);
        add(r3);


        r4 = new JRadioButton("Joint Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 12));
        r4.setBackground(Color.white);
        r4.setBounds(350, 190, 150, 20);
        add(r4);


        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);



        JLabel card = new JLabel("Card No: ");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 230, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(330, 230, 250, 30);
        add(number);


        JLabel carddetail = new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 255, 300, 20);
        add(carddetail);


        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 280, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pnumber.setBounds(330, 280, 300, 30);
        add(pnumber);


        JLabel pindetail = new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 300, 300, 20);
        add(pindetail);


        JLabel services = new JLabel("Services Required : ");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 340, 200, 30);
        add(services);


        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 12));
        c1.setBounds(100, 380, 200, 30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 12));
        c2.setBounds(350, 380, 200, 30);
        add(c2);


        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 12));
        c3.setBounds(100, 420, 200, 30);
        add(c3);


        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 12));
        c4.setBounds(350, 420, 200, 30);
        add(c4);


        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 12));
        c5.setBounds(100, 460, 200, 30);
        add(c5);


        c7 = new JCheckBox("I hereby declare that the above mentioned details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 9));
        c7.setBounds(100, 500, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 620, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 620, 100, 30);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.white);







        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Current Account";
            } else if (r3.isSelected()) {
                accountType = "Student Account";
            } else if (r4.isSelected()) {
                accountType = "Joint Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs(((random.nextLong() % 90000000L)) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "Email & SMS Services";
            } else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            }


            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signup2 values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber+ "\n Pin: " + pinnumber);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new SignUp2("");
    }
}
