package workshop4;

import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
			FileInputStream fis = new FileInputStream("output.sre");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			JLabel textLabel = new JLabel("Student Information", SwingConstants.CENTER);
			frame.getContentPane().add(textLabel);
			
			boolean read = true;
			int count = 1;
			
			while(read) {
				
				Student student = (Student) ois.readObject();
				
				JTextArea textArea = new JTextArea(8,20);
				if(student != null) {		
					textArea.append("Student "  + count++ + "\n" );
					textArea.append("Student ID : "  + student.getStdID() + "\n" );
					textArea.append("First Name : " + student.getFirstName() + "\n");
					textArea.append("Last Name: " + student.getLastName() + "\n");
					textArea.append("Courses : \n");
				
					for(String a : student.getCourses()) {
						textArea.append(a + "  ");
					}
					
					frame.add(textArea);
					
				} else {
					read = false;
				}	
				
				frame.setLayout(new FlowLayout());
				
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			ois.close();
			fis.close();
			
		} catch (IOException e) {
			System.out.println("End Of File!\n");
		} catch (Throwable e) {
			System.err.println(e);

		}
	}
	
	
}
