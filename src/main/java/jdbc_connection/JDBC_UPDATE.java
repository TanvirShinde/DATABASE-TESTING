package jdbc_connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_UPDATE {

	public static void main(String[] args) {

		String value;  int ID;  Long  MO_NO;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "system", "system");

			Statement smt = conn.createStatement();

			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			System.out.println("Enter student Id :");

			value = br.readLine();

			ID = Integer.parseInt(value);

			System.out.println("Enter mobile no :");

			value =br.readLine();

			MO_NO = Long.parseLong(value);

			int count = smt.executeUpdate("update INFO_OF_MOCKSTUDENTS SET " + MO_NO + "WHERE ID = " + ID);

			if (count >0) {

				System.out.println(count + "row updated");
			}
			else {

				System.out.println("no record found");
			}
		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}





