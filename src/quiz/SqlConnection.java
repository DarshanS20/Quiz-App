package quiz;
import java.sql.*;

public class SqlConnection {
	 public   Connection con ;
	   public  SqlConnection()
	    {
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logindetails","root","");
	            System.out.println("connection Established");
	        }
	        catch(Exception e)
	                {
	                    System.out.println("Connection Failed due to : "+e);
	                }
}
}
