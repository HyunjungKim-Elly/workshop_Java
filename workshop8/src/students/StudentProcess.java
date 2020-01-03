package students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentProcess {
	
	public static List<Student> gradeRange(List<Student> list, double lower, double high){
		return list.parallelStream().filter(student->student.getGrade() >= lower && student.getGrade() <= high).collect(Collectors.toList());
		
	}
	
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
				.sorted(Comparator.comparing(Student::getGrade));
				StudentProcess.gradeRange(list, 50, 100)
				.forEach(System.out::println);
			
			//task3
			System.out.println("\n\nTask 3: \n");			
			System.out.println("First Student who got 50.0-100.0:");	
		
			System.out.println(
				StudentProcess.gradeRange(list, 50, 100).get(0));

			
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
			
			//task6
			System.out.println("\n\nTask 6: \n");			
			System.out.println("Student names in order by last name then first name:");
			
			list
				.stream()
				.sorted(Comparator.comparing(Student::getLastName)
						.thenComparing(Student::getFirstName))
				.forEach(student->System.out.println(student.getName()));
			
			//task7
			System.out.println("\n\nTask 7: \n");			
			System.out.println("Students by department:");
			Map<String,List<Student>> stuArr = list
					.stream()
					.collect(Collectors.groupingBy(Student::getDepartment));
			stuArr.forEach((key,value)->{
				System.out.println(key);
				value.forEach(student->System.out.println(" " + student));
			});
			
			//task8
			System.out.println("\n\nTask 8: \n");			
			System.out.println("Count of Students by department:");
			list
				.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, TreeMap::new,Collectors.counting()))
				.forEach((key, value) -> 
						System.out.println(key + " has " + value + " Student(s)"));
					
						
			//task9
			System.out.println("\n\nTask 9: \n");			
			Double sumGrade = list
					.stream().mapToDouble(std->std.getGrade()).sum();
			System.out.println("Sum of Students' grades: " + sumGrade);
			
			//task10
			System.out.println("\n\nTask 10: \n");
			list
				.stream()
				.mapToDouble(std -> std.getGrade())
				.average()
				.ifPresent(avgGrade -> System.out.printf("Average of Students' grades: %.2f", avgGrade));
			
			
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
