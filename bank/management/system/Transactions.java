package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, pinchange, fastcash, balanceenquiry, exit;

    String pinnumber;
    Transactions(String pinnumber){


        this.pinnumber = pinnumber;
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);


        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);


        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Quick Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);


        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 450, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);


        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);



        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);







        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        }else if (e.getSource() == deposit){
            setVisible(true);
            new Deposit(pinnumber).setVisible(true);
        }else if (e.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if (e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource() == pinchange) {
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        } else if (e.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }

        }





    public static void main(String[] args) {
        new Transactions("");

    }
}
