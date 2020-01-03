package workshop11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertStudent {
	
	public InsertStudent(String id, String name, String course) {
		
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName(Values.DRIVER_CLASS_MYSQL);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}

		try {
			con = DriverManager.getConnection(Values.URL, Values.USER_NAME, Values.PASS_WORD);
			stmt = con.createStatement();

			stmt.executeUpdate("insert into Students " + "values" + "('"+ id + "', '"+ name + "','"+ course + "')");

			ResultSet rs = stmt.executeQuery("select NAME, ID, COURSE from students");

			System.out.println("Student Information:");
			while (rs.next()) {
				String i = rs.getString("ID");
				String n = rs.getString("NAME");
				String c = rs.getString("COURSE");
		
				System.out.println(i + " \t  " + n + "\t"+c);
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try {

				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();
			} catch (Exception ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		}
	}

}
