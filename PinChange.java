package bank.management.system.netbeans;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pins, repins;
    JLabel text, image, pintext, repintext;
    String pin;

    PinChange(String pin) {
        setLayout(null);
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 200, 500, 35);
        image.add(text);

        pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(200, 320, 180, 25);
        image.add(pintext);

        repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(160, 355, 500, 35);
        image.add(repintext);

        pins = new  JPasswordField();
        pins.setFont(new Font("Railway", Font.BOLD, 25));
        pins.setBounds(310, 320, 180, 25);
        image.add(pins);

        repins = new  JPasswordField();
        repins.setFont(new Font("Railway", Font.BOLD, 25));
        repins.setBounds(310, 360, 180, 25);
        image.add(repins);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 155, 30);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(355, 520, 155, 30);
        image.add(back);
        back.addActionListener(this);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
        if (ae.getSource() == change) {
            try {
                String npin = pins.getText();
                String rpin = repins.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, " Please Entered new PIN ");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, " Please Re-Entered new PIN ");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin='" + rpin + "' where pin='" + pin + "'";
                String query2 = "update login set pin='" + rpin + "' where pin='" + pin + "'";
                String query3 = "update signup3 set pin='" + rpin + "' where pin='" + pin + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, " PIN changed successfully ");
                
               setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }  
}
