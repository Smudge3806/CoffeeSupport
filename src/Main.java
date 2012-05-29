import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	static Scanner scanner = new Scanner(System.in);
	static Connection con;
	private static Boolean $loop = true;
	
	public static void main(String[] args) throws Exception
	{		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/help_desk", "root", "root");
		init();
	}
	
	public static void init() throws Exception
	{
		while($loop)
		{
			System.out.println("$");
			String $ui = getInput();
			$ui = parseInput($ui);
			ResultSet $results = queryDB($ui);
			display($results);
		}
	}
	
	private static void display(ResultSet $results) throws SQLException
	{
		while($results.next())
		{
			System.out.println($results.getString(2) + " " + $results.getString(3));
		}
	}

	/**
	 * Listens for input from the user
	 * @return String user_input
	 */
	public static String getInput()
	{
		String $input = scanner.nextLine();
		String $output;
		if($input.length() != 0)
		{
			$output = $input;
		}
		else
		{
			System.out.println("Sorry I Didn't catch that...\r\n");
			$output = getInput();
		}
		return $output;
	}
	
	public static String parseInput(String $input)
	{
		String $output = "";
		if($input.equals("list"))
		{
			$output = "Select * From Users";
		}
		else if($input.equals("exit"))
		{
			$loop = false;
			System.out.println("Goodbye...");
			System.exit(0);
		}
		else if($input.contains("show") || $input.contains("-s"))
		{
			$output = "SELECT * FROM Users WHERE uid = 1";
		}
		return $output;
	}
	
	public static ResultSet queryDB(String $input) throws SQLException
	{
		ResultSet result = null;
		if($input.length() != 0)
		{
			PreparedStatement statement = con.prepareStatement($input);
		
			result = statement.executeQuery();
			
		}
		
		return result;

	}

}
