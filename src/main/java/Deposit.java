package banking.management.system;

/**
 *
 * @author Harshal
 */
import java.awt.*;
import java.awt.event.*;
import static java.lang.Double.parseDouble;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Deposit extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    //JRadioButton r1,r2,r3,r4,r5;
    //JComboBox c1,c2,c3;
    
    
    public Deposit() 
    {
        setFont(new Font("System",Font.BOLD,22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Deposit");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"Deposit");
        
        
        l1 = new JLabel("ENTER THE AMOUNT YOU WANT");
        l1.setFont(new Font("System",Font.BOLD,35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("System",Font.BOLD,35));
        
        l3 = new JLabel("Enter Pin");
        l3.setFont(new Font("System",Font.BOLD,18));

        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
      
        t2 = new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,18));
        
        b1 = new JButton("Deposit");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Exit");
        b3.setFont(new Font("System",Font.BOLD,18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        
        
        setLayout(null);
         l3.setBounds(590, 10, 80, 30);
        add(l3);
        t2.setBounds(680, 10, 80, 30);
        add(t2);
        l1.setBounds(150, 150, 800, 60);
        add(l1);
        l2.setBounds(290, 210, 800, 60);
        add(l2);
       
        t1.setBounds(250, 300, 300, 50);
        add(t1);
      
        
       
        b1.setBounds(260, 380, 125, 50);
        add(b1);
        b2.setBounds(415, 380, 125, 50);
        add(b2);
        b3.setBounds(300, 550, 200, 50);
        add(b3); 
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
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
        String b = t2.getText();
        
        if(ae.getSource()==b1)
        {
            if(t1.getText().equals(""))
            {
              JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
            }
            else
            {
                conn cl =  new conn();
                PreparedStatement ps;
                ResultSet rs = cl.s.executeQuery("select * from bank where pin = '"+b+"' ");
                if(rs.next())
                {
                 
                    double balance=0;
                    double depositamount;
                    //String pin = rs.getString(1);
                    balance = rs.getDouble(4);
                    depositamount = parseDouble(a);
                    String Withdrawal=rs.getString(3);
                    balance+=depositamount;
                    //String ql = "insert into bank values ('"+b+"','"+a+"','"+Withdrawal+"','"+balance+"')";
                    String ql = "update bank set balance='"+balance+"',withdraw='"+Withdrawal+"',deposit='"+a+"' where pin='"+b+"'";
                    cl.s.executeUpdate(ql);  
                   }
                    else
                   {
                    String ql = "insert into bank values('"+b+"','"+a+"','"+null+"','"+a+"')";
                    cl.s.executeUpdate(ql);
                   }
                }
            }
        JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                new Transactions().setVisible(true);
                setVisible(false);
                if(ae.getSource()==b3)
            {
                System.exit(0);
            }
   
                    //if(executeUpdate>0)
                    //{
                    // System.out.println("record inserted....");
                    //} 
            }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error: "+e);
        }
                
            }
  
    public static void main(String[] args)
    {
    new Deposit().setVisible(true);
    }
}
