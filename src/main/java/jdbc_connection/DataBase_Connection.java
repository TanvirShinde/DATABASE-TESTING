package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase_Connection {

public static void main(String[] args) {
		
		//database connection
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","system");
			
			Statement statement = connection.createStatement();
			
			
			String query = "CREATE TABLE Work (Id int, Name VARCHAR2 (20), Place VARCHAR2 (20), Exp int )";
			
			
			statement.executeQuery(query);
			
			System.out.println("table created succesfully....");
			
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
