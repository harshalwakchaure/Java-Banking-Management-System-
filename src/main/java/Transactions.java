package banking.management.system;

/**
 *
 * @author Harshal
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Transactions extends JFrame implements ActionListener
{
    JLabel l1;
    //JTextField t1;
    //JRadioButton r1,r2,r3,r4;
    JButton b1,b2,b3,b4,b5,b6,b7;
    //JCheckBox c1,c2,c3,c4,c5,c6,c7;
    
    

    public Transactions() 
    {
        setFont(new Font("System",Font.BOLD,22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Transactions");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (2*x);
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"Transactions");
        
        
        l1 = new JLabel("Please select your Transaction");
        l1.setFont(new Font("System",Font.BOLD,38));
        
        b1 = new JButton("Deposit");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cash Withdrawl");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Fast Cash");
        b3.setFont(new Font("System",Font.BOLD,18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Mini Statement");
        b4.setFont(new Font("System",Font.BOLD,18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("Pin change");
        b5.setFont(new Font("System",Font.BOLD,18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("Balance Enquiry");
        b6.setFont(new Font("System",Font.BOLD,18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("Exit");
        b7.setFont(new Font("System",Font.BOLD,18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        
        
        setLayout(null);
     
        l1.setBounds(100, 100, 700, 40);
        add(l1);
     
        b1.setBounds(40, 250, 300, 60);
        add(b1);
        b2.setBounds(440, 250, 300, 60);
        add(b2);
        b3.setBounds(240, 360, 300, 60);
        add(b3);
        b4.setBounds(440, 360, 300, 60);
        add(b4);
        b5.setBounds(40, 470, 300, 60);
        add(b5);
        b6.setBounds(440, 470, 300, 60);
        add(b6);
        b7.setBounds(240, 600, 300, 60);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
         
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);        
    }
    public void actionPerformed(ActionEvent ae)
    {
                if(ae.getSource()==b1)
            {
                new Deposit().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b2)
            {
                new Withdrawl().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b3)
            {
                new Fastcash().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b4)
            {
                new Login().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b5)
            {
                new pin().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b6)
            {
                String pinn=JOptionPane.showInputDialog("Enter Pin");
                conn cl=new conn();
                
                try
                {
                 ResultSet rs = cl.s.executeQuery("Select balance FROM bank ORDER BY pin = '"+pinn+"' DESC LIMIT 1");
                  if (rs.next())
                  {
                     String balance = rs.getString("balance");
                     JOptionPane.showMessageDialog(null,"Your Account Balance is: "+balance);
                  }
                }
                catch (Exception e) 
                {
                        e.printStackTrace();
                        System.out.println("error:"+e);
                }
            }
                else if(ae.getSource()==b7)
            {
                System.exit(0);
            }
   
    }
    public static void main(String[] args)
    {
    new Transactions().setVisible(true);
    }
}


