package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;

    String pinnumber;
    pinChange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900, 900);
        add(image);


        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);


        JLabel pinText = new JLabel("New Pin: ");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 35);
        image.add(pinText);


        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);


        JLabel repintext = new JLabel("Re-Enter New Pin: ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 35);
        image.add(repintext);


        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);


        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == change){
        try {
            String npin = pin.getText();
            String rpin = pin.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }

            if(rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }

            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signup2 set pin = '"+rpin+"' where pin='"+pinnumber+"'";


            Conn.s.executeUpdate(query1);
            Conn.s.executeUpdate(query2);
            Conn.s.executeUpdate(query3);


            JOptionPane.showMessageDialog(null, "PIN changed successfully");

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);


        }catch (Exception ex){
            System.out.println(ex);
        }
    }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

}
    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }
}
