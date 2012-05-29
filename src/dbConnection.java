import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

@SuppressWarnings("unused")
public class dbConnection {
	private String db_user = "root";
	private String db_pass = "root";
	private String db_name = "help_desk";
	private String db_addr = "127.0.0.1";
	private String db_port = "3306";
	private Connection con = null;
	
	public dbConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public void connect() throws SQLException
	{
		System.out.println("DB_CONNECTION: Connecting...\r\n");
		con = DriverManager.getConnection("jdbc:mysql://" + db_addr + ":" + db_port + "/" + db_name, db_user, db_pass);
		System.out.println("DB_CONNECTION: Connected\r\n");
	}
	
	public ResultSet query(String input) throws SQLException
	{
		ResultSet result = null;
		if(input.length() != 0)
		{
			PreparedStatement statement = con.prepareStatement(input);
		
			result = statement.executeQuery();
			
		}
		
		return result;
	}
	
	public boolean setUser(String user)
	{
		if(user.length() != 0)
		{
			db_user = user;
			return true;
		}
		else
		{
			System.out.println("ERROR: user not set\r\n");
			return false;
		}
	}
	
	public boolean setPassword(String old_pass, String new_pass)
	{
		if(old_pass.equals(db_pass))
		{
			old_pass = new_pass;
			return true;
		}
		else
		{
			System.out.println("ERROR: Re-enter the correct old password\r\n");
			return false;
		}
	}
	
	public boolean setHostAddress(String address)
	{
		if(address.length() != 0)
		{
			db_addr = address;
			return true;
		}
		else
		{
			System.out.println("ERROR: address not set\r\n");
			return false;
		}
	}
	
	public boolean setPortNumber(String port)
	{
		if(port.length() != 0)
		{
			db_port = port;
			return true;
		}
		else
		{
			System.out.println("ERROR: port not set\r\n");
			return false;
		}
	}
	
	public boolean setName(String name)
	{
		if(name.length() != 0)
		{
			db_name = name;
			return true;
		}
		else
		{
			System.out.println("ERROR: name not set\r\n");
			return false;
		}
	
	}
}
