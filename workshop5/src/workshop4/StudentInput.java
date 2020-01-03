package workshop4;

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
			//open for read
			//read whatever file in the ArrayList
			//when I add new student append to the ArrayList
			StudentInput input = new StudentInput();
			
			@SuppressWarnings("resource")
			FileOutputStream file = new FileOutputStream("output.sre");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			
			
			JLabel title = new JLabel("Add Student Information", SwingConstants.CENTER);
			input.getContentPane().add(title);
			
			//student ID
			JLabel studentID = new JLabel(" Student ID: ");
			input.getContentPane().add(studentID);
			
			JTextField idField = new JTextField(20);
			input.getContentPane().add(idField);
			idField.requestFocus();
			
			//First Name
			JLabel firstName = new JLabel(" First Name: ");
			input.getContentPane().add(firstName);
			
			JTextField fNameField = new JTextField(20);
			input.getContentPane().add(fNameField);
			
			//Last Name
			JLabel lastName = new JLabel(" last Name: ");
			input.getContentPane().add(lastName);
			
			JTextField lNameField = new JTextField(20);
			input.getContentPane().add(lNameField);
			
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
							
							try {											
								Student std = new Student();
								std.setStdID(Integer.parseInt(idField.getText()));
								std.setFirstName(fNameField.getText());
								std.setLastName(lNameField.getText());
									
								ArrayList<String> courses = new ArrayList<>(
										Arrays.asList(coursesArea.getText().split("\n")));
								std.setCourses(courses);
									
								oos.writeObject(std);
								oos.flush();
									
								idField.setText("");
								fNameField.setText("");
								lNameField.setText("");	
								coursesArea.setText("");	
									
								
							} catch (IOException | NumberFormatException | StudentException e1) {
								System.out.println(e1.getMessage());
							}
							
						}
						
					};
			
			submit.addActionListener(listener);	
			
			JButton addMore = new JButton("Do you want to finish?");
			input.getContentPane().add(addMore);
			
			addMore.addActionListener(e ->{
				try {
					oos.close();
					input.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});															
						
			input.setLayout(new GridLayout(12,14,17,6));
		
		}catch(Throwable e){
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		  studentInput();
	}

}
