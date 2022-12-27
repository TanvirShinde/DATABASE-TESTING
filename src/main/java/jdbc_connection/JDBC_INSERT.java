package jdbc_connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_INSERT {

	public static void main(String[] args) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "system");
			PreparedStatement smt = conn.prepareStatement("INSERT INTO INFO_OF_MOCKSTUDENTS VALUES (?, ?,? ,?,? )");

			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			while (true) {

				System.out.println("Enter student Id :");

				int s_id = Integer.parseInt(br.readLine());

				System.out.println("Enter student first_name :");

				String s_firstname = br.readLine();

				System.out.println("Enter student last_name :");

				String s_lastname = br.readLine();

				System.out.println("Enter mobile no :");

				Long mobile_no= Long.parseLong(br.readLine());

				System.out.println("Enter student stream :");

				String s_stream = br.readLine();
				
				smt.setInt(1, s_id);
				
				smt.setString(2, s_firstname);
				
				smt.setString(3, s_lastname);
				
				smt.setLong(4, mobile_no);
				
				smt.setString(5, s_stream);
				
				int count = smt.executeUpdate();
				
				if (count >0) {
	            	   
					System.out.println(count + "record inserted");
	               }
				else {
					
					System.out.println("no record inserted");
				}
				
				System.out.println("Do you want to insert more records");
				
				String ch = br.readLine();
				
				if (ch.equalsIgnoreCase("no"))
				break;
			}

               
		}

		catch (Exception e) {


		}
	}
}
