
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
	private dbConnection con = null;
	private int user_id = 0;
	private String user_firstname;
	private String user_lastname;
	private String user_email;
	private Department user_department;
	
	public User() throws SQLException
	{
		con.connect();
	}
	
	public User(int id) throws SQLException
	{
		con.connect();
		user_id = id;
		getUserFromDB();
	}
	
	public User(String id) throws SQLException
	{
		con.connect();
		Integer i = new Integer(id);
		user_id = i.intValue();
		getUserFromDB();
	}
	
	public void getUserFromDB() throws SQLException
	{
		String stmt = "SELECT * FROM Users";
		if(user_id != 0)
		{
			Integer i = new Integer(user_id);
			stmt.concat(" WHERE uid = "+i.toString());
		}
		else if(user_firstname.length() != 0)
		{
			stmt.concat(" WHERE first_name = "+user_firstname);
			if(user_lastname.length() != 0)
			{
				stmt.concat(" AND last_name = "+user_lastname);
			}
		}
		stmt.concat(" LIMIT 0, 1");
		ResultSet result = con.query(stmt);
		result.next();
		set_username(result.getString("first_name"), result.getString("last_name"));
		set_email(result.getString("email"));
		set_department(result.getString("department_id"));
	}

	private void set_department(String department_id) 
	{
		Integer i = new Integer(department_id);
		user_department = new Department(i.intValue());
		user_department.setSupportOfficer();
	}

	public Department get_department()
	{
		return user_department;
	}
	
	private void set_username(String first_name, String last_name) 
	{
		user_firstname = first_name;
		user_lastname = last_name;
	}
	
	public String get_username()
	{
		return user_firstname.concat(" "+user_lastname);
	}
	
	private void set_email(String email)
	{
		user_email = email;
	}
	
	public String get_email()
	{
		return user_email;
	}
}
