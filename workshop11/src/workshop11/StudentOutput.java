package workshop11;

import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class StudentOutput extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentOutput() {
		setBounds(700,250,250,500);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void studentOutput() {
		
		StudentOutput frame = new StudentOutput();
		
		try {
			
			JLabel textLabel = new JLabel("Student Information", SwingConstants.CENTER);
			frame.getContentPane().add(textLabel);
		
				Connection con = null;
				Statement stmt = null;


				try {
						Class.forName(Values.DRIVER_CLASS_MYSQL);
				} catch (java.lang.ClassNotFoundException e) {
						System.err.println(e.getMessage());
						System.exit(0);
				}

				try {
					JTextArea textArea = new JTextArea(20,20);

					con = DriverManager.getConnection(Values.URL, Values.USER_NAME, Values.PASS_WORD);
					stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("select NAME, ID, COURSE from students");
					
					textArea.append("ID" + " \t  " + "NAME" + "\t" + "COURSE" +"\n");
					while (rs.next()) {
						String i = rs.getString("ID");
						String n = rs.getString("NAME");
						String c = rs.getString("COURSE");			
						textArea.append(i + " \t  " + n + "\t" +  c +"\n");
				
						frame.add(textArea);
						
					
					frame.setLayout(new FlowLayout());
					
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					frame.setVisible(true);
					}
				} catch (SQLException ex) {
					System.err.println("SQLException: " + ex.getMessage());
				} finally {
					try {
						// Close the connection and statement
						if (stmt != null)
							stmt.close();

						if (con != null)
							con.close();
					} catch (Exception ex) {
						System.err.println("SQLException: " + ex.getMessage());
					}
				}
			
		} catch (Throwable e) {
			System.err.println(e);

		}
	}
	
	
}
