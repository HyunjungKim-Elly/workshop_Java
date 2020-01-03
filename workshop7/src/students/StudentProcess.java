package students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentProcess {
	
	public static void main(String[] args) {
		
		try{
			Student[] students = {
					new Student("Jack", "Smith", 50.0, "IT"),
					new Student("Aaron", "Johnson", 76.0, "IT"),
					new Student("Maaria", "White", 35.8, "Business"),
					new Student("John", "White", 47.0, "Media"),
					new Student("Laney", "White", 62.0, "IT"),
					new Student("Jack", "Jones", 32.9, "Business"),
					new Student("Wesley", "Jones", 42.89, "Media")};
		
			List<Student> list = Arrays.asList(students);
		
			//task1
			System.out.println("Task 1: \n");			
			System.out.println("Complete Student list:");			
		
			list
				.stream()
				.forEach(System.out::println);
			
			//task2
			System.out.println("\n\nTask 2: \n");			
			System.out.println("Students who got 50.0-100.0 sorted by grade:");	
			
			list	
				.stream()
				.sorted(Comparator.comparing(Student::getGrade))
				.filter(student -> student.getGrade() >= 50.0 && student.getGrade() <= 100)
				.forEach(System.out::println);
			
			//task3
			System.out.println("\n\nTask 3: \n");			
			System.out.println("First Student who got 50.0-100.0:");	
		
			System.out.println(
				list
					.stream()
					.filter(student -> student.getGrade() >= 50.0 && student.getGrade() <= 100.0)
					.findFirst()
					.get());
			
			//task4
			System.out.println("\n\nTask 4: \n");			
			System.out.println("Students in ascending order by last name then first:");	
			
			list
				.stream()
				.sorted(Comparator.comparing(Student::getLastName)
						.thenComparing(Student::getFirstName)
						)
				.forEach(System.out::println);
			
			System.out.println("\nStudents in descending order by last name then first:");	
			
			list
			.stream()
			.sorted(Comparator.comparing(Student::getLastName)
					.thenComparing(Student::getFirstName)
					.reversed()
					)
			.forEach(System.out::println);
			
			//task5
			System.out.println("\n\nTask 5: \n");			
			System.out.println("Unique Student last names:");	
			
			list
				.stream()
				.map(Student::getLastName)
				.distinct()
				.sorted()
				.forEach(System.out::println);
			
			
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
