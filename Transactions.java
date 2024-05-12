
package bank.management.system.netbeans;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pin;
    
    
    Transactions(String pin){
        this.pin=pin;
         setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel Image=new JLabel(i3);
        Image.setBounds(0,0,900,900);
        add(Image);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        Image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        Image.add(text);
        //setUndecorated(true);
        
        
         deposit =new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        Image.add(deposit);
        
         withdrawl =new JButton("Withdraw");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);
        
         fastcash =new JButton("Fastcash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        Image.add(fastcash);
        
         ministatement =new JButton("Ministatement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        Image.add(ministatement);
        
        pinchange =new JButton("Pinchange");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        Image.add(pinchange);
        
         balanceenquiry =new JButton("Balanceenquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        Image.add(balanceenquiry);
        
         exit =new JButton("exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        Image.add(exit);
        
            
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
           new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new Balancefind(pin).setVisible(true);
        }else {
            
            new Ministatement(pin).setVisible(true);
        }
    }
    public static void main(String[]args){
        new Transactions("").setVisible(true);
    }
}
