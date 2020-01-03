package workshop4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentOutput {
	
	public static void studentOutput() {
		
		try {
			FileInputStream fis = new FileInputStream("output.sre");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			boolean read = true;
			int count = 1;
			
			while(read) {
				
				Student student = (Student) ois.readObject();
			
				if(student != null) {					
					System.out.println("Student " + count++);
					System.out.println("Student Number: " + student.getStdID());
					System.out.println("Student Name: " + student.getFullName());
					System.out.println("Student course(s): " + student.getCourses());
					System.out.println();
				} else {
					read = false;
				}	
			}
			
			fis.close();
			
		} catch (IOException e) {
			System.out.println("End Of File!\n");
		} catch (Throwable e) {
			System.err.println(e);

		}
	}
	
	
}
