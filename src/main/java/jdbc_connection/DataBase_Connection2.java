package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase_Connection2 {

public static void main(String[] args) {
		
		try {
		 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "system");
			Statement smt = conn.createStatement();
			smt.executeUpdate("CREATE TABLE INFO_OF_MOCKSTUDENTS ( ID int, FIRST_NAME VARCHAR2(300), LAST_NAME VARCHAR2(250) , MOBILE_NO  long, STREAM varchar2 (200))");
			
			System.out.println("Table created successfully");
			
			conn.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
	}
}
