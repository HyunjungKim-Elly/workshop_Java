package workshop11;

import java.sql.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInput extends JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentInput() {
		super("Student Information");
		JPanel panel = new JPanel();
		
		JButton[] optionButtons = {
				new JButton("Add new Student"),
				new JButton("Display Student"),
				new JButton("Exit")
		};
		
		for(JButton button: optionButtons) {
			button.setFont(button.getFont().deriveFont(13.0f));
			button.setPreferredSize(new Dimension(150,25));
			panel.add(button);
		}
		
		optionButtons[0].addActionListener(e ->{
				StudentInput.studentInput();							
		});
		
		optionButtons[1].addActionListener(e -> {
			StudentOutput.studentOutput();
		});
		optionButtons[2].addActionListener(e -> {
			System.exit(0);
		});
		add(panel);
		setBounds(300,100,500,560);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void studentInput() {
	
		try {

			StudentInput input = new StudentInput();
			
			
			JLabel title = new JLabel("Add Student Information", SwingConstants.CENTER);
			input.getContentPane().add(title);
			
			//student ID
			JLabel studentID = new JLabel(" Student ID: ");
			input.getContentPane().add(studentID);
			
			JTextField idField = new JTextField(20);
			input.getContentPane().add(idField);
			idField.requestFocus();
			
			//First Name
			JLabel name = new JLabel(" Name: ");
			input.getContentPane().add(name);
			
			JTextField nameField = new JTextField(20);
			input.getContentPane().add(nameField);
			
			
			//courses
			JLabel courses = new JLabel(" Courses: ");
			input.getContentPane().add(courses);
			
			JTextArea coursesArea = new JTextArea();
			JScrollPane sp = new JScrollPane(coursesArea);
			
			input.getContentPane().add(sp);
		
			//submit
			JButton submit = new JButton("Submit");
			input.getContentPane().add(submit);
			
			
			ActionListener listener = 
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							new InsertStudent(idField.getText(),nameField.getText(),coursesArea.getText());
							idField.setText("");
							nameField.setText("");
							coursesArea.setText("");
							
						}
						
					};
			
			submit.addActionListener(listener);	
			
			JButton addMore = new JButton("Do you want to finish?");
			input.getContentPane().add(addMore);
			
			addMore.addActionListener(e ->{
				input.setVisible(false);
			});															
						
			input.setLayout(new GridLayout(12,14,17,6));
		
		}catch(Throwable e){
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		  StudentInput panel = new StudentInput();
		 
		  Connection con = null;
		  Statement stmt = null;

		  String createString = "create table Students " + "(ID varchar(13), " + "NAME varchar(32), " + "COURSE varchar(10))";

					try {
						Class.forName(Values.DRIVER_CLASS_MYSQL);
					} catch (ClassNotFoundException e) {
						System.err.println(e.getMessage());
						System.exit(0);
					}

			try {

				con = DriverManager.getConnection(Values.URL, Values.USER_NAME, Values.PASS_WORD);
				stmt = con.createStatement();

				stmt.execute("DROP TABLE IF EXISTS Students");
				stmt.executeUpdate(createString);
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
	}

}
