package banking.management.system;

/**
 *
 * @author Harshal
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Fastcash extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JTextField t1;
    
    
    

    public Fastcash() 
    {
        setFont(new Font("System",Font.BOLD,22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("FAST CASH");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (2*x);
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"FAST CASH");
        
        
        l1 = new JLabel("Select Withdrawal Amount");
        l1.setFont(new Font("System",Font.BOLD,38));
        
        l2 = new JLabel("Enter PIN");
        l2.setFont(new Font("System",Font.BOLD,18));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,18));
        
        b1 = new JButton("100");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("500");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("1000");
        b3.setFont(new Font("System",Font.BOLD,18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("2000");
        b4.setFont(new Font("System",Font.BOLD,18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("5000");
        b5.setFont(new Font("System",Font.BOLD,18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("10000");
        b6.setFont(new Font("System",Font.BOLD,18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("Back");
        b7.setFont(new Font("System",Font.BOLD,18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
      
        
        setLayout(null);
        l2.setBounds(580, 10, 90, 40);
        add(l2);
        t1.setBounds(670, 15, 70, 30);
        add(t1);
        l1.setBounds(160, 120, 700, 40);
        add(l1);
     
        b1.setBounds(40, 250, 300, 60);
        add(b1);
        b2.setBounds(440, 250, 300, 60);
        add(b2);
        b3.setBounds(40, 360, 300, 60);
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
                
                
            try
            {
                String a = t1.getText();
                double balance=0;
                if(ae.getSource()==b1)
                {
                 conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=100;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+100+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 100 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
                }
                else if(ae.getSource()==b2)
            {
                conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=500;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+500+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 500 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
                }
                else if(ae.getSource()==b3)
            {
               conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=1000;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+1000+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 1000 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b4)
            {
               conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=2000;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+2000+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 2000 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b5)
            {
                conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=5000;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+5000+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 5000 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b6)
            {
                conn cl=new conn();
                 ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+a+"' ");
                 if(rs.next())
                {
                    
                   
                    String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    //JButton withdraw=b1;
                    String depositamount=rs.getString(2);
                    balance-=10000;
                    String ql = "update bank set balance='"+balance+"',withdraw='"+10000+"',deposit='"+depositamount+"' where pin='"+a+"'";
                    cl.s.executeUpdate(ql);
                }
                 JOptionPane.showMessageDialog(null, "Rs. 10000 Debited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
            }
                else if(ae.getSource()==b7)
            {
                new Transactions().setVisible(true);
                setVisible(false);
            }
                }
                catch (Exception e) 
                {
                        e.printStackTrace();
                        System.out.println("error:"+e);
                }
            }
               
   
    
    public static void main(String[] args)
    {
    new Fastcash().setVisible(true);
    }
}


