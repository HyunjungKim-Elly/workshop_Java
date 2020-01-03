package workshop4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentInput {
	
	public static void studentInput() {
		
		try {
				boolean addStd = true;
				FileOutputStream file = new FileOutputStream("output.sre");
				ObjectOutputStream oos = new ObjectOutputStream(file);
		
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
	
				do {
					
					Student student = new Student();
					
					System.out.println("Enter Student ID: ");
					student.setStdID(scanner.nextInt());
					scanner.nextLine();
					
					System.out.println("Enter student's first Name: ");
					student.setFirstName(scanner.nextLine());
					
					System.out.println("Enter student's Last Name: ");
					student.setLastName(scanner.nextLine());
					
					boolean addCourse = true;
					
					do {
						System.out.println("Enter courses(finish : 0)");
						String course = scanner.nextLine();
						
						if(course.equals("0")) {
							addCourse = false;
						}else {
							student.setCourses(course);
						}
						
					}while(addCourse);
					
					oos.writeObject(student);	
					oos.flush();
							
					System.out.println("Do you want to add another student? ('y' or 'n')");
					String addMore = scanner.nextLine();
					
					if(addMore.equalsIgnoreCase("n")) {
						addStd = false;
					}
					
					while(!(addMore.equalsIgnoreCase("n")) && !(addMore.equalsIgnoreCase("y"))) {
						System.out.println("Please press Y or N");
						addMore = scanner.nextLine();
					}
								
					
				}while(addStd == true);
				
				file.close();
			
		} catch(Throwable e){
			System.err.println(e);
		} 
	}
	
	 public static void main(String[] args) {
		 
		 	int option = -1;
		 	 	
		 	do {
		 		System.out.println("1. Enter Student Info");
		 		System.out.println("2. Display Students");
		 		System.out.println("0. Exit\n");
		 		System.out.println("Enter the option number: ");
		 		
		 		@SuppressWarnings("resource")
		 		Scanner sc = new Scanner(System.in);
		 		option = sc.nextInt();
		 		
		 		switch(option) {
		 		case 1:
		 			System.out.println("\n----Enter Student Info----\n");		
		 			studentInput();
		 			break;
		 		case 2:
		 			System.out.println("----Display Students----");
		 			StudentOutput.studentOutput();
		 			break;
		 		case 0:
		 			System.out.println("Bye Bye");
		 			break;
		 		default:
		 			System.out.println("Invalid option!\n");
		 			break;
		 		}
		 			 		
		 	}while(option != 0);
			
	    }

}
