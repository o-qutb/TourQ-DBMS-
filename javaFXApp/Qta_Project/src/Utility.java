import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {
	String dburl="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
	String user="aa2111262";
	String pass="aa2111262";
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Utility() throws SQLException 
	{
		conn=DriverManager.getConnection(dburl, user, pass);
	}
	public void terminate() throws SQLException
	{
		System.out.println("Terminate the Connection");
		conn.close();
	}
}
