package banking.management.system;

/**
 *
 * @author Harshal
 */
import java.sql.*;
public class conn 
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1?","root","");
        s=c.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
           System.out.println(e);
        }
    }   
}
