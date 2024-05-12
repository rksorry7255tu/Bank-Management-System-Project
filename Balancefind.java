
package bank.management.system.netbeans;

import bank.management.system.netbeans.Conn;
import bank.management.system.netbeans.Transactions;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;


public class Balancefind extends JFrame implements ActionListener{
 
    
     //JTextField t1, t2;
    JButton back;
    JLabel l1,l3;
    String pin;
    

    Balancefind(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
         int balance = 0;
         
         setLayout(null);
         
        l1 = new JLabel();
        
        

        
        //l1.setText("Your Current Account Balance is Rs '"+balance+"'");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        back = new JButton("BACK");
        back.setBounds(390, 633, 150, 35);
        l3.add(back);
        back.addActionListener(this);
        
        //int balance = 0;
       try{ 
            Conn c=new Conn();
                ResultSet rs= c.s.executeQuery("Select* from bank where pin='"+pin+"'");
            
                while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                } 
            }    
            l1.setText("Your Current Account Balance is Rs '"+balance+"'");   
       }catch(Exception e){
           System.out.println(e);
       }  
        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
          setVisible(false);
        new Transactions(pin).setVisible(true);
     }
     
      public static void main(String[] args) {
        new Balancefind("").setVisible(true);
    }
}
    
    
    
    

