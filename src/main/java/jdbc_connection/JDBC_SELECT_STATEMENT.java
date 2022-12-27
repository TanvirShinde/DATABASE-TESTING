package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_SELECT_STATEMENT {

	public static void main(String[] args) {
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "system");
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from INFO_OF_MOCKSTUDENTS");
			
			while (rs.next()) {
				
				int s_id =rs.getInt(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				long mobile_no = rs.getLong(4);
				String branch = rs.getString(5);
				
				System.out.println("emp id is : " + s_id);
				System.out.println("emp first name is : " + first_name);
				System.out.println("emp last_name is : " + last_name);
				System.out.println("emp mobile_no is : " + mobile_no);
				System.out.println("emp branch is : " + branch);
			}
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}
